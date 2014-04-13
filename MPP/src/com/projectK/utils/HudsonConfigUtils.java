package com.projectK.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.StatusLine;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class HudsonConfigUtils {

	private static String getConfigURL(String jobURL) {
		if (!jobURL.endsWith("/"))
			jobURL += "/";

		String configURL = jobURL + "config.xml";
		return configURL;
	}

	public static String getHudsonConfig(String jobURL) {
		String configURL = getConfigURL(jobURL);

		String result = null;
		try {
			result = MPPHttpUtils.sendGetRequest(configURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "";
		}

		return result;
	}

	public static void updateHudsonConfig(String jobURL, String autoCaseSVN,
			String configContent) throws Exception {
		String configURL = getConfigURL(jobURL);
		Element root = MPPXMLOperator.parseXML(configContent);
		Node scmNode = MPPXMLOperator
				.selectSingleNode(
						"/project/project-properties/entry[string='scm']/scm-property/originalValue/locations/hudson.scm.SubversionSCM_-ModuleLocation/remote",
						root);
		scmNode.setTextContent(autoCaseSVN);

		String newConfigContent = MPPXMLOperator.toString(root);

		MPPHttpUtils.sendPostRequest(configURL, newConfigContent);
	}

	public static String updateSVNCredential(String jobURL, String svnURL,
			String name, String passwd) throws Throwable {
		if (!jobURL.endsWith("/"))
			jobURL += "/";

		String credentialURL = jobURL
				+ "descriptorByName/hudson.scm.SubversionSCM/postCredential";

		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(credentialURL);

		// StringEntity reqEntity = new StringEntity(xml);
		// httppost.setEntity(reqEntity);

		MultipartEntity multipartEntity = new MultipartEntity();
		multipartEntity.addPart("url", new StringBody(svnURL));
		multipartEntity.addPart("kind", new StringBody("password"));
		multipartEntity.addPart("username1", new StringBody(name));
		multipartEntity.addPart("password1", new StringBody(passwd));

		httpPost.setEntity(multipartEntity);

		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity resEntity = response.getEntity();
		System.out.println("----------------------------------------");
		System.out.println(response.getStatusLine());
		int statusCode = response.getStatusLine().getStatusCode();
		if (HttpStatus.SC_OK == statusCode
				|| HttpStatus.SC_MOVED_TEMPORARILY == statusCode) {
			// System.out.println(response.getEntity().getContentLength());
			String resContent = EntityUtils.toString(resEntity, "UTF-8");
			System.out.println(resContent);
			return resContent;
		}

		throw new Exception("SVN credential info update failed! status:" + statusCode);
	}

	public static int getResMetaID(String jobURL) throws Exception {
		if (!jobURL.endsWith("/"))
			jobURL += "/";
		String lastBuildInfoURL = jobURL + "lastBuild/api/json";

		String raw = MPPHttpUtils.sendGetRequest(lastBuildInfoURL);

		JSONObject infoObj = JSONObject.fromObject(raw);

		JSONArray actions = infoObj.getJSONArray("actions");

		JSONArray parameters = null;

		for (Object a : actions) {
			JSONObject act = (JSONObject) a;
			if (act.containsKey("parameters")) {
				parameters = act.getJSONArray("parameters");
				break;
			}
		}

		if (parameters == null)
			throw new Exception("No parameters in actions!");

		int resMetaID = -1;

		for (Object p : parameters) {
			JSONObject param = (JSONObject) p;

			if (param.getString("name").equals("resMetaID")) {
				resMetaID = Integer.parseInt(param.getString("value"));
				break;
			}
		}

		if (resMetaID == -1)
			throw new Exception("No resMetaID in parameters!");

		return resMetaID;
	}

}

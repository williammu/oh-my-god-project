package com.projectK.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MPPHttpUtils {
	private static String sendRequest(String targetURL, String method, String postData) throws IOException
	{
		method = method.toUpperCase();
		boolean isPost = method.equals("POST");
		URL url;
		HttpURLConnection connection = null;

		// Create connection
		url = new URL(targetURL);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method);
		if(isPost)
		{
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
	
			connection.setRequestProperty("Content-Length", ""
					+ Integer.toString(postData.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
		}

		connection.setUseCaches(false);
		connection.setDoInput(true);
		
		if(isPost)
			connection.setDoOutput(true);
		else
			connection.setDoOutput(false);

		if(isPost)
		{
			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(postData);
			wr.flush();
			wr.close();
		}

		// Get Response
		InputStream is = connection.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		rd.close();
		String ret = response.toString();
		connection.disconnect();
		return ret;
		
	}
	
	
	public static String sendGetRequest(String targetURL) throws IOException
	{
		return sendRequest(targetURL, "GET", null);
	}
	
	
	public static String sendPostRequest(String targetURL, String postData)
			throws IOException {
		return sendRequest(targetURL, "POST", postData);
	}
}

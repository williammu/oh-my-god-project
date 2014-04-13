package com.projectK.utils;

import javax.servlet.http.HttpServletRequest;

public class UrlUtils {
	public static String getBasePath(HttpServletRequest httpReq)
	{
		String path = httpReq.getContextPath();
		String basePath = httpReq.getScheme() + "://"
				+ httpReq.getServerName() + ":" + httpReq.getServerPort()
				+ path + "/";
		return basePath;
	}
	
	private String getFullURL(HttpServletRequest request) {
	    StringBuffer requestURL = request.getRequestURL();
	    String queryString = request.getQueryString();

	    if (queryString == null) {
	        return requestURL.toString();
	    } else {
	        return requestURL.append('?').append(queryString).toString();
	    }
	}
}

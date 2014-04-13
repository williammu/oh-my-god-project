package com.projectK.utils;

import java.util.ArrayList;
import java.util.List;

public class UrlDescriptor {
	private List<String> accessPrimitive = new ArrayList<String>();
	private String urlPattern;
	
	public UrlDescriptor(String ... args)
	{
		this.urlPattern = args[0];
		
		for(int i = 1; i < args.length; i ++)
			accessPrimitive.add(args[i]);
	}
	
	public List<String> getAccessPrimitive() {
		return accessPrimitive;
	}
	public void setAccessPrimitive(List<String> accessPrimitive) {
		this.accessPrimitive = accessPrimitive;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	
	
	
}

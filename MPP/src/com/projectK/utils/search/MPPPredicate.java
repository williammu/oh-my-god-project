package com.projectK.utils.search;

import java.lang.reflect.Method;

import org.apache.commons.lang.WordUtils;

public abstract class MPPPredicate {
	protected String propertyName;
	protected String expectedValue;
	
	public MPPPredicate(String propertyName, String expectedValue)
	{
		this.propertyName = propertyName;
		this.expectedValue = expectedValue;
	}
	
	protected String getValue(Object element)
	{
		String methodName = "get" + WordUtils.capitalize(propertyName);
		for(Class<?> clz = element.getClass(); clz != Object.class; clz = clz.getSuperclass())
		{
			try {
				Method getter = clz.getDeclaredMethod(methodName);
				String ret = getter.invoke(element) + "";
				return ret;
			} catch (Exception ex)
			{
				//do nothing, just continue to check whether it is in super class
			}
		}
		return "";
	}
	
	public abstract boolean check(Object element);
}

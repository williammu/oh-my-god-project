package com.projectK.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
		public static String getKeyFromCookies(Cookie[] cookies, String key)
		{
			for(int i = 0; i < cookies.length; i ++)
			{
				if(cookies[i].getName().equals(key))
					return cookies[i].getValue();
			}
			
			return null;
		}
}

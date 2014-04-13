package com.projectK.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MPPEncodingUtils {
	public static String encodeBase64(String s)
	{
		if(s == null)
			return null;
		
		String ret = new BASE64Encoder().encode(s.getBytes());
		return ret;
	}
	
	public static String decodeBase64(String s)
	{
		if(s == null)
			return null;
		
		try {
			byte[] b = new BASE64Decoder().decodeBuffer(s);
			String ret = new String(b);
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
}


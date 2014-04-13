package com.projectK.utils;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.projectK.common.DomainObject;



public class HashCalculator {
	public static String getStrHash(String str)
	{
		String ret = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInt = new BigInteger(1,digest.digest());
			ret = bigInt.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			ret = "unknown hash!";
		}
		
		return ret;
	}
	
	public static String getObjHash(DomainObject obj, HashFieldSelector selector)
	{
		String hash = "unknown hash!";
		try
		{
			Field[] primitiveField = ReflectUtils.getAllHashableField(obj);
			String raw = obj.getClass().getName();
			
			for(Field f : primitiveField)
			{
				if(!selector.shouldIncludeField(obj, f))
					continue;
				
				f.setAccessible(true);
				raw += f.get(obj) + "";
			}
			
			hash = getStrHash(raw);
		}
		catch(Throwable ex)
		{
			 ex.printStackTrace();
		}
		return hash;
	}
	
	public static String geneHashFromEdge(HashSet<MirrorEdge> allEdge)
	{
		ArrayList<String> lst = new ArrayList<String>();
		for(MirrorEdge e : allEdge)
		{
			String str = e.class1.getName() + e.class2.getName() + e.getter.getName() + e.hash1 + e.hash2 + e.id1 + e.id2 + e.setter.getName();
			lst.add(str);
		}
		
		Collections.sort(lst);
		
		StringBuffer strBuffer = new StringBuffer();
		
		for(String str : lst)
			strBuffer.append(str);
		
		String hash = getStrHash(strBuffer.toString());
		
		return hash;
	}
}

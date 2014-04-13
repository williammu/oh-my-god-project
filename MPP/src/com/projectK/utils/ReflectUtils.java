package com.projectK.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

import com.projectK.common.DomainObject;

public class ReflectUtils {

	public static void copyProperties(Object obj, Class cls, Object objNew) {
		try {
			for (Field field : cls.getDeclaredFields()) {
				if (field.getType().isPrimitive() || field.getType() == String.class) {
					field.setAccessible(true);
					field.set(objNew, field.get(obj));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean methodReturnSet(Method method) {
		if (method.getReturnType().getName().contains("Set")
				|| (method.getParameterTypes().length != 0 && method
						.getParameterTypes()[0].getName().contains("Set"))) {
			return true;
		} else {
			return false;
		}
	}

	public static Object invokeMethod(Object obj, Method method,
			Object[] parameter) {
		Object ret = null;
		try {
			ret = method.invoke(obj, parameter);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}
	
	public static Field[] getAllHashableField(DomainObject obj)
	{
		Field[] fields = obj.getClass().getDeclaredFields();
		ArrayList<Field> ret = new ArrayList<Field>();
		
		for(Field f : fields)
		{
			if(f.getType().isPrimitive() || f.getType() == String.class)
				ret.add(f);
		}
		
		Field[] ary = new Field[ret.size()];
		ret.toArray(ary);
		return ary;
	}
	
	public static Method[] getAllMethod(Class<? extends DomainObject> clz)
	{
		return clz.getDeclaredMethods();
	}
	
	public static Method[] getAllGetters(Class<? extends DomainObject> clz)
	{
		Method[] methods = getAllMethod(clz);
		ArrayList<Method> ret = new ArrayList<Method>();
		for(Method m : methods)
		{
			if(m.getName().startsWith("get"))
				ret.add(m);
		}
		
		Method[] ary = new Method[ret.size()];
		
		ret.toArray(ary);
		
		return ary;
	}

	
	public static Method[] getAllEdge(Class<? extends DomainObject> clz)
	{
		Method[] getters = ReflectUtils.getAllGetters(clz);
		ArrayList<Method> ret = new ArrayList<Method>();	
		for(Method m : getters)
		{
			if(!DomainObject.class.isAssignableFrom(m.getReturnType()) && !(m.getReturnType() == Set.class) )
				continue;
			
			ret.add(m);
		}
		
		Method[] ary = new Method[ret.size()];
		ret.toArray(ary);
		return ary;
	}
	
	public static boolean isReturnType(Method m, Class cls)
	{
		return m.getReturnType() == cls;
	}

	
	public static Object getField(String name, Object obj, Class cls){
		try {
			Object ret = null;
			while(ret == null && cls.getSuperclass() != null){
				for(Field f : cls.getDeclaredFields()){
					if(f.getName().equals(name)){
						f.setAccessible(true);
						ret = f.get(obj);
						return ret;
					}
				}
				cls = cls.getSuperclass();
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Method getMethodByName(Class cls, String name)
	{
		Method[] allMethod = cls.getMethods();
		for(Method m : allMethod)
			if(m.getName().equals(name))
				return m;
		
		return null;
	}

}

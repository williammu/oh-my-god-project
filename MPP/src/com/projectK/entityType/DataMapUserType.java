package com.projectK.entityType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

@SuppressWarnings("unchecked")
public class DataMapUserType implements UserType, ParameterizedType {

	private static final Log logger = LogFactory.getLog(DataMapUserType.class);

	private static final String VALUE_TYPE = "valueType";
	private static final String KEY_TYPE = "keyType";

	private Constructor<?> valueConstructor;
	private Constructor<?> keyConstructor;

	public int[] sqlTypes() {
		return new int[] { Hibernate.TEXT.sqlType() };
	}

	public Class<?> returnedClass() {
		return Map.class;
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		if (logger.isDebugEnabled()) {
			logger.debug("assemble owner[" + ToStringBuilder.reflectionToString(owner) + "]");
		}
		return deepCopy(cached);
	}

	public Object deepCopy(Object value) throws HibernateException {
		return (value != null) ? new HashMap((Map) value) : null;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) deepCopy(value);
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return (x == y) || (x != null && x.equals(y));
	}

	public int hashCode(Object value) throws HibernateException {
		return value.hashCode();
	}

	public boolean isMutable() {
		return true;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("nullSafeGet owner[" + ToStringBuilder.reflectionToString(owner) + "]");
		}
		String text = (String) Hibernate.TEXT.nullSafeGet(rs, names);
		if (text == null) {
			return new HashMap();
		}
		Properties properties = new Properties();
		try {
			properties.load(new ByteArrayInputStream(text.getBytes("utf-8")));
		} catch (Exception e) {
			throw new IllegalStateException("load properties failed");
		}

		Map map = new HashMap();
		for (Object key : properties.keySet()) {
			String k = (String) key;
			String v = properties.getProperty(k);
			try {
				map.put(keyConstructor.newInstance(k), valueConstructor.newInstance(v));
			} catch (Exception e) {
			}
		}
		return map;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		String text = null;
		if (value != null) {
			Map map = (Map) value;
			if (!map.isEmpty()) {
				Properties properties = new Properties();
				for (Object key : map.keySet()) {
					properties.setProperty(key.toString(), map.get(key).toString());
				}
				OutputStream os = new ByteArrayOutputStream();
				try {
					properties.store(os, "utf-8");
				} catch (IOException e) {
					throw new IllegalStateException("store [" + map + "] to xml failed", e);
				}
				text = os.toString();
			}
		}
		Hibernate.TEXT.nullSafeSet(st, text, index);
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		if (logger.isDebugEnabled()) {
			logger.debug("replace owner[" + ToStringBuilder.reflectionToString(owner) + "]");
		}
		return deepCopy(original);
	}

	public void setParameterValues(Properties properties) {
		String valueType = properties.getProperty(VALUE_TYPE);
		String keyType = properties.getProperty(KEY_TYPE);
		if (keyType == null || valueType == null) {
			throw new IllegalArgumentException("illegal params setting[" + properties + "]");
		}
		this.valueConstructor = getConstructor(valueType);
		this.keyConstructor = getConstructor(keyType);
	}

	private static final Constructor<?> getConstructor(String clazzType) {
		try {
			return Class.forName(clazzType).getConstructor(String.class);
		} catch (Exception eStr) {
			logger.warn("get Constructor with String failed");
			try {
				Constructor<?> c = Class.forName(clazzType).getConstructor(Object.class);
				logger.warn("get Constructor with Object succed");
				return c;
			} catch (Exception eObj) {
				throw new IllegalStateException("Constructor init failed!", eObj);
			}
		}
	}
}

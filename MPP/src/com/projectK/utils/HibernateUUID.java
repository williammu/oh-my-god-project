package com.projectK.utils;

import java.io.Serializable;
import java.net.InetAddress;

public class HibernateUUID {

	//private String sep = "-";
	private String sep = "";
	
	/**
	 * @param 通过处理Ip得到的整数值
	 */
	private static final int IP;
	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}
	private static short counter = (short) 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	/**
	 * 或得该类加载时jvm的时间唯一的(除非加载该类在相同德四分之一秒-几乎不可能) Unique across JVMs on this
	 * machine (unless they load this class in the same quater second - very
	 * unlikely)
	 */
	protected int getJVM() {
		return JVM;
	}

	/**
	 * 35. * Unique in a millisecond for this JVM instance (unless there 36. *
	 * are > Short.MAX_VALUE instances created in a millisecond) 37.
	 */
	protected short getCount() {
		synchronized (HibernateUUID.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	/**
	 * Unique in a local network
	 */
	protected int getIP() {
		return IP;
	}

	/**
	 * 53. * Unique down to millisecond 54.
	 */
	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}
	

	public Serializable generate() {
		return new StringBuffer(36).append(format(getIP())).append(sep).append(
				format(getJVM())).append(sep).append(format(getHiTime()))
				.append(sep).append(format(getLoTime())).append(sep).append(
						format(getCount())).toString();
	}

	protected String format(int intValue) {
		String formatted = Integer.toHexString(intValue);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortValue) {
		String formatted = Integer.toHexString(shortValue);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	public static int toInt(byte[] bytes) {
		int result = 0;
		// 将result每次乘256 -128+ bytes[i]
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}
	
	public static String generateUUID() {
		return new HibernateUUID().generate().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new HibernateUUID().generate());
		System.out.println(generateUUID());;
	}

}

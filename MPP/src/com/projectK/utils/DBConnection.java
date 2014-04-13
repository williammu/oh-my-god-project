package com.projectK.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBConnection {
	private static Log log = LogFactory.getLog(DBConnection.class);
	private DBConnection()
	{
		
	}
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		java.util.ResourceBundle rb = ResourceBundle.getBundle("jdbc", java.util.Locale.getDefault()); 
		try {
			String driver = rb.getString("driver");
			Class.forName(driver);
			String url = rb.getString("url");
			String userName = rb.getString("userName");
			String password = rb.getString("password");
			
			con = DriverManager.getConnection(url, userName, password);
//			if(con == null)
//			{
//				con = DriverManager.getConnection(url, userName, password);
//			}
		} catch(ClassNotFoundException e){
			con = null;
			log.info("连接门禁系统数据库驱动类未加载!");
			//e.printStackTrace();
		} catch (SQLException e) {
			con = null;
			log.info("连接门禁系统数据库失败!reason:" + e.getMessage());
			//e.printStackTrace();
		}
		
		return con;
	}
//	
//	public static void main(String[] args) {
//		
//		try {
//			Connection con = getConnection();
//			java.sql.PreparedStatement pre = con.prepareStatement("select * from OM_Account where del = 0");
//			ResultSet res = pre.executeQuery();
//			while(res.next()) {
//				System.out.println(res.getString("name"));
//			}
//		} catch (Exception e) {
//		}
//	}
}

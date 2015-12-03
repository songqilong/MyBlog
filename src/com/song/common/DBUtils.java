package com.song.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	// mysql 驱动字符串
	private static String DRIVER = "com.mysql.jdbc.Driver";
	// mysql 连接URL
	private static String URL = "jdbc:mysql://127.0.0.1:3306/blog";
	// mysql数据库用户名
	private static String USERNAME = "root";
	// mysql数据库密码
	private static String PASSWORD = "root";
	private static Connection con = null;
	
	/**
	 * 连接mysql数据库
	 */
	public static void ConnDB()
	{
		try{
			// 如果连接为空，则创建mysql连接
			if(con==null){
				// 加载数据库驱动
				Class.forName(DRIVER);
				// 获取数据库连接
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		}catch(Exception ex){
			System.out.println(ex.toString());
		}		
	}
	
	public static 
}

package com.song.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtils {
	// mysql 驱动字符串
	private static String DRIVER = PropertiesUtils.ReadProperties("DRIVER");
	// mysql 连接URL
	private static String URL = PropertiesUtils.ReadProperties("URL");
	// mysql数据库用户名
	private static String USERNAME = PropertiesUtils.ReadProperties("USERNAME");
	// mysql数据库密码
	private static String PASSWORD = PropertiesUtils.ReadProperties("PASSWORD");
	// 数据库连接
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rst = null;
	
	// 优先加载驱动
	static {
		try {
			// 加载数据库驱动
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 连接mysql数据库
	 * @throws Exception 
	 */
	public static void ConnDB() throws Exception
	{
		// 如果连接为空，则创建mysql连接
		if (con == null) {			
			// 获取数据库连接
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
	}
	
	/**
	 * 查询结果
	 * @param sql 查询的SQL语句
	 * @return 返回查询结果ResultSet
	 * @throws SQLException 
	 */
	public static ResultSet Query(String sql) throws SQLException
	{
		stmt = con.createStatement();
		rst = stmt.executeQuery(sql);	
		return 	rst;
	}
	
	/**
	 * 更新、插入、删除
	 * @param sql 执行的SQL语句
	 * @return 影响的行数
	 * @throws SQLException 
	 */
	public static int ExecuteUpdateOrDelete(String sql) throws SQLException
	{
		int row = 0;
		stmt = con.createStatement();
		row = stmt.executeUpdate(sql);
		return row;
	}
	
	/**
	 * 关闭数据库
	 * @throws SQLException
	 */
	public static void CloseCon()
	{
		try {
			if(stmt != null)
			{
				stmt.close();
				stmt = null;
			}
			if(rst != null)
			{
				rst.close();
				rst = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

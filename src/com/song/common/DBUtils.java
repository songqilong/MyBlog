package com.song.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtils {
	// mysql 驱动字符串
	private static String DRIVER = "com.mysql.jdbc.Driver";
	// mysql 连接URL
	private static String URL = "jdbc:mysql://127.0.0.1:3306/blog";
	// mysql数据库用户名
	private static String USERNAME = "root";
	// mysql数据库密码
	private static String PASSWORD = "root";
	// 数据库连接
	private static Connection con = null;

	
	/**
	 * 连接mysql数据库
	 * @throws Exception 
	 */
	public static void ConnDB() throws Exception
	{
		// 如果连接为空，则创建mysql连接
		if (con == null) {
			// 加载数据库驱动
			Class.forName(DRIVER);
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
		Statement stmt = con.createStatement();
		return stmt.executeQuery(sql);		
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
		Statement stmt = con.createStatement();
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
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

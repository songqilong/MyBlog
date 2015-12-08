package com.song.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtils {
	// mysql �����ַ���
	private static String DRIVER = PropertiesUtils.ReadProperties("DRIVER");
	// mysql ����URL
	private static String URL = PropertiesUtils.ReadProperties("URL");
	// mysql���ݿ��û���
	private static String USERNAME = PropertiesUtils.ReadProperties("USERNAME");
	// mysql���ݿ�����
	private static String PASSWORD = PropertiesUtils.ReadProperties("PASSWORD");
	// ���ݿ�����
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rst = null;
	
	// ���ȼ�������
	static {
		try {
			// �������ݿ�����
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����mysql���ݿ�
	 * @throws Exception 
	 */
	public static void ConnDB() throws Exception
	{
		// �������Ϊ�գ��򴴽�mysql����
		if (con == null) {			
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
	}
	
	/**
	 * ��ѯ���
	 * @param sql ��ѯ��SQL���
	 * @return ���ز�ѯ���ResultSet
	 * @throws SQLException 
	 */
	public static ResultSet Query(String sql) throws SQLException
	{
		stmt = con.createStatement();
		rst = stmt.executeQuery(sql);	
		return 	rst;
	}
	
	/**
	 * ���¡����롢ɾ��
	 * @param sql ִ�е�SQL���
	 * @return Ӱ�������
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
	 * �ر����ݿ�
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

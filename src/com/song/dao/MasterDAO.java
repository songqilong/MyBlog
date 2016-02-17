package com.song.dao;

import java.sql.ResultSet;
import com.song.common.DBUtils;
import com.song.entity.Master;

public class MasterDAO {


	/**
	 * ����û�
	 * @param user �û�����
	 * @return true��ӳɹ���false���ʧ��
	 */
	public boolean AddMaster(Master user)
	{
		boolean isSuccess = false;
		// �������û���SQL���
		String sql = "insert into t_master(username,password) values('"+user.getUsername()+"','"+user.getPassword()+"')";
		try {
			// �����ݿ�
			DBUtils.ConnDB();
			// ִ�в������ݿ����
			int row = DBUtils.ExecuteUpdateOrDelete(sql);
			// ���Ӱ����������0��ִ�гɹ�
			if(row >0)
			{
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			DBUtils.CloseCon();
			return isSuccess;
		
	}

	/**
	 * ��ȡ�����û�
	 * @param user
	 * @return
	 */
	public Master GetMaster(Master user)
	{
		String sql = "select * from t_master where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		Master u = null;
		try {
			// �����ݿ�
			DBUtils.ConnDB();;
			// ִ�в�ѯ���ݿ����
			ResultSet rst = DBUtils.Query(sql);
			if(rst.next())
			{
				u = new Master();
				u.setId(rst.getInt("id"));
				u.setPassword(rst.getString("password"));
				u.setUsername(rst.getString("username"));
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			DBUtils.CloseCon();
			return u;		
	}
	
	/**
	 * �����û��������ȡ�����û�
	 * @param username
	 * @param password
	 * @return
	 */
	public Master GetMaster(String username,String password)
	{
		String sql = "select * from t_master where username='"+username+"' and password='"+password+"'";
		Master master = null;
		try {
			// �����ݿ�
			DBUtils.ConnDB();;
			// ִ�в�ѯ���ݿ����
			ResultSet rst = DBUtils.Query(sql);
			if(rst.first())
			{
				master = new Master();
				master.setId(rst.getInt("id"));
				master.setPassword(rst.getString("password"));
				master.setUsername(rst.getString("username"));
				master.setNickName(rst.getString("nickname"));
				master.setEmail(rst.getString("email"));
				master.setSex(rst.getString("sex"));
				master.setQq(rst.getString("qq"));
				master.setRegisterTime(rst.getString("rtime"));
				master.setLastLoginTime(rst.getString("lltime"));
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			DBUtils.CloseCon();
			return master;		
	}
	
	/**
	 * ��������ID��ȡ������Ϣ
	 * @param masterId
	 * @return
	 */
	public Master getMaster(int masterId){
		Master master = null;
		String sql = "select * from t_master where id = "+masterId+"";
		try {
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			if(rst.next())
			{
				master = new Master();
				master.setId(rst.getInt("id"));
				master.setPassword(rst.getString("password"));
				master.setUsername(rst.getString("username"));
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.CloseCon();
		return master;
	}
}

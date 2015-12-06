package com.song.dao;

import java.sql.ResultSet;
import com.song.common.DBUtils;
import com.song.entity.User;

public class UserDAO {


	/**
	 * ����û�
	 * @param user �û�����
	 * @return true��ӳɹ���false���ʧ��
	 */
	public boolean AddUser(User user)
	{
		boolean isSuccess = false;
		// �������û���SQL���
		String sql = "insert into t_user(username,password) values('"+user.getUsername()+"','"+user.getPassword()+"')";
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
			isSuccess = false;
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
	public User GetUser(User user)
	{
		String sql = "select * from t_user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		User u = null;
		try {
			// �����ݿ�
			DBUtils.ConnDB();;
			// ִ�в�ѯ���ݿ����
			ResultSet rst = DBUtils.Query(sql);
			if(rst.next())
			{
				u = new User();
				u.setPassword(rst.getString("password"));
				u.setUsername(rst.getString("username"));
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			u = null;
			e.printStackTrace();
		}
			DBUtils.CloseCon();
			return u;
		
	}
}

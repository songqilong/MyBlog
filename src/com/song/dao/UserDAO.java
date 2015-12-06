package com.song.dao;

import java.sql.ResultSet;
import com.song.common.DBUtils;
import com.song.entity.User;

public class UserDAO {


	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return true添加成功，false添加失败
	 */
	public boolean AddUser(User user)
	{
		boolean isSuccess = false;
		// 插入新用户的SQL语句
		String sql = "insert into t_user(username,password) values('"+user.getUsername()+"','"+user.getPassword()+"')";
		try {
			// 打开数据库
			DBUtils.ConnDB();
			// 执行插入数据库语句
			int row = DBUtils.ExecuteUpdateOrDelete(sql);
			// 如果影响行数大于0则执行成功
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
	 * 获取单个用户
	 * @param user
	 * @return
	 */
	public User GetUser(User user)
	{
		String sql = "select * from t_user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		User u = null;
		try {
			// 打开数据库
			DBUtils.ConnDB();;
			// 执行查询数据库语句
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

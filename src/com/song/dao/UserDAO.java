package com.song.dao;

import com.song.common.DBUtils;
import com.song.entity.User;

public class UserDAO {


	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return true添加成功，false添加失败
	 */
	@SuppressWarnings("finally")
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
		}finally{
			DBUtils.CloseCon();
			return isSuccess;
		}
	}
}

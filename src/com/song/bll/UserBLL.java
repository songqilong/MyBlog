package com.song.bll;

import com.song.dao.UserDAO;
import com.song.entity.User;

public class UserBLL {
	private UserDAO userDAO;

	/**
	 * 构造方法
	 */
	public UserBLL()
	{
		userDAO = new UserDAO();
	}
	
	/**
	 * 注册用户
	 * @param user 注册用户对象实体
	 * @return true注册成功，false注册失败
	 */
	public boolean Register(User user)
	{
		return userDAO.AddUser(user);		
	}
}

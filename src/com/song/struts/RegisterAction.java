package com.song.struts;

import com.song.bll.UserBLL;
import com.song.entity.User;

public class RegisterAction {
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 注册用户
	 * @return
	 * @throws Exception
	 */
	public String register()throws Exception{
		UserBLL userBLL = new UserBLL();
		// 如果注册成功
		if(userBLL.Register(user)){
			return "register";
		}		
		return "registerfail";
	}
}

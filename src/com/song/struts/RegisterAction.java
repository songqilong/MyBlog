package com.song.struts;

import com.song.bll.MasterBLL;
import com.song.entity.Master;

public class RegisterAction {
	private Master user;
	
	public Master getUser() {
		return user;
	}

	public void setUser(Master user) {
		this.user = user;
	}

	/**
	 * 注册用户
	 * @return
	 * @throws Exception
	 */
	public String register()throws Exception{
		MasterBLL masterBLL = new MasterBLL();
		// 如果注册成功
		if(masterBLL.Register(user)){
			return "register";
		}		
		return "registerfail";
	}
}

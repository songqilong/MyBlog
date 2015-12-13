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
	 * ע���û�
	 * @return
	 * @throws Exception
	 */
	public String register()throws Exception{
		UserBLL userBLL = new UserBLL();
		// ���ע��ɹ�
		if(userBLL.Register(user)){
			return "register";
		}		
		return "registerfail";
	}
}

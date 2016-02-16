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
	 * ע���û�
	 * @return
	 * @throws Exception
	 */
	public String register()throws Exception{
		MasterBLL masterBLL = new MasterBLL();
		// ���ע��ɹ�
		if(masterBLL.Register(user)){
			return "register";
		}		
		return "registerfail";
	}
}

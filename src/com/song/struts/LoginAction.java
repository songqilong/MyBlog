package com.song.struts;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.MasterBLL;
import com.song.entity.Master;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1344151717344033281L;
	private Master master;
	
	



	public Master getMaster() {
		return master;
	}





	public void setMaster(Master master) {
		this.master = master;
	}





	/**
	 * 登录Action
	 * @return
	 * @throws Exception
	 */
	public String login()throws Exception{	
		MasterBLL masterBLL = new MasterBLL();
		Master m = masterBLL.Login(master);
		// 如果用户名和密码验证通过
		if(m != null)
		{
			master.setId(m.getId());
			// 将用户信息保存进Session中
			ServletActionContext.getRequest().getSession().setAttribute("master", master);
			return "loginSuccess";
		}
		return "loginfail";
	}

}

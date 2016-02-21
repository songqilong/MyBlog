package com.song.struts;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.BlogBLL;
import com.song.bll.MasterBLL;
import com.song.entity.Blog;
import com.song.entity.Master;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1344151717344033281L;
	private String username;
	private String password;


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * 登录Action
	 * @return
	 * @throws Exception
	 */
	public String login()throws Exception{	
		MasterBLL masterBLL = new MasterBLL();
		Master master = masterBLL.Login(username,password);
		// 如果用户名和密码验证通过
		if(master != null)
		{
			// 将用户信息保存进struts2的Session对象中
			ServletActionContext.getRequest().getSession().setAttribute("Master", master);
			int masterId = master.getId();
			ActionContext.getContext().put("mid",masterId);
			return "loginSuccess";
		}
		return "loginfail";
	}

}

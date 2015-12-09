package com.song.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.UserBLL;
import com.song.entity.User;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1344151717344033281L;
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * 登录Action
	 * @return
	 * @throws Exception
	 */
	public String login()throws Exception{	
		UserBLL userBLL = new UserBLL();
		// 如果用户名和密码验证通过
		if(userBLL.Login(user))
		{
			// 将用户信息保存进Session中
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "success";
		}
		return "false";
	}

}

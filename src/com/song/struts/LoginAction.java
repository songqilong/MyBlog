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
	 * ��¼Action
	 * @return
	 * @throws Exception
	 */
	public String login()throws Exception{	
		UserBLL userBLL = new UserBLL();
		// ����û�����������֤ͨ��
		if(userBLL.Login(user))
		{
			// ���û���Ϣ�����Session��
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "success";
		}
		return "false";
	}

}

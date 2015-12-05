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
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取基础路径url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// 实例化用户对象
		User user = new User();
		// 对实例化对象设置用户名和密码
		user.setUsername(username);
		user.setPassword(password);
		UserBLL userBLL = new UserBLL();
		// 如果用户名和密码验证通过
		if(userBLL.Login(user))
		{
			// 将用户信息保存进Session中
			ActionContext.getContext().getSession().put("user", user);
			return "success";
		}
		return "false";
	}

}

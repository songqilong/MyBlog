package com.song.struts;

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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	/**
	 * 登录Action
	 * @return
	 * @throws Exception
	 */
	public String login()throws Exception{
		// 实例化用户对象
		User user = new User();
		// 对实例化对象设置用户名和密码
		user.setUsername(username);
		user.setPassword(password);
		UserBLL userBLL = new UserBLL();
		// 如果用户名和密码验证通过
		if(userBLL.Login(user))
		{
			return "success";
		}
		return "false";
	}

}

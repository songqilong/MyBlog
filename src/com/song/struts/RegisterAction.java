package com.song.struts;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.song.bll.BlogBLL;
import com.song.bll.MasterBLL;
import com.song.entity.Blog;
import com.song.entity.Master;

public class RegisterAction {
	private Master master;

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	/**
	 * 注册用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		MasterBLL masterBLL = new MasterBLL();
		// 如果注册成功
		if (masterBLL.Register(master)>0) {
			// 获取用户ID
			int masterId = masterBLL.GetMasterId(master.getUsername(), master.getPassword());
			// 将用户ID保存进struts2的request对象中
			ActionContext.getContext().put("mid", masterId);
			// 将用户对像保存进struts2的session对象中
			ActionContext.getContext().getSession().put("Master", master);
			// 生成一条blog信息
			Blog blog = new Blog();
			blog.setMasterId(masterId);
			blog.setBlogName(master.getNickName()+"博客");
			BlogBLL blogBLL = new BlogBLL();
			// 保存博客信息
			blogBLL.AddBlog(blog);
			return "register";
		}
		return "registerfail";
	}
	
	/**
	 * 验证用户名是否可注册
	 * @return
	 * @throws Exception
	 */
	public String checkUsername() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		// 获取要验证的用户名
		String username  = request.getParameter("username");
		MasterBLL masterBLL = new MasterBLL();
		if(!masterBLL.IsUsernameRegister(username)){
			out.print("canRegister");
		}else{
			out.print("cannotRegister");
		}
		return null;
	}
}

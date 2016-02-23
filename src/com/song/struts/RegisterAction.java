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
	 * ע���û�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		MasterBLL masterBLL = new MasterBLL();
		// ���ע��ɹ�
		if (masterBLL.Register(master)>0) {
			// ��ȡ�û�ID
			int masterId = masterBLL.GetMasterId(master.getUsername(), master.getPassword());
			// ���û�ID�����struts2��request������
			ActionContext.getContext().put("mid", masterId);
			// ���û����񱣴��struts2��session������
			ActionContext.getContext().getSession().put("Master", master);
			// ����һ��blog��Ϣ
			Blog blog = new Blog();
			blog.setMasterId(masterId);
			blog.setBlogName(master.getNickName()+"����");
			BlogBLL blogBLL = new BlogBLL();
			// ���沩����Ϣ
			blogBLL.AddBlog(blog);
			return "register";
		}
		return "registerfail";
	}
	
	/**
	 * ��֤�û����Ƿ��ע��
	 * @return
	 * @throws Exception
	 */
	public String checkUsername() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		// ��ȡҪ��֤���û���
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

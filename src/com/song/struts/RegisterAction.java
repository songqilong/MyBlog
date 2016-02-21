package com.song.struts;

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
}

package com.song.struts;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.NavigationBLL;
import com.song.entity.Navigation;

public class PhotoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5466689722495476346L;
	
	/**
	 * ͼƬ�б�
	 * @return
	 * @throws Exception
	 */
	public String showList()throws Exception{
		String result = "showlist";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations();
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() <= 0) {				
				result = "showlistfail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
	}
	
	/**
	 * ��ȡͼƬ�б�
	 * @return
	 * @throws Exception
	 */
	public String getList()throws Exception{
		// ��ȡ����master
		String master = ServletActionContext.getRequest().getParameter("master");
		// ����requestֵmaster
		ActionContext.getContext().put("master", master);
		return "getlist";
	}

}

package com.song.struts;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.NavigationBLL;
import com.song.entity.Navigation;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660000257797688856L;

	public String loadIndexData()throws Exception{
		ActionContext cxt = ActionContext.getContext();
		NavigationBLL nvaBLL = new NavigationBLL();
		List<Navigation> list = nvaBLL.GetNavigations();
		if (list.size() > 0) {
			cxt.getSession().put("navigation", list);
			return "success";
		}
		return "false";
	}
}

 package com.song.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.NavigationBLL;
import com.song.entity.Navigation;

public class CommonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597189176012215446L;

	/**
	 * 加载导航栏数据
	 * @return
	 * @throws Exception
	 */
	public String loadNavigation()throws Exception{
		// type参数用于确认页面起始跳转页面
		String type = ServletActionContext.getRequest().getParameter("type");
		String result = "";
		switch(type){
		// 首页加载导航
		case "100001":
			result = "ins";
			break;
		// 文章列表界面加载导航
		case "100002":
			result = "ans";
			break;
		// 图片列表界面导航 
		case "100003":
			result = "pns";
			break;
		// 单篇文章界面加载导航栏	
		case "100004":
			result = "sns";
			break;
		}
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// 获取导航栏的导航项
			List<Navigation> list = nvaBLL.GetNavigations();
			// 如果导航项集合长度不为0
			if (list.size() <= 0) {				
				result = "loadNavFail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
	}
	
	/**
	 * 加载路径用于定位js，css
	 * @return
	 * @throws Exception
	 */
	public String loadUrl()throws Exception{
		// 获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取基础路径url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// 将基础路径存入session
		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
		return "loadUrl";
	}
}

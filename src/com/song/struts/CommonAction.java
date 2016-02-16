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
	 * ���ص���������
	 * @return
	 * @throws Exception
	 */
	public String loadNavigation()throws Exception{
		// type��������ȷ��ҳ����ʼ��תҳ��
		String type = ServletActionContext.getRequest().getParameter("type");
		String result = "";
		switch(type){
		// ��ҳ���ص���
		case "100001":
			result = "ins";
			break;
		// �����б������ص���
		case "100002":
			result = "ans";
			break;
		// ͼƬ�б���浼�� 
		case "100003":
			result = "pns";
			break;
		// ��ƪ���½�����ص�����	
		case "100004":
			result = "sns";
			break;
		}
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations();
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() <= 0) {				
				result = "loadNavFail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
	}
	
	/**
	 * ����·�����ڶ�λjs��css
	 * @return
	 * @throws Exception
	 */
	public String loadUrl()throws Exception{
		// ��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ȡ����·��url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// ������·������session
		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
		return "loadUrl";
	}
}

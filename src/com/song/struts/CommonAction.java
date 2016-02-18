 package com.song.struts;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.CategoryBLL;
import com.song.bll.MasterBLL;
import com.song.bll.NavigationBLL;
import com.song.bll.NoticeBLL;
import com.song.common.PropertiesUtils;
import com.song.entity.Article;
import com.song.entity.Navigation;
import com.song.entity.Notice;

public class CommonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597189176012215446L;
	private Article article;
	private Notice notice;

	

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}


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
	
	public String getMasterName()throws Exception{
		MasterBLL masterBLL = new MasterBLL();
		// ��ȡresponse
		HttpServletResponse response = ServletActionContext.getResponse();
		// ��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		int masterId = Integer.parseInt(request.getParameter("master"));
		PrintWriter out = response.getWriter();
		out.print(masterBLL.GetMasterInfo(masterId).getUsername());
		return null;
	}
	
	/**
	 * ����ҳ������
	 * @return
	 * @throws Exception
	 */
	public String loadPageDate()throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		int masterId = Integer.parseInt(request.getParameter("mid"));
		String type = request.getParameter("type");
		getNavigation();
		getUrl();
		ArticleBLL articleBLL = new ArticleBLL();
		switch(type){
		// ������ҳ����
		case "100001":
			article = articleBLL.GetLastArticleByAuthor(masterId);
			ActionContext.getContext().put("recommends", articleBLL.GetRecommendArticles(masterId, 5));
			NoticeBLL noticeBLL = new NoticeBLL();
			notice = noticeBLL.GetLastNotice(masterId);
			CategoryBLL categoryBLL = new CategoryBLL();
			// ��ȡ����
			ActionContext.getContext().put("categorys", categoryBLL.GetCategorysByMid(masterId));
			result = "indexready";
			break;
		// Ĭ�������б�
		case "100002":	
			ActionContext.getContext().put("mid", masterId);
			// ��ȡȫ�����µ�����
			int totalArticleQty = articleBLL.GetAllArticleCount(masterId);
			// ��ȡÿҳ��ʾ���µ�����
			int perPageQty = Integer.parseInt(PropertiesUtils.ReadProperties("page"));
			// �������߷������������µ�����
			ActionContext.getContext().put("TotalArticleQty", articleBLL.GetAllArticleCount(masterId));
			// ��ҳ��
			int pageQty = 0;
			if(totalArticleQty%perPageQty != 0){
				pageQty = totalArticleQty/perPageQty+1;
			}else{
				pageQty = totalArticleQty/perPageQty;
			}		
			ActionContext.getContext().put("pageQty", pageQty);
			// ��ȡ��ǰҳ�� 
			int page = Integer.parseInt(request.getParameter("page"));
			ActionContext.getContext().put("page", page);
			ActionContext.getContext().put("articles", articleBLL.GetArticlesForPage(masterId, page));
			result = "defaultArticlesReady";
			break;
		}
		return result;
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	private boolean getNavigation(){
		boolean flag = false;
		Object nav = ActionContext.getContext().getSession().get("navigation");
		if (nav == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations();
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() > 0) {				
				ActionContext.getContext().getSession().put("navigation", list);
				flag = true;
			}			
		}
		return flag;
	}

	/**
	 * ��ȡURL
	 */
	private void getUrl(){
		// ��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ȡ����·��url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// ������·������session
		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
	}
}

package com.song.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.NavigationBLL;
import com.song.entity.Article;
import com.song.entity.Navigation;


public class IndexAction extends ActionSupport {

	private Article article;
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660000257797688856L;

	public String access()throws Exception{
		// ��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ȡ����·��url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// ������·������session
		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
		// ��ȡurl�и������û�����
		String master = ServletActionContext.getRequest().getParameter("master");
		// ���û���������session��
		ServletActionContext.getRequest().getSession().setAttribute("master", master);
		return "access";
	}
	
	/**
	 * ������ҳ��ʾ������
	 * @return
	 * @throws Exception
	 */
	public String loadNav()throws Exception{
		ActionContext cxt = ActionContext.getContext();
		NavigationBLL nvaBLL = new NavigationBLL();
		// ��ȡ�������ĵ�����
		List<Navigation> list = nvaBLL.GetNavigations();
		// ���������ϳ��Ȳ�Ϊ0
		if (list.size() > 0) {
			cxt.getSession().put("navigation", list);
			return "nav";
		}
		return "navfail";
	}
	
	/**
	 * ������ҳ��һƪ����
	 * @return
	 * @throws Exception
	 */
	public String loadArticle()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// ��ȡurl�еĲ���
		String author = ServletActionContext.getRequest().getSession().getAttribute("master").toString();
		// ��ȡ��ҳ��ʾ����������
		article = articleBLL.GetLastArticleByAuthor(author);
		// �����ҳ��ʾ������Ϊ��
		if(article != null){
			return "article";
		}
		return "articlefail";
	}
}

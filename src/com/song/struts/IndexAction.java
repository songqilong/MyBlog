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
		// 获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取基础路径url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// 将基础路径存入session
		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
		// 获取url中附带的用户参数
		String master = ServletActionContext.getRequest().getParameter("master");
		// 将用户参数存入session中
		ServletActionContext.getRequest().getSession().setAttribute("master", master);
		return "access";
	}
	
	/**
	 * 加载首页显示的数据
	 * @return
	 * @throws Exception
	 */
	public String loadNav()throws Exception{
		ActionContext cxt = ActionContext.getContext();
		NavigationBLL nvaBLL = new NavigationBLL();
		// 获取导航栏的导航项
		List<Navigation> list = nvaBLL.GetNavigations();
		// 如果导航项集合长度不为0
		if (list.size() > 0) {
			cxt.getSession().put("navigation", list);
			return "nav";
		}
		return "navfail";
	}
	
	/**
	 * 加载首页第一篇文章
	 * @return
	 * @throws Exception
	 */
	public String loadArticle()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// 获取url中的参数
		String author = ServletActionContext.getRequest().getSession().getAttribute("master").toString();
		// 获取首页显示的最新文章
		article = articleBLL.GetLastArticleByAuthor(author);
		// 如果首页显示的文章为空
		if(article != null){
			return "article";
		}
		return "articlefail";
	}
}

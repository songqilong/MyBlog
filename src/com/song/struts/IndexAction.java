package com.song.struts;


import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.NoticeBLL;
import com.song.entity.Article;
import com.song.entity.Notice;



public class IndexAction extends ActionSupport {

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
	 * 
	 */
	private static final long serialVersionUID = 1660000257797688856L;

	public String access()throws Exception{
//		// 获取request对象
//		HttpServletRequest request = ServletActionContext.getRequest();
//		// 获取基础路径url
//		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
//		// 将基础路径存入session
//		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
		// 获取url中附带的用户参数
		String str = ServletActionContext.getRequest().getParameter("master");
		int masterId = Integer.parseInt(str);
		// 将用户参数存入session中
		ServletActionContext.getRequest().getSession().setAttribute("master", masterId);
		return "access";
	}
	
//	/**
//	 * 加载首页显示的数据
//	 * @return
//	 * @throws Exception
//	 */
//	public String loadNav()throws Exception{
//		ActionContext cxt = ActionContext.getContext();
//		NavigationBLL nvaBLL = new NavigationBLL();
//		// 获取导航栏的导航项
//		List<Navigation> list = nvaBLL.GetNavigations();
//		// 如果导航项集合长度不为0
//		if (list.size() > 0) {
//			cxt.getSession().put("navigation", list);
//			return "nav";
//		}
//		return "navfail";
//	}
	
	/**
	 * 加载首页第一篇文章
	 * @return
	 * @throws Exception
	 */
	public String loadHomeInfo()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		NoticeBLL noticeBLL = new NoticeBLL();
		// 获取url中的参数
		int masterId = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute("master").toString());
		// 获取首页显示的最新文章
		article = articleBLL.GetLastArticleByAuthor(masterId);
		// 获取最新的公告
		notice = noticeBLL.GetLastNotice(masterId);
		// 如果首页显示的文章为空
		if(article != null&&notice != null){
			return "loadInfoSuccess";
		}
		return "loadInfoFail";
	}
}

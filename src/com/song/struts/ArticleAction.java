package com.song.struts;

import java.util.List;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.CommentBLL;
import com.song.bll.NavigationBLL;
import com.song.common.Common;
import com.song.entity.Article;
import com.song.entity.Comment;
import com.song.entity.Navigation;

public class ArticleAction extends ActionSupport {

	private Article article;
	private List<Article> articlelist;
	private List<Comment> commentlist;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticlelist() {
		return articlelist;
	}

	public void setArticlelist(List<Article> articlelist) {
		this.articlelist = articlelist;
	}

	
	
	public List<Comment> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 8713584507960045011L;

	/**
	 * 显示文章列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showList() throws Exception {
		String result = "showlist";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// 获取导航栏的导航项
			List<Navigation> list = nvaBLL.GetNavigations();
			// 如果导航项集合长度不为0
			if (list.size() < 0) {
				ActionContext.getContext().getSession().put("navigation", list);
				result = "showlistfail";
			}
		}
		return result;
//		return "showlist";
	}
	
	/**
	 * 获取文章列表
	 * @return
	 * @throws Exception
	 */
	public String getList()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// 获取master
		String master = ServletActionContext.getRequest().getParameter("master");
		// 获取全部文章的数量
		int totalArticleQty = articleBLL.GetAllArticleCount(master);
		ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
		// 获取当前页码 
		int page =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		// 获取当前页码全部文章的集合		
		this.articlelist = articleBLL.GetArticlesForPage(master,page);
		if(this.articlelist.size()>0){
			return "list";
		}
		// 计算分页数量
		return "list";
	}

	/**
	 * 前往写文章界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String write() throws Exception {
		return "write";
	}

	/**
	 * 提交新文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		// 设置文章创建的时间
		this.article.setCtime(Common.GetCurrentTime());
		// 获取存在Session对象中的作者即用户名
		String author = String.valueOf(ActionContext.getContext().getSession().get("user"));
		this.article.setAuthor(author);
		ArticleBLL articleBLL = new ArticleBLL();
		// 如果添加成功跳转到文章列表
		if (articleBLL.AddArticle(article)) {
			return "add";
		}
		return "addfail";
	}
	
	/**
	 * 获取单篇文章
	 * @return
	 * @throws Exception
	 */
	public String single()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// 获取文章的ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		//根据ID获取文章
		this.article = articleBLL.GetArticleById(articleID);
		// 如果文章不为空
		if(this.article != null){
			return "comment";
		}
		return "noarticle";
	}
	
	/**
	 * 获取评论数据
	 * @return
	 * @throws Exception
	 */
	public String comment()throws Exception{
		CommentBLL commentBLL = new CommentBLL();
		// 获取文章ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		// 更加文章ID获取文章的评论数
		int commentQty = commentBLL.GetCommentQtyByArticle(articleID);
		// 将文章的评论数存放在request中
		ActionContext.getContext().put("CommentQty", commentQty);
		// 获取评论集合
		this.commentlist = commentBLL.GetCommentCollection(articleID);
		return "single";
	}

}

package com.song.struts;

import java.util.List;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.CommentBLL;
import com.song.common.Common;
import com.song.entity.Article;
import com.song.entity.Comment;


public class ArticleAction extends ActionSupport {

	private Article article;
//	private List<Article> articlelist;
	private List<Comment> commentlist;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
//
//	public List<Article> getArticlelist() {
//		return articlelist;
//	}
//
//	public void setArticlelist(List<Article> articlelist) {
//		this.articlelist = articlelist;
//	}

	
	
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
		return "showList";
	}
	
	/**
	 * 获取单篇文章
	 * @return
	 * @throws Exception
	 */
	public String single()throws Exception{
		return "single";
		
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
		int masterId = Integer.parseInt(ServletActionContext.getRequest().getParameter("mid"));
		ActionContext.getContext().put("mid", masterId);
		this.article.setMasterId(masterId);
		ArticleBLL articleBLL = new ArticleBLL();
		// 如果添加成功跳转到文章列表
		if (articleBLL.AddArticle(article)) {
			return "addSuccess";
		}
		return "addfail";
	}
	
//	/**
//	 * 获取文章列表
//	 * @return
//	 * @throws Exception
//	 */
//	public String getList()throws Exception{
//		ArticleBLL articleBLL = new ArticleBLL();
//		// 获取master
//		int masterId = Integer.parseInt(ServletActionContext.getRequest().getParameter("master"));
//		// 强master保存进request中
//		ActionContext.getContext().put("master", masterId);
//		// 获取全部文章的数量
//		int totalArticleQty = articleBLL.GetAllArticleCount(masterId);
//		ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
//		// 获取每页显示文章的条数
//		int perPageQty = Integer.parseInt(PropertiesUtils.ReadProperties("page"));
//		// 分页数
//		int pageQty = 0;
//		if(totalArticleQty%perPageQty != 0){
//			pageQty = totalArticleQty/perPageQty+1;
//		}else{
//			pageQty = totalArticleQty/perPageQty;
//		}		
//		ActionContext.getContext().put("pageQty", pageQty);
//		// 获取当前页码 
//		int page =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
//		ActionContext.getContext().put("page", page);
//		// 获取当前页码全部文章的集合		
//		this.articlelist = articleBLL.GetArticlesForPage(masterId,page);
//		if(this.articlelist.size()>0){
//			return "getListSuccess";
//		}
//		// 计算分页数量
//		return "list";
//	}

	/**
	 * 前往写文章界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String write() throws Exception {
		String masterId  = ServletActionContext.getRequest().getParameter("mid");
		ServletActionContext.getRequest().setAttribute("mid", masterId);
		return "write";
	}


	

	
	/**
	 * 显示单篇文章
	 * @return
	 * @throws Exception
	 */
	public String showArticle()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// 获取文章的ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		// 将文章ID存入request对象中
		ActionContext.getContext().put("articleID", articleID);
		CommentBLL commentBLL = new CommentBLL();
		// 最新评论数量
		int commentLastQty = commentBLL.CommentLast(articleID);
		ActionContext.getContext().put("commentLastQty", commentLastQty);
		//根据ID获取文章
		this.article = articleBLL.GetArticleById(articleID);
		// 如果文章不为空
		if(this.article != null){
			// 累加文章点击次数
			articleBLL.SumArticleClick(articleID);
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
		return "singleShowSuccess";
	}

}

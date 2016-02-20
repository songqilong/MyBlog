package com.song.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.common.Common;
import com.song.entity.Article;
import com.song.entity.Comment;
import com.song.entity.Master;


public class ArticleAction extends ActionSupport  {

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
		if(article.getType()==1){
			Master master =(Master) ServletActionContext.getContext().getSession().get("Master");
			article.setAuthor(master.getNickName());
		}
		ArticleBLL articleBLL = new ArticleBLL();
		// 如果添加成功跳转到文章列表
		if (articleBLL.AddArticle(article)) {
			return "addSuccess";
		}
		return "addfail";
	}


	/**
	 * 前往写文章界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String write() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		int masterId  =Integer.parseInt(request.getParameter("mid"));
		int categoryId = Integer.parseInt(request.getParameter("cid"));
		request.setAttribute("mid", masterId);
		request.setAttribute("cid", categoryId);
		return "write";
	}

}

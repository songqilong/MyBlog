package com.song.struts;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.common.Common;
import com.song.entity.Article;

public class ArticleAction extends ActionSupport {

	private Article article;
	private List<Article> articlelist;

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
		ArticleBLL articleBLL = new ArticleBLL();
		// 获取全部文章的数量
		int totalArticleQty = articleBLL.GetAllArticleCount();
		ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
		// 获取当前页码 
		int page =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		// 获取当前页码全部文章的集合		
		this.articlelist = articleBLL.GetArticlesForPage(page);
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
			return "list";
		}
		return "write";
	}
	
	
	public String single()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// 获取文章的ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		//根据ID获取文章
		this.article = articleBLL.GetArticleById(articleID);
		// 如果文章不为空
		if(this.article != null){
			return "single";
		}
		return "noarticle";
	}

}

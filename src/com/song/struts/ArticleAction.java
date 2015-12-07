package com.song.struts;

import java.util.List;

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
		// 获取全部文章的数量

		// 获取全部文章的集合
		ArticleBLL articleBLL = new ArticleBLL();
		this.articlelist = articleBLL.GetAllArticle();
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
		this.article.setCtime(Common.GetCurrentTime());
		ArticleBLL articleBLL = new ArticleBLL();
		// 如果添加成功跳转到文章列表
		if (articleBLL.AddArticle(article)) {
			return "list";
		}
		return "write";
	}

}

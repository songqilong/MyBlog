package com.song.bll;

import java.util.List;

import com.song.dao.ArticleDAO;
import com.song.entity.Article;

public class ArticleBLL {
	private ArticleDAO articleDAO;
	
	public ArticleBLL() {
		super();
		// TODO Auto-generated constructor stub
		articleDAO = new ArticleDAO();
	}

	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	public boolean AddArticle(Article article){
		return articleDAO.AddArticle(article);
	}
	
	/**
	 * 获取分页文章
	 * @return
	 */
	public List<Article> GetAllArticle(){
		//return articleDAO.ArticleCollection();
		return null;
	}
	
	/**
	 * 获取所有文章的数量
	 * @return
	 */
	public int GetAllArticleCount(){
		return articleDAO.ArticleCount();
	}
}

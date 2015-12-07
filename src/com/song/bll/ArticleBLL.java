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
	 * �������
	 * @param article
	 * @return
	 */
	public boolean AddArticle(Article article){
		return articleDAO.AddArticle(article);
	}
	
	/**
	 * ��ȡ��ҳ����
	 * @return
	 */
	public List<Article> GetAllArticle(){
		//return articleDAO.ArticleCollection();
		return null;
	}
	
	/**
	 * ��ȡ�������µ�����
	 * @return
	 */
	public int GetAllArticleCount(){
		return articleDAO.ArticleCount();
	}
}

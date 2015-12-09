package com.song.bll;

import java.util.List;

import com.song.common.PropertiesUtils;
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
	public List<Article> GetArticlesForPage(String author,int page){
		// 从配置文件中获取每页显示的文章数量
		int articleCount = Integer.parseInt(PropertiesUtils.ReadProperties("page").toString());
		return articleDAO.ArticleCollection(author,page,articleCount);
	}
	
	/**
	 * 获取所有文章的数量
	 * @return
	 */
	public int GetAllArticleCount(){
		return articleDAO.ArticleCount();
	}

	/**
	 * 根据文章ID获取文章
	 * @param id 文章ID
	 * @return
	 */
	public Article GetArticleById(int id){
		return articleDAO.GetArticle(id);
	}

	/**
	 * 获取最新发布的一篇文章（用于首页显示）
	 * @param author
	 * @return
	 */
	public Article GetLastArticleByAuthor(String author){
		return articleDAO.GetArticle(author);
	}
}

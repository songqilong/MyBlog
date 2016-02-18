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
	public List<Article> GetArticlesForPage(int masterId,int page){
		// 从配置文件中获取每页显示的文章数量
		int articleCount = Integer.parseInt(PropertiesUtils.ReadProperties("page").toString());
		return articleDAO.ArticleCollection(masterId,page,articleCount);
	}
	
	/**
	 * 获取指定作者所有文章的数量
	 * @return
	 */
	public int GetAllArticleCount(int masterId){
		return articleDAO.ArticleCount(masterId);
	}

	/**
	 * 根据文章ID获取文章
	 * @param id 文章ID
	 * @return
	 */
	public Article GetArticleById(int id){
		String sql = "select * from t_article where id="+id+"";
		return articleDAO.GetSingleArticle(sql);
	}

	/**
	 * 获取最新发布的一篇文章（用于首页显示）
	 * @param author
	 * @return
	 */
	public Article GetLastArticleByMaster(int masterId){
		String sql = "select * from t_article where master_id="+masterId+" order by ctime desc limit 0,1";
		return articleDAO.GetSingleArticle(sql);
	}

	/**
	 * 累加文章点击次数
	 * @param articleID
	 * @return
	 */
	public int ModifyArticleClickTime(int aid,int clickTime){
		String sql = "update t_article set clicktime="+clickTime+" where id="+aid+"";
		return articleDAO.UpdateArticle(sql);
	}
	
	/**
	 * 获取推荐的文章
	 * @param masterId
	 * @param articleQty
	 * @return
	 */
	public List<Article> GetRecommendArticles(int masterId,int articleQty){
		return articleDAO.GetRecommendArticles(masterId, articleQty);
	}
}

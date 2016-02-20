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
	 * 获取不区分文章类别分页文章
	 * @return
	 */
	public List<Article> GetArticlesForPage(int masterId,int page,int pageSize,int categoryId){
		String sql = "";
		if(categoryId==0){
			sql = "select * from t_article where master_id = "+masterId+" and isdelete = 0 order by ctime desc limit "+((page-1)*pageSize)+","+pageSize+";";
		}else{
			sql = "select * from t_article where master_id = "+masterId+" and category_id = "+categoryId+" and isdelete = 0 order by ctime desc limit "+((page-1)*pageSize)+","+pageSize+";";
		} 
		return articleDAO.GetArticles(sql);
	}
	
//	/**
//	 * 获取区分文章类别的分页文章
//	 * @param masterId
//	 * @param categoryId
//	 * @param page
//	 * @return
//	 */
//	public List<Article> GetArticlesForPage(int masterId,int categoryId,int page,int pageSize){
//		// 从配置文件中获取每页显示的文章数量
//		//int pageSize = Integer.parseInt(PropertiesUtils.ReadProperties("page").toString());
//		String sql = "select * from t_article where master_id = "+masterId+" and category_id = "+categoryId+" and isdelete = 0 order by ctime desc limit "+((page-1)*pageSize)+","+pageSize+";";
//		return articleDAO.GetArticles(sql);
//	}
	
	/**
	 * 获取指定作者指定分类文章文章的数量
	 * @return
	 */
	public int GetAllArticleQtyByMid(int masterId,int categoryId){
		String sql = "";
		// 如果分类ID为0 则获取全部分类文章
		if(categoryId == 0){
			sql = "select * from t_article where master_id="+masterId+" and isdelete=0;";
		}else{
			 sql = "select * from t_article where master_id="+masterId+" and category_id="+categoryId+" and isdelete=0;";
		}
		return articleDAO.GetQueryQty(sql);
	}
	
//	/**
//	 * 获取指定分类文章的数量
//	 * @param masterId
//	 * @param categoryId
//	 * @return
//	 */
//	public int GetCategoryArticleQty(int masterId,int categoryId){
//		String sql = "select * from t_article where master_id="+masterId+" and category_id="+categoryId+" and isdelete=0;";
//		return articleDAO.GetQueryQty(sql);
//	}

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
		String sql = "select * from t_article where master_id='"+masterId+"' and isrecommend=1 order by ctime desc limit 0,"+articleQty+";";
		
		return articleDAO.GetArticles(sql);
	}
}

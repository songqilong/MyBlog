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
	 * ��ȡ��������������ҳ����
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
//	 * ��ȡ�����������ķ�ҳ����
//	 * @param masterId
//	 * @param categoryId
//	 * @param page
//	 * @return
//	 */
//	public List<Article> GetArticlesForPage(int masterId,int categoryId,int page,int pageSize){
//		// �������ļ��л�ȡÿҳ��ʾ����������
//		//int pageSize = Integer.parseInt(PropertiesUtils.ReadProperties("page").toString());
//		String sql = "select * from t_article where master_id = "+masterId+" and category_id = "+categoryId+" and isdelete = 0 order by ctime desc limit "+((page-1)*pageSize)+","+pageSize+";";
//		return articleDAO.GetArticles(sql);
//	}
	
	/**
	 * ��ȡָ������ָ�������������µ�����
	 * @return
	 */
	public int GetAllArticleQtyByMid(int masterId,int categoryId){
		String sql = "";
		// �������IDΪ0 ���ȡȫ����������
		if(categoryId == 0){
			sql = "select * from t_article where master_id="+masterId+" and isdelete=0;";
		}else{
			 sql = "select * from t_article where master_id="+masterId+" and category_id="+categoryId+" and isdelete=0;";
		}
		return articleDAO.GetQueryQty(sql);
	}
	
//	/**
//	 * ��ȡָ���������µ�����
//	 * @param masterId
//	 * @param categoryId
//	 * @return
//	 */
//	public int GetCategoryArticleQty(int masterId,int categoryId){
//		String sql = "select * from t_article where master_id="+masterId+" and category_id="+categoryId+" and isdelete=0;";
//		return articleDAO.GetQueryQty(sql);
//	}

	/**
	 * ��������ID��ȡ����
	 * @param id ����ID
	 * @return
	 */
	public Article GetArticleById(int id){
		String sql = "select * from t_article where id="+id+"";
		return articleDAO.GetSingleArticle(sql);
	}

	/**
	 * ��ȡ���·�����һƪ���£�������ҳ��ʾ��
	 * @param author
	 * @return
	 */
	public Article GetLastArticleByMaster(int masterId){
		String sql = "select * from t_article where master_id="+masterId+" order by ctime desc limit 0,1";
		return articleDAO.GetSingleArticle(sql);
	}

	/**
	 * �ۼ����µ������
	 * @param articleID
	 * @return
	 */
	public int ModifyArticleClickTime(int aid,int clickTime){
		String sql = "update t_article set clicktime="+clickTime+" where id="+aid+"";
		return articleDAO.UpdateArticle(sql);
	}
	
	/**
	 * ��ȡ�Ƽ�������
	 * @param masterId
	 * @param articleQty
	 * @return
	 */
	public List<Article> GetRecommendArticles(int masterId,int articleQty){
		String sql = "select * from t_article where master_id='"+masterId+"' and isrecommend=1 order by ctime desc limit 0,"+articleQty+";";
		
		return articleDAO.GetArticles(sql);
	}
}

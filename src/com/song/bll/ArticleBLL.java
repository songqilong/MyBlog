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
	 * ��������id�߼�ɾ������
	 * @param aid
	 * @return
	 */
	public int DeleteArticle(int aid){
		int row = 0;
		String sql = "update t_article set isdelete = 1 where id="+aid+";";
		row = articleDAO.UpdateArticle(sql);
		return row;
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
	
	/**
	 * �༭������������
	 * @param article
	 * @return
	 */
	public int EditArticle(Article article){
		int row = 0;
		String sql = "update t_article set title='" + article.getTitle() + "',author='"+article.getAuthor()+"',type=" + article.getType()
				+ ",category_id=" + article.getCategoryId() + ",sourceweb='" + article.getSourceweb() + "',sourceurl='"
				+ article.getSourceurl() + "',keyword='" + article.getKeyword() + "',content='" + article.getContent()
				+ "' where id=" + article.getId() + ";";
		row = articleDAO.UpdateArticle(sql);
		return row;
	}
	

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

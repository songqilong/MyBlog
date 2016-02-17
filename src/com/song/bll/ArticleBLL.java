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
	public List<Article> GetArticlesForPage(int masterId,int page){
		// �������ļ��л�ȡÿҳ��ʾ����������
		int articleCount = Integer.parseInt(PropertiesUtils.ReadProperties("page").toString());
		return articleDAO.ArticleCollection(masterId,page,articleCount);
	}
	
	/**
	 * ��ȡָ�������������µ�����
	 * @return
	 */
	public int GetAllArticleCount(int masterId){
		return articleDAO.ArticleCount(masterId);
	}

	/**
	 * ��������ID��ȡ����
	 * @param id ����ID
	 * @return
	 */
	public Article GetArticleById(int id){
		return articleDAO.GetArticle(id);
	}

	/**
	 * ��ȡ���·�����һƪ���£�������ҳ��ʾ��
	 * @param author
	 * @return
	 */
	public Article GetLastArticleByAuthor(int masterId){
		return articleDAO.GetArticle(masterId);
	}

	/**
	 * �ۼ����µ������
	 * @param articleID
	 * @return
	 */
	public boolean SumArticleClick(int articleID){
		return articleDAO.SumArticleClick(articleID);
	}
	
	/**
	 * ��ȡ�Ƽ�������
	 * @param masterId
	 * @param articleQty
	 * @return
	 */
	public List<Article> GetRecommendArticles(int masterId,int articleQty){
		return articleDAO.GetRecommendArticles(masterId, articleQty);
	}
}

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
	public List<Article> GetArticlesForPage(String author,int page){
		// �������ļ��л�ȡÿҳ��ʾ����������
		int articleCount = Integer.parseInt(PropertiesUtils.ReadProperties("page").toString());
		return articleDAO.ArticleCollection(author,page,articleCount);
	}
	
	/**
	 * ��ȡ�������µ�����
	 * @return
	 */
	public int GetAllArticleCount(){
		return articleDAO.ArticleCount();
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
	public Article GetLastArticleByAuthor(String author){
		return articleDAO.GetArticle(author);
	}
}

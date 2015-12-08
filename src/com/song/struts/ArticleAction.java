package com.song.struts;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
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
	 * ��ʾ�����б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showList() throws Exception {
		ArticleBLL articleBLL = new ArticleBLL();
		// ��ȡȫ�����µ�����
		int totalArticleQty = articleBLL.GetAllArticleCount();
		ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
		// ��ȡ��ǰҳ�� 
		int page =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		// ��ȡ��ǰҳ��ȫ�����µļ���		
		this.articlelist = articleBLL.GetArticlesForPage(page);
		if(this.articlelist.size()>0){
			return "list";
		}
		// �����ҳ����
		return "list";
	}

	/**
	 * ǰ��д���½���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String write() throws Exception {
		return "write";
	}

	/**
	 * �ύ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		// �������´�����ʱ��
		this.article.setCtime(Common.GetCurrentTime());
		// ��ȡ����Session�����е����߼��û���
		String author = String.valueOf(ActionContext.getContext().getSession().get("user"));
		this.article.setAuthor(author);
		ArticleBLL articleBLL = new ArticleBLL();
		// �����ӳɹ���ת�������б�
		if (articleBLL.AddArticle(article)) {
			return "list";
		}
		return "write";
	}
	
	
	public String single()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// ��ȡ���µ�ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		//����ID��ȡ����
		this.article = articleBLL.GetArticleById(articleID);
		// ������²�Ϊ��
		if(this.article != null){
			return "single";
		}
		return "noarticle";
	}

}

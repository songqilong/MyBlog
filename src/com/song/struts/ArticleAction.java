package com.song.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.common.Common;
import com.song.entity.Article;

public class ArticleAction extends ActionSupport {

	private Article article;
	
	
	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 8713584507960045011L;
	
	/**
	 * ��ʾ�����б�
	 * @return
	 * @throws Exception
	 */
	public String showList()throws Exception{
		// ��ȡȫ�����µ�����
		
		// ��ȡȫ�����µļ���
		
		// �����ҳ����
		return "list";
	} 
	
	/**
	 * ǰ��д���½���
	 * @return
	 * @throws Exception
	 */
	public String write()throws Exception{
		return "write";
	}
	
	/**
	 * �ύ������
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		this.article.setCtime(Common.GetCurrentTime());
		ArticleBLL articleBLL = new ArticleBLL();
		// �����ӳɹ���ת�������б�
		if(articleBLL.AddArticle(article)){
			return "list";
		}
		return "write";
	}

}

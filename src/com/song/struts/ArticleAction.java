package com.song.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.common.Common;
import com.song.entity.Article;
import com.song.entity.Comment;
import com.song.entity.Master;


public class ArticleAction extends ActionSupport  {

	private Article article;
//	private List<Article> articlelist;
	private List<Comment> commentlist;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
//
//	public List<Article> getArticlelist() {
//		return articlelist;
//	}
//
//	public void setArticlelist(List<Article> articlelist) {
//		this.articlelist = articlelist;
//	}

	
	
	public List<Comment> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
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
		return "showList";
	}
	
	/**
	 * ��ȡ��ƪ����
	 * @return
	 * @throws Exception
	 */
	public String single()throws Exception{
		return "single";
		
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
		int masterId = Integer.parseInt(ServletActionContext.getRequest().getParameter("mid"));
		ActionContext.getContext().put("mid", masterId);
		this.article.setMasterId(masterId);
		if(article.getType()==1){
			Master master =(Master) ServletActionContext.getContext().getSession().get("Master");
			article.setAuthor(master.getNickName());
		}
		ArticleBLL articleBLL = new ArticleBLL();
		// �����ӳɹ���ת�������б�
		if (articleBLL.AddArticle(article)) {
			return "addSuccess";
		}
		return "addfail";
	}


	/**
	 * ǰ��д���½���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String write() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		int masterId  =Integer.parseInt(request.getParameter("mid"));
		int categoryId = Integer.parseInt(request.getParameter("cid"));
		request.setAttribute("mid", masterId);
		request.setAttribute("cid", categoryId);
		return "write";
	}

}

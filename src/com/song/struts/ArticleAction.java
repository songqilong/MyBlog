package com.song.struts;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
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
	 * ��ȡҪ�༭��������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String getArticleForEdit()throws Exception{
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control","no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int articleId = Integer.parseInt(request.getParameter("aid"));
		ArticleBLL articleBLL = new ArticleBLL();
		article = articleBLL.GetArticleById(articleId);
		String result = JSON.toJSON(article).toString();
		System.out.println(result);
		out.print(result);
		return null;
	}
	

	
	/**
	 * �ύ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception {
		// �������´�����ʱ��
		this.article.setCtime(Common.GetCurrentTime());
		// ��ȡ����Session�����е����߼��û���
		int masterId = Integer.parseInt(ServletActionContext.getRequest().getParameter("mid"));
		int categoryId = Integer.parseInt(ServletActionContext.getRequest().getParameter("cid"));
		ActionContext.getContext().put("mid", masterId);
		ActionContext.getContext().put("cid", categoryId);
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
	 * ��תд���½���
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
	
	/**
	 * �༭����
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		HttpServletRequest request =  ServletActionContext.getRequest();
		int masterId  =Integer.parseInt(request.getParameter("mid"));
		int articleId = Integer.parseInt(request.getParameter("aid"));
		int categoryId = Integer.parseInt(request.getParameter("cid"));
		request.setAttribute("mid", masterId);
		request.setAttribute("aid", articleId);
		request.setAttribute("cid", categoryId);
		ArticleBLL articleBLL = new ArticleBLL();
		article = articleBLL.GetArticleById(articleId);
		return "edit";
	}
	
	/**
	 * ���±༭��������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		String result = "updateFail";
		HttpServletRequest request =  ServletActionContext.getRequest();
		int masterId = Integer.parseInt(request.getParameter("mid"));
		int categoryId = Integer.parseInt(request.getParameter("cid"));
		int articleId = Integer.parseInt(request.getParameter("aid"));
		ActionContext.getContext().put("mid", masterId);
		ActionContext.getContext().put("cid", categoryId);
		article.setId(articleId);
		ArticleBLL articleBLL = new ArticleBLL();
		if(articleBLL.EditArticle(article)>0){
			result = "updateSuccess";
		}
		return result;
	}
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		int articleId = Integer.parseInt(request.getParameter("aid"));
		ArticleBLL articleBLL = new ArticleBLL();
		if(articleBLL.DeleteArticle(articleId)>0){
			out.print("deleteSuccess");
		}else{
			out.print("deleteFail");
		}
		return null;
	}

}

package com.song.struts;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.CommentBLL;
import com.song.common.Common;
import com.song.entity.Article;
import com.song.entity.Comment;

public class CommentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4248206423855973781L;
	
	private Comment comment;
	private Article article;
	
	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}

	
	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	/**
	 * �ύ����
	 * @return
	 * @throws Exception
	 */
	public String commit()throws Exception{
		CommentBLL commentBLL = new CommentBLL();
		// ��ȡmaster����
		String master = ServletActionContext.getRequest().getParameter("master");
		// ��master��������session��
		ActionContext.getContext().put("master", master);
		// ��ȡ����ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		// ��������ID
		comment.setArticleid(articleID);
		// ������ID����session������
		ActionContext.getContext().put("articleID", articleID);
		// ��ȡ������IP
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		// ����IP
		comment.setIp(ip);
		// ���������ύʱ��
		comment.setCtime(Common.GetCurrentTime());
		if(commentBLL.CommentAdd(comment)){
			return "commit";
		}		
		 return "commitfail";
	}
}

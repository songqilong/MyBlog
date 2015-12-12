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
	 * 提交评论
	 * @return
	 * @throws Exception
	 */
	public String commit()throws Exception{
		CommentBLL commentBLL = new CommentBLL();
		// 获取master参数
		String master = ServletActionContext.getRequest().getParameter("master");
		// 将master参数存入session中
		ActionContext.getContext().put("master", master);
		// 获取文章ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		// 设置文章ID
		comment.setArticleid(articleID);
		// 将文章ID存入session对象中
		ActionContext.getContext().put("articleID", articleID);
		// 获取评论者IP
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		// 设置IP
		comment.setIp(ip);
		// 设置评论提交时间
		comment.setCtime(Common.GetCurrentTime());
		if(commentBLL.CommentAdd(comment)){
			return "commit";
		}		
		 return "commitfail";
	}
}

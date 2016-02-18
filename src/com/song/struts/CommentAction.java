package com.song.struts;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		String author = request.getParameter("author");
		String content = request.getParameter("comment");
		// 获取文章ID
		int aid = Integer.parseInt(request.getParameter("aid"));
		CommentBLL commentBLL = new CommentBLL();
		Comment cet = new Comment();
		cet.setArticleId(aid);
		cet.setAuthor(author);
		cet.setContent(content);
		cet.setIp(request.getRemoteAddr());
		cet.setCtime(Common.GetCurrentTime());
		if(commentBLL.AddComment(comment)>0){
			out.print("addSuccess");
		}else{
			out.print("addFail");
		}		
		 return null;
	}
}

package com.song.bll;

import java.util.List;

import com.song.dao.CommentDAO;
import com.song.entity.Comment;

public class CommentBLL {
	private CommentDAO commentDAO;

	public CommentBLL() {
		commentDAO = new CommentDAO();
	}
	
	/**
	 * 根据文章ID获取文章的评论数量
	 * @param articleid
	 * @return
	 */
	public int GetCommentQtyByArticle(int articleid){
		return commentDAO.CommentCount(articleid);
	}
	
	/**
	 * 根据文章ID获取评论集合
	 * @param articleid 文章ID
	 * @return
	 */
	public List<Comment> GetCommentCollection(int articleid){
		return commentDAO.CommentCollection(articleid);
	}
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public boolean CommentAdd(Comment comment){
		return commentDAO.CommentAdd(comment);
	}
	
	/**
	 * 获取最新评论的数量
	 * @param articleID
	 * @return
	 */
	public int CommentLast(int articleID){
		return commentDAO.CommentLast(articleID);
	}
}

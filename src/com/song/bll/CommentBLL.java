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
	 * ��������ID��ȡ���µ���������
	 * @param articleid
	 * @return
	 */
	public int GetCommentQtyByArticle(int articleid){
		return commentDAO.CommentCount(articleid);
	}
	
	/**
	 * ��������ID��ȡ���ۼ���
	 * @param articleid ����ID
	 * @return
	 */
	public List<Comment> GetCommentCollection(int articleid){
		return commentDAO.CommentCollection(articleid);
	}
	
	/**
	 * �������
	 * @param comment
	 * @return
	 */
	public boolean CommentAdd(Comment comment){
		return commentDAO.CommentAdd(comment);
	}
	
	/**
	 * ��ȡ�������۵�����
	 * @param articleID
	 * @return
	 */
	public int CommentLast(int articleID){
		return commentDAO.CommentLast(articleID);
	}
}

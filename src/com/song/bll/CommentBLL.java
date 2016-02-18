package com.song.bll;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	public int GetCommentQtyByAid(int aid){
		String sql = "select * from t_comment where article_id="+aid+";";
		return commentDAO.GetQueryQty(sql);
	}
	
	/**
	 * ��ȡ�������۵�����
	 * @param articleID
	 * @return
	 */
	public int GetLastCommentQty(int aid){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(Calendar.getInstance().getTime())+" 00:00:00";
		String sql = "select * from t_comment where article_id="+aid+" and ctime>'"+date+"';";
		return commentDAO.GetQueryQty(sql);
	}
	
	/**
	 * ��������ID��ȡ���ۼ���
	 * @param articleid ����ID
	 * @return
	 */
	public List<Comment> GetComments(int aid){
		String sql = "select * from t_comment where article_id="+aid+";";
		return commentDAO.GetCollectionComment(sql);
	}
	
	/**
	 * �������
	 * @param comment
	 * @return
	 */
	public int AddComment(Comment comment){
		String sql = "insert into t_comment(article_id,author,content,ip,replyto,ctime) values ("
				+ comment.getArticleId() + ",'" + comment.getAuthor() + "','" + comment.getContent() + "','"
				+ comment.getIp() + "','" + comment.getReplyto() + "','" + comment.getCtime() + "');";
		return commentDAO.UpdateComment(sql);
	}
	

}

package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Comment;

public class CommentDAO {

	/**
	 * ��������id��ȡ��Ӧ������
	 * @param articleid ����ID
	 * @return
	 */
	public int CommentCount(int articleid){
		int row = 0;
		// ������ѯSQL���
		String sql = "select * from t_comment where articleid="+articleid+";";
		try{
			// �����ݿ�
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			// ����ƶ������һ��
			rst.last();
			// ��ȡ���һ�е��к�
			row = rst.getRow();
			// �ͷ���Դ
			rst.close();
			// �ر����ݿ�
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	} 

	/**
	 * ��������ID��ȡ���ۼ���
	 * @param articleid
	 * @return
	 */
	public List<Comment> CommentCollection(int articleid){
		List<Comment> list = new ArrayList<Comment>();
		String sql = "select * from t_comment where articleid="+articleid+";";
		try{
			// �������ݿ�
			DBUtils.ConnDB();
			// ִ�в�ѯSQL���
			ResultSet rst = DBUtils.Query(sql);
			while(rst.next()){
				Comment comment = new Comment();
				comment.setId(rst.getInt("id"));
				comment.setArticleid(rst.getInt("articleid"));
				comment.setAuthor(rst.getString("author"));
				comment.setContent(rst.getString("content"));
				comment.setIp(rst.getString("ip"));
				comment.setReplyto(rst.getString("replyto"));
				comment.setCtime(rst.getString("ctime"));
				list.add(comment);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}

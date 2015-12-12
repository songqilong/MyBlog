package com.song.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Comment;

public class CommentDAO {

	/**
	 * 根据文章id获取相应的评论
	 * @param articleid 文章ID
	 * @return
	 */
	public int CommentCount(int articleid){
		int row = 0;
		// 构建查询SQL语句
		String sql = "select * from t_comment where articleid="+articleid+";";
		try{
			// 打开数据库
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			// 光标移动到最后一行
			rst.last();
			// 获取最后一行的行号
			row = rst.getRow();
			// 释放资源
			rst.close();
			// 关闭数据库
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	} 

	/**
	 * 根据文章ID获取评论集合
	 * @param articleid
	 * @return
	 */
	public List<Comment> CommentCollection(int articleid){
		List<Comment> list = new ArrayList<Comment>();
		String sql = "select * from t_comment where articleid="+articleid+";";
		try{
			// 连接数据库
			DBUtils.ConnDB();
			// 执行查询SQL语句
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

	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public boolean CommentAdd(Comment comment){
		boolean isSuccess = false;
		int row = 0;
		String sql = "insert into t_comment(articleid,author,content,ip,ctime) values(" + comment.getArticleid() + ",'"
				+ comment.getAuthor() + "','" + comment.getContent() + "','" + comment.getIp() + "','"
				+ comment.getCtime() + "');";
		try{
			DBUtils.ConnDB();;
			row = DBUtils.ExecuteUpdateOrDelete(sql);
			if(row >0){
				isSuccess = true;
			}
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	/**
	 * 获取最新评论数量
	 * @param articleID
	 * @return
	 */
	public int CommentLast(int articleID){
		int row = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(Calendar.getInstance().getTime())+" 00:00:00";
		String sql = "select * from t_comment where articleid="+articleID+" and ctime>'"+date+"';";
		try{
			// 打开数据库
			DBUtils.ConnDB();
			// 执行SQL查询
			ResultSet rst = DBUtils.Query(sql);
			rst.last();
			row = rst.getRow();
			// 释放资源
			rst.close();
			// 关闭数据库连接
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}
}

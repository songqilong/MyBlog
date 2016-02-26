package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Notice;

public class NoticeDAO {

	/**
	 * 添加公告
	 * @param notice
	 * @return
	 */
	public boolean AddNotice(Notice notice){
		boolean isSuccess = false;
		String sql = "insert into t_notice(master_id,title,content,ctime) values ("+notice.getMasterId()+",'"+notice.getTitle()+"','"+notice.getContent()+"','"+notice.getCtime()+"')";
		try{
			DBUtils.ConnDB();
			int row = DBUtils.ExecuteUpdateOrDelete(sql);
			if(row >0){
				isSuccess = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.CloseCon();
		return isSuccess;
	}
	
	/**
	 * 获取最新一条公告
	 * @return
	 */
	public Notice GetNotice(String sql){
		Notice notice = null;
		try {
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			if(rst.first()){
				notice = new Notice();
				notice.setId(rst.getInt("id"));
				notice.setMasterId(rst.getInt("master_id"));
				notice.setTitle(rst.getString("title"));
				notice.setContent(rst.getString("content"));
				notice.setCtime(rst.getString("ctime"));
				notice.setIsdelete(rst.getInt("isdelete"));
				notice.setDtime(rst.getString("dtime"));
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
	
	/**
	 * 获取公告集合
	 * @param sql
	 * @return
	 */
	public List<Notice> GetNotices(String sql){
		List<Notice> list = new ArrayList<Notice>();
		try {
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			while(rst.next()){
				Notice notice = new Notice();
				notice.setId(rst.getInt("id"));
				notice.setMasterId(rst.getInt("master_id"));
				notice.setTitle(rst.getString("title"));
				notice.setContent(rst.getString("content"));
				notice.setCtime(rst.getString("ctime"));
				notice.setIsdelete(rst.getInt("isdelete"));
				notice.setDtime(rst.getString("dtime"));
				list.add(notice);
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 更新文章对象
	 * @param sql
	 * @return
	 */
	public int UpdateNotice(String sql){
		int row =0;
		try{
			DBUtils.ConnDB();
			row = DBUtils.ExecuteUpdateOrDelete(sql);
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}
	
	/**
	 * 查询结果的条数
	 * @param sql
	 * @return
	 */
	public int GetQueryQty(String sql){
		int row = 0;
		try{
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			rst.last();
			row = rst.getRow();
			rst.close();
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}
}

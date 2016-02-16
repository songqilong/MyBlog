package com.song.dao;

import java.sql.ResultSet;

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
	public Notice GetNotice(int masterId){
		Notice notice = null;
		String sql = "select * from t_notice where master_id="+masterId+" order by ctime desc limit 0,1";
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
}

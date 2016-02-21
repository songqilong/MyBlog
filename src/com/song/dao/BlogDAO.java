package com.song.dao;

import java.sql.ResultSet;

import com.song.common.DBUtils;
import com.song.entity.Blog;

public class BlogDAO {

	/**
	 * ��ȡһ��������Ϣ
	 * @param sql
	 * @return
	 */
	public Blog GetBlog(String sql){
		Blog  blog = null;
		try {
			// �����ݿ�����
			DBUtils.ConnDB(); 
			ResultSet rst = DBUtils.Query(sql);
			if(rst.first()){
				blog = new Blog();
				blog.setId(rst.getInt("id"));
				blog.setMasterId(rst.getInt("master_id"));
				blog.setBlogName(rst.getString("bname"));
			}
			rst.close();
			DBUtils.CloseCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blog;
	}
	
	/**
	 * ���²�����Ϣ
	 * @param sql
	 * @return
	 */
	public int UpdateBlog(String sql){
		int row = 0; 
		try{
			DBUtils.ConnDB();
			row = DBUtils.ExecuteUpdateOrDelete(sql);
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}
}

package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Category;

public class CategoryDAO {
	 
	/**
	 * ��ȡ������Ϣ����
	 * @param sql
	 * @return
	 */
	public List<Category> GetCategorys(String sql){
		List<Category> list = new ArrayList<Category>();
		try {
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			while(rst.next()){
				Category category = new Category();
				category.setId(rst.getInt("id"));
				category.setMasterId(rst.getInt("master_id"));
				category.setCategory(rst.getString("category"));
				category.setCtime(rst.getString("ctime"));
				category.setIsdelete(rst.getInt("isdelete"));
				category.setDtime(rst.getString("dtime"));
				list.add(category);
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.CloseCon();
		return list;
	}
	
	/**
	 * �������¶���
	 * @param sql
	 * @return
	 */
	public int UpdateCategory(String sql){
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
	 * ��ѯ���������
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

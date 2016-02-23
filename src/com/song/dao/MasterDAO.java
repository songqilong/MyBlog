package com.song.dao;

import java.sql.ResultSet;
import com.song.common.DBUtils;
import com.song.entity.Master;

public class MasterDAO {
	
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
	
	/**
	 * 更新用户
	 * @param sql
	 * @return
	 */
	public int UpdateMaster(String sql){
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
	
	/**
	 * 获取单个用户
	 * @param username
	 * @param password
	 * @return
	 */
	public Master GetMaster(String sql)
	{
		Master master = null;
		try {
			// 打开数据库
			DBUtils.ConnDB();;
			// 执行查询数据库语句
			ResultSet rst = DBUtils.Query(sql);
			if(rst.first())
			{
				master = new Master();
				master.setId(rst.getInt("id"));
				master.setPassword(rst.getString("password"));
				master.setUsername(rst.getString("username"));
				master.setNickName(rst.getString("nickname"));
				master.setEmail(rst.getString("email"));
				master.setSex(rst.getString("sex"));
				master.setQq(rst.getString("qq"));
				master.setRegisterTime(rst.getString("rtime"));
				master.setLastLoginTime(rst.getString("lltime"));
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			DBUtils.CloseCon();
			return master;		
	}
}

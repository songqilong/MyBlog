package com.song.dao;

import java.sql.ResultSet;
import com.song.common.DBUtils;
import com.song.entity.Master;

public class MasterDAO {
	
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
	
	/**
	 * �����û�
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
	 * ��ȡ�����û�
	 * @param username
	 * @param password
	 * @return
	 */
	public Master GetMaster(String sql)
	{
		Master master = null;
		try {
			// �����ݿ�
			DBUtils.ConnDB();;
			// ִ�в�ѯ���ݿ����
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

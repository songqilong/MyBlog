package com.song.bll;

import com.song.dao.MasterDAO;
import com.song.entity.Master;

public class MasterBLL {
	private MasterDAO masterDAO;

	/**
	 * ���췽��
	 */
	public MasterBLL()
	{
		masterDAO = new MasterDAO();
	}
	
	/**
	 * ע���û�
	 * 
	 * @param master
	 * @return
	 */
	public int Register(Master master) {
		String sql = "insert into t_master(username,password,nickname,email,sex,qq,rtime,lltime) values('"
				+ master.getUsername() + "','" + master.getPassword() + "','" + master.getNickName() + "','"
				+ master.getEmail() + "','" + master.getSex() + "','" + master.getQq() + "','"
				+ master.getRegisterTime() + "','" + master.getLastLoginTime() + "');";
		return masterDAO.UpdateMaster(sql);
	}
	
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	public Master Login(String username,String password)
	{
		String sql = "select * from t_master where username='"+username+"' and password='"+password+"'";
		return masterDAO.GetMaster(sql);
	}
	
	/**
	 * �����û��������ȡ�û�ID
	 * @param username
	 * @param password
	 * @return
	 */
	public int GetMasterId(String username,String password){
		return Login(username,password).getId();
	}
	
}

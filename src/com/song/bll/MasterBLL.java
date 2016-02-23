package com.song.bll;

import com.song.dao.MasterDAO;
import com.song.entity.Master;

public class MasterBLL {
	private MasterDAO masterDAO;

	/**
	 * 构造方法
	 */
	public MasterBLL()
	{
		masterDAO = new MasterDAO();
	}
	
	/**
	 * 注册用户
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
	 * 用户登录
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
	 * 根据用户名密码获取用户ID
	 * @param username
	 * @param password
	 * @return
	 */
	public int GetMasterId(String username,String password){
		return Login(username,password).getId();
	}
	
	/**
	 * 根据给定的用户，验证该用户名是否已经被注册
	 * @param username
	 * @return true已经被注册   false尚未被注册
	 */
	public boolean IsUsernameRegister(String username){
		String sql = "select * from t_master where username='"+username+"';";
		if(masterDAO.GetQueryQty(sql)>0){
			return true;
		}
		return false;
	}
	
}

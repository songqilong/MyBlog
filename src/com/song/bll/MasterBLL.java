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
	 * @param user 注册用户对象实体
	 * @return true注册成功，false注册失败
	 */
	public boolean Register(Master user)
	{
		return masterDAO.AddMaster(user);		
	}
	
	/**
	 * 用户登录
	 * @param user 封装的登录用户信息
	 * @return true验证通过可以登录，false验证失败不能登录
	 */
	public Master Login(Master user)
	{
		return masterDAO.GetMaster(user);
	}
	
	/**
	 * 根据作者ID获取作者信息
	 * @param masterId
	 * @return
	 */
	public Master GetMasterInfo(int masterId){
		return masterDAO.getMaster(masterId);
	}
}

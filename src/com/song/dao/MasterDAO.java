package com.song.dao;

import java.sql.ResultSet;
import com.song.common.DBUtils;
import com.song.entity.Master;

public class MasterDAO {


	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return true添加成功，false添加失败
	 */
	public boolean AddMaster(Master user)
	{
		boolean isSuccess = false;
		// 插入新用户的SQL语句
		String sql = "insert into t_master(username,password) values('"+user.getUsername()+"','"+user.getPassword()+"')";
		try {
			// 打开数据库
			DBUtils.ConnDB();
			// 执行插入数据库语句
			int row = DBUtils.ExecuteUpdateOrDelete(sql);
			// 如果影响行数大于0则执行成功
			if(row >0)
			{
				isSuccess = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			DBUtils.CloseCon();
			return isSuccess;
		
	}

	/**
	 * 获取单个用户
	 * @param user
	 * @return
	 */
	public Master GetMaster(Master user)
	{
		String sql = "select * from t_master where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		Master u = null;
		try {
			// 打开数据库
			DBUtils.ConnDB();;
			// 执行查询数据库语句
			ResultSet rst = DBUtils.Query(sql);
			if(rst.next())
			{
				u = new Master();
				u.setId(rst.getInt("id"));
				u.setPassword(rst.getString("password"));
				u.setUsername(rst.getString("username"));
			}
			rst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			DBUtils.CloseCon();
			return u;		
	}
	
	/**
	 * 根据用户名密码获取单个用户
	 * @param username
	 * @param password
	 * @return
	 */
	public Master GetMaster(String username,String password)
	{
		String sql = "select * from t_master where username='"+username+"' and password='"+password+"'";
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
	
	/**
	 * 根据作者ID获取作者信息
	 * @param masterId
	 * @return
	 */
	public Master getMaster(int masterId){
		Master master = null;
		String sql = "select * from t_master where id = "+masterId+"";
		try {
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			if(rst.next())
			{
				master = new Master();
				master.setId(rst.getInt("id"));
				master.setPassword(rst.getString("password"));
				master.setUsername(rst.getString("username"));
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

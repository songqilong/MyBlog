package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Navigation;

public class NavigationDAO {

	/**
	 * 获取导航栏中的导航项
	 * @param sql
	 * @return
	 */
	public List<Navigation> GetNavigations(String sql){
		List<Navigation> list = new ArrayList<Navigation>();
		try{
			// 连接数据库
			DBUtils.ConnDB();
			// 执行查询导航栏操作
			ResultSet rst = DBUtils.Query(sql);
			// 遍历查询结果并放入list集合
			while(rst.next())
			{
				Navigation nav = new Navigation();
				nav.setId(rst.getInt("id"));
				nav.setMasterId(rst.getInt("master_id"));
				nav.setNav_name(rst.getString("nav_name"));
				nav.setUrl(rst.getString("url"));
				nav.setVisible(rst.getInt("visible"));
				list.add(nav);
			}
			rst.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// 关闭数据库连接
		DBUtils.CloseCon();
		return list;
	}
}

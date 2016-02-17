package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Navigation;

public class NavigationDAO {

	/**
	 * 获取导航栏中的导航项
	 * @return 导航项集合
	 */
	public List<Navigation> GetNavigationItems()
	{
		List<Navigation> list = new ArrayList<Navigation>();
		String sql = "select * from t_navigation where visible = 1";
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

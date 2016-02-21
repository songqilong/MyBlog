package com.song.bll;

import java.util.List;

import com.song.dao.NavigationDAO;
import com.song.entity.Navigation;

public class NavigationBLL {
	private NavigationDAO navigationDAO;

	public NavigationBLL() {
		navigationDAO = new NavigationDAO();
	}
	
	/**
	 * 获取导航项
	 * @return
	 */
	public List<Navigation> GetNavigations(int masterId)
	{
		String sql = "select * from t_navigation where master_id in("+masterId+",0) and visible = 1 order by id asc";
		List<Navigation> list = navigationDAO.GetNavigations(sql);
		return list;
	}
}

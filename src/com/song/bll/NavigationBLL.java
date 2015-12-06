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
	 * ��ȡ������
	 * @return
	 */
	public List<Navigation> GetNavigations()
	{
		List<Navigation> list = navigationDAO.GetNavigationItem();
		return list;
	}
}

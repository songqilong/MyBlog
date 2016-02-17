package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Navigation;

public class NavigationDAO {

	/**
	 * ��ȡ�������еĵ�����
	 * @return �������
	 */
	public List<Navigation> GetNavigationItems()
	{
		List<Navigation> list = new ArrayList<Navigation>();
		String sql = "select * from t_navigation where visible = 1";
		try{
			// �������ݿ�
			DBUtils.ConnDB();
			// ִ�в�ѯ����������
			ResultSet rst = DBUtils.Query(sql);
			// ������ѯ���������list����
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
		// �ر����ݿ�����
		DBUtils.CloseCon();
		return list;
	}
}

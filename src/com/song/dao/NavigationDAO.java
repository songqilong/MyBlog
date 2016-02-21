package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.entity.Navigation;

public class NavigationDAO {

	/**
	 * ��ȡ�������еĵ�����
	 * @param sql
	 * @return
	 */
	public List<Navigation> GetNavigations(String sql){
		List<Navigation> list = new ArrayList<Navigation>();
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
		// �ر����ݿ�����
		DBUtils.CloseCon();
		return list;
	}
}

package com.song.bll;


import java.util.List;

import com.song.dao.CategoryDAO;
import com.song.entity.Category;

public class CategoryBLL {
	private CategoryDAO categoryDAO;

	public CategoryBLL() {
		categoryDAO = new CategoryDAO();
	}
	
	/**
	 * ͨ��������ID��ȡ����б�
	 * @param masterId
	 * @return
	 */
	public List<Category> GetCategorysByMid(int masterId){
		String sql = "select * from t_category where master_id in("+masterId+",0) and isdelete = 0;"; 
		return categoryDAO.GetCategorys(sql);
	}
	
	/**
	 * ��ȡ��ҳ���ࣨ��ʱ���ǲ��ã�
	 * @param masterId
	 * @return
	 */
	public List<Category> GetCategorysForHome(int masterId){
		String sql = "select * from t_category where master_id in("+masterId+") and isdelete = 0;"; 
		return categoryDAO.GetCategorys(sql);
	}
}

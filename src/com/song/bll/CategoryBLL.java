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
	 * 通过创建者ID获取类别列表
	 * @param masterId
	 * @return
	 */
	public List<Category> GetCategorysByMid(int masterId){
		String sql = "select * from t_category where master_id in("+masterId+",0) and isdelete = 0;"; 
		return categoryDAO.GetCategorys(sql);
	}
	
	/**
	 * 获取首页分类（暂时考虑不用）
	 * @param masterId
	 * @return
	 */
	public List<Category> GetCategorysForHome(int masterId){
		String sql = "select * from t_category where master_id in("+masterId+") and isdelete = 0;"; 
		return categoryDAO.GetCategorys(sql);
	}
}

package com.song.bll;

import java.util.ArrayList;
import java.util.List;

import com.song.dao.CategoryDAO;
import com.song.entity.Category;

public class CategoryBLL {
	private CategoryDAO categoryDAO;

	public CategoryBLL() {
		categoryDAO = new CategoryDAO();
	}
	
	public List<Category> GetCategorysByMid(int masterId){
		return categoryDAO.GetCategoryListByMasterId(masterId);
	}
}

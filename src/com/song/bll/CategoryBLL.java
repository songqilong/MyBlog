package com.song.bll;

import com.song.dao.CategoryDAO;

public class CategoryBLL {
	private CategoryDAO categoryDAO;

	public CategoryBLL() {
		categoryDAO = new CategoryDAO();
	}
}

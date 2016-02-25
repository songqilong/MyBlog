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
	
	/**
	 * 获取文章分类对象（用于分类管理）
	 * @param masterId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Category> GetCategorysForManager(int masterId,int page,int pageSize){
		String sql ="select * from t_category where master_id ="+masterId+" and isdelete = 0 order by id asc limit "+((page-1)*pageSize)+","+pageSize+";";
		return categoryDAO.GetCategorys(sql);
	}
	
	/**
	 * 根据文章分类ID删除文章分类
	 * @param categoryId
	 * @return
	 */
	public int DeleteCategory(int categoryId,String dtime){
		String sql = "update t_category set isdelete=1,dtime='"+dtime+"' where id="+categoryId+";";
		ArticleBLL articleBLL = new ArticleBLL();
		articleBLL.DeleteArticleByCategoryId(categoryId);
		return categoryDAO.UpdateCategory(sql);
	}
}

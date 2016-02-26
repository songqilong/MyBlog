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
	
	/**
	 * ��ȡ���·���������ڷ������
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
	 * �������·���IDɾ�����·���
	 * @param categoryId
	 * @return
	 */
	public int DeleteCategory(int categoryId,String dtime){
		String sql = "update t_category set isdelete=1,dtime='"+dtime+"' where id="+categoryId+";";
		ArticleBLL articleBLL = new ArticleBLL();
		articleBLL.DeleteArticleByCategoryId(categoryId);
		return categoryDAO.UpdateCategory(sql);
	}
	
	/**
	 * ��ȡָ��Master�����·��������
	 * @param masterId
	 * @return
	 */
	public int GetTotalCategoryQty(int masterId){
		String sql = "select * from t_category where master_id="+masterId+" and isdelete=0;";
		return categoryDAO.GetQueryQty(sql);
	}
	
	/**
	 * �༭���·���
	 * @param categoryId
	 * @param newcategory
	 * @return
	 */
	public int EditCategory(int categoryId,String newcategory){
		String sql = "update t_category set category='"+newcategory+"' where id="+categoryId+";";
		return categoryDAO.UpdateCategory(sql);
	}
	
	/**
	 * ������·���
	 * @param category
	 * @return
	 */
	public int AddCategory(Category category){
		String sql ="insert into t_category(master_id,category,ctime) values ("+category.getMasterId()+",'"+category.getCategory()+"','"+category.getCtime()+"');";
		return categoryDAO.UpdateCategory(sql);
	}
}

package com.song.bll;

import com.song.dao.BlogDAO;
import com.song.entity.Blog;


public class BlogBLL {
	private BlogDAO blogDAO;

	public BlogBLL() {
		blogDAO = new BlogDAO();
	}
	
	/**
	 * 根据用户ID获取Blog信息
	 * @param masterId
	 * @return
	 */
	public Blog GetBlogByMasterId(int masterId){
		String sql ="select * from t_blog where master_id="+masterId+";";
		return blogDAO.GetBlog(sql);
	}
	
	/**
	 * 添加Blog信息
	 * @param blog
	 * @return
	 */
	public int AddBlog(Blog blog){
		String sql = "insert into t_blog(master_id,bname) values("+blog.getMasterId()+",'"+blog.getBlogName()+"');";
		return blogDAO.UpdateBlog(sql);
	}
}

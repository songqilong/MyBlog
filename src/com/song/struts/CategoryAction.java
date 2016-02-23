package com.song.struts;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.CategoryBLL;
import com.song.entity.Category;

public class CategoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取分类信息(用于添加文章，编辑文章界面)
	 * @return
	 */
	public String getCategoryInfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse reponse = ServletActionContext.getResponse();
		reponse.setHeader("Cache-Control","no-cache");
		reponse.setContentType("text/json;charset=UTF-8");
		PrintWriter out = reponse.getWriter();
		int masterId = Integer.parseInt(request.getParameter("mid"));
		CategoryBLL categoryBLL = new CategoryBLL();
		List<Category> list = categoryBLL.GetCategorysByMid(masterId);
		String info = JSON.toJSONString(list);
		out.print(info);
		System.out.println(info);
		return null;
	}

}

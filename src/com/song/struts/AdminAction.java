package com.song.struts;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.CategoryBLL;
import com.song.common.PropertiesUtils;
import com.song.entity.Category;

public class AdminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String home()throws Exception{
		return "home";
	}
	
	/**
	 * 文章分类管理获取分类数据
	 * @return
	 * @throws Exception
	 */
	public String getCategorysForManager()throws Exception{
		System.out.println("*****************************************");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse reponse = ServletActionContext.getResponse();
		reponse.setHeader("Cache-Control","no-cache");
		reponse.setContentType("text/json;charset=UTF-8");
		PrintWriter out = reponse.getWriter();
		int masterId = Integer.parseInt(request.getParameter("mid"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize =  Integer.parseInt(PropertiesUtils.ReadProperties("categorySize"));
		CategoryBLL categoryBLL = new CategoryBLL();
		List<Category> list = categoryBLL.GetCategorysForManager(masterId, page, pageSize);
		String info = JSON.toJSONString(list);
		out.print(info);
		return null;
	}
}

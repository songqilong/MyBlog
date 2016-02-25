package com.song.struts;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.CategoryBLL;
import com.song.common.PropertiesUtils;
import com.song.entity.Category;

public class CategoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse reponse = ServletActionContext.getResponse();
	private CategoryBLL categoryBLL = new CategoryBLL();
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
	
	/**
	 * 文章分类管理获取分类数据
	 * @return
	 * @throws Exception
	 */
	public String getCategorysForManager()throws Exception{
		System.out.println("*****************************************");

		reponse.setHeader("Cache-Control","no-cache");
		reponse.setContentType("text/json;charset=UTF-8");
		PrintWriter out = reponse.getWriter();
		int masterId = Integer.parseInt(request.getParameter("mid"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize =  Integer.parseInt(PropertiesUtils.ReadProperties("categorySize"));
		CategoryBLL categoryBLL = new CategoryBLL();
		List<Category> list = categoryBLL.GetCategorysForManager(masterId, page, pageSize);

		String info = JSON.toJSONString(list);
		System.out.println(info);
		JSONObject jo = new JSONObject();
		jo.put("categorys", info);
		jo.put("totalPage", 3);
		System.out.println(jo.toJSONString());
		out.print(jo.toJSONString());
		return null;
	}
	
	/**
	 * 删除文章分类
	 * @return
	 * @throws Exception
	 */
	public String delete()throws Exception{
		int cid = Integer.parseInt(request.getParameter("cid"));
		String dtime = request.getParameter("dtime");
		System.out.println(cid+"*************************"+dtime);
		PrintWriter out = reponse.getWriter();
		if(categoryBLL.DeleteCategory(cid,dtime)>0){
			out.print("deleteSuccess");
		}else{
			out.print("deleteFail");
		}
		return null;
	}

}

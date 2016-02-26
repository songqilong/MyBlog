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
		reponse.setHeader("Cache-Control","no-cache");
		reponse.setContentType("text/json;charset=UTF-8");
		PrintWriter out = reponse.getWriter();
		// 用户ID
		int masterId = Integer.parseInt(request.getParameter("mid"));
		// 当前页数
		int page = Integer.parseInt(request.getParameter("page"));
		// 每页显示的分类条数
		int pageSize =  Integer.parseInt(PropertiesUtils.ReadProperties("categorySize"));
		CategoryBLL categoryBLL = new CategoryBLL();
		// 该Master的有效文章分类数
		int categoryQty = categoryBLL.GetTotalCategoryQty(masterId);
		// 默认分页数
		int totalPage = 1;
		if(categoryQty%pageSize == 0){
			totalPage = categoryQty/pageSize;
		}else{
			totalPage = categoryQty/pageSize+1;
		}
		// 获取文章分类集合
		List<Category> list = categoryBLL.GetCategorysForManager(masterId, page, pageSize);
		String categorys = JSON.toJSONString(list);
		System.out.println(categorys);
		JSONObject jo = new JSONObject();
		jo.put("categorys", categorys);
		jo.put("totalPage", totalPage);
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
		PrintWriter out = reponse.getWriter();
		if(categoryBLL.DeleteCategory(cid,dtime)>0){
			out.print("deleteSuccess");
		}else{
			out.print("deleteFail");
		}
		return null;
	}
	
	/**
	 * 编辑文章分类
	 * @return
	 * @throws Exception
	 */
	public String edit()throws Exception{
		int categoryId = Integer.parseInt(request.getParameter("cid"));
		//int masterId= Integer.parseInt(request.getParameter("mid"));
		String newcategory = request.getParameter("newcategory");
		PrintWriter out = reponse.getWriter();
		CategoryBLL categoryBLL = new CategoryBLL();
		if(categoryBLL.EditCategory(categoryId, newcategory)>0){
			out.print("editSuccess");
		}else{
			out.println("editFail");
		}
		return null;
	}
	
	/**
	 * 添加文章分类
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		int masterId = Integer.parseInt(request.getParameter("mid"));
		String category = request.getParameter("category");
		String ctime = request.getParameter("ctime");
		System.out.println(masterId+"**********"+category+"****************"+ctime);
		Category c = new Category();
		c.setCategory(category);
		c.setMasterId(masterId);
		c.setCtime(ctime);
		PrintWriter out = reponse.getWriter();
		CategoryBLL categoryBLL = new CategoryBLL();
		if(categoryBLL.AddCategory(c)>0){
			out.print("addSuccess");
		}else{
			out.print("addFail");
		}
		return null;
	}

}

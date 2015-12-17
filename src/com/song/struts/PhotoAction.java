package com.song.struts;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.NavigationBLL;
import com.song.entity.Navigation;

public class PhotoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5466689722495476346L;
	
	// 上传的图片文件
	private File[] uploadimage;
	// 文件名称
	private String[] uploadimageFileName;
	// 文件类型
	private String[] uploadimageContextType;
	
	
	public File[] getUploadimage() {
		return uploadimage;
	}

	public void setUploadimage(File[] uploadimage) {
		this.uploadimage = uploadimage;
	}
	
	

	public String[] getUploadimageFileName() {
		return uploadimageFileName;
	}

	public void setUploadimageFileName(String[] uploadimageFileName) {
		this.uploadimageFileName = uploadimageFileName;
	}

	public String[] getUploadimageContextType() {
		return uploadimageContextType;
	}

	public void setUploadimageContextType(String[] uploadimageContextType) {
		this.uploadimageContextType = uploadimageContextType;
	}

	/**
	 * 图片列表
	 * @return
	 * @throws Exception
	 */
	public String showList()throws Exception{
		String result = "showlist";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// 获取导航栏的导航项
			List<Navigation> list = nvaBLL.GetNavigations();
			// 如果导航项集合长度不为0
			if (list.size() <= 0) {				
				result = "showlistfail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
	}
	
	/**
	 * 获取图片列表
	 * @return
	 * @throws Exception
	 */
	public String getList()throws Exception{
		// 获取参数master
		String master = ServletActionContext.getRequest().getParameter("master");
		// 设置request值master
		ActionContext.getContext().put("master", master);
		return "getlist";
	}

	/**
	 * 添加图片
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		String result = "add";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// 获取导航栏的导航项
			List<Navigation> list = nvaBLL.GetNavigations();
			// 如果导航项集合长度不为0
			if (list.size() <= 0) {				
				result = "showlistfail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
	}
	
	/**
	 * 加载添加图片界面数据
	 * @return
	 * @throws Exception
	 */
	public String showAdd()throws Exception{
		
		return "showadd";
	}
	
	
	public String upload()throws Exception{
		String imagePath = ServletActionContext.getRequest().getContextPath()+"/picture/image/";
		for(int i = 0;i<uploadimage.length;i++){
			uploadimage[i].renameTo(new File("D:/"+"aa.png"));
		}
		return "";
	}
}

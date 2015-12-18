package com.song.struts;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.NavigationBLL;
import com.song.bll.PhotoBLL;
import com.song.common.Common;
import com.song.entity.Navigation;
import com.song.entity.Photo;

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
		String master = ServletActionContext.getRequest().getParameter("master");
		PhotoBLL photoBLL = new PhotoBLL();
		List<Photo> list = new ArrayList<Photo>();
		// 获取图片存放路径
		String imagePath =PhotoAction.class.getClassLoader().getResource("").getFile().replaceAll("/WEB-INF/classes/", "").replaceAll("%20", " ").substring(1)+"/picture/image/";
		// 遍历上传的图片
		for(int i = 0;i<uploadimage.length;i++){
			Photo photo = new Photo();
			photo.setPhotoname(RenamePhoto(uploadimageFileName[i],master,i));
			photo.setAlbumid(1);
			photo.setOriginalname(uploadimageFileName[i]);
			photo.setAuthor("1");
			photo.setCtime(Common.GetCurrentTime());
			list.add(photo);
			uploadimage[i].renameTo(new File(imagePath+RenamePhoto(uploadimageFileName[i],master,i)));
		}
		if(photoBLL.AddPhotoList(list)){
			return "upload";
		}
		return "uploadfail";
	}
	
	/**
	 * 重命名图片名字
	 * @param originalname 图片元始名称
	 * @param author 图片上传者
	 * @param index 图片索引
	 * @return
	 */
	private String RenamePhoto(String originalname,String author,int index){
		// 图片后缀
		String suffix = originalname.substring(originalname.lastIndexOf('.'), originalname.length());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = sdf.format(Calendar.getInstance().getTime());
		String newName = author+time+index+suffix;
		return newName;
	}
}

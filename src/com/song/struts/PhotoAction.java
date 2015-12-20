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
import com.song.common.PropertiesUtils;
import com.song.entity.Navigation;
import com.song.entity.Photo;

public class PhotoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5466689722495476346L;
	
	// �ϴ���ͼƬ�ļ�
	private File[] uploadimage;
	// �ļ�����
	private String[] uploadimageFileName;
	// �ļ�����
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
	 * ͼƬ�б�
	 * @return
	 * @throws Exception
	 */
	public String showList()throws Exception{
		String result = "showlist";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations();
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() <= 0) {				
				result = "showlistfail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
	}
	
	/**
	 * ��ȡͼƬ�б�
	 * @return
	 * @throws Exception
	 */
	public String getList()throws Exception{
		PhotoBLL photoBLL = new PhotoBLL();
		// ��ȡ����master
		String master = ServletActionContext.getRequest().getParameter("master");
		// ����requestֵmaster
		ActionContext.getContext().put("master", master);
	    // ��ȡһ��������ͼƬ
		int photoQty =  photoBLL.GetPhotoQtyByAuthor(master);
		int photoSize = Integer.parseInt(PropertiesUtils.ReadProperties("photosize"));
		ActionContext.getContext().put("photoQty", photoQty);
		int pageQty = 0;
		if(photoQty%photoSize >0){
			pageQty = photoQty/photoSize+1;
		}else{
			pageQty = photoQty/photoSize;
		}
		ActionContext.getContext().put("pageQty", pageQty);
		// ��ȡ��ǰҳ��Ĳ���
		int currentPage = Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		ActionContext.getContext().put("page", currentPage);
		List<Photo> list = photoBLL.GetPhotoList(master, currentPage);
		//String jsonstr = JSON.toJSONString(list);
		//ServletActionContext.getResponse().getWriter().print(jsonstr);
		ActionContext.getContext().put("photoList", list);
		return "getlist";
	}
	

	/**
	 * ���ͼƬ
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		String result = "add";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations();
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() <= 0) {				
				result = "showlistfail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
	}
	
	/**
	 * �������ͼƬ��������
	 * @return
	 * @throws Exception
	 */
	public String showAdd()throws Exception{
		// ��ȡmater����
		String master = ServletActionContext.getRequest().getParameter("master");
		ServletActionContext.getRequest().setAttribute("master", master);
		return "showadd";
	}
	
	/**
	 * ͼƬ�ϴ�����
	 * @return
	 * @throws Exception
	 */
	public String upload()throws Exception{
		String master = ServletActionContext.getRequest().getParameter("master");
		PhotoBLL photoBLL = new PhotoBLL();
		List<Photo> list = new ArrayList<Photo>();
		// ��ȡͼƬ���·��
		String imagePath =PhotoAction.class.getClassLoader().getResource("").getFile().replaceAll("/WEB-INF/classes/", "").replaceAll("%20", " ").substring(1)+"/picture/image/";
		// �����ϴ���ͼƬ
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
	 * ������ͼƬ����
	 * @param originalname ͼƬԪʼ����
	 * @param author ͼƬ�ϴ���
	 * @param index ͼƬ����
	 * @return
	 */
	private String RenamePhoto(String originalname,String author,int index){
		// ͼƬ��׺
		String suffix = originalname.substring(originalname.lastIndexOf('.'), originalname.length());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = sdf.format(Calendar.getInstance().getTime());
		String newName = author+time+index+suffix;
		return newName;
	}
}

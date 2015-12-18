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
		// ��ȡ����master
		String master = ServletActionContext.getRequest().getParameter("master");
		// ����requestֵmaster
		ActionContext.getContext().put("master", master);
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
		
		return "showadd";
	}
	
	
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

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
		String imagePath = ServletActionContext.getRequest().getContextPath()+"/picture/image/";
		for(int i = 0;i<uploadimage.length;i++){
			uploadimage[i].renameTo(new File("D:/"+"aa.png"));
		}
		return "";
	}
}

package com.song.bll;

import java.util.List;

import com.song.dao.PhotoDAO;
import com.song.entity.Photo;

public class PhotoBLL {
	private PhotoDAO photoDAO;

	public PhotoBLL() {
		photoDAO = new PhotoDAO();
	}
	
	/**
	 * ���ͼƬ����
	 * @param list
	 * @return
	 */
	public boolean AddPhotoList(List<Photo> list){
		return photoDAO.AddPhotoList(list);
	}
	
	/**
	 * ��ȡָ�����ߣ�ָ��ҳ����ͼƬ
	 * @param author
	 * @param currentPage
	 * @return
	 */
	public List<Photo> GetPhotoList(String author,int currentPage){
		return photoDAO.GetPhotoList(author, currentPage);
	} 

	/**
	 * �������߻�ȡ�ϴ���ͼƬ����
	 * @param author
	 * @return
	 */
	public int GetPhotoQtyByAuthor(String author){
		return photoDAO.GetPhotoQty(author);
	}
}

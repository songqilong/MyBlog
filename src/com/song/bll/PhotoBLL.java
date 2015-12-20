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
	 * 添加图片集合
	 * @param list
	 * @return
	 */
	public boolean AddPhotoList(List<Photo> list){
		return photoDAO.AddPhotoList(list);
	}
	
	/**
	 * 获取指定作者，指定页数的图片
	 * @param author
	 * @param currentPage
	 * @return
	 */
	public List<Photo> GetPhotoList(String author,int currentPage){
		return photoDAO.GetPhotoList(author, currentPage);
	} 

	/**
	 * 根据作者获取上传的图片数量
	 * @param author
	 * @return
	 */
	public int GetPhotoQtyByAuthor(String author){
		return photoDAO.GetPhotoQty(author);
	}
}

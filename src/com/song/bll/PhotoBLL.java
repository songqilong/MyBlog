package com.song.bll;

import java.util.List;

import com.song.common.PropertiesUtils;
import com.song.dao.PhotoDAO;
import com.song.entity.Photo;

public class PhotoBLL {
	private PhotoDAO photoDAO;

	public PhotoBLL() {
		photoDAO = new PhotoDAO();
	}
	

	
	/**
	 * ��ȡָ���ϴ��ߣ�ָ��ҳ���ͼƬ
	 * @param mid �ϴ���ID
	 * @param page ҳ��
	 * @return
	 */
	public List<Photo> GetPagePhotoes(int mid,int page){
		int photoSize = Integer.parseInt(PropertiesUtils.ReadProperties("photosize").toString());
		String sql = "select * from t_photo where master_id="+mid+" order by ctime desc limit "+(page-1)*photoSize+","+photoSize+";";
		return photoDAO.GetPhotoes(sql);
	} 
	
	/**
	 * ���ͼƬ����
	 * @param list
	 * @return
	 */
	public int AddPhotoes(List<Photo> list){
		int rows = 0;
		for(int i = 0;i <list.size();i++){
			Photo photo = list.get(i);
			// ��������SQL���
			String sql = "insert into t_photo(master_id,photoname,originalname,albumid,author,ctime) values("+photo.getMasterId()+",'"+ photo.getPhotoname()
					+ "','"+photo.getOriginalname()+"'," + photo.getAlbumid() + ",'" + photo.getAuthor() + "','" + photo.getCtime() + "');";
			if(photoDAO.UpdatePhoto(sql)>0){
				rows++;
			}
		}
		return rows;
	}

	/**
	 * �������߻�ȡ�ϴ���ͼƬ����
	 * @param author
	 * @return
	 */
	public int GetPhotoQtyByMid(int mid){
		String sql = "select * from t_photo where master_id="+mid+";";
		return photoDAO.GetQueryQty(sql);
	}
}

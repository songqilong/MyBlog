package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.song.common.DBUtils;
import com.song.common.PropertiesUtils;
import com.song.entity.Photo;

public class PhotoDAO {

	/**
	 * ����ͼƬ����
	 * 
	 * @param list
	 * @return
	 */
	public boolean AddPhotoList(List<Photo> list) {
		boolean isSuccess = true;
		try {
			// �����ݿ�����
			DBUtils.ConnDB();
			for (int i = 0; i < list.size(); i++) {
				Photo photo = list.get(i);
				// ��������SQL���
				String sql = "insert into t_photo(photoname,originalname,albumid,author,ctime) values('" + photo.getPhotoname()
						+ "','"+photo.getOriginalname()+"'," + photo.getAlbumid() + ",'" + photo.getAuthor() + "','" + photo.getCtime() + "');";
				// ִ�в������
				DBUtils.ExecuteUpdateOrDelete(sql);
			}
			// �ر����ݿ�����
			DBUtils.CloseCon();
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}
	
	/**
	 * �������߻�ȡͼƬ�б�
	 * @param author
	 * @return
	 */
	public List<Photo> GetPhotoList(String author,int currentPage){
		List<Photo> list = new ArrayList<Photo>();
		int photoSize = Integer.parseInt(PropertiesUtils.ReadProperties("photosize").toString());
		String sql = "select * from t_photo where author='"+author+"' order by ctime desc limit "+(currentPage-1)*photoSize+","+photoSize+";";
		try{
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			while(rst.next()){
				Photo photo = new Photo();
				photo.setPhotoname(rst.getString("photoname"));
				photo.setOriginalname(rst.getString("originalname"));
				photo.setAlbumid(rst.getInt("albumid"));
				photo.setAuthor(rst.getString("author"));
				photo.setCtime(rst.getString("ctime"));
				list.add(photo);
			}
			rst.close();
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * �������߻�ȡ�ϴ�ͼƬ������
	 * @param author
	 * @return
	 */
	public int GetPhotoQty(String author){
		int row  =0;
		String sql = "select * from t_photo where author='"+author+"'";
		try{
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			if(rst.last()){
				row = rst.getRow();
			}
			rst.close();
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}
}
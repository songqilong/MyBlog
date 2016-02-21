package com.song.entity;

import java.io.Serializable;

public class Navigation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ������ID
	private int id;
	// �û�ID
	private int masterId;
	// ����������
	private String nav_name;
	// url��ַ
	private String url;
	// �������Ƿ���ʾ 1Ϊ��ʾ 0Ϊ����ʾ
	private int visible;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getNav_name() {
		return nav_name;
	}

	public void setNav_name(String nav_name) {
		this.nav_name = nav_name;
	}
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	

}

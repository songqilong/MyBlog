package com.song.entity;

public class Navigation {
	// ������ID
	private int id;
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

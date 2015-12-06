package com.song.entity;

public class Navigation {
	// 导航项ID
	private int id;
	// 导航项名称
	private String nav_name;
	// url地址
	private String url;
	// 导航项是否显示 1为显示 0为不显示
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

package com.song.entity;

public class Article {
	// 文章ID
	private int id;
	// 文章题目
	private String title;
	// 文章作者ID
	private int masterId;
	// 文章类型
	private int type;
	// 文章源网站名
	private String sourceweb;
	// 文章源网站网址
	private String sourceurl;
	// 文章关键字
	private String keyword;
	// 文章内容
	private String content;
	// 文章点击次数
	private int clicktime;
	// 文章创建时间
	private String ctime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSourceweb() {
		return sourceweb;
	}

	public void setSourceweb(String sourceweb) {
		this.sourceweb = sourceweb;
	}

	public String getSourceurl() {
		return sourceurl;
	}

	public void setSourceurl(String sourceurl) {
		this.sourceurl = sourceurl;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}



	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public int getClicktime() {
		return clicktime;
	}

	public void setClicktime(int clicktime) {
		this.clicktime = clicktime;
	}
	
	

}

package com.song.entity;

public class Article {
	// ����ID
	private int id;
	// ������Ŀ
	private String title;
	// ��������ID
	private int masterId;
	// ��������
	private int type;
	// ����Դ��վ��
	private String sourceweb;
	// ����Դ��վ��ַ
	private String sourceurl;
	// ���¹ؼ���
	private String keyword;
	// ��������
	private String content;
	// ���µ������
	private int clicktime;
	// ���´���ʱ��
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

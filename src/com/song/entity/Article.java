package com.song.entity;

import java.io.Serializable;

public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ����ID
	private int id;
	// ������Ŀ
	private String title;
	// ��������
	private String author;
	// ������ID
	private int masterId;
	// ��������
	private int type;
	// ���·���ID
	private int categoryId;
	// ����Դ��վ��
	private String sourceweb;
	// ����Դ��վ��ַ
	private String sourceurl;
	// ���¹ؼ���
	private String keyword;
	// ��������
	private String content;
	// �Ƽ���־
	private int isrecommend;
	// ���µ������
	private int clicktime;
	// ���´���ʱ��
	private String ctime;
	// ɾ����־
	private int isdelete;
	// ɾ��ʱ��
	private String deleteTime;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(int isrecommend) {
		this.isrecommend = isrecommend;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

}

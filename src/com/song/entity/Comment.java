package com.song.entity;

import java.io.Serializable;

public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ����ID
	private int id;
	// ����ID
	private int articleId;
	// ������
	private String author;
	// ��������
	private String content;
	// ������IP
	private String ip;
	// �ظ�����
	private String replyto;
	// ����ʱ��
	private String ctime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getReplyto() {
		return replyto;
	}

	public void setReplyto(String replyto) {
		this.replyto = replyto;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

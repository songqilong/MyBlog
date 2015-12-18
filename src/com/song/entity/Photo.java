package com.song.entity;

public class Photo {
	// 图片ID
	private int id;
	// 图片名称
	private String photoname;
	// 图片元始名字
	private String originalname;
	// 相册ID
	private int albumid;
	// 图片作者
	private String author;
	// 上传时间
	private String ctime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public int getAlbumid() {
		return albumid;
	}

	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getOriginalname() {
		return originalname;
	}

	public void setOriginalname(String originalname) {
		this.originalname = originalname;
	}

}

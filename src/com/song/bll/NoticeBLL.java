package com.song.bll;

import com.song.dao.NoticeDAO;
import com.song.entity.Notice;

public class NoticeBLL {
	private NoticeDAO noticeDAO;

	public NoticeBLL() {
		noticeDAO = new NoticeDAO();
	}
	
	/**
	 * ��ȡ����һ������
	 * @return
	 */
	public Notice GetLastNotice(int masterId){
		return noticeDAO.GetNotice(masterId);
	}

}

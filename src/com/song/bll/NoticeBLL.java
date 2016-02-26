package com.song.bll;

import java.util.List;

import com.song.dao.NoticeDAO;
import com.song.entity.Notice;

public class NoticeBLL {
	private NoticeDAO noticeDAO;

	public NoticeBLL() {
		noticeDAO = new NoticeDAO();
	}
	
	/**
	 * 获取最新一条公告
	 * @return
	 */
	public Notice GetLastNotice(int masterId){
		String sql = "select * from t_notice where master_id="+masterId+" order by ctime desc limit 0,1";
		return noticeDAO.GetNotice(sql);
	}
	
	/**
	 * 获取公告列表
	 * @param masterId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Notice> GetNotices(int masterId,int page,int pageSize){
		String sql ="select * from t_notice where master_id ="+masterId+" and isdelete = 0 order by id asc limit "+((page-1)*pageSize)+","+pageSize+";";
		return noticeDAO.GetNotices(sql);
	}
	
	/**
	 * 获取单个公告
	 * @param noticeId
	 * @return
	 */
	public Notice GetNotice(int noticeId){
		String sql ="select * from t_notice where id="+noticeId+";";
		return noticeDAO.GetNotice(sql);
	}
	
	/**
	 * 获取公告数量
	 * @param masterId
	 * @return
	 */
	public int GetTotalNoticeQty(int masterId){
		String sql ="select * from t_notice where master_id="+masterId+" and isdelete=0;";
		return noticeDAO.GetQueryQty(sql);
	}
	
	/**
	 * 新增公告
	 * @param notice
	 * @return
	 */
	public int AddNotice(Notice notice){
		String sql = "insert into t_notice (master_id,title,content,ctime) values ("+notice.getMasterId()+",'"+notice.getTitle()+"','"+notice.getContent()+"','"+notice.getCtime()+"');";
		return noticeDAO.UpdateNotice(sql);
	}
	
	/**
	 * 删除公告
	 * @param noticeId
	 * @return
	 */
	public int RemoveNotice(Notice notice){
		String sql = "update t_notice set isdelete=1,dtime='"+notice.getDtime()+"' where id="+notice.getId()+";";
		return noticeDAO.UpdateNotice(sql);
	}
	
	/**
	 * 编辑公告
	 * @param notice
	 * @return
	 */
	public int EditNotice(Notice notice){
		String sql = "update t_notice set title='"+notice.getTitle()+"',content='"+notice.getContent()+"' where id="+notice.getId()+";";
		return noticeDAO.UpdateNotice(sql);
	}

}

package com.song.struts;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.NoticeBLL;
import com.song.common.PropertiesUtils;
import com.song.entity.Notice;

public class NoticeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	/**
	 * 获取公告列表
	 * @return
	 * @throws Exception
	 */
	public String getNoticesForManager()throws Exception{
		response.setHeader("Cache-Control","no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 用户ID
		int masterId = Integer.parseInt(request.getParameter("mid"));
		// 当前页数
		int page = Integer.parseInt(request.getParameter("page"));
		// 每页显示的分类条数
		int pageSize =  Integer.parseInt(PropertiesUtils.ReadProperties("noticeSize"));
		NoticeBLL noticeBLL = new NoticeBLL();
		// 该Master的有效文章分类数
		int noticeQty = noticeBLL.GetTotalNoticeQty(masterId);
		// 默认分页数
		int totalPage = 1;
		if(noticeQty%pageSize == 0){
			totalPage = noticeQty/pageSize;
		}else{
			totalPage = noticeQty/pageSize+1;
		}
		// 获取文章分类集合
		List<Notice> list = noticeBLL.GetNotices(masterId, page, pageSize);
		String notices = JSON.toJSONString(list);
		System.out.println(notices);
		JSONObject jo = new JSONObject();
		jo.put("notices", notices);
		jo.put("totalPage", totalPage);
		System.out.println(jo.toJSONString());
		out.print(jo.toJSONString());
		return null;
	}
	
	/**
	 * 获取指定ID的公告
	 * @return
	 * @throws Exception
	 */
	public String getNoticesForId()throws Exception{
		response.setHeader("Cache-Control","no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int noticeId = Integer.parseInt(request.getParameter("nid"));
		NoticeBLL noticeBLL = new NoticeBLL();
		Notice notice = noticeBLL.GetNotice(noticeId);
		if(notice != null){
			String noticeinfo = JSON.toJSONString(notice);
			System.out.println(noticeinfo);
			out.print(noticeinfo);
		}else{
			out.print("none");
		}
		return null;
	}
	
	/**
	 * 删除公告
	 * @return
	 * @throws Exception
	 */
	public String delete()throws Exception{
		PrintWriter out = response.getWriter();
		// 获取公告ID
		int noticeId = Integer.parseInt(request.getParameter("nid"));
		String dtime = request.getParameter("dtime");
		Notice notice = new Notice();
		notice.setId(noticeId);
		notice.setDtime(dtime);
		NoticeBLL noticeBLL = new NoticeBLL();
		if(noticeBLL.RemoveNotice(notice)>0){
			out.print("deleteSuccess");
		}else{
			out.print("deleteFail");
		}
		return null;
	}
	
	/**
	 * 编辑公告
	 * @return
	 * @throws Exception
	 */
	public String edit()throws Exception{
		PrintWriter out = response.getWriter();
		Notice notice = new Notice();
		notice.setId(Integer.parseInt(request.getParameter("nid")));
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		NoticeBLL noticeBLL = new NoticeBLL();
		if(noticeBLL.EditNotice(notice)>0){
			out.print("editSuccess");
		}else{
			out.print("editFail");
		}
		return null;
	}

}

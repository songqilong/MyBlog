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
	 * ��ȡ�����б�
	 * @return
	 * @throws Exception
	 */
	public String getNoticesForManager()throws Exception{
		response.setHeader("Cache-Control","no-cache");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// �û�ID
		int masterId = Integer.parseInt(request.getParameter("mid"));
		// ��ǰҳ��
		int page = Integer.parseInt(request.getParameter("page"));
		// ÿҳ��ʾ�ķ�������
		int pageSize =  Integer.parseInt(PropertiesUtils.ReadProperties("noticeSize"));
		NoticeBLL noticeBLL = new NoticeBLL();
		// ��Master����Ч���·�����
		int noticeQty = noticeBLL.GetTotalNoticeQty(masterId);
		// Ĭ�Ϸ�ҳ��
		int totalPage = 1;
		if(noticeQty%pageSize == 0){
			totalPage = noticeQty/pageSize;
		}else{
			totalPage = noticeQty/pageSize+1;
		}
		// ��ȡ���·��༯��
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
	 * ��ȡָ��ID�Ĺ���
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
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String delete()throws Exception{
		PrintWriter out = response.getWriter();
		// ��ȡ����ID
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
	 * �༭����
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

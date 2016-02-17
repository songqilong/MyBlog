package com.song.struts;


import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.NoticeBLL;
import com.song.entity.Article;
import com.song.entity.Notice;



public class IndexAction extends ActionSupport {

	private Article article;
	private Notice notice;
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1660000257797688856L;

	public String access()throws Exception{
//		// ��ȡrequest����
//		HttpServletRequest request = ServletActionContext.getRequest();
//		// ��ȡ����·��url
//		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
//		// ������·������session
//		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
		// ��ȡurl�и������û�����
		int masterId = Integer.parseInt(ServletActionContext.getRequest().getParameter("mid"));
		// ���û���������session��
		ServletActionContext.getRequest().getSession().setAttribute("master", masterId);
		return "access";
	}
	

	/**
	 * ������ҳ��һƪ����
	 * @return
	 * @throws Exception
	 */
	public String loadHomeInfo()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		NoticeBLL noticeBLL = new NoticeBLL();
		// ��ȡurl�еĲ���
		int masterId = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute("master").toString());
		// ��ȡ��ҳ��ʾ����������
		article = articleBLL.GetLastArticleByAuthor(masterId);
		// ��ȡ���µĹ���
		notice = noticeBLL.GetLastNotice(masterId);
		// �����ҳ��ʾ������Ϊ��
		if(article != null&&notice != null){
			return "loadInfoSuccess";
		}
		return "loadInfoFail";
	}
}

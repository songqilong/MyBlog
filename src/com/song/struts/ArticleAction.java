package com.song.struts;

import java.util.List;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.CommentBLL;
import com.song.common.Common;
import com.song.entity.Article;
import com.song.entity.Comment;


public class ArticleAction extends ActionSupport {

	private Article article;
//	private List<Article> articlelist;
	private List<Comment> commentlist;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
//
//	public List<Article> getArticlelist() {
//		return articlelist;
//	}
//
//	public void setArticlelist(List<Article> articlelist) {
//		this.articlelist = articlelist;
//	}

	
	
	public List<Comment> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8713584507960045011L;

	/**
	 * ��ʾ�����б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showList() throws Exception {
		return "showList";
	}
	
	/**
	 * ��ȡ��ƪ����
	 * @return
	 * @throws Exception
	 */
	public String single()throws Exception{
		return "single";
		
	}
	
	/**
	 * �ύ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		// �������´�����ʱ��
		this.article.setCtime(Common.GetCurrentTime());
		// ��ȡ����Session�����е����߼��û���
		int masterId = Integer.parseInt(ServletActionContext.getRequest().getParameter("mid"));
		ActionContext.getContext().put("mid", masterId);
		this.article.setMasterId(masterId);
		ArticleBLL articleBLL = new ArticleBLL();
		// �����ӳɹ���ת�������б�
		if (articleBLL.AddArticle(article)) {
			return "addSuccess";
		}
		return "addfail";
	}
	
//	/**
//	 * ��ȡ�����б�
//	 * @return
//	 * @throws Exception
//	 */
//	public String getList()throws Exception{
//		ArticleBLL articleBLL = new ArticleBLL();
//		// ��ȡmaster
//		int masterId = Integer.parseInt(ServletActionContext.getRequest().getParameter("master"));
//		// ǿmaster�����request��
//		ActionContext.getContext().put("master", masterId);
//		// ��ȡȫ�����µ�����
//		int totalArticleQty = articleBLL.GetAllArticleCount(masterId);
//		ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
//		// ��ȡÿҳ��ʾ���µ�����
//		int perPageQty = Integer.parseInt(PropertiesUtils.ReadProperties("page"));
//		// ��ҳ��
//		int pageQty = 0;
//		if(totalArticleQty%perPageQty != 0){
//			pageQty = totalArticleQty/perPageQty+1;
//		}else{
//			pageQty = totalArticleQty/perPageQty;
//		}		
//		ActionContext.getContext().put("pageQty", pageQty);
//		// ��ȡ��ǰҳ�� 
//		int page =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
//		ActionContext.getContext().put("page", page);
//		// ��ȡ��ǰҳ��ȫ�����µļ���		
//		this.articlelist = articleBLL.GetArticlesForPage(masterId,page);
//		if(this.articlelist.size()>0){
//			return "getListSuccess";
//		}
//		// �����ҳ����
//		return "list";
//	}

	/**
	 * ǰ��д���½���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String write() throws Exception {
		String masterId  = ServletActionContext.getRequest().getParameter("mid");
		ServletActionContext.getRequest().setAttribute("mid", masterId);
		return "write";
	}


	

	
	/**
	 * ��ʾ��ƪ����
	 * @return
	 * @throws Exception
	 */
	public String showArticle()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// ��ȡ���µ�ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		// ������ID����request������
		ActionContext.getContext().put("articleID", articleID);
		CommentBLL commentBLL = new CommentBLL();
		// ������������
		int commentLastQty = commentBLL.CommentLast(articleID);
		ActionContext.getContext().put("commentLastQty", commentLastQty);
		//����ID��ȡ����
		this.article = articleBLL.GetArticleById(articleID);
		// ������²�Ϊ��
		if(this.article != null){
			// �ۼ����µ������
			articleBLL.SumArticleClick(articleID);
			return "comment";
		}
		return "noarticle";
	}
	
	/**
	 * ��ȡ��������
	 * @return
	 * @throws Exception
	 */
	public String comment()throws Exception{
		CommentBLL commentBLL = new CommentBLL();
		// ��ȡ����ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		// ��������ID��ȡ���µ�������
		int commentQty = commentBLL.GetCommentQtyByArticle(articleID);
		// �����µ������������request��
		ActionContext.getContext().put("CommentQty", commentQty);
		// ��ȡ���ۼ���
		this.commentlist = commentBLL.GetCommentCollection(articleID);
		return "singleShowSuccess";
	}

}

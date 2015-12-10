package com.song.struts;

import java.util.List;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.CommentBLL;
import com.song.bll.NavigationBLL;
import com.song.common.Common;
import com.song.entity.Article;
import com.song.entity.Comment;
import com.song.entity.Navigation;

public class ArticleAction extends ActionSupport {

	private Article article;
	private List<Article> articlelist;
	private List<Comment> commentlist;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticlelist() {
		return articlelist;
	}

	public void setArticlelist(List<Article> articlelist) {
		this.articlelist = articlelist;
	}

	
	
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
		String result = "showlist";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations();
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() < 0) {
				ActionContext.getContext().getSession().put("navigation", list);
				result = "showlistfail";
			}
		}
		return result;
//		return "showlist";
	}
	
	/**
	 * ��ȡ�����б�
	 * @return
	 * @throws Exception
	 */
	public String getList()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// ��ȡmaster
		String master = ServletActionContext.getRequest().getParameter("master");
		// ��ȡȫ�����µ�����
		int totalArticleQty = articleBLL.GetAllArticleCount(master);
		ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
		// ��ȡ��ǰҳ�� 
		int page =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		// ��ȡ��ǰҳ��ȫ�����µļ���		
		this.articlelist = articleBLL.GetArticlesForPage(master,page);
		if(this.articlelist.size()>0){
			return "list";
		}
		// �����ҳ����
		return "list";
	}

	/**
	 * ǰ��д���½���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String write() throws Exception {
		return "write";
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
		String author = String.valueOf(ActionContext.getContext().getSession().get("user"));
		this.article.setAuthor(author);
		ArticleBLL articleBLL = new ArticleBLL();
		// �����ӳɹ���ת�������б�
		if (articleBLL.AddArticle(article)) {
			return "add";
		}
		return "addfail";
	}
	
	/**
	 * ��ȡ��ƪ����
	 * @return
	 * @throws Exception
	 */
	public String single()throws Exception{
		ArticleBLL articleBLL = new ArticleBLL();
		// ��ȡ���µ�ID
		int articleID = Integer.parseInt(ServletActionContext.getRequest().getParameter("articleID"));
		//����ID��ȡ����
		this.article = articleBLL.GetArticleById(articleID);
		// ������²�Ϊ��
		if(this.article != null){
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
		return "single";
	}

}

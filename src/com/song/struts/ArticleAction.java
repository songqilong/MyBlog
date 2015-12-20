package com.song.struts;

import java.util.List;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.CommentBLL;
import com.song.bll.NavigationBLL;
import com.song.common.Common;
import com.song.common.PropertiesUtils;
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
		return "showList";
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
		// ǿmaster�����request��
		ActionContext.getContext().put("master", master);
		// ��ȡȫ�����µ�����
		int totalArticleQty = articleBLL.GetAllArticleCount(master);
		ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
		// ��ȡÿҳ��ʾ���µ�����
		int perPageQty = Integer.parseInt(PropertiesUtils.ReadProperties("page"));
		// ��ҳ��
		int pageQty = 0;
		if(totalArticleQty%perPageQty != 0){
			pageQty = totalArticleQty/perPageQty+1;
		}else{
			pageQty = totalArticleQty/perPageQty;
		}		
		ActionContext.getContext().put("pageQty", pageQty);
		// ��ȡ��ǰҳ�� 
		int page =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		ActionContext.getContext().put("page", page);
		// ��ȡ��ǰҳ��ȫ�����µļ���		
		this.articlelist = articleBLL.GetArticlesForPage(master,page);
		if(this.articlelist.size()>0){
			return "getListSuccess";
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
		String master  = ServletActionContext.getRequest().getParameter("master");
		ServletActionContext.getRequest().setAttribute("master", master);
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
		String author = ServletActionContext.getRequest().getParameter("master");
		ActionContext.getContext().put("master", author);
		this.article.setAuthor(author);
		ArticleBLL articleBLL = new ArticleBLL();
		// �����ӳɹ���ת�������б�
		if (articleBLL.AddArticle(article)) {
			return "addSuccess";
		}
		return "addfail";
	}
	
	/**
	 * ��ȡ��ƪ����
	 * @return
	 * @throws Exception
	 */
	public String single()throws Exception{
		String result = "showarticle";
		Object obj = ActionContext.getContext().getSession().get("navigation");
		if (obj == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations();
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() < 0) {
				result = "showlistfail";
			}else{
				ActionContext.getContext().getSession().put("navigation", list);
			}
		}
		return result;
		
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
		return "single";
	}

}

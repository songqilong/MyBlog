 package com.song.struts;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.BlogBLL;
import com.song.bll.CategoryBLL;
import com.song.bll.CommentBLL;
import com.song.bll.NavigationBLL;
import com.song.bll.NoticeBLL;
import com.song.bll.PhotoBLL;
import com.song.common.PropertiesUtils;
import com.song.entity.Article;
import com.song.entity.Blog;
import com.song.entity.Comment;
import com.song.entity.Navigation;
import com.song.entity.Notice;
import com.song.entity.Photo;

public class CommonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597189176012215446L;
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
	 * ����ҳ������
	 * @return
	 * @throws Exception
	 */
	public String loadPageDate()throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		int masterId = Integer.parseInt(request.getParameter("mid"));
		String type = request.getParameter("type");
		BlogBLL blogBLL = new BlogBLL();
		// �����û�ID��ȡBlog����
		Blog blog = blogBLL.GetBlogByMasterId(masterId);
		// ��Blog���󱣴��session������
		ServletActionContext.getRequest().getSession().setAttribute("Blog", blog);
		getNavigation(masterId);
		getUrl();
		ArticleBLL articleBLL = new ArticleBLL();
		// �����ҳ��
		int pageQty = 0;
		// ��ȡ��ǰҳ�� 
		int page = 0;
		//ActionContext.getContext().put("mid", masterId);
		request.setAttribute("mid", masterId);
		switch(type){
		// ������ҳ����
		case "100001":
			article = articleBLL.GetLastArticleByMaster(masterId);
			ActionContext.getContext().put("recommends", articleBLL.GetRecommendArticles(masterId, 5));
			NoticeBLL noticeBLL = new NoticeBLL();
			notice = noticeBLL.GetLastNotice(masterId);
			CategoryBLL categoryBLL = new CategoryBLL();
			// ��ȡ����
			ActionContext.getContext().put("categorys", categoryBLL.GetCategorysByMid(masterId));
			result = "indexready";
			break;
		// Ĭ�������б�
		case "100002":
			// ��ȡ�������ID 
			int categoryId = Integer.parseInt(request.getParameter("cid"));
			ActionContext.getContext().put("cid", categoryId);
			// ��ȡÿҳ��ʾ���µ�����
			int pageSize = Integer.parseInt(PropertiesUtils.ReadProperties("pageSize"));
			// ��ȡȫ�����µ�����
			int totalArticleQty = articleBLL.GetAllArticleQtyByMid(masterId,categoryId);
			// �������߷������������µ�����
			ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
			if(totalArticleQty%pageSize != 0){
				pageQty = totalArticleQty/pageSize+1;
			}else{
				pageQty = totalArticleQty/pageSize;
			}		
			ActionContext.getContext().put("pageQty", pageQty);
			// ��ȡ��ǰҳ�� 
			page = Integer.parseInt(request.getParameter("page"));
			ActionContext.getContext().put("page", page);
			List<Article> aa = articleBLL.GetArticlesForPage(masterId, page,pageSize,categoryId);
			ActionContext.getContext().put("articles",aa );
			result = "defaultArticlesReady";
			break;
		// ��ʾͼƬ�б����
		case "100003":
			PhotoBLL photoBLL = new PhotoBLL();
			// ��ȡһ��������ͼƬ
			int photoQty =  photoBLL.GetPhotoQtyByMid(masterId);
			ActionContext.getContext().put("photoQty", photoQty);
			// ��ȡÿҳ��ʾ��ͼƬ����
			int photoSize = Integer.parseInt(PropertiesUtils.ReadProperties("photosize"));
			if(photoQty%photoSize >0){
				pageQty = photoQty/photoSize+1;
			}else{
				pageQty = photoQty/photoSize;
			}
			ActionContext.getContext().put("pageQty", pageQty);
			// ��ȡ��ǰҳ��Ĳ���
			page = Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
			ActionContext.getContext().put("page", page);
			List<Photo> plist = photoBLL.GetPagePhotoes(masterId, page);
			ActionContext.getContext().put("photoes", plist);
			result="defaultPicturesReady";
			break;
		// ��ʾ��ƪ�ļ�
		case "100004":
			// ��ȡ����ID
			int aid = Integer.parseInt(request.getParameter("aid"));
			// ��������ID��ȡ���¶���
			article = articleBLL.GetArticleById(aid);
			// ���µ�������ۼ�
			int clickTime = article.getClicktime()+1;
			// �������µĵ������
			articleBLL.ModifyArticleClickTime(aid, clickTime);
			CommentBLL commentBLL = new CommentBLL();
			ActionContext.getContext().put("CommentQty", commentBLL.GetCommentQtyByAid(aid));
			// ��ȡ�������۵�����
			int lastCommentQty = commentBLL.GetLastCommentQty(aid);
			ActionContext.getContext().put("lastCommentQty", lastCommentQty);
			// ��ȡ�����µ����ۼ���
			List<Comment> clist = commentBLL.GetComments(aid);
			ActionContext.getContext().put("comments", clist);
			result = "singleArticleReady";
			break;
		}
		return result;
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	private boolean getNavigation(int masterId){
		boolean flag = false;
		Object nav = ActionContext.getContext().getSession().get("navigations");
		if (nav == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// ��ȡ�������ĵ�����
			List<Navigation> list = nvaBLL.GetNavigations(masterId);
			// ���������ϳ��Ȳ�Ϊ0
			if (list.size() > 0) {				
				ActionContext.getContext().getSession().put("navigations", list);
				flag = true;
			}			
		}
		return flag;
	}

	/**
	 * ��ȡURL
	 */
	private void getUrl(){
		// ��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ȡ����·��url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// ������·������session
		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
	}
}

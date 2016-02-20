 package com.song.struts;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.song.bll.ArticleBLL;
import com.song.bll.CategoryBLL;
import com.song.bll.CommentBLL;
import com.song.bll.NavigationBLL;
import com.song.bll.NoticeBLL;
import com.song.bll.PhotoBLL;
import com.song.common.PropertiesUtils;
import com.song.entity.Article;
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


//	/**
//	 * 加载导航栏数据
//	 * @return
//	 * @throws Exception
//	 */
//	public String loadNavigation()throws Exception{
//		// type参数用于确认页面起始跳转页面
//		String type = ServletActionContext.getRequest().getParameter("type");
//		String result = "";
//		switch(type){
//		// 首页加载导航
//		case "100001":
//			result = "ins";
//			break;
//		// 文章列表界面加载导航
//		case "100002":
//			result = "ans";
//			break;
//		// 图片列表界面导航 
//		case "100003":
//			result = "pns";
//			break;
//		// 单篇文章界面加载导航栏	
//		case "100004":
//			result = "sns";
//			break;
//		}
//		Object obj = ActionContext.getContext().getSession().get("navigation");
//		if (obj == null) {
//			NavigationBLL nvaBLL = new NavigationBLL();
//			// 获取导航栏的导航项
//			List<Navigation> list = nvaBLL.GetNavigations();
//			// 如果导航项集合长度不为0
//			if (list.size() <= 0) {				
//				result = "loadNavFail";
//			}else{
//				ActionContext.getContext().getSession().put("navigation", list);
//			}
//		}
//		return result;
//	}
	
//	/**
//	 * 加载路径用于定位js，css
//	 * @return
//	 * @throws Exception
//	 */
//	public String loadUrl()throws Exception{
//		// 获取request对象
//		HttpServletRequest request = ServletActionContext.getRequest();
//		// 获取基础路径url
//		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
//		// 将基础路径存入session
//		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
//		return "loadUrl";
//	}
	
//	public String getMasterName()throws Exception{
//		MasterBLL masterBLL = new MasterBLL();
//		// 获取response
//		HttpServletResponse response = ServletActionContext.getResponse();
//		// 获取request对象
//		HttpServletRequest request = ServletActionContext.getRequest();
//		int masterId = Integer.parseInt(request.getParameter("master"));
//		PrintWriter out = response.getWriter();
//		out.print(masterBLL.GetMasterInfo(masterId).getUsername());
//		return null;
//	}
	
	/**
	 * 加载页面数据
	 * @return
	 * @throws Exception
	 */
	public String loadPageDate()throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		int masterId = Integer.parseInt(request.getParameter("mid"));
		String type = request.getParameter("type");
		getNavigation();
		getUrl();
		ArticleBLL articleBLL = new ArticleBLL();
		// 定义分页数
		int pageQty = 0;
		// 获取当前页码 
		int page = 0;
		ActionContext.getContext().put("mid", masterId);
		switch(type){
		// 加载首页数据
		case "100001":
			article = articleBLL.GetLastArticleByMaster(masterId);
			ActionContext.getContext().put("recommends", articleBLL.GetRecommendArticles(masterId, 5));
			NoticeBLL noticeBLL = new NoticeBLL();
			notice = noticeBLL.GetLastNotice(masterId);
			CategoryBLL categoryBLL = new CategoryBLL();
			// 获取分类
			ActionContext.getContext().put("categorys", categoryBLL.GetCategorysByMid(masterId));
			result = "indexready";
			break;
		// 默认文章列表
		case "100002":
			// 获取文章类别ID 
			int categoryId = Integer.parseInt(request.getParameter("cid"));
			ActionContext.getContext().put("cid", categoryId);
			// 获取每页显示文章的条数
			int pageSize = Integer.parseInt(PropertiesUtils.ReadProperties("pageSize"));
			// 获取全部文章的数量
			int totalArticleQty = articleBLL.GetAllArticleQtyByMid(masterId,categoryId);
			// 设置作者发布的所有文章的总数
			ActionContext.getContext().put("TotalArticleQty", totalArticleQty);
			if(totalArticleQty%pageSize != 0){
				pageQty = totalArticleQty/pageSize+1;
			}else{
				pageQty = totalArticleQty/pageSize;
			}		
			ActionContext.getContext().put("pageQty", pageQty);
			// 获取当前页码 
			page = Integer.parseInt(request.getParameter("page"));
			ActionContext.getContext().put("page", page);
			List<Article> aa = articleBLL.GetArticlesForPage(masterId, page,pageSize,categoryId);
			ActionContext.getContext().put("articles",aa );
			result = "defaultArticlesReady";
			break;
		// 显示图片列表界面
		case "100003":
			PhotoBLL photoBLL = new PhotoBLL();
			// 获取一共多少张图片
			int photoQty =  photoBLL.GetPhotoQtyByMid(masterId);
			ActionContext.getContext().put("photoQty", photoQty);
			// 获取每页显示的图片数量
			int photoSize = Integer.parseInt(PropertiesUtils.ReadProperties("photosize"));
			if(photoQty%photoSize >0){
				pageQty = photoQty/photoSize+1;
			}else{
				pageQty = photoQty/photoSize;
			}
			ActionContext.getContext().put("pageQty", pageQty);
			// 获取当前页码的参数
			page = Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
			ActionContext.getContext().put("page", page);
			List<Photo> plist = photoBLL.GetPagePhotoes(masterId, page);
			ActionContext.getContext().put("photoes", plist);
			result="defaultPicturesReady";
			break;
		// 显示单篇文件
		case "100004":
			// 获取文章ID
			int aid = Integer.parseInt(request.getParameter("aid"));
			// 更加文章ID获取文章对象
			article = articleBLL.GetArticleById(aid);
			// 文章点击次数累加
			int clickTime = article.getClicktime()+1;
			// 更新文章的点击次数
			articleBLL.ModifyArticleClickTime(aid, clickTime);
			CommentBLL commentBLL = new CommentBLL();
			ActionContext.getContext().put("CommentQty", commentBLL.GetCommentQtyByAid(aid));
			// 获取最新评论的数量
			int lastCommentQty = commentBLL.GetLastCommentQty(aid);
			ActionContext.getContext().put("lastCommentQty", lastCommentQty);
			// 获取该文章的评论集合
			List<Comment> clist = commentBLL.GetComments(aid);
			ActionContext.getContext().put("comments", clist);
			result = "singleArticleReady";
			break;
		}
		return result;
	}
	
	/**
	 * 获取导航
	 * @return
	 */
	private boolean getNavigation(){
		boolean flag = false;
		Object nav = ActionContext.getContext().getSession().get("navigation");
		if (nav == null) {
			NavigationBLL nvaBLL = new NavigationBLL();
			// 获取导航栏的导航项
			List<Navigation> list = nvaBLL.GetNavigations();
			// 如果导航项集合长度不为0
			if (list.size() > 0) {				
				ActionContext.getContext().getSession().put("navigation", list);
				flag = true;
			}			
		}
		return flag;
	}

	/**
	 * 获取URL
	 */
	private void getUrl(){
		// 获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取基础路径url
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		// 将基础路径存入session
		ServletActionContext.getRequest().getSession().setAttribute("basePath", basePath);
	}
}

package com.song.dao;

import com.song.common.DBUtils;
import com.song.entity.Article;

public class ArticleDAO {

	/**
	 * 插入文章
	 * @param article
	 * @return
	 */
	public boolean AddArticle(Article article) {
		boolean isSuccess = false;
		// 构建插入文章对象语句
		String sql = "insert into t_article(title,sourceweb,sourceurl,keyword,content,ctime)values('"
				+ article.getTitle() + "','" + article.getSourceweb() + "','" + article.getSourceurl() + "','"
				+ article.getKeyword() + "','" + article.getContent() + "','" + article.getCtime() + "')";
		try{
			// 打开数据库连接
			DBUtils.ConnDB();
			// 执行插入操作，返回影响行数
			int row = DBUtils.ExecuteUpdateOrDelete(sql);
			// 如果影响行数大于0，则插入成功
			if(row > 0){
				isSuccess = true;
			}
			// 关闭数据库连接
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
}

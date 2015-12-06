package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 获取文章集合
	 * @return
	 */
	public List<Article> ArticleCollection(){
		// 构建查询文章集合的语句
		String sql = "select * from t_article";
		// 实例化一个文章对象的集合
		List<Article> list = new ArrayList<Article>();
		try{
			// 打开数据库
			DBUtils.ConnDB();
			// 执行查询
			ResultSet rst = DBUtils.Query(sql);
			while(rst.next())
			{
				Article article = new Article();
				article.setId(rst.getInt("id"));
				article.setTitle(rst.getString("title"));
				article.setType(rst.getString("type"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setContent(rst.getString("content"));
				article.setCtime(rst.getString("ctime"));
				list.add(article);
			}
			rst.close();
			// 关闭数据库连接
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}

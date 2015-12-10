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
		String sql = "insert into t_article(title,author,sourceweb,sourceurl,keyword,content,ctime)values('"
				+ article.getTitle() + "','"+article.getAuthor()+"','" + article.getSourceweb() + "','" + article.getSourceurl() + "','"
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
	 * 获取分页文章集合
	 * @param page 页码
	 * @param articleCount 每页的文章数量
	 * @return
	 */
	public List<Article> ArticleCollection(String author,int page,int articleCount){
		String sql = "";
		if(page == 1){
			// 构建查询文章集合的语句
			sql = "select * from t_article where author='"+author+"' limit 0,"+articleCount+"";
		}else{
			if(page>1){
				sql = "select * from t_article where author='"+author+"' limit "+((page-1)*articleCount+1)+","+articleCount+"";
			}
		}		
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
				article.setAuthor(rst.getString("author"));
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

	/**
	 * 获取指定作者一共有多少条篇文章
	 * @return
	 */
	public int ArticleCount(String author){
		int row = 0;
		String sql = "select * from t_article where author='"+author+"'";
		try{
			// 打开数据库连接
			DBUtils.ConnDB();
			// 查询操作
			ResultSet rst = DBUtils.Query(sql);
			// 移动到最后一行
			rst.last();
			// 获取最后一行的行号
			row = rst.getRow();
			rst.close();
			// 关闭数据库连接
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * 根据文章ID获取文章
	 * @param id
	 * @return
	 */
	public Article GetArticle(int id){
		Article article = null;
		String sql = "select * from t_article where id="+id+"";
		try{
			// 连接数据库
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			if(rst.next()){
				article = new Article();
				article.setId(rst.getInt("id"));
				article.setTitle(rst.getString("title"));
				article.setAuthor(rst.getString("author"));
				article.setType(rst.getString("type"));
				article.setKeyword(rst.getString("keyword"));
				article.setSourceurl(rst.getString("sourceurl"));;
				article.setSourceurl(rst.getString("sourceurl"));
				article.setContent(rst.getString("content"));
				article.setCtime(rst.getString("ctime"));
			}
			// 是否ResultSet资源
			rst.close();
			// 关闭数据库连接
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return article;
	}

	/**
	 * 根据作者查询最新发布的一篇文章
	 * @param author 作者
	 * @return
	 */
	public Article GetArticle(String author){
		Article article = null;
		// 构建SQL查询语句
		String sql = "select  * from t_article where author='"+author+"' order by ctime desc limit 0,1;";
		try{
			// 打开数据库
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			// 如果查询结果存在，则将查询的结果存入文章对象中
			if(rst.next()){
				article = new Article();
				article.setId(rst.getInt("id"));
				article.setTitle(rst.getString("title"));
				article.setAuthor(rst.getString("author"));
				article.setType(rst.getString("type"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setKeyword(rst.getString("keyword"));
				article.setContent(rst.getString("content"));
				article.setCtime(rst.getString("ctime"));
			}
			// 释放资源
			rst.close();
			// 关闭数据库连接
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return article;
	}
}

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
		String sql = "insert into t_article(title,author,type,master_id,category_id,sourceweb,sourceurl,keyword,content,ctime)values('"
				+ article.getTitle() + "'," + article.getAuthor() + "'," + article.getType() + ",'"
				+ article.getMasterId() + "'," + article.getCategoryId() + ",'" + article.getSourceweb() + "','"
				+ article.getSourceurl() + "','" + article.getKeyword() + "','" + article.getContent() + "','"
				+ article.getCtime() + "')";
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
	public List<Article> ArticleCollection(int masterId,int page,int articleCount){
		String sql = "";
		if(page == 1){
			// 构建查询文章集合的语句
			sql = "select * from t_article where master_id='"+masterId+"' order by ctime desc limit 0,"+articleCount+";";
		}else{
			if(page>1){
				sql = "select * from t_article where master_id='"+masterId+"'  order by ctime desc limit "+((page-1)*articleCount)+","+articleCount+";";
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
				article.setMasterId(rst.getInt("master_id"));
				article.setType(rst.getInt("type"));
				article.setCategoryId(rst.getInt("category_id"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setKeyword(rst.getString("keyword"));
				article.setContent(rst.getString("content"));
				article.setIsrecommend(rst.getInt("isrecommend"));
				article.setClicktime(rst.getInt("clicktime"));
				article.setCtime(rst.getString("ctime"));
				article.setIsdelete(rst.getInt("isdelete"));
				article.setDeleteTime(rst.getString("dtime"));
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
	public int ArticleCount(int masterId){
		int row = 0;
		String sql = "select * from t_article where master_id='"+masterId+"'";
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
				article.setMasterId(rst.getInt("master_id"));
				article.setType(rst.getInt("type"));
				article.setCategoryId(rst.getInt("category_id"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setKeyword(rst.getString("keyword"));
				article.setContent(rst.getString("content"));
				article.setIsrecommend(rst.getInt("isrecommend"));
				article.setClicktime(rst.getInt("clicktime"));
				article.setCtime(rst.getString("ctime"));
				article.setIsdelete(rst.getInt("isdelete"));
				article.setDeleteTime(rst.getString("dtime"));
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
				article.setMasterId(rst.getInt("master_id"));
				article.setType(rst.getInt("type"));
				article.setCategoryId(rst.getInt("category_id"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setKeyword(rst.getString("keyword"));
				article.setContent(rst.getString("content"));
				article.setIsrecommend(rst.getInt("isrecommend"));
				article.setClicktime(rst.getInt("clicktime"));
				article.setCtime(rst.getString("ctime"));
				article.setIsdelete(rst.getInt("isdelete"));
				article.setDeleteTime(rst.getString("dtime"));
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

	/**
	 * 更新文章点击次数
	 * @param articleID
	 * @return
	 */
	public boolean SumArticleClick(int articleID){
		boolean isSuccess = false;
		int row = 0;
		String sql = "update t_article set clicktime=clicktime+1 where id="+articleID+";";
		try{
			// 打开数据连接
			DBUtils.ConnDB();
			// 执行更新SQL语句
			row = DBUtils.ExecuteUpdateOrDelete(sql);
			if(row >0){
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
	 * 获取推荐文章集合
	 * @param masterId
	 * @param articleQty
	 * @return
	 */
	public List<Article> GetRecommendArticles(int masterId,int articleQty){
		String sql = "select * from t_article where master_id='"+masterId+"' and isrecommend=1 order by ctime desc limit 0,"+articleQty+";";		
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
				article.setMasterId(rst.getInt("master_id"));
				article.setType(rst.getInt("type"));
				article.setCategoryId(rst.getInt("category_id"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setKeyword(rst.getString("keyword"));
				article.setContent(rst.getString("content"));
				article.setIsrecommend(rst.getInt("isrecommend"));
				article.setClicktime(rst.getInt("clicktime"));
				article.setCtime(rst.getString("ctime"));
				article.setIsdelete(rst.getInt("isdelete"));
				article.setDeleteTime(rst.getString("dtime"));
				list.add(article);
			}
			rst.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		// 关闭数据库连接
		DBUtils.CloseCon();
		return list;
	}
}

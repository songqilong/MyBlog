package com.song.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.song.common.DBUtils;
import com.song.entity.Article;

public class ArticleDAO {


	/**
	 * ��������
	 * @param article
	 * @return
	 */
	public boolean AddArticle(Article article) {
		boolean isSuccess = false;
		// �����������¶������
		String sql = "insert into t_article(title,author,type,master_id,category_id,sourceweb,sourceurl,keyword,content,ctime)values('"
				+ article.getTitle() + "'," + article.getAuthor() + "'," + article.getType() + ",'"
				+ article.getMasterId() + "'," + article.getCategoryId() + ",'" + article.getSourceweb() + "','"
				+ article.getSourceurl() + "','" + article.getKeyword() + "','" + article.getContent() + "','"
				+ article.getCtime() + "')";
		try{
			// �����ݿ�����
			DBUtils.ConnDB();
			// ִ�в������������Ӱ������
			int row = DBUtils.ExecuteUpdateOrDelete(sql);
			// ���Ӱ����������0�������ɹ�
			if(row > 0){
				isSuccess = true;
			}
			// �ر����ݿ�����
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	/**
	 * ��ȡ��ҳ���¼���
	 * @param page ҳ��
	 * @param articleCount ÿҳ����������
	 * @return
	 */
	public List<Article> ArticleCollection(int masterId,int page,int articleCount){
		String sql = "";
		if(page == 1){
			// ������ѯ���¼��ϵ����
			sql = "select * from t_article where master_id='"+masterId+"' order by ctime desc limit 0,"+articleCount+";";
		}else{
			if(page>1){
				sql = "select * from t_article where master_id='"+masterId+"'  order by ctime desc limit "+((page-1)*articleCount)+","+articleCount+";";
			}
		}		
		// ʵ����һ�����¶���ļ���
		List<Article> list = new ArrayList<Article>();
		try{
			// �����ݿ�
			DBUtils.ConnDB();
			// ִ�в�ѯ
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
			// �ر����ݿ�����
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ȡָ������һ���ж�����ƪ����
	 * @return
	 */
	public int ArticleCount(int masterId){
		int row = 0;
		String sql = "select * from t_article where master_id='"+masterId+"'";
		try{
			// �����ݿ�����
			DBUtils.ConnDB();
			// ��ѯ����
			ResultSet rst = DBUtils.Query(sql);
			// �ƶ������һ��
			rst.last();
			// ��ȡ���һ�е��к�
			row = rst.getRow();
			rst.close();
			// �ر����ݿ�����
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * ��������ID��ȡ����
	 * @param id
	 * @return
	 */
	public Article GetArticle(int id){
		Article article = null;
		String sql = "select * from t_article where id="+id+"";
		try{
			// �������ݿ�
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
			// �Ƿ�ResultSet��Դ
			rst.close();
			// �ر����ݿ�����
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return article;
	}

	/**
	 * �������߲�ѯ���·�����һƪ����
	 * @param author ����
	 * @return
	 */
	public Article GetArticle(String author){
		Article article = null;
		// ����SQL��ѯ���
		String sql = "select  * from t_article where author='"+author+"' order by ctime desc limit 0,1;";
		try{
			// �����ݿ�
			DBUtils.ConnDB();
			ResultSet rst = DBUtils.Query(sql);
			// �����ѯ������ڣ��򽫲�ѯ�Ľ���������¶�����
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
			// �ͷ���Դ
			rst.close();
			// �ر����ݿ�����
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return article;
	}

	/**
	 * �������µ������
	 * @param articleID
	 * @return
	 */
	public boolean SumArticleClick(int articleID){
		boolean isSuccess = false;
		int row = 0;
		String sql = "update t_article set clicktime=clicktime+1 where id="+articleID+";";
		try{
			// ����������
			DBUtils.ConnDB();
			// ִ�и���SQL���
			row = DBUtils.ExecuteUpdateOrDelete(sql);
			if(row >0){
				isSuccess = true;
			}
			// �ر����ݿ�����
			DBUtils.CloseCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	/**
	 * ��ȡ�Ƽ����¼���
	 * @param masterId
	 * @param articleQty
	 * @return
	 */
	public List<Article> GetRecommendArticles(int masterId,int articleQty){
		String sql = "select * from t_article where master_id='"+masterId+"' and isrecommend=1 order by ctime desc limit 0,"+articleQty+";";		
		// ʵ����һ�����¶���ļ���
		List<Article> list = new ArrayList<Article>();
		try{
			// �����ݿ�
			DBUtils.ConnDB();
			// ִ�в�ѯ
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
		// �ر����ݿ�����
		DBUtils.CloseCon();
		return list;
	}
}

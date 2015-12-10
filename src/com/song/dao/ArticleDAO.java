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
		String sql = "insert into t_article(title,author,sourceweb,sourceurl,keyword,content,ctime)values('"
				+ article.getTitle() + "','"+article.getAuthor()+"','" + article.getSourceweb() + "','" + article.getSourceurl() + "','"
				+ article.getKeyword() + "','" + article.getContent() + "','" + article.getCtime() + "')";
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
	public List<Article> ArticleCollection(String author,int page,int articleCount){
		String sql = "";
		if(page == 1){
			// ������ѯ���¼��ϵ����
			sql = "select * from t_article where author='"+author+"' limit 0,"+articleCount+"";
		}else{
			if(page>1){
				sql = "select * from t_article where author='"+author+"' limit "+((page-1)*articleCount+1)+","+articleCount+"";
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
				article.setType(rst.getString("type"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setContent(rst.getString("content"));
				article.setCtime(rst.getString("ctime"));
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
	public int ArticleCount(String author){
		int row = 0;
		String sql = "select * from t_article where author='"+author+"'";
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
				article.setType(rst.getString("type"));
				article.setKeyword(rst.getString("keyword"));
				article.setSourceurl(rst.getString("sourceurl"));;
				article.setSourceurl(rst.getString("sourceurl"));
				article.setContent(rst.getString("content"));
				article.setCtime(rst.getString("ctime"));
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
				article.setType(rst.getString("type"));
				article.setSourceurl(rst.getString("sourceurl"));
				article.setSourceweb(rst.getString("sourceweb"));
				article.setKeyword(rst.getString("keyword"));
				article.setContent(rst.getString("content"));
				article.setCtime(rst.getString("ctime"));
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
}

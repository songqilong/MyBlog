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
		String sql = "insert into t_article(title,sourceweb,sourceurl,keyword,content,ctime)values('"
				+ article.getTitle() + "','" + article.getSourceweb() + "','" + article.getSourceurl() + "','"
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
	 * ��ȡ���¼���
	 * @return
	 */
	public List<Article> ArticleCollection(){
		// ������ѯ���¼��ϵ����
		String sql = "select * from t_article";
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
}

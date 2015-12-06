package com.song.dao;

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
}

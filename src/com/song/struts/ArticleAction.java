package com.song.struts;

import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8713584507960045011L;
	
	/**
	 * ��ʾ�����б�
	 * @return
	 * @throws Exception
	 */
	public String showList()throws Exception{
		return "list";
	} 
	
	/**
	 * ǰ��д���½���
	 * @return
	 * @throws Exception
	 */
	public String write()throws Exception{
		return "write";
	}
	
	/**
	 * �ύ������
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		return "add";
	}

}

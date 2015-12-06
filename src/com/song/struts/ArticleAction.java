package com.song.struts;

import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8713584507960045011L;
	
	/**
	 * 显示文章列表
	 * @return
	 * @throws Exception
	 */
	public String showList()throws Exception{
		return "list";
	} 
	
	/**
	 * 前往写文章界面
	 * @return
	 * @throws Exception
	 */
	public String write()throws Exception{
		return "write";
	}
	
	/**
	 * 提交新文章
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		return "add";
	}

}

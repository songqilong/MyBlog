<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${sessionScope.basePath}/plugin/bootstrap.css">
<script type="text/javascript" src="${sessionScope.basePath}/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath}/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath}/plugin/pagejs/articlelist-page.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
</head>
<body>
<div class="container">
	<div class="row"><jsp:include page="../view/navigation.jsp"></jsp:include></div>
	<div class="row">
 <article>
    <div contenteditable="false" spellcheck="false" class="example">
      <br>
      <ul class="breadcrumb breadcrumb-block">
        <li><i class="icon-location-arrow icon-muted"></i></li>
        <li><a href="/Blog/index_access?mid=${mid}&type=100001">首页</a></li>
        <li class="active">文章列表</li>
      </ul>
      <div class="list">
        <header>
          <h3><i class="icon-list-ul icon-border-circle"></i> 文章列表 &nbsp;<small><span id="TotalArticleQty">${TotalArticleQty}</span> 篇文章</small></h3>
          <s:if test="#session.Master.username!=null">
          <div class="pull-right">
            <a class="btn btn-primary" href="article_write?mid=${mid}&cid=<s:property value="#cid"/>">写文章</a>
          </div>
         <br><br>
         </s:if>
        </header>
        <section class="items items-hover">
        <s:iterator value="articles" id="article" status="st">
        	<div class="item" id="<s:property value="#article.id"/>">
            <div class="item-heading">
            <s:if test="#session.Master.username!=null">
              <div class="pull-right"><a href="article_edit?mid=${mid}&aid=<s:property value="#article.id"/>&cid=<s:property value="#cid"/>&operate=2"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a class="delete" href="#delete"/><i class="icon-remove"></i> 删除</a></div>
            </s:if>  
              <h4> <a href="article_single?mid=${mid}&aid=<s:property value="#article.id"/>&type=100004"><s:property value="#article.title"/></a></h4>
            </div>
            <div class="item-content">
            <s:property value="#article.content" escape="false"/>               
            </div>
            <div class="item-footer">
              <span class="text-muted"><s:property value="#article.ctime"/> </span>
            </div>
          </div>
        </s:iterator>
        </section>
        <footer>
          <ul class="pager">
 			<li class="previous">
 				<s:if test="#page==1">
 					<a href="article/article_showList?mid=${mid}&cid=<s:property value="#cid"/>&page=1&type=100002">« 上一页</a>
 				</s:if>
    			<s:else>
    				<a href="article/article_showList?mid=${mid}&cid=<s:property value="#cid"/>&page=<s:property value="%{#page-1}"/>&type=100002">« 上一页</a>
    			</s:else>
 			</li>
  			<li class="next">
  				<s:if test="%{#page==#pageQty}">
  					<a href="article/article_showList?mid=${mid}&cid=<s:property value="#cid"/>&page=<s:property value="#page"/>&type=100002">下一页 »</a>
  				</s:if>
  				<s:else>
  					<a href="article/article_showList?mid=${mid}&cid=<s:property value="#cid"/>&page=<s:property value="%{#page+1}"/>&type=100002">下一页 »</a>
  				</s:else>    			
  			</li>
          </ul>
        </footer>
      </div>
    </div>
  </article>
</div>
</div>
<div id="load-modal"></div>

</body>
</html>
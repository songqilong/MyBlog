<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${sessionScope.basePath}/plugin/bootstrap.css">
<script type="text/javascript" src="${sessionScope.basePath}/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath}/plugin/bootstrap.min.js"></script>
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
        <li><a href="/Blog/index_access?master=<s:property value="#master"/>&type=100001">首页</a></li>
        <li class="active">文章列表</li>
      </ul>
      <div class="list">
        <header>
          <h3><i class="icon-list-ul icon-border-circle"></i> 文章列表 &nbsp;<small><s:property value="#request.TotalArticleQty"/> 篇文章</small></h3>
          <s:if test="#session.user.username!=null">
          <div class="pull-right">
            <a class="btn btn-primary" href="article_write?master=<s:property value="#master"/>">写文章</a>
          </div>
         <br><br>
         </s:if>
        </header>
        <section class="items items-hover">
        <s:iterator value="articlelist" id="article" status="st">
        	<div class="item">
            <div class="item-heading">
            <s:if test="#session.user.username!=null">
              <div class="pull-right"><a href="article_edit?articleID=<s:property value="#article.id"/>"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a href="article_delete?articleID=<s:property value="#article.id"/>"><i class="icon-remove"></i> 删除</a></div>
            </s:if>  
              <h4><span class="label label-success">新</span>&nbsp; <a href="article_single?master=<s:property value="#master"/>&articleID=<s:property value="#article.id"/>"><s:property value="#article.title"/></a></h4>
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
 					<a href="article/article_showList?master=<s:property value="#master"/>&page=1&type=100002">« 上一页</a>
 				</s:if>
    			<s:else>
    				<a href="article/article_showList?master=<s:property value="#master"/>&page=<s:property value="%{#page-1}"/>&type=100002">« 上一页</a>
    			</s:else>
 			</li>
  			<li class="next">
  				<s:if test="%{#page==#pageQty}">
  					<a href="article/article_showList?master=<s:property value="#master"/>&page=<s:property value="#page"/>&type=100002">下一页 »</a>
  				</s:if>
  				<s:else>
  					<a href="article/article_showList?master=<s:property value="#master"/>&page=<s:property value="%{#page+1}"/>&type=100002">下一页 »</a>
  				</s:else>    			
  			</li>
          </ul>
        </footer>
      </div>
    </div>
  </article>
</div>
</div>


<script type="text/javascript">
$(document).ready(function(){
	// 遍历class为item-content的元素
	$(".item-content").each(function(){
		// 获取每个元素中的文本，然后截取150个字符
		var articleContent = $(this).text().substr(0,150)+"......";
		// 将每个元素的样式设为默认样式
		$(this).text(articleContent).css({"style":"none"});
	});
});
</script>

</body>
</html>
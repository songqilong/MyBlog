<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <article>
    <div contenteditable="true" spellcheck="false" class="example">
      <br>
      <article class="article">
        <header>
          <!-- 文章标题 -->
          <h1 class="text-center"><s:property value="article.title"/></h1>
          <dl class="dl-inline">
            <dt>作者：</dt>
            <!-- 文章作者 -->
            <dd><s:property value="article.author"/></dd>
            <dt></dt>
            <dd class="pull-right"><span class="label label-success">NEW</span> <span class="label label-warning">火爆</span> <span class="label label-info">原创</span> <span class="label label-danger"><i class="icon-eye-open"></i> 235</span></dd>
          </dl>
        </header>
        <!-- 文章内容 -->
        <section class="article-content">
         <s:property value="article.content" escape="false"/>
        </section>
        <footer>
          <p class="pull-right text-muted">
            发布时间：<s:property value="article.ctime"/> &nbsp;点击数：<s:property value="article.clicktime"/>
          </p>
          <p class="text-important">本文版权所有归<a href="###">@catouse</a></p>         
        </footer>
      </article>
    </div>
  </article>
</body>
</html>
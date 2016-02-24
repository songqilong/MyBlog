<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/bootstrap.min.css">
<script type="text/javascript" src="${sessionScope.basePath }/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/blogcommon.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="height: 1000px;">
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
            
            <!-- 文章标签  -->
            <dd id="label" class="pull-right"></dd>
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
        </footer>
      </article>
    </div>
  </article>
</body>
</html>
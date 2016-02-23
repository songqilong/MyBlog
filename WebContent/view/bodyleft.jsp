<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>left</title>
</head>
<body>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">公告</h3>
  </div>
  <div class="panel-body">
    	<s:property value="notice.content"/>
  </div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">日历</h3>
  </div>
  <div class="panel-body">
    <div id="calendar"></div>
  </div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">文章分类</h3>
  </div>
  <div class="panel-body">
    <ul>
    	<s:iterator value="#categorys" id="category" status="st">
    		<li><a href="/Blog/article/article_showList?mid=${mid}&cid=<s:property value="#category.id"/>&page=1&type=100002"><s:property value="#category.category"/></a></li>
    	</s:iterator>
    </ul>
  </div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">博主推荐</h3>
  </div>
  <div class="panel-body">
  <ul>
    <s:iterator value="#recommends" id="recommend" status="st">
    <li>
    	<a href="/Blog/article/article_single?mid=<s:property value="#recommend.masterId"/>&aid=<s:property value="#recommend.id"/>&type=100004"><s:property value="#recommend.title"/></a>
    </li>
    </s:iterator>
    </ul>
  </div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Panel title</h3>
  </div>
  <div class="panel-body">
    Panel content
  </div>
</div>
</body>
</html>
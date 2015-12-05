<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      <!-- 获取导航项集合遍历显示 -->
      <s:iterator value="#session.navigation" id="navItem" status="st">
      	<li><a href="<s:property value="#navItem.url"/>"><s:property value="#navItem.nav_name"/> </a></li>
      </s:iterator>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<s:if test="#session.user.username!= null">
      		<li><a href="#">欢迎 <s:property value="#session.user.username"/>登录</a></li>
      	</s:if>
      	<s:else>
        	<li><a href="register">登录</a></li>
        	<li><a href="#">注册</a></li>
        </s:else>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>导航栏</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">${sessionScope.Blog.blogName}</a>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<!-- 获取导航项集合遍历显示 -->
					<s:iterator value="#session.navigations" id="item" status="st">
						<li><a href="<s:property value="#item.url"/>&mid=${mid}"><s:property value="#item.nav_name" /></a></li>
					</s:iterator>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<s:if test="#session.Master.username!= null">
						<li><a href="#">欢迎 <s:property value="#session.Master.username" />登录</a></li>
					</s:if>
					<s:else>
						<li><a href="${basePath}/index.jsp">登录</a></li>
						<li><a data-toggle="modal" href="#modal-register">注册</a></li>
					</s:else>
				</ul>
			</div>
		</div>
	</nav>
	<jsp:include page="modal.jsp"></jsp:include>

</body>
</html>
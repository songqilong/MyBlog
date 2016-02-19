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
				<a class="navbar-brand" href="#">小龙博客</a>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<!-- 获取导航项集合遍历显示 -->
					<s:iterator value="#session.navigation" id="navItem" status="st">
						<s:if test="%{#navItem.nav_name=='首页'}">
							<li><a href="<s:property value="#navItem.url"/>?mid=${sessionScope.master}&type=100001"><s:property value="#navItem.nav_name" /></a></li>
						</s:if>
						<s:elseif test="%{#navItem.nav_name=='文章列表'}">
							<li><a href="<s:property value="#navItem.url" escape="false"/>?mid=${sessionScope.master}&page=1&type=100002"><s:property value="#navItem.nav_name" /> </a></li>
						</s:elseif>
						<s:elseif test="%{#navItem.nav_name=='相册'}">
							<li><a href="<s:property value="#navItem.url"/>?mid=${sessionScope.master}&page=1&type=100003"><s:property value="#navItem.nav_name" /> </a></li>
						</s:elseif>
					</s:iterator>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<s:if test="#session.Master.username!= null">
						<li><a href="#">欢迎 <s:property value="#session.Master.username" />登录</a></li>
					</s:if>
					<s:else>
						<li><a href="${basePath}/index.jsp">登录</a></li>
						<li><a data-toggle="modal" href="#register">注册</a></li>
					</s:else>
				</ul>
			</div>
		</div>
	</nav>

	<!-- 模态框开始 -->
	<div class="modal fade" id="register">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="${basePath}/register" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">用户注册</h4>
					</div>
					<div class="modal-body">
						<div class="control-group">
							<label class="control-label">用户名</label> 
							<input type="text" name="user.username" class="form-control">
						</div>
						<div class="control-group">
							<label class="control-label">密码</label> 
							<input type="password" name="user.password" class="form-control">
						</div>
						<!-- 
						<div class="control-group">
							<label class="control-label">确认密码</label>
							<input type="password" name="spassword" class="form-control">
						</div>
						 -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-primary" value="注册">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 模态框结束 -->

</body>
</html>
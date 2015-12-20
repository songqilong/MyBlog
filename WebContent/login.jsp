<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./plugin/bootstrap.min.css">
<script type="text/javascript" src="./plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<div class="container">
		<div class="row col-md-4 col-md-offset-4">
			<form class="form-signin" action="login">
				<h2 class="form-signin-heading" align="center">登录</h2>
				<!-- 用户名输入框 -->
				<input type="text" name="user.username" class="form-control" placeholder="用户名" required autofocus>
				<br> 
				<!-- 密码输入框 -->
				<input type="password" name="user.password" class="form-control" placeholder="密码" required>
				<br>
				<!--   注释掉记住密码复选框
                <div class="checkbox">
                  <label>
                  <input type="checkbox" value="remember-me"> 记住密码
                  </label>
                </div>
                -->
                <!-- 登录按钮 -->
				<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			</form>
		</div>
	</div>
</body>
</html>
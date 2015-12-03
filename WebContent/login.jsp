<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h2 class="form-signin-heading">登录</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="input" name="username" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
</div>
    </div> <!-- /container -->
</body>
</html>
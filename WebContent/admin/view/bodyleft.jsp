<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#master"> 我的资料 </a>
							</h4>
						</div>
						<div id="master" class="panel-collapse collapse in">

							<ul class="list-group">
								<li class="list-group-item"><a href="#">修改个人资料</a></li>
								<li class="list-group-item"><a href="#">修改密码</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
							</ul>

						</div>
					</div>


					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#article"> 文章管理 </a>
							</h4>
						</div>
						<div id="article" class="panel-collapse collapse">
							<ul class="list-group">
								<li class="list-group-item"><a href="#">文章管理</a></li>
								<li class="list-group-item"><a id="mcategory" href="#">文章分类管理</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
							</ul>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#photo"> 图片管理 </a>
							</h4>
						</div>
						<div id="photo" class="panel-collapse collapse">
							<ul class="list-group">
								<li class="list-group-item"><a href="#">相册管理</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
							</ul>
						</div>
					</div>
					
									<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#other"> 其他功能 </a>
							</h4>
						</div>
						<div id="other" class="panel-collapse collapse">
							<ul class="list-group">
								<li class="list-group-item"><a id="mnotice" href="#">公告管理</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
								<li class="list-group-item"><a href="#">待开发...</a></li>
							</ul>
						</div>
					</div>
				</div>
</body>
</html>
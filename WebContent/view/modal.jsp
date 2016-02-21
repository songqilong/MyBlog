<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<!-- 注册模态框开始 -->
	<div class="modal fade" id="modal-register">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/Blog/register" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">用户注册</h4>
					</div>
					<div class="modal-body">
						<div class="control-group">
							<label class="control-label">用户名</label> <input type="text" name="master.username" class="form-control">
						</div>
						<div class="control-group">
							<label class="control-label">密码</label> <input type="password" name="master.password" class="form-control">
						</div> 
						<div class="control-group">
							<label class="control-label">确认密码</label>
							<input type="password" name="spassword" class="form-control">
						</div>
						<div class="control-group">
							<label class="control-label">昵称</label> <input type="text" name="master.nickName" class="form-control">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-primary" value="注册">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 注册模态框结束 -->
</body>
</html>
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
				<form action="/Blog/register_register" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">用户注册（*必填）</h4>
					</div>
					<div class="modal-body">
						<div class="control-group">
							<label class="control-label">*用户名</label><div><input id="input_uname" type="text" name="master.username" class="form-control"></div> 
							<div id="username-prompt">用户名为非0开头的数字或字母组成，至少6位</div>
						</div>
						<div class="control-group">
							<label class="control-label">*密码</label><div> <input id="input_pwd" type="password" name="master.password" class="form-control"></div>
							<div id="password-prompt">密码为数字或字母组成，至少6位</div>
						</div> 
						<div class="control-group">
							<label class="control-label">*确认密码</label>
							<div><input id="input_spwd" type="password"  class="form-control"></div>
							<div id="spassword-prompt"></div>
						</div>
						<div class="control-group">
							<label class="control-label">*昵称</label> <div><input id="input_nickname" type="text" name="master.nickName" class="form-control"></div>
							<div id="nickname-prompt"></div>
						</div>
						<div class="control-group">
							<label class="control-label">性别</label>
							<div class="form-control">
								<label class="radio-inline">
  									<input type="radio" name="master.sex" id="inlineRadio1" value="male"  checked="checked"> 男
								</label>
								<label class="radio-inline">
  									<input type="radio" name="master.sex" id="inlineRadio2" value="famale">女
								</label>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Email</label> <div><input id="input_email" type="text" name="master.email" class="form-control"></div>
							<div id="email-prompt"></div>
						</div>
						<div class="control-group">
							<label class="control-label">QQ</label><div><input id="input_qq" type="text" name="master.qq" class="form-control"></div>
							<div id="qq-prompt"></div>
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
	
	<!-- **********************************模态框start***************************************** -->
	<div class="modal fade" id="model-delete">
		<div class="modal-dialog">
			<div class="modal-content">			
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">提示</h4>
					</div>					
					<div class="modal-body">
						<h4>Are you sure</h4>
						<p>删除这篇绝美文章</p>	
					</div>					
					<div class="modal-footer">
						<a class="btn btn-default" data-dismiss="modal">取消</a>
						<a id="delete" class="btn btn-primary">删除</a>
					</div>					
			</div>
		</div>
	</div>
<!-- **********************************模态框end***************************************** -->
</body>
</html>
$(function() {
	// 点击注册连接 显示注册模态框
	$('#modal').click(function() {		
		$('#load-modal').load("/Blog/view/modal.jsp #modal-register", function() {
			$('#modal-register').modal('show');
			var $username = $('#input_uname'); 
			var $password = $('#input_pwd');
			var $spassword = $('#input_spwd');
			
			var username = "";
			var password = "";
			var spassword = "";
			
			// 用户名文本框失去焦点验证
			$username.on("blur",function(){
				username = $username.val();
				// 用户名验证通过标志
				var flag = true;
				// 正则表达式，验证命名规范
				var reg = /^[^0]{1}[A-Za-z0-9]{5,20}/;
				// 如果用户名为空
				if(username == ""){
					$('#username-prompt').text("用户名为空").css({"color":"#FF0000"});
					$username.parent().addClass("has-error");
					flag = false;
					return false;
				}
				// 如果用户名长度少于6位
				 if(username.length<6){
					$('#username-prompt').text("用户名最少6位长度").css({"color":"#FF0000"});
					$username.parent().addClass("has-error");
					flag = false;
					return false;
				 }
				 // 如果用户名命名格式不匹配
				 if(!reg.test(username)){
					$('#username-prompt').text("用户名不能以0开头或者包含特殊符号").css({"color":"#FF0000"});
					$username.parent().addClass("has-error"); 
					flag = false;
					return false;
				 }
				 // 异步验证用户名是否已经被注册
				 $.get("/Blog/register_checkUsername",{username:username},function(data,status){
					 if(data=="cannotRegister"){
							$('#username-prompt').text("用户名已经被注册！").css({"color":"#FF0000"});
							$username.parent().addClass("has-error"); 
							flag = false;
							return false;
					 }
				 });
				 // 如果以上验证通过
				 if(flag&&$username.parent().hasClass("has-error")){
					 $('#username-prompt').text("").css({"style":"none"});
					 $username.parent().removeClass("has-error"); 
				 }
			});
			
			// 密码文本框失去焦点后验证
			$password.on("blur",function(){
				password = $password.val();
				var flag = true;
				// 正则表达式，验证命名规范
				var reg = /^[A-Za-z0-9]{6,20}/;
				// 如果用户名为空
				if(password == ""){
					$('#password-prompt').text("密码为空").css({"color":"#FF0000"});
					$password.parent().addClass("has-error");
					flag = false;
					return false;
				}
				// 如果用户名长度少于6位
				 if(password.length<6){
					$('#password-prompt').text("用户名最少6位长度").css({"color":"#FF0000"});
					$password.parent().addClass("has-error");
					flag = false;
					return false;
				 }
				 // 如果用户名命名格式不匹配
				 if(!reg.test(password)){
					$('#password-prompt').text("用户名不能以0开头或者包含特殊符号").css({"color":"#FF0000"});
					$password.parent().addClass("has-error"); 
					flag = false;
					return false;
				 }
				 // 如果以上验证通过
				 if(flag&&$password.parent().hasClass("has-error")){
					 $('#password-prompt').text("").css({"style":"none"});
					 $password.parent().removeClass("has-error"); 
				 }
			});
		});
	});
	


});



$(function() {
	// 点击注册连接 显示注册模态框
	$('#modal').click(function() {		
		$('#load-modal').load("/Blog/view/modal.jsp #modal-register", function() {
			$('#modal-register').modal('show');
			var $username = $('#input_uname'); 
			var $password = $('#input_pwd');
			var $spassword = $('#input_spwd');
			var $nickname = $('#input_nickname');
			var $email = $('#input_email');
			var $qq = $('#input_qq');
			
			var username = "";
			var password = "";
			var spassword = "";
			var nickname = "";
			var email = "";
			var qq = "";
			
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
				// 如果密码为空
				if(password == ""){
					$('#password-prompt').text("密码为空").css({"color":"#FF0000"});
					$password.parent().addClass("has-error");
					flag = false;
					return false;
				}
				// 如果密码长度少于6位
				 if(password.length<6){
					$('#password-prompt').text("密码最少6位长度").css({"color":"#FF0000"});
					$password.parent().addClass("has-error");
					flag = false;
					return false;
				 }
				 // 如果密码命名格式不匹配
				 if(!reg.test(password)){
					$('#password-prompt').text("密码不能包含特殊符号").css({"color":"#FF0000"});
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
			
			// 再次输入密码框验证
			$spassword.on("blur",function(){
				spassword = $spassword.val();
				var flag = true;
				// 如果密码不一致
				if(password != spassword){
					$('#spassword-prompt').text("两次输入密码不一致").css({"color":"#FF0000"});
					$spassword.parent().addClass("has-error");
					flag = false;
					return false;
				}
				// 如果以上验证通过
				 if(flag&&$spassword.parent().hasClass("has-error")){
					 $('#spassword-prompt').text("").css({"style":"none"});
					 $spassword.parent().removeClass("has-error"); 
				 }
			});
			
			
			// 验证昵称
			$nickname.on("blur",function(){
				var flag = true;
				nickname = $nickname.val();
				if(nickname == ""){
					$('#nickname-prompt').text("昵称不能为空").css({"color":"#FF0000"});
					$nickname.parent().addClass("has-error");
					flag = false;
					return false;
				}
				// 如果以上验证通过
				 if(flag&&$nickname.parent().hasClass("has-error")){
					 $('#nickname-prompt').text("").css({"style":"none"});
					 $nickname.parent().removeClass("has-error"); 
				 }
			});
			
			
			// 验证邮箱 
			$email.on("blur",function(){
				var flag = true;
				email = $email.val();
				var reg = /^[A-Za-z0-9]{1,30}@[A-Za-z0-9]{1,10}.com/;
				if(!reg.test(email)){
					$('#email-prompt').text("Email格式不正确").css({"color":"#FF0000"});
					$email.parent().addClass("has-error");
					flag = false;
					return false;
				}
				// 如果以上验证通过
				 if(flag&&$email.parent().hasClass("has-error")){
					 $('#email-prompt').text("").css({"style":"none"});
					 $email.parent().removeClass("has-error"); 
				 }
			});
			
			// 验证QQ
			$qq.on("blur",function(){
				var flag = true;
				var reg = /^[0-9]{6,11}/;
				qq = $qq.val();
				if(!reg.test(qq)){
					$('#qq-prompt').text("QQ号格式不正确").css({"color":"#FF0000"});
					$qq.parent().addClass("has-error");
					flag = false;
					return false;
				}
				// 如果以上验证通过
				 if(flag&&$qq.parent().hasClass("has-error")){
					 $('#qq-prompt').text("").css({"style":"none"});
					 $qq.parent().removeClass("has-error"); 
				 }
			});
			
			// 提价按钮
			$('form').on("submit",function(e){
				//e.preventDefault();
				var flag = true;
				
				username = $username.val();
				// 用户名验证通过标志
				var flag = true;
				// 正则表达式，验证命名规范
				var ureg = /^[^0]{1}[A-Za-z0-9]{5,20}/;
				// 如果用户名为空
				if(username == ""){
					$('#username-prompt').text("用户名为空").css({"color":"#FF0000"});
					$username.parent().addClass("has-error");
					flag = false;
				}
				// 如果用户名长度少于6位
				 if(username.length<6){
					$('#username-prompt').text("用户名最少6位长度").css({"color":"#FF0000"});
					$username.parent().addClass("has-error");
					flag = false;
				 }
				 // 如果用户名命名格式不匹配
				 if(!ureg.test(username)){
					$('#username-prompt').text("用户名不能以0开头或者包含特殊符号").css({"color":"#FF0000"});
					$username.parent().addClass("has-error"); 
					flag = false;
				 }
				 // 异步验证用户名是否已经被注册
				 $.get("/Blog/register_checkUsername",{username:username},function(data,status){
					 if(data=="cannotRegister"){
							$('#username-prompt').text("用户名已经被注册！").css({"color":"#FF0000"});
							$username.parent().addClass("has-error"); 
							flag = false;
					 }
				 });
				 
				 //*****************
				 
					password = $password.val();
					// 正则表达式，验证命名规范
					var preg = /^[A-Za-z0-9]{6,20}/;
					// 如果密码为空
					if(password == ""){
						$('#password-prompt').text("密码为空").css({"color":"#FF0000"});
						$password.parent().addClass("has-error");
						flag = false;
					}
					// 如果密码长度少于6位
					 if(password.length<6){
						$('#password-prompt').text("密码最少6位长度").css({"color":"#FF0000"});
						$password.parent().addClass("has-error");
						flag = false;
					 }
					 // 如果密码命名格式不匹配
					 if(!preg.test(password)){
						$('#password-prompt').text("密码不能包含特殊符号").css({"color":"#FF0000"});
						$password.parent().addClass("has-error"); 
						flag = false;
					 }
					 
					//*****************
					 
						spassword = $spassword.val();
						// 如果密码不一致
						if(password != spassword){
							$('#spassword-prompt').text("两次输入密码不一致").css({"color":"#FF0000"});
							$spassword.parent().addClass("has-error");
							flag = false;
						}
						
					//******************
						
						nickname = $nickname.val();
						if(nickname == ""){
							$('#nickname-prompt').text("昵称不能为空").css({"color":"#FF0000"});
							$nickname.parent().addClass("has-error");
							flag = false;
						}
						
					//*******************
						var ereg = /^[A-Za-z0-9]{1,30}@[A-Za-z0-9]{1,10}.com/;
						if(!ereg.test(email)){
							$('#email-prompt').text("Email格式不正确").css({"color":"#FF0000"});
							$email.parent().addClass("has-error");
							flag = false;
						}
						
					// *******************
						
						var qreg = /^[0-9]{6,11}/;
						qq = $qq.val();
						if(!qreg.test(qq)){
							$('#qq-prompt').text("QQ号格式不正确").css({"color":"#FF0000"});
							$qq.parent().addClass("has-error");
							flag = false;
						}
						
						return flag;
				
			});
			
			/******************************************************************************************/
			function qqCheck(qq){
				var flag = true;
				if(!reg.test(qq)){
					$('#qq-prompt').text("QQ号格式不正确").css({"color":"#FF0000"});
					$qq.parent().addClass("has-error");
					flag = false;
				}
				return flag;
			}
			/******************************************************************************************/
			
		});
	});
	


});



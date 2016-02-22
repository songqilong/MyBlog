$(function() {
	// 点击注册连接 显示注册模态框
	$('#modal').click(function() {		
		$('#load-modal').load("/Blog/view/modal.jsp #modal-register", function() {
			$('#modal-register').modal('show');
			var $username = $('#input_uname'); 
			
			var username = "";
			
			// 用户名文本框失去焦点验证
			$username.on("blur",function(){
				username = $username.val();
				if(username == ""){
					$('#username-err').text("用户名为空").css({"color":"#FF0000"});
					$username.parent().addClass("has-error");
				}
				 if(username.length<6){
					$('#username-err').text("用户名最少6位长度").css({"color":"#FF0000"});
					$username.parent().addClass("has-error");
				 }
			});
		});
	});
	


});



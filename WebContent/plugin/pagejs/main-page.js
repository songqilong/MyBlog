$(function() {
	// 点击注册连接 显示注册模态框
	$('#modal').click(function() {
		$('#nav').load("/Blog/view/modal.jsp", function() {
			$('#modal-register').modal('show');
		});
	});
});

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/bootstrap.min.css">
<script type="text/javascript" src="${sessionScope.basePath }/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理界面</title>
</head>
<body>
<div class="container">
<!-- top start -->
<div class="row">
	<jsp:include page="view/top.jsp"></jsp:include>
</div>
<!-- top end -->
<!-- body start -->
<div class="row">
	<!-- body left start -->
	<div class="col-md-4">
		<jsp:include page="view/bodyleft.jsp"></jsp:include>
	</div>
	<!-- body left end -->
	
	<!-- body right start -->
	<div class="col-md-8">
		<jsp:include page="view/bodyright.jsp"></jsp:include>
	</div>
	<!-- body right end -->
</div>
<!-- body end -->
</div>
</body>
<script type="text/javascript">

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

var mid = getUrlParam("mid");

$(function(){
	$.ajaxSetup ({
		cache: false //close AJAX cache
		})
	$('#mcategory').click(function(){
		//  加载文章分类管理界面
		$('#bodyleft').load("/Blog/admin/part/ManagerCategory.jsp",function(){
			// 异步获取第一页文章分类的数据
			$.getJSON("/Blog/admin/admin_getCategorysForManager",{mid:mid,page:1},function(data){
				// 遍历Json数据
				$.each(data,function(index,item){
					var dom = "<tr><td>"+item.id+"</td><td>"+item.category+"</td><td>"+item.ctime+"</td><td style='text-align:center;'><span class='glyphicon glyphicon-trash' data-toggle='tooltip' data-placement='top' title='删除'></span></td><td style='text-align:center;'><span class='glyphicon glyphicon-pencil' data-toggle='tooltip' data-placement='top' title='编辑'></span></td></tr>";
					$('table#categoryTable tbody')
					.append(dom);
					//$('table#categoryTable tbody').trigger("create"); //这名的意思是重新加载所在标签的样式。非常有用的一句话，不加这一句你动态append的标签将丢失Css样式
				});
			});
			$('tr td:gt(3)').css({"text-align":"center"});
		});
	});
});
</script>
</html>
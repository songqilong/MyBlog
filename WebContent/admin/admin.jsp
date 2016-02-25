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
<div id="load-modal"></div>
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
			$.getJSON("/Blog/category/category_getCategorysForManager",{mid:mid,page:1},function(data){
				var categorys = JSON.parse(data.categorys);   // 文章分类
				var totalPage = data.totalPage;  //页数
				// 遍历文章分类数据
				$.each(categorys,function(index,item){
					var dom = "<tr id='c"+item.id+"'><td>"+item.id+"</td><td>"+item.category+"</td><td>"+item.ctime+"</td><td style='text-align:center;'><span class='glyphicon glyphicon-trash'></span></td><td style='text-align:center;'><span class='glyphicon glyphicon-pencil'></span></td></tr>";
					$('table#categoryTable tbody')
					.append(dom);
					//$('table#categoryTable tbody').trigger("create"); //这名的意思是重新加载所在标签的样式。非常有用的一句话，不加这一句你动态append的标签将丢失Css样式
				});
				// 页数下拉框  .glyphicon-pencil
				for(var i=1;i<=totalPage;i++){
					$('#totalPage').append("<option value="+i+">"+i+"</option>").next().text(totalPage);
				}
				// 鼠标移动到删除图标上时改变鼠标形状
				$('.glyphicon-trash').on("mouseover",function(){
					$(this).css("cursor","default");
				});
				// 点击删除图标时
				$('.glyphicon-trash').on("click",function(){
					// 获取该行的文章分类ID
					var cid = $(this).parent().siblings().first().text();
					// 加载模态框dom
					$('#load-modal').load("/Blog/admin/part/modal.jsp #modal-deletecategory",function(){
						// 显示模态框
						$('#modal-deletecategory').modal('show');
						// 点击模态框的删除按钮
						$('#category-delete').on("click",function(){
							// 异步删除该文章分类
							$.get("/Blog/category/category_delete",{cid:cid,dtime:getCurrentTime()},function(data){
								if(data=="deleteSuccess"){
									// 隐藏该模态框
									$('#modal-deletecategory').modal('hide');
									// 删除要删除的行
									$("#c"+cid).remove();									
								}
							})
							
						});
					});
				});
				// 鼠标移动到编辑图标上时改变鼠标形状
				$('.glyphicon-pencil').on("mouseover",function(){
					$(this).css("cursor","default");
				});
				// 点击编辑图标时
				$('.glyphicon-pencil').on("click",function(){
					// 获取该行的文章分类ID
					var cid = $(this).parent().siblings().first().text();
					// 加载编辑模态框
					$('#load-modal').load("/Blog/admin/part/modal.jsp #modal-editcategory",function(){
						// 显示编辑模态框
						$('#modal-editcategory').modal('show');
					});
				});
			});
			
		});
	});
});

// 获取系统当前时间
function getCurrentTime(){
	var date = new Date();
	var year = date.getFullYear()
	var month ="";
	if((date.getMonth()+1)<10){
		month = "0"+(date.getMonth()+1);
	}else{
		month = date.getMonth()+1;
	}
	var day =0;
	if(date.getDate()<10){
		day = "0"+date.getDate();
	}else{
		day = date.getDate();
	}
	var hour = 0;
	if(date.getHours()<10){
		hour = "0"+date.getHours();
	}else{
		hour = date.getHours();
	}
	var minute = 0;
	if(date.getMinutes()<10){
		minute = "0"+date.getMinutes();
	}else{
		minute = date.getMinutes();
	}
	var secend = 0;
	if(date.getSeconds()<10){
		secend = "0"+date.getSeconds();
	}else{
		secend=date.getSeconds();
	}
	var time = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+secend;
	return time;
}
</script>
</html>
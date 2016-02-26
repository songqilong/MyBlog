//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

var mid = getUrlParam("mid");
//******************************************文章分类处理start**************************************************
$(function(){
	$.ajaxSetup ({
		cache: false //close AJAX cache
		});
	$('#mcategory').click(function(){
		//  加载文章分类管理界面
		$('#bodyleft').load("/Blog/admin/part/ManagerCategory.jsp",function(){
			// 异步获取第一页文章分类的数据
			LoadFirstCategoryPage();
			
			
			// 页数下拉框变化事件
			$('#page').on("change",function(){
				$('table#categoryTable tbody').empty();
				var page = $(this).val();
				// 异步获取指定页数的分类数据
				$.getJSON("/Blog/category/category_getCategorysForManager",{mid:mid,page:page},function(data){
					// 文章分类
					var categorys = JSON.parse(data.categorys);
					// 遍历文章分类数据
					$.each(categorys,function(index,item){
						var dom = "<tr id='c"+item.id+"'><td>"+item.id+"</td><td>"+item.category+"</td><td>"+item.ctime+"</td><td style='text-align:center;'><span class='glyphicon glyphicon-trash'></span></td><td style='text-align:center;'><span class='glyphicon glyphicon-pencil'></span></td></tr>";
						$('table#categoryTable tbody').append(dom);	
						$('table#categoryTable tbody').trigger("create");
					});
					CategoryCommon();
				});
			});
			// 新增文章类别
			$('#cadd').on("click",function(){
				// 加载新增文章类别模态框
				$('#load-modal').load("/Blog/admin/part/modal.jsp #modal-addcategory",function(){
					// 显示模态框
					$('#modal-addcategory').modal('show');
					// 点击添加按钮
					$("#btn-addcategory").on("click",function(){
						// 获取新增分类名称
						var category = $('#input_addcategory').val();
						// 获取创建时间
						var ctime = getCurrentTime();
						// 发送新文章的数据
						$.post("/Blog/category/category_add",{mid:mid,category:category ,ctime:getCurrentTime()},function(data){
							if(data=="addSuccess"){
								// 隐藏模态框
								$('#modal-addcategory').modal('hide');
								LoadFirstCategoryPage();
							}
						});
					});
				});
			});
			
			
		});
	});
});

function LoadFirstCategoryPage(){
	$.getJSON("/Blog/category/category_getCategorysForManager",{mid:mid,page:1},function(data){
		var categorys = JSON.parse(data.categorys);   // 文章分类
		var totalPage = data.totalPage;  //页数
		$('table#categoryTable tbody').empty();
		// 遍历文章分类数据
		$.each(categorys,function(index,item){
			var dom = "<tr id='c"+item.id+"'><td>"+item.id+"</td><td>"+item.category+"</td><td>"+item.ctime+"</td><td style='text-align:center;'><span class='glyphicon glyphicon-trash'></span></td><td style='text-align:center;'><span class='glyphicon glyphicon-pencil'></span></td></tr>";
			$('table#categoryTable tbody')
			.append(dom);
			//$('table#categoryTable tbody').trigger("create"); //这名的意思是重新加载所在标签的样式。非常有用的一句话，不加这一句你动态append的标签将丢失Css样式
		});
		$('#page').empty();
		// 页数下拉框  .glyphicon-pencil
		for(var i=1;i<=totalPage;i++){
			$('#page').append("<option value="+i+">"+i+"</option>").next().text(totalPage);
		}				
		CategoryCommon();
	});
}

//文章分类公共方法
function CategoryCommon(){
	// 鼠标移动到删除图标上时改变鼠标形状
	$('.glyphicon-trash').on("mouseover",function(){
		$(this).css("cursor","default");
	});
	// 鼠标移动到删除图标上时改变鼠标形状结束
	
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
				});							
			});
		});
	});
	// 点击删除图标结束
	
	// 鼠标移动到编辑图标上时改变鼠标形状
	$('.glyphicon-pencil').on("mouseover",function(){
		$(this).css("cursor","default");
	});
	// 鼠标移动到编辑图标上时改变鼠标形状结束
	
	// 点击编辑图标时
	$('.glyphicon-pencil').on("click",function(){
		// 获取该行的文章分类ID
		var cid = $(this).parent().siblings().first().text();
		// 加载编辑模态框
		$('#load-modal').load("/Blog/admin/part/modal.jsp #modal-editcategory",function(){
			// 显示编辑模态框
			$('#modal-editcategory').modal('show');
			$('#category-edit').on("click",function(){
				var newcategory = $('#newcategory').val();
				if(newcategory==""){
					// 设置文本框错误红色边框
					$('#newcategory').parent().addClass("has-error");
					return false;
				}else{
					// 异步提交修改数据
					$.post("/Blog/category/category_edit",{cid:cid,newcategory:newcategory},function(data){
						if(data == "editSuccess"){
							$("#c"+cid).children().first().next().text(newcategory);
							$('#modal-editcategory').modal('hide');
							
						}
					});
				}
			});
		});
	});
	// 点击编辑图标结束
}
//******************************************文章分类处理end**************************************************


//******************************************公告管理start**************************************************
$(function(){
	$.ajaxSetup ({
		cache: false //close AJAX cache
		});
	// 点击"公告管理"链接 start
	$('#mnotice').click(function(){
		// 加载公告管理界面 start
		$('#bodyleft').load("/Blog/admin/part/ManagerNotice.jsp",function(){
			// 加载第一页数据
			LoadFirstNoticePage();
		});
		// 加载公告管理界面 end
	});
	// 点击"公告管理"链接 end
});

// 加载第一页公告
function LoadFirstNoticePage(){
	// 异步获取公告数据 start
	$.getJSON("/Blog/notice/notice_getNoticesForManager",{mid:mid,page:1},function(data){
		var notices = JSON.parse(data.notices);
		var totalPage = data.totalPage;
		// 遍历公告集合的JSON start
		$('table#noticeTable tbody').empty();
		$.each(notices,function(index,item){
			var dom = "<tr id='n"+item.id+"'><td>"+item.id+"</td><td>"+item.title+"</td><td>"+item.ctime+"</td><td style='text-align:center;'><span class='glyphicon glyphicon-trash'></span></td><td style='text-align:center;'><span class='glyphicon glyphicon-pencil'></span></td></tr>"; 
			$('table#noticeTable tbody').append(dom);
		});
		// 遍历公告集合的JSON end
		// 清空页数下拉框
		$('#page').empty();
		// 设置页数下拉框 
		for(var i=1;i<=totalPage;i++){
			$('#page').append("<option value="+i+">"+i+"</option>");
		}
		$('#page').next().text(totalPage);
		NoticeCommon();
	});
	// 异步获取公告数据 end
}

// 公告公共处理方法
function NoticeCommon(){
	// 鼠标移动到删除、编辑图标上时改变鼠标形状 start
	$('.glyphicon-trash, .glyphicon-pencil').on("mouseover",function(){
		$(this).css("cursor","default");
	});
	// 鼠标移动到删除、编辑图标上时改变鼠标形状 end
	
	// 点击删除图标 start
	$('.glyphicon-trash').on("click",function(){
		// 获取公告ID
		var nid = $(this).parent().siblings().first().text();
		// 加载删除模态框 start
		$('#load-modal').load("/Blog/admin/part/modal.jsp #modal-deletenotice",function(){
			// 显示模态框
			$('#modal-deletenotice').modal('show');
			// 点击删除公告按钮 start
			$('#mbtn-deletenotice').on("click",function(){
				var info={"id":nid,"dtime":getCurrentTime()}
				$.post("/Blog/notice/notice_delete",{nid:nid,dtime:getCurrentTime()},function(data){
					if(data =="deleteSuccess"){
						$('#modal-deletenotice').modal('hide');
						$("#n"+nid).remove();
					}
				});
			});
			// 点击删除公告按钮 end
		});
		// 加载删除模态框 end
	});
	// 点击删除图标 end
	
	// 点击编辑图标 start
	$('.glyphicon-pencil').on("click",function(){
		// 获取公告ID
		var nid = $(this).parent().siblings().first().text();
		// 加载编辑公告文本框 start
		$('#load-modal').load("/Blog/admin/part/modal.jsp #modal-editnotice",function(){
			$('#modal-editnotice').modal('show');
			// 加载指定ID的公告 start
			$.getJSON("/Blog/notice/notice_getNoticesForId",{nid:nid},function(data){
				if(data != "none"){
					$('#input_noticetitle').val(data.title);
					$('#textarea_noticecontent').val(data.content);
				}
			});
			// 加载指定ID的公告 end
			
			// 点击修改按钮 start 
			$('#mbtn-editnotice').on("click",function(){
				var title = $('#input_noticetitle').val();
				var content = $('#textarea_noticecontent').val();
				$.post("/Blog/notice/notice_edit",{nid:nid,title:title,content:content},function(data){
					if(data=="editSuccess"){
						LoadFirstNoticePage();
						$('#modal-editnotice').modal('hide');
					}
				});
			});
			// 点击修改按钮 end
		});
		// 加载编辑公告文本框 end
	});
	// 点击编辑图标 start
}

//******************************************公告管理end**************************************************



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



//获取url中的参数
  function getUrlParam(name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      if (r != null) return unescape(r[2]); return null; //返回参数值
  }
  
  // 该jquery 用于文章标签显示（需要完善）
  $(function(){
	 var $label = $('#label'); // 显示文章标签的父元素
	 $label.append("<span class=\"label label-success\">NEW</span>")
	 .append("&nbsp;<span class=\"label label-warning\">火爆</span>")
	 .append("&nbsp;<span class=\"label label-info\">原创</span>")
	 .append("&nbsp;<span class=\"label label-danger\"><i class=\"icon-eye-open\"></i> 235</span>")
  });
  
  //******************************* 该JQuery用于创建文章时的操作******************************************************* 

  $(function(){
	  var $title = $('#input_title'); //文章题目
	  var $copyBox = $('#copyBox');
	  $copyBox.hide();
	  // 标题失去焦点后验证
	  $title.blur(function(){
		  var $titleWarn = $('#title_warn');
		  // 如果标题内容为空
		  if($title.val()==""){
			  $title.parent().addClass("has-error");
			  if($titleWarn.length==0){
				  $title.parent().append("<div id=\"title_warn\" class=\"help-block alert alert-warning\">标题不能为空</div>");
			  }
		  }else{
			  if($titleWarn.length>0){
				  $titleWarn.parent().removeClass("has-error");
				  $titleWarn.remove();
			  }
		  }
	  });
	  
	  var $type = $('#select_type'); // 文章来源
	  // 文章来源下拉框变化监听
	  $type.change(function(){
		  if($type.val()==2){
			  $copyBox.show();
		  }else{
			  $copyBox.hide();
		  }
	  });
	  
	  
	  // 获取文章分类
	  var mid = getUrlParam("mid");
	  var $categroy = $('#select_category');
	  $.getJSON("/Blog/category/category_getCategoryInfo",{mid:mid},function(data){
		  $.each(data,function(index,item){
			  $categroy.append("<option value='"+item.id+"'>"+item.category+"</option>");
		  });
	  });
	  
	  // 点击提交按钮
	  $('#submit').bind('click',function(e){
		  var title = $title.val();
		  // 文章标题的验证处理
		  if(title == ""){
			  $title.focus();
			  $title.parent().addClass("has-error")
			  .append("<div id=\"title_warn\" class=\"help-block alert alert-warning\">标题不能为空</div>");
			  e.preventDefault();
		  }
		  var type = $type.val();
		  // 如果文章类型为转帖的验证处理
		  if(type == 2){
			  var $author = $('#input_author');
			  var $sourceweb = $('#input_sourceweb');
			  var $sourceurl = $('#input_sourceurl');
			  var author = $author.val();
			  var sourceweb = $sourceweb.val();
			  var sourceurl = $sourceurl.val();
			  if(author == ""){
				  $author.focus();
				  $author.parent().addClass("has-error");
				  e.preventDefault();
			  }
			  if(sourceweb == ""){
				  $sourceweb.focus();
				  $sourceweb.parent().addClass("has-error");				 
				  e.preventDefault();
			  }
			  if(sourceurl == ""){
				  $sourceurl.focus();
				  $sourceurl.parent().addClass("has-error");
				  e.preventDefault();
			  }
		  }
		  var $content = $('#content');
		  var content = $content.val();
		  if(content == ""){
			  alert("文章内容为空！");
			  e.preventDefault();
		  }

	  });
  });
  
  //********************************************************************************************************************************************
  
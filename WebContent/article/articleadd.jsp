<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${basePath}/plugin/editor/themes/default/default.css">
<link rel="stylesheet" href="${basePath}/plugin/bootstrap.min.css">
<script type="text/javascript" src="${basePath}/plugin/editor/kindeditor-min.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/plugin/blogcommon.js"></script>
<script>
KindEditor.ready(function(K) {
    window.editor = K.create('#content',{afterBlur: function(){this.sync()}});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>写文章</title>
</head>
<body>
<div class="container">
<div class="row"><jsp:include page="../view/navigation.jsp"></jsp:include></div>
		<!-- 面包屑开始 -->
		<div class="row">
			<ul class="breadcrumb">
				<li><a href="/Blog/index_access?mid=${mid}&type=100001">首页</a></li>
				<li><a href="article_showList?mid=${mid}&cid=${cid}&page=1&type=100002">文章列表</a></li>
				<li class="active">发布文章</li>
			</ul>
		</div>
		<!-- 面包屑结束 -->
<div class="row">
<div class="example">
      <form action="article_add?mid=${mid}&cid=${cid}" class="form-horizontal form-condensed" role="form" method='post'>
        <legend>创建文章</legend>
        <div class="form-group">
          <label class="col-md-2 control-label">标题</label>
          <div class="col-md-10">
             <input id="input_title" type='text' name='article.title' id='title' value='' class='form-control' placeholder=''/>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-2 control-label">来源</label>
          <div class='col-md-3'>
            <select id="select_type" name='article.type' id='original' class='form-control'>
              <option value='1' selected='selected'>原创</option>
              <option value='2'>转贴</option>
            </select>
          </div> 
          <div id='copyBox'>
          	<div class='col-md-2'><input id="input_author" type='text' name='article.author' class='form-control' placeholder='作者'/></div>
			<div class='col-md-2'><input id="input_sourceweb" type='text' name='article.sourceweb' class='form-control' placeholder='来源网站'/></div>
			<div class='col-md-3'><input id="input_sourceurl" type='text' name='article.sourceurl' class='form-control' placeholder='来源URL' /></div>
		</div>       
        </div>
         <div class="form-group">
          <label class="col-md-2 control-label">分类</label>
          <div class='col-md-3'>
            <select id='select_category' name='article.categoryId' id='original' class='form-control'>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-2 control-label">关键字</label>
          <div class="col-md-10">
            <input type='text' name='article.keyword' id='keywords' value='' class='form-control' />
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-2 control-label">内容</label>
          <div class="col-md-10">
            <textarea id="content" name="article.content"  class='form-control'>
				
			</textarea>
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-offset-2 col-md-10">
             <input type='submit' id='submit' class='btn btn-primary' value='发表'/> 
          </div>
        </div>
      </form>
    </div>
</div>
</div>
</body>
</html>
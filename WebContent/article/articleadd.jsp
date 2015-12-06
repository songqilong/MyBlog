<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=basePath%>/plugin/editor/themes/default/default.css">
<link rel="stylesheet" href="<%=basePath%>/plugin/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>/plugin/editor/kindeditor-min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/bootstrap.min.js"></script>
<script>
KindEditor.ready(function(K) {
    window.editor = K.create('#content');
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>写文章</title>
</head>
<body>
<div class="container">
<div class="row"><jsp:include page="../view/navigation.jsp"></jsp:include></div>
<div class="row">
<div class="example">
      <form action="article_add" class="form-horizontal form-condensed" role="form" method='post'>
        <legend>创建文章</legend>
        <div class="form-group">
          <label class="col-md-2 control-label">标题</label>
          <div class="col-md-10 has-error">
             <input type='text' name='title' id='title' value='' class='form-control' placeholder=''/>
             <div class="help-block alert alert-warning">标题不能为空</div>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-2 control-label">来源</label>
          <div class='col-md-4'>
            <select name='original' id='original' class='form-control'>
              <option value='1' selected='selected'>原创</option>
              <option value='0'>转贴</option>
            </select>
          </div>
          <div id='copyBox'>
            <div class='col-md-2'><input type='text' name='copySite' id='copySite' value='' class='form-control' placeholder='来源网站' /></div>
            <div class='col-md-3'><input type='text' name='copyURL' id='copyURL' value='' class='form-control' placeholder='来源URL' /></div>
          </div>
        </div>
        
        <div class="form-group">
          <label class="col-md-2 control-label">关键字</label>
          <div class="col-md-10">
            <input type='text' name='keywords' id='keywords' value='' class='form-control' />
          </div>
        </div>

        <div class="form-group">
          <label class="col-md-2 control-label">内容</label>
          <div class="col-md-10">
            <textarea id="content" name="content" class='form-control'>
				
			</textarea>
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-offset-2 col-md-10">
             <input type='submit' id='submit' class='btn btn-primary' value='保存' data-loading='稍候...' /> <input type='hidden' name='type' id='type' value='article'  />
          </div>
        </div>
      </form>
    </div>
</div>
</div>
</body>
</html>
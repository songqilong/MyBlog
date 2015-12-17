<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
                <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=basePath%>/plugin/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片列表</title>
</head>
<body>
<div class="container">
<div class="row"><jsp:include page="../view/navigation.jsp"></jsp:include></div>
<div class="row">
  <article>
    <div contenteditable="false" spellcheck="false" class="example">
      <br>
      <ul class="breadcrumb breadcrumb-block">
        <li><i class="icon-location-arrow icon-muted"></i></li>
        <li><a href="/Blog/index_access?master=<s:property value="#master"/>">首页</a></li>
        <li class="active">图片</li>
      </ul>
      <div class="list">
        <header>
          <s:if test="#session.user.username != null">
            <div class="pull-right">
            	<a class="btn btn-primary" href="photo_add?master=<s:property value="#master"/>">上传图片</a>
            </div>
          </s:if>
          <h3><i class="icon-list-ul icon-border-circle"></i> 图片列表 &nbsp;<small>26 张图片</small></h3>
        </header>
        <section class="cards">
        <br><br>
        <div class="row">
								<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
		</div>
		
		        <div class="row">
								<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
		</div>
		
		        <div class="row">
								<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="${basePath }/picture/image/1.png" alt="...">
									</a>
								</div>
		</div>
        </section>
        <footer>
          <ul class="pager">
            <li class="previous"><a href="#">« 上一页</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">⋯</a></li>
            <li><a href="#">6</a></li>
            <li class="active"><a href="#">7</a></li>
            <li><a href="#">8</a></li>
            <li><a href="#">9</a></li>
            <li><a href="#">⋯</a></li>
            <li><a href="#">12</a></li>
            <li class="next"><a href="#">下一页 »</a></li>
          </ul>
        </footer>
      </div>
    </div>
  
  </article>
</div>
</div>
</body>
</html>
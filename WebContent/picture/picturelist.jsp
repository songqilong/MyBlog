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
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
      </ul>
      <div class="list">
        <header>
          <div class="pull-right">
            <div class="btn-group" data-toggle="buttons-radio">
              <button type="button" class="btn btn-default active"><i class="icon-th-list"></i></button>
              <button type="button" class="btn btn-default"><i class="icon-th"></i></button>
              <button type="button" class="btn btn-default"><i class="icon-th-large"></i></button>
            </div>
          </div>
          <h3><i class="icon-list-ul icon-border-circle"></i> Cards &nbsp;<small>26 items</small></h3>
        </header>
        <section class="cards">
        <div class="row">
								<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
		</div>
		
		        <div class="row">
								<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
		</div>
		
		        <div class="row">
								<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
										<div class="col-xs-6 col-md-3">
									<a href="#" class="thumbnail"> <img src="./myimage/1.png" alt="...">
									</a>
								</div>
		</div>
        <!--  
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card">
              <img src="./myimage/1.png" alt="">             
            </a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card">
              <img src="./myimage/1.png" alt="">
            </a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card"><img src="./myimage/1.png" alt=""></a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card"><img src="./myimage/1.png" alt=""></a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card"><img src="./myimage/1.png" alt=""></a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card"><img src="./myimage/1.png" alt=""></a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card"><img src="./myimage/1.png" alt=""></a>
          </div>
          <div class="col-md-4 col-sm-6 col-lg-3">
            <a href="###" class="card"><img src="./myimage/1.png" alt=""></a>
          </div>
            -->
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
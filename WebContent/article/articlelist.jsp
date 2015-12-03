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
<title>文章列表</title>
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
          <h3><i class="icon-list-ul icon-border-circle"></i> Contents List &nbsp;<small>26 articles</small></h3>
        </header>
        <section class="items items-hover">
          <div class="item">
            <div class="item-heading">
              <div class="pull-right"><a href="###"><i class="icon-pencil"></i> edit</a> &nbsp;<a href="#"><i class="icon-remove"></i> delete</a></div>
              <h4><span class="label label-success">NEW</span>&nbsp; <a href="###">Lorem ipsum dolor sit amet.中文标题测试</a></h4>
            </div>
            <div class="item-content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi, necessitatibus, animi magni illo vel ducimus quia dolorum modi temporibus iste fugit laudantium minima minus sit debitis. Autem voluptate dolorum saepe!
            </div>
            <div class="item-footer">
              <a href="#" class="text-muted"><i class="icon-comments"></i> 243</a>&nbsp;
              <span class="text-muted">2013-11-11 16:14:37</span>
            </div>
          </div>
          <div class="item">
            <div class="item-heading">
              <div class="pull-right"><a href="###"><i class="icon-pencil"></i> edit</a> &nbsp;<a href="#"><i class="icon-remove"></i> delete</a></div>
              <h4><a href="###">Lorem ipsum dolor sit amet.中文标题测试</a></h4>
            </div>
            <div class="item-content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi, necessitatibus, animi magni illo vel ducimus quia dolorum modi temporibus iste fugit laudantium minima minus sit debitis. Autem voluptate dolorum saepe!
            </div>
            <div class="item-footer">
              <a href="#"><i class="icon-comments"></i> 243</a>&nbsp;
              <span class="text-muted">2013-11-11 16:14:37</span>
            </div>
          </div>
          <div class="item">
            <div class="item-heading">
              <div class="pull-right"><a href="###"><i class="icon-pencil"></i> edit</a> &nbsp;<a href="#"><i class="icon-remove"></i> delete</a></div>
              <h4><a href="###">Lorem ipsum dolor sit amet.中文标题测试</a></h4>
            </div>
            <div class="item-content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi, necessitatibus, animi magni illo vel ducimus quia dolorum modi temporibus iste fugit laudantium minima minus sit debitis. Autem voluptate dolorum saepe!
            </div>
            <div class="item-footer">
              <a href="#"><i class="icon-comments"></i> 243</a>&nbsp;
              <span class="text-muted">2013-11-11 16:14:37</span>
            </div>
          </div>
          <div class="item">
            <div class="item-heading">
              <div class="pull-right"><a href="###"><i class="icon-pencil"></i> edit</a> &nbsp;<a href="#"><i class="icon-remove"></i> delete</a></div>
              <h4><a href="###">Lorem ipsum dolor sit amet.中文标题测试</a></h4>
            </div>
            <div class="item-content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi, necessitatibus, animi magni illo vel ducimus quia dolorum modi temporibus iste fugit laudantium minima minus sit debitis. Autem voluptate dolorum saepe!
            </div>
            <div class="item-footer">
              <a href="#"><i class="icon-comments"></i> 243</a>&nbsp;
              <span class="text-muted">2013-11-11 16:14:37</span>
            </div>
          </div>
          <div class="item">
            <div class="item-heading">
              <div class="pull-right"><a href="###"><i class="icon-pencil"></i> edit</a> &nbsp;<a href="#"><i class="icon-remove"></i> delete</a></div>
              <h4><a href="###">Lorem ipsum dolor sit amet.中文标题测试</a></h4>
            </div>
            <div class="item-content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi, necessitatibus, animi magni illo vel ducimus quia dolorum modi temporibus iste fugit laudantium minima minus sit debitis. Autem voluptate dolorum saepe!
            </div>
            <div class="item-footer">
              <a href="#"><i class="icon-comments"></i> 243</a>&nbsp;
              <span class="text-muted">2013-11-11 16:14:37</span>
            </div>
          </div>
          <div class="item">
            <div class="item-heading">
              <div class="pull-right"><a href="###"><i class="icon-pencil"></i> edit</a> &nbsp;<a href="#"><i class="icon-remove"></i> delete</a></div>
              <h4><a href="###">Lorem ipsum dolor sit amet.中文标题测试</a></h4>
            </div>
            <div class="item-content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi, necessitatibus, animi magni illo vel ducimus quia dolorum modi temporibus iste fugit laudantium minima minus sit debitis. Autem voluptate dolorum saepe!
            </div>
            <div class="item-footer">
              <a href="#"><i class="icon-comments"></i> 243</a>&nbsp;
              <span class="text-muted">2013-11-11 16:14:37</span>
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
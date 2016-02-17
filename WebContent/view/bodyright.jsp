<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <article>
    <div contenteditable="true" spellcheck="false" class="example">
      <br>
      <article class="article">
        <header>
          <!-- 文章标题 -->
          <h1 class="text-center"><s:property value="article.title"/></h1>
          <dl class="dl-inline">
            <dt>作者：</dt>
            <!-- 文章作者 -->
            <dd><s:property value="article.author"/></dd>
            <dt></dt>
            <dd class="pull-right"><span class="label label-success">NEW</span> <span class="label label-warning">火爆</span> <span class="label label-info">原创</span> <span class="label label-danger"><i class="icon-eye-open"></i> 235</span></dd>
          </dl>
        </header>
        <!-- 文章内容 -->
        <section class="article-content">
         <s:property value="article.content" escape="false"/>
        </section>
        <footer>
          <p class="pull-right text-muted">
            发布时间：<s:property value="article.ctime"/> &nbsp;点击数：<s:property value="article.clicktime"/>
          </p>
          <p class="text-important">本文版权所有归<a href="###">@catouse</a></p>         
        </footer>
      </article>
    </div>
  </article>
  
  <script type="text/javascript">
  //获取url中的参数
  function getUrlParam(name) {
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
      var r = window.location.search.substr(1).match(reg);  //匹配目标参数
      if (r != null) return unescape(r[2]); return null; //返回参数值
  }
  
  $(function(){
	  var master = getUrlParam("master");
	  $.get("/Blog/common_getMasterName?master="+master,function(data,status){
		  $("#masterName").text(data);
	  });
  });
  </script>
</body>
</html>
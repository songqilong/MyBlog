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
<link rel="stylesheet" href="${basePath}/plugin/bootstrap.min.css">
<script type="text/javascript" src="${basePath}/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/plugin/bootstrap.min.js"></script>
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
        <li><a href="/Blog/index_access?mid=<s:property value="#mid"/>&type=100001">首页</a></li>
        <li class="active">图片列表</li>
      </ul>
      <div class="list">
        <header>
          <s:if test="#session.Master.username != null">
            <div class="pull-right">
            	<a class="btn btn-primary" href="photo_add?mid=<s:property value="#mid"/>">上传图片</a>
            </div>
          </s:if>
          <h3><i class="icon-list-ul icon-border-circle"></i> 图片列表 &nbsp;<small><s:property value="#photoQty"/>张图片</small></h3>
        </header>
        <section class="cards">
        <br><br>
        <div class="row">
        	<s:iterator value="#photoes" id="photo" status="st">
        	   <div class="col-xs-6 col-md-3" >
					 <a href="#" class="thumbnail"> <img src="${basePath }/picture/image/<s:property value="#photo.photoname"/>" style="height: 200px;" alt="..."></a>
				</div>
        	</s:iterator>
								
		</div>
        </section>
        <footer>
          <ul class="pager">
          	<s:if test="%{#page==1}">
          		<li class="previous"><a href="photo_showList?mid=<s:property value="#mid"/>&page=1&type=100003">« 上一页</a></li>
          	</s:if>
            <s:else>
            	<li class="previous"><a href="photo_showList?mid=<s:property value="#mid"/>&page=<s:property value="%{#page-1}"/>&type=100003">« 上一页</a></li>
            </s:else>
			
			<s:if test="%{#page==#pageQty}">
				<li class="next"><a href="photo_showList?mid=<s:property value="#mid"/>&page=<s:property value="#page"/>&type=100003">下一页 »</a></li>
			</s:if>
            <s:else>
            	<li class="next"><a href="photo_showList?mid=<s:property value="#mid"/>&page=<s:property value="%{#page+1}"/>&type=100003">下一页 »</a></li>
            </s:else>
          </ul>
        </footer>
      </div>
    </div>
  
  </article>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:"photo_getPhotoUrl?master=1&page=1",
	    dataType:"json",
	    success:function(data){
	    	$start = $("<br><br>");
	    	for(i=0;i<data.length;i++){
	    		
	    	}
	    }
	});
});
</script>
</body>
</html>
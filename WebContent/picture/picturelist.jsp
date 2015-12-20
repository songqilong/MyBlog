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
        <li><a href="/Blog/index_access?master=<s:property value="#master"/>&type=100001">首页</a></li>
        <li class="active">图片列表</li>
      </ul>
      <div class="list">
        <header>
          <s:if test="#session.user.username != null">
            <div class="pull-right">
            	<a class="btn btn-primary" href="photo_add?master=<s:property value="#master"/>">上传图片</a>
            </div>
          </s:if>
          <h3><i class="icon-list-ul icon-border-circle"></i> 图片列表 &nbsp;<small><s:property value="#photoQty"/>张图片</small></h3>
        </header>
        <section class="cards">
        <br><br>
        <div class="row">
        	<s:iterator value="#photoList" id="photo" status="st">
        	   <div class="col-xs-6 col-md-3">
					 <a href="#" class="thumbnail"> <img src="${basePath }/picture/image/<s:property value="#photo.photoname"/>" alt="..."></a>
				</div>
        	</s:iterator>
								
		</div>
		<!--  
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
		-->
        </section>
        <footer>
          <ul class="pager">
          	<s:if test="%{#page==1}">
          		<li class="previous"><a href="photo_showList?master=<s:property value="#master"/>&page=1">« 上一页</a></li>
          	</s:if>
            <s:else>
            	<li class="previous"><a href="photo_showList?master=<s:property value="#master"/>&page=<s:property value="%{#page-1}"/>">« 上一页</a></li>
            </s:else>
			
			<s:if test="%{#page==#pageQty}">
				<li class="next"><a href="photo_showList?master=<s:property value="#master"/>&page=<s:property value="#page"/>">下一页 »</a></li>
			</s:if>
            <s:else>
            	<li class="next"><a href="photo_showList?master=<s:property value="#master"/>&page=<s:property value="%{#page+1}"/>">下一页 »</a></li>
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
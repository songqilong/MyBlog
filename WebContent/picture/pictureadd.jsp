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
<link rel="stylesheet" href="<%=basePath%>/plugin/image-upload/webuploader.css">
<link rel="stylesheet" href="<%=basePath%>/plugin/image-upload/style.css">
<script type="text/javascript" src="<%=basePath%>/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/image-upload/webuploader.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/image-upload/upload.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片上传</title>
</head>
<body>
<div class="container">
	<!-- 导航栏 -->
	<div class="row"><jsp:include page="../view/navigation.jsp"></jsp:include></div>
	<!-- 图片批量上传 -->
	<div class="row">
	
	<div id="wrapper">
        <div id="container">
            <!--头部，相册选择和格式选择-->

            <div id="uploader">
                <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker"></div>
                        <p>或将照片拖到这里，单次最多可选300张</p>
                    </div>
                </div>
                <div class="statusBar" style="display:none;">
                    <div class="progress">
                        <span class="text">0%</span>
                        <span class="percentage"></span>
                    </div><div class="info"></div>
                    <div class="btns">
                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	</div>

</div>
</body>
</html>
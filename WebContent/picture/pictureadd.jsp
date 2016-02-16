<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/image-upload/webuploader.css">
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/image-upload/style.css">
<script type="text/javascript" src="${sessionScope.basePath }/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/image-upload/webuploader.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/image-upload/upload.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片上传</title>
</head>
<body>
	<div class="container">
		<!-- 导航栏 -->
		<div class="row"><jsp:include page="../view/navigation.jsp"></jsp:include></div>
		<!-- 面包屑开始 -->
		<div class="row">
			<ul class="breadcrumb">
				<li><a href="/Blog/index_access?master=${master }&type=100001">首页</a></li>
				<li><a href="photo_showList?master=${master }&page=1&type=100003">图片列表</a></li>
				<li class="active">图片上传</li>
			</ul>
		</div>
		<!-- 面包屑结束 -->
		<!-- 图片批量上传开始 -->
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
						<div class="statusBar" style="display: none;">
							<div class="progress">
								<span class="text">0%</span> <span class="percentage"></span>
							</div>
							<div class="info"></div>
							<div class="btns">
								<div id="filePicker2"></div>
								<div class="uploadBtn">开始上传</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- 图片批量上传开始 -->

	</div>
</body>
</html>
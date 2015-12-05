<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/bootstrap.min.css">
<script type="text/javascript" src="${sessionScope.basePath }/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<jsp:include page="navigation.jsp"></jsp:include></div>
		<div class="row">
			<div class="col-md-3"><jsp:include page="bodyleft.jsp"></jsp:include></div>
			<div class="col-md-9"><jsp:include page="bodyright.jsp"></jsp:include></div>
		</div>
		<div class="row"></div>
	</div>
</body>
</html>
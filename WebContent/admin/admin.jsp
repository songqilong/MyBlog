<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${sessionScope.basePath }/plugin/bootstrap.min.css">
<script type="text/javascript" src="${sessionScope.basePath }/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath }/plugin/pagejs/admin-page.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理界面</title>
</head>
<body>
<div class="container">
<!-- top start -->
<div class="row">
	<jsp:include page="view/top.jsp"></jsp:include>
</div>
<!-- top end -->
<!-- body start -->
<div class="row">
	<!-- body left start -->
	<div class="col-md-4">
		<jsp:include page="view/bodyleft.jsp"></jsp:include>
	</div>
	<!-- body left end -->
	
	<!-- body right start -->
	<div class="col-md-8">
		<jsp:include page="view/bodyright.jsp"></jsp:include>
	</div>
	<!-- body right end -->
</div>
<!-- body end -->
</div>
<div id="load-modal"></div>
</body>

</html>
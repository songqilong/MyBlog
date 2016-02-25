<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
 <legend>文章分类管理</legend>
	<div>
		<table id="categoryTable" class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>类别名</th>
					<th>创建日期</th>
					<th>删除</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
			<!--  
				<tr>
					<td>Mark</td>
					<td>Otto</td>
					<td><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="删除"></span></td>
					<td><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="top" title="编辑"></span></td>
				</tr>
				-->
			</tbody>
		</table>
	</div>
	
	<div>
	<div class="col-md-4">
	第
	<select id="totalPage">
		<!--<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>  -->
	</select>
	页
	&nbsp;&nbsp;&nbsp;一共<span></span>页
	</div>
	<button class="btn btn-primary pull-right col-md-2">新增</button></div>
</body>
</html>
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
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>类别名</th>
					<th>创建日期</th>
					<th>删除</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Mark</td>
					<td>Otto</td>
					<td><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="删除"></span></td>
					<td><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="top" title="编辑"></span></td>
				</tr>
				<tr>
					<td>Jacob</td>
					<td>Thornton</td>
					<td><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="删除"></span></td>
					<td><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="top" title="编辑"></span></td>
				</tr>
				<tr>
					<td>Larry</td>
					<td>the Bird</td>
					<td><span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-placement="top" title="删除"></span></td>
					<td><span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-placement="top" title="编辑"></span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div><button class="btn btn-primary pull-right">新增</button></div>
</body>
</html>
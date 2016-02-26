<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>


<!-- 添加文章分类模态框start -->
<div class="modal fade" id="modal-deletecategory">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">删除提示</h4>
      </div>
      <div class="modal-body">
      	<h3>确定删除吗！</h3>
		<h3>删除该分类的同时，将会删除该分类下的所有文章！</h3>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button id="category-delete" type="button" class="btn btn-primary">删除</button>
      </div>
    </div>
  </div>
</div>
<!-- 删除文章分类模态框 end -->

<!-- 编辑章分类模态框start -->
<div class="modal fade" id="modal-editcategory">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">编辑文章分类</h4>
      </div>
      <div class="modal-body">
		<div class="form-group" style="margin-bottom: 40px;">
			<label class="col-sm-3 control-label">新分类名称</label>
			<div class="col-sm-9">
      			<input type="text" class="form-control" id="newcategory">
    		</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button id="category-edit" type="button" class="btn btn-primary">修改</button>
      </div>
    </div>
  </div>
</div>
<!-- 编辑文章分类模态框 end -->

<!-- 新增文章分类模态框start -->
<div class="modal fade" id="modal-addcategory">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">新增文章分类</h4>
      </div>
      <div class="modal-body">
		<div class="form-group" style="margin-bottom: 40px;">
			<label class="col-sm-3 control-label">分类名称</label>
			<div class="col-sm-9">
      			<input type="text" class="form-control" id="input_addcategory">
    		</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button id="btn-addcategory" type="button" class="btn btn-primary">添加</button>
      </div>
    </div>
  </div>
</div>
<!-- 新增文章分类模态框 end -->

<!-- 删除公告模态框start -->
<div class="modal fade" id="modal-deletenotice">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">删除提示</h4>
      </div>
      <div class="modal-body">
      	<h3>确定删除该公告吗！</h3>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button id="mbtn-deletenotice" type="button" class="btn btn-primary">删除</button>
      </div>
    </div>
  </div>
</div>
<!-- 删除公告模态框 end -->

<!-- 编辑公告模态框start -->
	<div class="modal fade" id="modal-editnotice">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">编辑公告</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label>公告题目</label> <input type="text" class="form-control" id="input_noticetitle">
					</div>
					<div class="form-group">
						<label>公告内容</label>
						<textarea id="textarea_noticecontent" class="form-control" rows="5"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button id="mbtn-editnotice" type="button" class="btn btn-primary">修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 编辑公告模态框 end -->
</body>
</html>
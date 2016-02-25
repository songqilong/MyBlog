<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<!-- 添加文章分类模态框start -->
<div class="modal fade" id="modal-addcategory">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加文章类别</h4>
      </div>
      <div class="modal-body">
        <form action="" class="form-horizontal" method="post">
        	<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    			<div class="col-sm-10">
      				<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
    			</div>
			</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- 添加文章分类模态框 end -->
</body>
</html>
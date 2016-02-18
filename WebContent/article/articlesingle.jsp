<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${sessionScope.basePath}/plugin/bootstrap.min.css">
<script type="text/javascript" src="${sessionScope.basePath}/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${sessionScope.basePath}/plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="article.title"/></title>
</head>
<body>
<div class="container">
	<div class="row"><jsp:include page="../view/navigation.jsp"></jsp:include></div>
	<div class="row">
	<article class="article">
        <header>
          <h1 class="text-center"><s:property value="article.title"/></h1>
          <dl class="dl-inline">
            <dt>作者：</dt>
            <dd><s:property value="article.author"/></dd>
            <dt></dt>
            <dd class="pull-right"><span class="label label-success">NEW</span> <span class="label label-warning">火爆</span> <span class="label label-info">原创</span> <span class="label label-danger"><i class="icon-eye-open"></i> 235</span></dd>
          </dl>
        </header>
        <section class="article-content">
          <s:property value="article.content" escape="false"/>
        </section>
        <footer>
          <p class="pull-right text-muted">
            发布时间：<s:property value="article.ctime"/> &nbsp;点击数：<s:property value="article.clicktime"/>
          </p>
          <p class="text-important">本文版权所有归<a href="###">@catouse</a></p>
        </footer>
      </article>
    </div>
    
    <div class="row">
     <div class="comments">
        <header>
          <h3><i class="icon-comments icon-border-circle"></i> <s:property value="#CommentQty"/> 条评论</h3>
          <div class="alert alert-info text-center">
            <s:property value="#lastCommentQty"/> 条新的评论
          </div>
        </header>
        <section class="comments-list">
 		<!-- 遍历评论 -->       
        <s:iterator value="#comments" id="comment" status="st">
        	<!-- 如果回复对象为空 -->
        	<s:if test="#comment.replyto==null">
        		<div class="comment">
            		<a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            		<div class="content">
              		<div class="pull-right"><span class="text-muted"><s:property value="#comment.ctime"/></span></div>
              		<!-- 文章作者 -->
              		<a href="#" class="author"><strong><s:property value="#comment.author"/></strong></a>
              		<div class="text">
              			<!-- 文章内容 -->
                		<s:property value="#comment.content"/>
              		</div>
              	<div class="actions">
                <a href="##">回复</a>
                <a href="##">编辑</a>
                <a href="##">删除</a>
              </div>
            </div>
          </div>
        </s:if>
        <!-- 如果回复对象不为空 -->
        <s:else>
        	<div class="comment">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="content">
              <div class="pull-right"><span class="text-muted"><s:property value="#comment.ctime"/></span></div>
              <span class="author">
                <a href="#"><strong>Catouse</strong></a>
                <span class="text-muted">回复 </span>
                <a href="#">Zhang Li</a>
              </span>

              <div class="text">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus, illo eaque a iure in quidem officiis numquam ducimus odio non. Architecto, repellendus optio maxime quae sed molestiae ipsa animi tenetur!
              </div>
              <div class="actions">
                <a href="##">回复</a>
                <a href="##">编辑</a>
                <a href="##">删除</a>
              </div>
            </div>
          </div>
        </s:else>

        </s:iterator>
                
        </section>
        <footer>
        <br>
          <!-- 发表评论 -->
          <div class="reply-form" id="commentReplyForm">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="form">
              <form id="form"role="form" action="" method="post">
               <div class="input-group  col-md-3">
                	<span class="input-group-addon">评论人</span>
                	<input type="text" id="author" class="form-control" name="comment.author" placeholder="评论人">
                </div>
                <br>
                <div class="form-group">
                  <textarea id="comment" class="form-control new-comment-text" rows="6"  name="comment.content" placeholder="评论一下吧"></textarea>
                </div>
                <div class="pull-right"><input type="submit" class="btn btn-info" value="发表评论"> </div>
              </form>
            </div>
          </div>
        </footer>
      </div>
    </div>
</div>
<!-- 该JQuery 用于提交评论 -->
<script type="text/javascript">
//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) {
    	return unescape(r[2]);
    	}
    return null; //返回参数值
    }

var aid= getUrlParam("aid"); // 获取文章ID
$(document).ready(function(){
	$("#form").submit(function(e){
 		// 阻止提交按钮的默认 action
		e.preventDefault();
		alert("AAAAAAAA");	
		var $author = $('#author');
		var $comment = $('#comment');
		if(author != null && comment != null){
			$.post(
			"/article/comment_commit",
			{aid:aid,author:$author.text(),comment:$comment.text()},
			function(data,status){
				// 如果提交评论成功
				if("addSuccess"==data){
					Date date = new Date();
					var ctime = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
					$(".comments-list").append("<div class=\"comment\"><a href=\"###\" class=\"avatar\"><i class=\"icon-user icon-border icon-2x icon-muted\"></i></a><div class=\"content\"><div class=\"pull-right\"><span class=\"text-muted\">"+ctime+"</span></div><!-- 文章作者 --><a href=\"#\" class=\"author\">"+$author.text()+"</strong></a><div class=\"text\"><!-- 文章内容 -->"+$comment.text()+"</div><div class=\"actions\"><a href=\"##\">回复</a><a href=\"##\">编辑</a><a href=\"##\">删除</a></div></div></div>");
					$author.text("");
					$comment.text("");
				}else{
					$author.text("");
					$comment.text("");
				}
			}
			);
		}
	});
});

</script>
</body>
</html>
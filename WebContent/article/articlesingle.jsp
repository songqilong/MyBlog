<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <section class="abstract">
            <p><strong>摘要：</strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Natus, necessitatibus provident quasi suscipit laborum nemo tenetur ad accusantium explicabo pariatur?</p>
          </section>
        </header>
        <section class="article-content">
          <s:property value="article.content" escape="false"/>
        </section>
        <footer>
          <p class="pull-right text-muted">
            发布时间：<s:property value="article.ctime"/> &nbsp;点击数：234
          </p>
          <p class="text-important">本文版权所有归<a href="###">@catouse</a></p>
          <ul class="pager pager-justify">
            <li class="previous"><a href="#"><i class="icon-arrow-left"></i> 论烧火煮饭</a></li>
            <li><a href="#"><i class="icon-list-ul"></i> 目录</a></li>
            <li class="next disabled"><a href="#">没有下一篇 <i class="icon-arrow-right"></i></a></li>
          </ul>
        </footer>
      </article>
    </div>
    
    <div class="row">
     <div class="comments">
        <header>
          <div class="pull-right"><a href="#commentReplyForm" class="btn btn-info"><i class="icon-comment-alt"></i> 发表评论</a></div>
          <h3><i class="icon-comments icon-border-circle"></i> 26 条评论</h3>
          <div class="alert alert-info text-center">
            <a href="alert-link">3 条新的评论</a>
          </div>
        </header>
        <section class="comments-list">
          <div class="comment">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="content">
              <div class="pull-right"><span class="text-muted" title="2013-11-08 15:52:32">2 hours ago</span> &nbsp;<strong>#5</strong></div>
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
          <div class="comment">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="content">
              <div class="pull-right"><span class="text-muted">2 hours ago</span> &nbsp;<strong>#4</strong></div>
              <a href="#" class="author"><strong>Catouse</strong></a>
              <div class="text">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus, illo eaque a iure in quidem officiis numquam ducimus odio non. Architecto, repellendus optio maxime quae sed molestiae ipsa animi tenetur!
              </div>
              <div class="actions">
                <a href="##">reply</a>
                <a href="##">edit</a>
                <a href="##">delete</a>
              </div>
            </div>
          </div>
          <div class="comment">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="content">
              <div class="pull-right"><span class="text-muted">4 hours ago</span> &nbsp;<strong>#3</strong></div>
              <a href="#" class="author"><strong>Catouse</strong></a>
              <div class="text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, iusto at voluptatem quis aspernatur voluptas harum odit corporis consequatur dicta? Eos, unde, doloremque ab voluptatibus mollitia quam quas itaque quod repellendus sed optio cum blanditiis architecto excepturi quidem sint eaque.</div>
              <div class="actions">
                <a href="##">reply</a>
                <a href="##">edit</a>
                <a href="##">delete</a>
              </div>
            </div>
          </div>
          <div class="comment">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="content">
              <div class="pull-right"><span class="text-muted">1 days ago</span> &nbsp;<strong>#2</strong></div>
              <a href="#" class="author"><strong>Catouse</strong></a>
              <div class="text">Excepturi voluptates ea esse voluptas ad voluptate voluptatibus laboriosam velit. Totam, fuga, laboriosam, optio, qui id voluptates nam fugit quibusdam labore alias atque laudantium repudiandae veniam delectus architecto libero ducimus consequatur hic sunt ipsa. Labore, eligendi sapiente dolores quibusdam ipsum.</div>
              <div class="actions">
                <a href="##">reply</a>
                <a href="##">edit</a>
                <a href="##">delete</a>
              </div>
            </div>
          </div>
          <div class="comment">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="content">
              <div class="pull-right"><span class="text-muted">2 months ago</span> &nbsp;<strong>#1</strong></div>
              <a href="#" class="author"><strong>Catouse</strong></a>
              <div class="text">Assumenda, accusamus, inventore, ut, ea laboriosam quae sunt maxime labore quisquam quod nesciunt saepe quis. Debitis, fuga, ad, aut eaque vero vitae suscipit obcaecati nemo eligendi numquam id labore voluptas veniam sequi perspiciatis facilis voluptates dolorem minus quibusdam unde molestias.</div>
              <div class="actions">
                <a href="##">reply</a>
                <a href="##">edit</a>
                <a href="##">delete</a>
              </div>
            </div>
          </div>
        </section>
        <footer>
          <div class="reply-form" id="commentReplyForm">
            <a href="###" class="avatar"><i class="icon-user icon-border icon-2x icon-muted"></i></a>
            <div class="form">
              <form role="form">
                <div class="form-group">
                  <textarea class="form-control new-comment-text" rows="2" placeholder="write a comment..."></textarea>
                </div>
                <div class="form-group comment-user" style="display:none">
                  <div class="row">
                    <div class="col-md-3">
                      <span class="pull-right">或者</span>
                      <a href="#">登录</a> &nbsp;<a href="##">注册</a>
                    </div>
                    <div class="col-md-7">
                      <div class="form-group">
                        <input type="text" class="form-control" id="nameInputEmail1" placeholder="Enter your name">
                      </div>
                      <div class="form-group">
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                      </div>
                    </div>
                    <div class="col-md-2"><button type="submit" class="btn btn-block btn-primary"><i class="icon-ok"></i></button></div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </footer>
      </div>
    </div>
</div>
</body>
</html>
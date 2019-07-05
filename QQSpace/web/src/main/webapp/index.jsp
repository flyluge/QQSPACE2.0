<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入 Bootstrap -->
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/top_nav.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" />
<!---->
<script type="text/javascript">
	$(function() {
		$("#head").load("container/head.html");
	})
</script>
</head>
<body style="background: #F9F9F9;">
	<div id="head"></div>
	<div class="container content">
		<div class="row">
			<div class="col-md-2" style="padding: 0;">
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">14</span> 好友动态
					</li>
					<li class="list-group-item"><span class="badge">14</span> 我的相册
					</li>
					<li class="list-group-item"><span class="badge">14</span> 好友请求
					</li>
				</ul>
			</div>
			<div class="col-md-8 article_container">
				<div class="col-md-12 publish-article">
					<div class="input-group">
						<textarea id="article_content_pub" class="form-control"
							placeholder="写下此刻的想法" aria-describedby="basic-addon2"></textarea>
						<span class="btn input-group-addon" id="basic-addon2"> 添加图片
						</span> <span class="btn btn-primary input-group-addon" id="basic-addon2"
							onclick="publish_article()">发表</span>
					</div>
				</div>
				<c:forEach items="${articles.page }" var="article">
					<div class="col-md-12 article-wrap">
						<div class="article-content">
							<div class="article-heading">
								<img class="img-circle user-headimg article-user-img"
									src="${article.user.userimg }"> <span
									class="article-user-name">${article.user.username }</span>
							</div>
							<div class="article-body">
								<p>${article.content }</p>
								<!--说说图片列表-->
							</div>
							<div class="text-right">
								<span class="article-publish-time">${article.pubdate }</span> <a
									href="#" class=" text-danger"><span
									class="glyphicon glyphicon-heart"></span>15</a>
							</div>
						</div>
						<c:if test="${not empty comments[article.aid].page}">
							<div class="article-comment">
								<c:forEach items="${comments[article.aid].page}" var="comment">
									<ul class="media-list comment">
										<li class="media">
											<div class="media-left">
												<a href="#"> <img class="media-object article-user-img"
													src="${comment.user.userimg }" alt="...">
												</a>
											</div>
											<div class="media-body">
												<h5 class="media-heading">${comment.user.username }<span
														class="article-comment-time">${comment.pubdate }</span><a
														href="#"><span class="glyphicon glyphicon-comment"></span></a>
												</h5>
												<p>${comment.content }</p>
											</div>
										</li>
									</ul>
									<c:if test="${not empty recomments[comment.cid].page}">
										<c:forEach items="${recomments[comment.cid].page}" var="comment">
											123
										</c:forEach>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
						<div class="publish-article-comment">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="写下你的想法"
									aria-describedby="basic-addon2"> <span
									class="input-group-addon" id="basic-addon2">评论</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class=" col-md-2" style="padding: 0;">
				<div class="panel panel-default left-panel">
					<div class="panel-heading">
						<h3 class="panel-title text-center">
							<span class="user-name"></span>的空间
						</h3>
					</div>
					<div class="panel-body text-center">
						<img class="user-touxiang-img" src="" class="img-responsive" /> <span
							class="user-name"></span>
					</div>
				</div>
				<div class="panel panel-default left-panel">
					<div class="panel-heading">
						<h3 class="panel-title">广告位招租</h3>
					</div>
					<div class="panel-body">联系电话:110</div>
				</div>
				<div class="panel panel-default left-panel">
					<div class="panel-heading">
						<h3 class="panel-title">广告位招租</h3>
					</div>
					<div class="panel-body">联系电话:110</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <script src="js/top_nav.js"></script> -->
</body>
</html>

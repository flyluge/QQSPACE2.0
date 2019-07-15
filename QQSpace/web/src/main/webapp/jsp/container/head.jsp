<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 引入 Bootstrap -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
		<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/css/top_nav.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath }/css/head.css" rel="stylesheet" />
	</head>
	<body  style="background: #e9e9e9;">
		<!--头-->
		<div class="container-fluid top-fix-bar">
			<div class="row" style="background: #000000;">
				<div class="top-fix-wrap container">
					<div class="row">
						<div class="top-logo"><img src="${pageContext.request.contextPath }/img/logo.png"></div>
						<%-- <ul class="top-nav">
							<li id="top-index"><a href="${pageContext.request.contextPath }/index_index">个人中心</a></li>
							<li id="top-main">
								我的主页
							</li>
							<li id="top-friends">
								好友
							</li>
						</ul> --%>
						<div class="top-user-info">
							<div class="top-right-el top-user-name">
							<c:if test="${sessionScope.user==null }">
								<div class="top-right-el"><a href="${pageContext.request.contextPath }/UserAction_loginFrame">您好,请登录</a></div>
							</c:if>
							<c:if test="${sessionScope.user!=null }">
								<div class="top-right-el user-name">欢迎!${sessionScope.user.username }</div>
								<div class="top-right-el"><a href="${pageContext.request.contextPath }/UserAction_logout">注销</a></div>
							</c:if>
							</div>
							<div class="top-right-el top-space-setting">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="every_head">
			<div class="container">
				<div class="row" style="height: 300px;">
					<div class="col-md-12">
						<div class="col-md-12" style="height: 50px;"></div>					
						<div class="col-md-12">
							<span class="text-primary" style="height: 38px;line-height: 38px;font-size: 28px;margin-right: 10px;display: inline-block;vertical-align: middle;">
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="user-name">${sessionScope.user.username }</span>的空间
							</span>
						</div>					
						<div class="col-md-12" style="height: 50px;"></div>					
						<div class="col-md-12">
							<div class="col-md-2">
								<img class="user-touxiang-img" id="every_head_touxiang" src="${pageContext.request.contextPath }/${sessionScope.user.userimg}" class="img-rounded"/>
							</div>
							<div class="col-md-8">
								<div class="col-md-12">
									<h3 class="text-primary user-name"></h3>
								</div>
								<div class="col-md-12">
									<h4>随风而动,随刃而行</h4>	
								</div>
								<div style="width:100%;">
									<ul id="head_daohang">
										<li></li>
										<li><a href="${pageContext.request.contextPath }/index_index">主页</a></li>
										<li><a href="${pageContext.request.contextPath }/daily_show">日志</a></li>
										<li><a href="${pageContext.request.contextPath }/AlbumAction_showAlbum">相册</a></li>
										<li><a href="${pageContext.request.contextPath }/Messageboard_showMessageboard">留言板</a></li>
										<li><a href="${pageContext.request.contextPath }/article_showtarticle">说说</a></li>
										<li><a href="${pageContext.request.contextPath }/UserAction_showinfo">个人档</a></li>
										<li><a href="${pageContext.request.contextPath }/index.html">音乐</a></li>
										<li><a href="${pageContext.request.contextPath }/index.html">更多</a></li>
										<li></li>
									</ul>
								</div>
							</div>
							<div class="col-md-2">
								天气 晴
							</div>
						</div>					
					</div>				
				</div>
			</div>
		</div>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/head.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/top_nav.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
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
			<div class="row" style="height: 260px;">
				<div class="col-md-12">
					<div class="col-md-12" style="height: 50px;"></div>					
					<div class="col-md-12">
						<div class="col-md-2">
							<img class="user-touxiang-img" id="every_head_touxiang" src="${pageContext.request.contextPath }/${selfuser.userimg}" class="img-rounded"/>
						</div>
						<div class="col-md-8">
							<div class="col-md-12">
								<h3 class="text-primary user-name"></h3>
							</div>
						</div>
						<div class="col-md-2">
							天气 晴
						</div>
					</div>		
					<div class="col-md-12" style="height: 30px;"></div>				
					<div class="col-md-12">
						<span class="text-primary" style="height: 38px;line-height: 38px;font-size: 28px;margin-right: 10px;display: inline-block;vertical-align: middle;">
							<span class="user-name">${selfuser.username }</span>的空间
						</span>
						<span style="float:right">
							<a href="${pageContext.request.contextPath }/index_index">返回我的主页</a>
						</span>
					</div>					
				</div>				
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>个人档</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
		<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/css/info.css" rel="stylesheet" />
	</head>
	<body style="background: #F9F9F9;">
		<jsp:include page="container/head.jsp"></jsp:include>
		<div class="container">
			<div class="row" style="background: white;height:650px;">
				<div style="margin-bottom: 10px; border-bottom: 1px solid goldenrod;">
					<div style="padding-left: 26px;">
						<h3>个人档</h3>
					</div>
				</div>
				<form action="UserAction_saveAlter" method="post"  enctype="multipart/form-data">
					<div class="col-md-12">
						<div class="col-md-2" style="padding: 0px;">
							<div>
								<img style="width:180px;" src="${pageContext.request.contextPath }/${sessionScope.user.userimg }" class="img-responsive img-rounded">
							</div>
							<div class="text-center" style="padding: 8px;">
								<div>修改头像</div>
								<input type="file" name="file">
								<button class="btn btn-primary">确认</button>
							</div>
							<div class="col-md-12 text-center">
								<div class="col-md-6"><a href="#">说说<span>10</span></a></div>
								<div class="col-md-6"><a href="#">相册<span>2</span></a></div>
							</div>
						</div>
						<div class="col-md-10" style="border-left: 1px solid goldenrod;">
							<div>
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a href="#info" aria-controls="info" role="tab" data-toggle="tab">基本资料</a></li>
									<li role="presentation"><a href="#alert" aria-controls="alert" role="tab" data-toggle="tab">编辑资料</a></li>
								</ul>
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="info">
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">邮箱/账号</div>
											<div class="col-md-10 class-value">${sessionScope.user.useremail}</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">昵称</div>
											<div class="col-md-10 class-value">${sessionScope.user.username}</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">性别</div>
											<div class="col-md-10 class-value">
												<c:if test="${sessionScope.user.sex==1 }">
													男
												</c:if>
												<c:if test="${sessionScope.user.sex==0 }">
													女
												</c:if>
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">手机号</div>
											<div class="col-md-10 class-value">
												${sessionScope.user.userphone }
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">生日</div>
											<div class="col-md-10 class-value">
												${sessionScope.user.birthday }
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">星座</div>
											<div class="col-md-10 class-value">
												${sessionScope.user.astro }
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">职业</div>
											<div class="col-md-10 class-value">
												${sessionScope.user.career}
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">家乡</div>
											<div class="col-md-10 class-value">
												${sessionScope.user.hometown}
											</div>
										</div>
									</div>
									<div role="tabpanel" class="tab-pane" id="alert">
										<input type="hidden" name="user.uid" value="${sessionScope.user.uid}">
										<input type="hidden" name="user.userimg" value="${sessionScope.user.userimg}">
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">邮箱</div>
											<div class="col-md-10 class-value">
												<input type="text" name="user.useremail" readonly="readonly" value="${sessionScope.user.useremail}"/>
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">昵称</div>
											<div class="col-md-10 class-value">
												<input type="text" name="user.username" value="${sessionScope.user.username}" />
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">性别</div>
											<div class="col-md-10 class-value">
												<c:if test="${sessionScope.user.sex==1}">
													男<input type="radio" name="user.sex" value="1" checked="checked"/>
													女<input type="radio" name="user.sex" value="0" />
												</c:if>
												<c:if test="${sessionScope.user.sex==0}">
													男<input type="radio" name="user.sex" value="1"/>
													女<input type="radio" name="user.sex" value="0" checked="checked"/>
												</c:if>
												<c:if test="${sessionScope.user.sex==null}">
													男<input type="radio" name="user.sex" value="1"/>
													女<input type="radio" name="user.sex" value="0" checked="checked"/>
												</c:if>
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">手机号</div>
											<div class="col-md-10 class-value">
												<input type="text" name="user.userphone" value="${sessionScope.user.userphone }"/>
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">地址</div>
											<div class="col-md-10 class-value">
												<input type="text" name="user.hometown" value="${sessionScope.user.hometown }"/>
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">生日</div>
											<div class="col-md-10 class-value">
												<input type="text" name="user.birthday" value="${sessionScope.user.birthday }"/>
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">星座</div>
											<div class="col-md-10 class-value">
												<input type="text" name="user.astro" value="${sessionScope.user.astro }" />
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<div class="col-md-2 class-name">职业</div>
											<div class="col-md-10 class-value">
												<input type="text" name="user.career" value="${sessionScope.user.career }"/>
											</div>
										</div>
										<div class="col-md-12 user-info-detail">
											<button class="btn btn-default">确认修改</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
	<jsp:include page="container/footer.jsp"></jsp:include>
</html>

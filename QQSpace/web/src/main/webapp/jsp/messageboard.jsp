<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>留言板</title>
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	</head>
	<body>
		<jsp:include page="container/head.jsp"></jsp:include>
		<div class="container" style="background: white;border-radius: 5px;">
			<div style="margin-top:20px">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active">
						<a href="#home" aria-controls="home" role="tab" data-toggle="tab">
							<span class="text-primary">留言板</span>
						</a>
					</li>
				</ul>
				<div class="row" style="padding:20px;">
					<c:if test="${page.page[0]==null }">
						<h4>您的好友未给您留言</h4>
					</c:if>
					<c:forEach var="mess" items="${page.page }" varStatus="status">
						<!--这是一个评论模块-->
						<div class="col-md-12" style="margin-top:20px ;">
							<ul class="media-list">
								<li class="media">
									<div class="media-left">
										<a href="#">
											<img class="media-object" src="${mess.wuser.userimg }" alt="图片加载失败" width="80px">
										</a>
									</div>
									<div class="media-body">
										<h4 class="media-heading">${mess.content } <small>一楼</small></h4>
										<div style="border:dotted gainsboro 1px;border-radius: 5px;padding:20px;">
											<p>${mess.content }</p>
										</div>
										<div class="text-right">
											<fmt:formatDate value="${mess.pubdate}" pattern="yyyy/MM/dd  HH:mm:ss" />
											<a role="button" data-toggle="collapse" href="#${status.index }">回复</a>
											<a href="Messageboard_deleteMessBd?mbid=${mess.mbid }">删除</a>
										</div>
										<!--回复评论-->
										<div id="remess_${status.index }">
										</div>
										<!--回复评论结束-->
										<c:forEach var="mmp" items="${page.map[mess.mbid] }">
											<div class="col-md-12">
												<ul class="media-list" style="margin-top:10px ;">
													<li class="media">
														<div class="media-left">
															<a href="#">
																<img class="media-object" src="${mmp.user.userimg }" alt="图片加载失败" width="50px">
															</a>
														</div>
														<div class="media-body">
															<h4 class="media-heading">
																${mmp.user.username }
																<small><fmt:formatDate value="${mmp.pubdate}" pattern="yyyy/MM/dd  HH:mm:ss" />
																<a href="ReMessageboardAction_deleteReMess?rmid=${mmp.rmid }">删除</a>
																</small>
															</h4>
															<div style="border:dotted gainsboro 1px;border-radius: 5px;padding:20px;">
																<p>${mmp.content }</p>
															</div>
														</div>
													</li>
												</ul>
											</div>
										</c:forEach>
										<div class="col-md-12">
											<form class="form-inline" action="ReMessageboardAction_addReMess" method="post">
												<div class="collapse" id="${status.index }" style="width: 100%;">
													<div>写下你的回复吧</div>
													<input type="hidden" name="user.uid" value="${mess.tuid }">
													<input type="hidden" name="mbid" value="${mess.mbid }">
													<textarea class="form-control messageboard_text"rows="2" style="width: 100%;" name="content"></textarea>
													<div>
														<input type="submit" class="btn btn-primary" value="发送" >
														<input type="reset" class="btn btn-primary messageboard_reset" value="取消"/>
													</div>
												</div>
											</form>
										</div>
									</div>
	
								</li>
							</ul>
								
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
	<jsp:include page="container/footer.jsp"></jsp:include>
</html>
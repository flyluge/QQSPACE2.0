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
	<script type="text/javascript">
		$(function(){
			$("#addMessageboard_btn").click(function(){
				let jsonString= $("#addMessageboard").serialize();
				$.ajax({
					url:"Messageboard_AddMessageBoard",
					type:"post",
					dataType:"json",
					data:jsonString,
					success:function(data){
						window.location.href="Messageboard_showFMessageboard?tuid=${selfuser.uid }";
					}
				})
			})
		})
		
	</script>
	<body>
		<jsp:include page="container/fhead.jsp"></jsp:include>
		<div class="container" style="background: white;border-radius: 5px;">
			<div style="margin-top:20px">
				<div class="row" style="padding:20px;">
					<div class="col-md-2">
						<ul class="list-group">
							<li class="list-group-item">
								<span><a href="article_showfarticle?uid=${selfuser.uid }">他的说说</a></span>
								<span class="badge" id="fartcle_myfriend">
								</span> 
							</li>
							<li class="list-group-item">
								<span><a href="Messageboard_showFMessageboard?tuid=${selfuser.uid }">他的留言板</a></span>
							</li>
							<li class="list-group-item">
								<span><a href="AlbumAction_friendAlbum?uid=${selfuser.uid }&currpage=1&pagesize=6">他的相册</a></span>
							</li>
						</ul>
					</div>
					<div class="col-md-8">
						<div style="border:solid lightgray 1px;border-radius:10px;padding:10px">
						<form id="addMessageboard">
							<input type="hidden" name="tuid" value="${selfuser.uid }">
							<input type="hidden" name="wuid" value="${sessionScope.user.uid }">
							<span class="text-primary">给他留言:</span>
							<div class="col-md-12">
								<textarea style="width:100%;height:80px" name="content" placeholder="快来留言吧"></textarea>
							</div>
							<div class="text-right">
								<input type="button" id="addMessageboard_btn" class="btn btn-primary" value="发布"/>
							</div>
						</form>
						</div>
						<c:if test="${page.page[0]==null }">
							<h4>他还未收到留言</h4>
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
							<c:if test="${page.page[0]!=null }">
								<div class="text-right col-md-12">
									总共${page.totalcount }条记录/每页显示${page.pageSize }条<br>
									当前页${page.currpage }/总共${page.totalpage }页<br>
									<c:if test="${page.currpage<page.totalpage }">
										<a href="AlbumAction_friendAlbum?uid=${selfuser.uid }&currpage=${page.currpage+1}&pagesize=6">下一页</a>
									</c:if>
									<c:if test="${page.currpage>=2}">
										<a href="AlbumAction_friendAlbum?uid=${selfuser.uid }&currpage=${page.currpage-1}&pagesize=6">上一页</a>
									</c:if>
								</div>
							</c:if>
						</div>
						<div class="col-md-2" style="padding: 0;">
							<div class="panel panel-default left-panel">
								<div class="panel-heading">
									<h3 class="panel-title text-center">
										<span class="user-name">${selfuser.username }</span>的空间
									</h3>
								</div>
								<div class="panel-body text-center">
									<img class="user-touxiang-img"
										style="width:160px"
										src="${pageContext.request.contextPath }/${selfuser.userimg}"
										class="img-responsive" /> <span class="user-name">${selfuser.username }</span>
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
				</div>
	</body>
	<jsp:include page="container/footer.jsp"></jsp:include>
</html>
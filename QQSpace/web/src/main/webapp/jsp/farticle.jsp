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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet" />
<script type="text/javascript">
	/*评论模块  */
	function publish_comment(aid, uid, id){
		id="#"+id;
		var val1=$("#publish-comment_"+aid).val();
		$.ajax({
			url:"CommentAction_addComment",
			type:"post",
			dataType:"json",
			data:{
				"comment.user.uid": uid,
				"comment.aid": aid,
				"comment.content":val1
			},
			success:function(data){
				// alert(JSON.stringify(data));
				if(data.message){
					$(id).append(`
						<ul class="media-list comment"> 
							<li class="media">
								<div class="media-left">
									<a href="#"> <img class="media-object article-user-img"
										src="${pageContext.request.contextPath }/${sessionScope.user.userimg }" alt="图片加载失败">
									</a>
								</div>
								<div class="media-body">
									<h5 class="media-heading">${selfuser.username }<span
											class="article-comment-time">刚刚</span><a
											href="#"><span class="glyphicon glyphicon-comment"></span></a>
									</h5>
									<p>`+$("#publish-comment_"+aid).val()+`</p>
								</div>
							</li>
						</ul>`);
				} else {
					alert(data.data);
				}
			}
		})
	}
	/*取消点赞模块  */
	function cancel(uid,aid){
		$.ajax({
			url:"praise_cancel",
			type:"post",
			data:{
				"aid": aid,
				"uid": uid
			},
			dataType: "json",
			success:function(data){
			}
		})
	}
	/*点赞模块*/
	function praise(uid, aid,id){
		id="#"+id;
		let count=$(id).html();
		$.ajax({
			url:"praise_praise",
			type:"post",
			data:{
				"aid": aid,
				"uid": uid
			},
			dataType: "json",
			success:function(data){
				if(data.message){
					count++;
					$(id).html(count);
					$(id).after(`<span>已赞</span>`);
				}
				else{
					count--;
					$(id).html(count);
					$(id).next().remove();
					cancel(uid,aid);
				}
			}
		})
	}
	$(function(){
		/*获取说说数量  */
		$.ajax({
			url:"article_getCount",
			type:"post",
			data:{
				"uid": ${selfuser.uid}
			},
			dataType: "json",
			success:function(data){
				if(data.message){
					$("#fartcle_myfriend").html(data.data);
				}
			}
		})
	})
</script>
</head>
<body style="background: #F9F9F9;">
	<jsp:include page="container/fhead.jsp"></jsp:include>
	<div class="container content">
		<div class="row">
			<div class="col-md-2" style="padding: 0;">
				<ul class="list-group">
					<li class="list-group-item">
						<span>他的说说</span>
						<span class="badge" id="fartcle_myfriend">
						</span> 
					</li>
					<li class="list-group-item">
						<span><a href="Messageboard_showFMessageboard.action?tuid=${selfuser.uid }">他的留言板</a></span>
					</li>
					<li class="list-group-item">
						<span><a href="AlbumAction_friendAlbum?uid=${selfuser.uid }&currpage=1&pagesize=6">他的相册</a></span>
					</li>
				</ul>
			</div>
			<div class="col-md-8 article_container" style="background:white">
				<div style="padding:5px;">
					<h4><span class="text-primary">说说</span></h4>
					<hr>
				</div>
				<c:forEach items="${selfarticle.page }" var="article">
					<div class="col-md-12 article-wrap">
						<div class="article-content">
							<div class="article-heading">
								<img class="img-circle user-headimg article-user-img"
									src="${pageContext.request.contextPath }/${article.user.userimg }"> <span
									class="article-user-name">${article.user.username }</span>
							</div>
							<div class="article-body">
								<p>${article.content }</p>
								<!--说说图片列表-->
							</div>
							<div class="text-right">
								<!--点赞区域  -->
								<span class="article-publish-time">${article.pubdate }</span> 
								<a href="javascript:;" onclick="praise('${sessionScope.user.uid }','${article.aid}','${article.aid}_praise')" class=" text-danger">
									<span class="glyphicon glyphicon-heart"></span><span id="${article.aid}_praise">${praises[article.aid] }</span>
								</a>
							</div>
						</div>
						<div class="article-comment" id="${article.aid}_commnet">
							<c:forEach items="${comments[article.aid].page}" var="comment">
								<ul class="media-list comment">
									<li class="media">
										<div class="media-left">
											<a href="#"> <img class="media-object article-user-img"
												src="${pageContext.request.contextPath }/${comment.user.userimg }" alt="...">
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
							</c:forEach>
						</div>
						<div class="publish-article-comment">
							<div class="input-group">
								<input type="text" id="publish-comment_${article.aid }" class="form-control" placeholder="写下你的想法"
									aria-describedby="basic-addon2" /> <span
									class="input-group-addon" id="basic-addon2" onclick="publish_comment('${article.aid }','${sessionScope.user.uid }','${article.aid}_commnet')">评论</span>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="col-md-12 text-right">
					总共${selfarticle.totalcount }条记录/每页显示${selfarticle.pageSize }条<br>
					当前页${selfarticle.currpage }/总共${selfarticle.totalpage }页<br>
					<c:if test="${page.currpage<page.totalpage }">
						<a href="article_showfarticle?uid=${selfuser.uid }&currpage=${selfarticle.currpage+1}&pagesize=10">下一页</a>
					</c:if>
					<c:if test="${page.currpage>1&&page.totalpage!=1&&page.currpage<=page.totalpage}">
						<a href="article_showfarticle?uid=${selfuser.uid }&currpage=${selfarticle.currpage-1}&pagesize=10">上一页</a>
					</c:if>
				</div>
				
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
</body>
</html>

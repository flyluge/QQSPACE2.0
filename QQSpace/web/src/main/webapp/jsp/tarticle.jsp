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
<link href="${pageContext.request.contextPath }/css/top_nav.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet" />
<script type="text/javascript">
	var flag_showfriend=false;
	function publish_article(){
		$.ajax({
			url:"article_publish",
			type:"post",
			dataType: "json",
			data:{"article.content":$("#article_content_pub").val()},
			success:function(data){
				// alert(JSON.stringify(data));
				if(data.message){
					alert(data.data);
					window.location.href="index_index";
				} else {
					alert(data.data);
				}
			}
		})
	}
	function publish_comment(aid, uid){
		$.ajax({
			url:"CommentAction_addComment",
			type:"post",
			dataType: "json",
			data:{
				"comment.user.uid": uid,
				"comment.aid": aid,
				"comment.content":$("#publish-comment_"+aid).val()
			},
			success:function(data){
				// alert(JSON.stringify(data));
				if(data.message){
					alert(data.data);
					window.location.href="index_index";
				} else {
					alert(data.data);
					
				}
			}
		})
	}
	function del_article(aid){
		$.ajax({
			url:"article_delArticle",
			type:"post",
			data:{
				"article.aid": aid
			},
			dataType: "json",
			success:function(data){
				// alert(JSON.stringify(data));
				if(data.message){
					alert(data.data);
					window.location.href="index_index";
				} else {
					alert(data.data);
					
				}
			}
		})
	}
	function del_comment(cid){
		$.ajax({
			url:"CommentAction_deleteComment",
			type:"post",
			data:{
				"comment.cid": cid
			},
			dataType: "json",
			success:function(data){
				// alert(JSON.stringify(data));
				if(data.message){
					alert(data.data);
					window.location.href="index_index";
				} else {
					alert(data.data);
				}
			}
		})
	}
	function praise(uid, aid){
		$.ajax({
			url:"praise_praise",
			type:"post",
			data:{
				"aid": aid,
				"uid": uid
			},
			dataType: "json",
			success:function(data){
				// alert(JSON.stringify(data));
				if(data.message){
					window.location.href="index_index";
				}
			}
		})
	}
	$(function(){
		$("#collapseFriend").hide();
		flushFriends();
	})
	/*获取好友的数量和好友请求的数量  */
	function flushFriends(){
		/*获取好友数量  */
		$.ajax({
			url:"FriendAction_findFCount",
			type:"post",
			dataType: "json",
			data:{tuid:"${user.uid}"},
			success:function(data){
				if(data.message){
					$("#index_myfriend").html(data.data);
				}
			}
		})
		/*获取请求数量  */
		$.ajax({
			url:"FriendAction_findFCount",
			type:"post",
			dataType: "json",
			data:{tuid:"${user.uid}"},
			success:function(data){
				if(data.message){
					$("#index_reqfriend").html(data.data);
				}
			}
		})
	}
	function showFriends(){
		if(flag_showfriend==false){
			flag_showfriend=true;
			$("#collapseFriend").show();
			$.ajax({
				url:"FriendAction_findAllFriends",
				type:"post",
				dataType: "json",
				data:{tuid:"${sessionScope.user.uid}"},
				success:function(data){
					$.each(data.data,function(i,n){
						$("#collapseFriend").append(`<div><a>`+n.username+`</a></div>`);
					})
				}
			})
		}else if(flag_showfriend==true){
			flag_showfriend=false;
			$("#collapseFriend").html("");
			$("#collapseFriend").hide();
		}
	}
</script>
</head>
<body style="background: #F9F9F9;">
	<jsp:include page="container/head.jsp"></jsp:include>
	<div class="container content" style="background: white;border-radius: 5px;">
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active">
				<a href="#home" aria-controls="home" role="tab" data-toggle="tab">
					<span class="text-primary">我的说说</span>
				</a>
			</li>
		</ul>
		<div style="margin-top:20px;padding:20px;">
			<div class="row">
				<div class="col-md-9 article_container">
					<div class="col-md-12 publish-article">
						<div class="input-group">
							<textarea id="article_content_pub" class="form-control"
								placeholder="写下此刻的想法" aria-describedby="basic-addon2"></textarea>
							<span class="btn input-group-addon" id="basic-addon2"> 添加图片
							</span> <span class="btn btn-primary input-group-addon" id="basic-addon2"
								onclick="publish_article()">发表</span>
						</div>
					</div>
					<c:forEach items="${selfarticle.page }" var="article">
						<div class="col-md-12 article-wrap">
							<div class="article-content">
								<div class="article-heading">
									<img class="img-circle user-headimg article-user-img"
										src="${pageContext.request.contextPath }/${article.user.userimg }"> <span
										class="article-user-name">${article.user.username }</span>
										<a href="javascript:;" onclick="del_article('${article.aid}')">删除</a>
								</div>
								<div class="article-body">
									<p>${article.content }</p>
									<!--说说图片列表-->
								</div>
								<div class="text-right">
									<span class="article-publish-time">${article.pubdate }</span> <a
										href="javascript:;" onclick="praise('${sessionScope.user.uid }','${article.aid}')" class=" text-danger"><span
										class="glyphicon glyphicon-heart"></span>${praises[article.aid] }</a>
								</div>
							</div>
							<c:if test="${not empty comments[article.aid].page}">
								<div class="article-comment">
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
															<a href="javascript:;" onclick="del_comment('${comment.cid}')">删除</a>
													</h5>
													<p>${comment.content }</p>
												</div>
											</li>
										</ul>
									</c:forEach>
								</div>
							</c:if>
							<div class="publish-article-comment">
								<div class="input-group">
									<input type="text" id="publish-comment_${article.aid }" class="form-control" placeholder="写下你的想法"
										aria-describedby="basic-addon2" /> <span
										class="input-group-addon" id="basic-addon2" onclick="publish_comment('${article.aid }', '${sessionScope.user.uid }')">评论</span>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class=" col-md-3" style="padding: 0;">
					<div class="panel panel-default left-panel">
						<div class="panel-heading">
							<h3 class="panel-title text-center">
								<span class="user-name">${sessionScope.user.username }</span>的空间
							</h3>
						</div>
						<div class="panel-body text-center">
							<img class="user-touxiang-img"
								style="width:120px"
								src="${pageContext.request.contextPath }/${sessionScope.user.userimg}"
								class="img-responsive" /> <span class="user-name">${sessionScope.user.username }</span>
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

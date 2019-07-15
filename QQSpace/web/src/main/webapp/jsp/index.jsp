<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入 Bootstrap -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/top_nav.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet" />
<script type="text/javascript">
	var flag_showfriend=false;
	var flag_showfriendreq=false;
	var flag_addfriend=false;
	var flag_myreqfriend=false;
	function publish_article(){
		$.ajax({
			url:"article_publish",
			type:"post",
			dataType: "json",
			data:{"article.content":$("#article_content_pub").val()},
			success:function(data){
				if(data.message)
					window.location.href="index_index";
				else
					alert(data.data);
			}
		})
	}
	function publish_comment(aid, uid,id){
		id="#"+id;
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
					$(id).append(`
						<ul class="media-list comment" id="comment_`+data.data.cid+`"> 
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
											<a href="javascript:;" onclick="del_comment(`+data.data.cid+`,'comment_'`+data.data.cid+`)">删除</a>
									</h5>
									<p>`+$("#publish-comment_"+aid).val()+`</p>
								</div>
							</li>
						</ul>`);
					$("#comment_input").val("");
				} else {
					alert(data.data);
				}
			}
		})
	}
	function del_article(aid,id){
		id="#"+id;
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
					$(id).remove();
				} else {
					alert(data.data);
					
				}
			}
		})
	}
	function del_comment(cid,id){
		id="#"+id;
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
					$(id).remove();
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
		$("#collapseFriend").hide();
		$("#collapseFriendReq").hide();
		$("#addFrined").hide();
		$("#myreqFriend").hide();
		flushFriends();
	})
	/*获取好友的数量和好友请求的数量  */
	function flushFriends(){
		/*获取好友数量  */
		$.ajax({
			url:"FriendAction_findFCount",
			type:"post",
			dataType: "json",
			data:{tuid:"${sessionScope.user.uid}"},
			success:function(data){
				if(data.message){
					$("#index_myfriend").html(data.data);
				}
			}
		})
		/*获取请求数量  */
		$.ajax({
			url:"FriendAction_findFReqCount",
			type:"post",
			dataType: "json",
			data:{tuid:"${sessionScope.user.uid}"},
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
						$("#collapseFriend").append(`<div><a href="article_showfarticle?uid=`+n.uid+`">`+n.username+`</a></div>`);
					})
				}
			})
		}else if(flag_showfriend==true){
			flag_showfriend=false;
			$("#collapseFriend").html("");
			$("#collapseFriend").hide();
		}
	}
	function showFriendsReq(){
		if(flag_showfriendreq==false){
			flag_showfriendreq=true;
			$("#collapseFriendReq").show();
			$.ajax({
				url:"FriendAction_findReqFriend",
				type:"post",
				dataType: "json",
				data:{tuid:"${sessionScope.user.uid}"},
				success:function(data){
					$.each(data.data,function(i,n){
						$("#collapseFriendReq").append(`<div>`+n.fuser.username+`&nbsp<a href="FriendAction_agreeFriend?msg=1&uid1=${sessionScope.user.uid}&uid2=`+n.fuser.uid+`">同意</a>&nbsp<a href="FriendAction_agreeFriend?msg=0&uid1=${sessionScope.user.uid}&uid2=`+n.fuser.uid+`"" >拒绝</a></div>`);
					})
				}
			})
		}else if(flag_showfriendreq==true){
			flag_showfriendreq=false;
			$("#collapseFriendReq").html("");
			$("#collapseFriendReq").hide();
		}
	}
	function addFriends(){
		if(flag_addfriend==false){
			flag_addfriend=true;
			$("#addFrined").show();
			$.ajax({
				url:"FriendAction_findReqFriend",
				type:"post",
				dataType: "json",
				data:{tuid:"${sessionScope.user.uid}"},
				success:function(data){
					$.each(data.data,function(i,n){
					})
				}
			})
		}else if(flag_addfriend==true){
			flag_addfriend=false;
			$("#friendFrame").html("");
			$("#addFrined").hide();
		}
	}
	function searchFriend(){
		let jsonString=$("#form_addFriend").serialize();
		$("#friendFrame").html("");
		$.ajax({
			url:"UserAction_findFuzzyUser",
			type:"post",
			dataType: "json",
			data:jsonString,
			success:function(data){
				if(data.data==""){
					$("#friendFrame").html("未查询到用户");
				}
				$.each(data.data,function(i,n){
					$("#friendFrame").append(`<div>账号:`+n.useremail+`</div><div>用户名:`+n.username+`&nbsp<a href="FriendAction_addReq?uid1=${sessionScope.user.uid}&uid2=`+n.uid+`">添加</a><div>`);
				})
			}
		})
	}
</script>
</head>
<body style="background: #F9F9F9;">
	<jsp:include page="container/head.jsp"></jsp:include>
	<div class="container content">
		<div class="row">
			<div class="col-md-2" style="padding: 0;">
				<ul class="list-group">
					<li class="list-group-item">
						<span><a onclick="showFriends()">我的好友</a></span>
						<span class="badge" id="index_myfriend"></span> 
					</li>
					<!--显示好友列表  -->
					<li class="list-group-item" id="collapseFriend">
					</li>
					<li class="list-group-item">
						<span><a onclick="showFriendsReq()">好友请求</a></span>
						<span id="index_reqfriend" class="badge"></span>
					</li>
					<!--显示好友请求  -->
					<li class="list-group-item" id="collapseFriendReq">
					<li class="list-group-item">
						<span><a onclick="addFriends()">添加好友</a></span>
						<span id="index_reqfriend" class="badge"></span>
					</li>
					<!--添加好友  -->
					<li class="list-group-item" id="addFrined">
						请输入好友的昵称:<br>
						<div>
							<form method="post" id="form_addFriend">
								<input type="text" name="fuzzyname" style="width:60%"><a class="btn" onclick="searchFriend()">搜索</a>
							</form>
							<div id="friendFrame">
								
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="col-md-8 article_container">
				<div class="col-md-12 publish-article" id="index_addArticle">
					<div class="input-group">
						<textarea id="article_content_pub" class="form-control"
							placeholder="写下此刻的想法" aria-describedby="basic-addon2"></textarea>
						<span class="btn input-group-addon" id="basic-addon2"> 添加图片
						</span> <span class="btn btn-primary input-group-addon" id="basic-addon2"
							onclick="publish_article()">发表</span>
					</div>
				</div>
				<c:forEach items="${articles.page }" var="article">
					<div class="col-md-12 article-wrap" id="article_${article.aid }">
						<div class="article-content">
							<div class="article-heading">
								<img class="img-circle user-headimg article-user-img"
									src="${pageContext.request.contextPath }/${article.user.userimg }"> <span
									class="article-user-name">${article.user.username }</span>
									<c:if test="${article.user.uid==sessionScope.user.uid }">
										<a href="javascript:;" onclick="del_article('${article.aid}','article_${article.aid }')">删除</a>	
									</c:if>
							</div>
							<div class="article-body">
								<p>${article.content }</p>
								<!--说说图片列表-->
							</div>
							<div class="text-right">
								<span class="article-publish-time">
									<fmt:formatDate value="${article.pubdate }" pattern="yyyy/MM/dd  HH:mm:ss" />
								</span> 
								<a href="javascript:;" onclick="praise('${sessionScope.user.uid }','${article.aid}','${article.aid}_praise')" class=" text-danger">
									<span class="glyphicon glyphicon-heart"></span><span id="${article.aid}_praise">${praises[article.aid] }</span>
								</a>
							</div>
						</div>
						<div class="article-comment"  id="${article.aid}_commnet"> 
							<c:forEach items="${comments[article.aid].page}" var="comment">
								<ul class="media-list comment" id="comment_${comment.cid}">
									<li class="media">
										<div class="media-left">
											<a href="#"> <img class="media-object article-user-img"
												src="${pageContext.request.contextPath }/${comment.user.userimg }" alt="...">
											</a>
										</div>
										<div class="media-body">
											<h5 class="media-heading">${comment.user.username }
											<span class="article-comment-time">
												<fmt:formatDate value="${comment.pubdate }" pattern="yyyy/MM/dd  HH:mm:ss" />
											</span>
											<a href="#"><span class="glyphicon glyphicon-comment"></span></a>
											<c:if test="${sessionScope.user.uid==comment.user.uid}">
												<a href="javascript:;" onclick="del_comment('${comment.cid}','comment_${comment.cid}')">删除</a>
											</c:if>
											</h5>
											<p>${comment.content }</p>
										</div>
									</li>
								</ul>
							</c:forEach>
						</div>
						<div class="publish-article-comment">
							<div class="input-group">
								<input type="text" id="publish-comment_${article.aid }" id="comment_input"  class="form-control" placeholder="写下你的想法"
									aria-describedby="basic-addon2" /> <span
									class="input-group-addon" id="basic-addon2" onclick="publish_comment('${article.aid }', '${sessionScope.user.uid }','${article.aid}_commnet')">评论</span>
							</div>
						</div>
					</div>
				</c:forEach>
				<!--分页标签-->
				<div class="text-right">
					总共${articles.totalcount }条记录/每页显示${articles.pageSize }条<br>
					当前页${articles.currpage }/总共${articles.totalpage }页<br>
					<c:if test="${articles.currpage < articles.totalpage }">
						<a href="index_index?currpage=${articles.currpage+1}&pagesize=10">下一页</a>
					</c:if>
					<c:if test="${articles.currpage>=1&&articles.totalpage!=1&&articles.currpage<=articles.totalpage}">
						<a href="index_index?currpage=${articles.currpage-1}&pagesize=10">上一页</a>
					</c:if>
				</div>
			</div>
			<div class=" col-md-2" style="padding: 0;">
				<div class="panel panel-default left-panel">
					<div class="panel-heading">
						<h3 class="panel-title text-center">
							<span class="user-name">${sessionScope.user.username }</span>的空间
						</h3>
					</div>
					<div class="panel-body text-center">
						<img class="user-touxiang-img" style="width:150px"
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
	<jsp:include page="container/footer.jsp"></jsp:include>
</body>
</html>

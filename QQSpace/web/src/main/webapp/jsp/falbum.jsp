<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>相册</title>
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript">
			var count=1;
			$(function(){
				setImg(400,200);
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
			function setImg(w, h){
			    var imgList = document.getElementsByTagName('img');
			    for(var i=0;i<imgList.length;i++){
			        if(imgList[i].width>w || imgList[i].height>h){
			            imgList[i].width = w;
			            imgList[i].heigth = h;
			        }
			    }
			}
		</script>
	</head>
	<body style="background:  #F9F9F9;">
		<jsp:include page="container/fhead.jsp"></jsp:include>
		<div class="container" style="border-radius: 5px;">
			<div class="row">
				<div class="col-md-2" style="padding: 0;">
					<ul class="list-group">
						<li class="list-group-item">
							<span><a href="article_showfarticle?uid=${selfuser.uid }">他的说说</a></span>
							<span class="badge" id="fartcle_myfriend">
							</span> 
						</li>
						<li class="list-group-item">
							<span><a>他的留言板</a></span>
						</li>
						<li class="list-group-item">
							<span><a href="AlbumAction_friendAlbum?uid=${selfuser.uid }&currpage=1&pagesize=6">他的相册</a></span>
						</li>
					</ul>
				</div>
				<div class="col-md-8" style="background:white;padding:0 30px;">
					<div style="padding:5px;">
						<h4><span class="text-primary">相册</span></h4>
						<hr>
					</div>
					<!--图片显示区域-->
					<div class="tab-content" style="margin-top: 20px;border:solid gainsboro 1px;">
						<div role="tabpanel" class="tab-pane active" id="home">
							<div class="row" id="album_container" style="padding: 50px;" id="albumcontainer">
								<c:forEach var="album" items="${page.page }">
									<div class="col-xs-6 col-md-4 .col-sm-4" style="padding: 5px;">
										<div class="thumbnail" >
											<img src="${pageContext.request.contextPath }/${album.image}" alt="图片加载失败">
										</div>
										<div class="caption" style="width:80%;position:absolute;bottom:10%;background:white">
											<div class="text-right">
												<fmt:formatDate value="${album.pubdate}" pattern="yyyy/MM/dd  HH:mm:ss" />
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<!--分页标签-->
						<div class="text-right">
							总共${page.totalcount }条记录/每页显示${page.pageSize }条<br>
							当前页${page.currpage }/总共${page.totalpage }页<br>
							<c:if test="${page.currpage<page.totalpage }">
								<a href="AlbumAction_friendAlbum?uid=${selfuser.uid }&currpage=${page.currpage+1}&pagesize=6">下一页</a>
							</c:if>
							<c:if test="${page.currpage>=2}">
								<a href="AlbumAction_friendAlbum?uid=${selfuser.uid }&currpage=${page.currpage-1}&pagesize=6">上一页</a>
							</c:if>
						</div>
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
	<jsp:include page="container/footer.jsp"></jsp:include>
</html>
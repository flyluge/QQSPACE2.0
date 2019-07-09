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
			$(function(){
				setImg(400,200);
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
		<jsp:include page="container/head.jsp"></jsp:include>
		<div class="container" style="background: white;border-radius: 5px;">
			<div style="margin-top:20px">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active">
						<a href="#home" aria-controls="home" role="tab" data-toggle="tab">
							<span class="text-primary">我的相册</span>
						</a>
					</li>
				</ul>
				<div>
				<form style="padding-left:50px" action="AlbumAction_addAlbum" method="post" enctype="multipart/form-data">
					上传我的相册<input type="file" name="file"><br>
					<input type="hidden" value="${sessionScope.user.uid }" name="uid">
					<input type="submit" value="提交">						
				</form>
				</div>
				<!--图片显示区域-->
				<div class="tab-content" style="margin-top: 20px;border:solid gainsboro 1px;">
					<div role="tabpanel" class="tab-pane active" id="home">
						<div class="row" id="album_container" style="padding: 50px;">
							<c:forEach var="album" items="${page.page }">
								<div class="col-xs-4 col-md-2 .col-sm-3" style="padding: 5px;">
									<div class="thumbnail" >
										<img src="${pageContext.request.contextPath }/${album.image}" class="img-responsive" alt="图片加载失败">
										<div class="caption" style="position:absolute;bottom:10%">
											<div class="text-right">
												<fmt:formatDate value="${album.pubdate}" pattern="yyyy/MM/dd  HH:mm:ss" />
												<a role="button" href="AlbumAction_deleteAlbum?alid=${album.alid }">
													<span class="glyphicon glyphicon-trash"></span>
												</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="find_more">
							<a href="#">显示更多</a>
						</div>
					</div>
					<!--分页标签-->
					<div class="text-right">
						<a>显示更多...</a>
					</div>
				</div>
			</div>

		</div>
	</body>
	<jsp:include page="container/footer.jsp"></jsp:include>
</html>
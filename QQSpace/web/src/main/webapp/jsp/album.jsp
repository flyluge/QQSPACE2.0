<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>相册</title>
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	</head>
	<body style="background:  #F9F9F9;">
		
		<jsp:include page="../container/head.jsp"></jsp:include>
		
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
					<form style="padding-left:50px" id="form_uploadAlbum" enctype="multipart/form-data">
						上传我的相册<input type="file" name="file"><br>
						<input type="hidden" name="user.uid" class="sessionuser_uid" id="sessionuser_uid">
						<input type="button" value="提交" id="uploadAlbum_sub">						
					</form>
				</div>
				<!--图片显示区域-->
				<div class="tab-content" style="margin-top: 20px;border:solid gainsboro 1px;">
					<div role="tabpanel" class="tab-pane active" id="home">
						<div class="row" id="album_container" style="padding: 50px;">
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

</html>
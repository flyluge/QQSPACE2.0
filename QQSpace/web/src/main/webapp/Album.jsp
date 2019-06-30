<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>相册</title>
</head>
<body>
	<!--删除相册  -->
	<form action="AlbumAction_deleteAlbum">
		
	</form>
	<!--上传相册  -->
	<form action="AlbumAction_addAlbum" enctype="multipart/form-data" method="post">
		<input type="file" name="file">请加入图片<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>
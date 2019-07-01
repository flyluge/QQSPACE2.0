<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>相册</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">
	$.ajax({
		url:"AlbumAction_findAlbumByPage",
		type:"POST",
		dataType: "json",
		data:{"currpage":1,"pagesize":5,"uid":2},
		success:function(data){
			$.each(data.data.page,function(i,n) {
				$("#imageid").append("<img src='"+n.image+"'>");
			});
		}
	})

</script>
<style>
	#imageid img{
		width:200px;
		font-weight: bold;
	}
</style>
<body>
	<!--删除相册  -->
	<form action="AlbumAction_deleteAlbum">
		
	</form>
	<!--上传相册  -->
	<form action="AlbumAction_addAlbum" enctype="multipart/form-data" method="post">
		<input type="file" name="file">请加入图片<br>
		<input type="submit" value="提交">
	</form>
	<div id="imageid"></div>
</body>
</html>
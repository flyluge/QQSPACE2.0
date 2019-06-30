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
		data:{"currpage":1,"pagesize":5,"uid":1},
		success:function(data){
			alert(data.data.page[0].image);
			$.each(data.data.page,function(i,n) {
				alert(n.image);
				$("#imageid").append("<img src='"+n.image+"'>");
			});
		}
	})

</script>
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
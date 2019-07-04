$(document).ready(function() {
	$.ajax({
		url:"user_sessionuser",
		type:"get",
		dataType: "json",
		success:function(data){
			//alert(JSON.stringify(data));
			$(".user-name").text(data.data.username);
			$(".user-touxiang-img").attr("src", data.data.userimg);
		}
	})
});
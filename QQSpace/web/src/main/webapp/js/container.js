$(document).ready(function() {
	$.ajax({
		url:"user_sessionuser",
		type:"get",
		dataType: "json",
		success:function(data){
			//alert(JSON.stringify(data));
			if(data.message){
				$(".user-name").text(data.data.username);
				$(".user-touxiang-img").attr("src", data.data.userimg);
			} else {
				alert(data.data);
				window.location.href="login.html";
			}
		}
	})
});
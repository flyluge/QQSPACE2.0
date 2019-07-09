<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆超时</title>
</head>

<body>
	<h1><span>用户未登录或登陆超时,5s后跳转到登陆界面...</span></h1>
	<h2>剩余时间<span id="timedown"></span></h2>
	<a href="login.jsp">立即跳转</a>
</body>
<script>
    var t=6;
    var timer=setInterval(time,1000);
    var spans=document.getElementById("timedown");
    function time(){
        t--;
        spans.innerHTML=t;
        if (t==0){
            clearInterval(timer);
            return window.location.href='login.jsp';
        }console.log(t);
    }
    time();
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户登录界面</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 引入 Bootstrap -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
		<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/css/top_nav.css" rel="stylesheet" />
	</head>
	<script>
		$(function() {
			var phoneFlag = false;
			var passwordFlag = false;
			var verifyCodeFlag = false;
			if(verifyPassword($("#user_password").val())) {
				passwordFlag = true;
			}
			if(verifyPhone($("#user_phone1").val())) {
				phoneFlag = true;
			}
			$("#btn_login_1").click(function() {
				$("#btn_login_1").css("color", "black");
				$("#btn_login_2").css("color", "#999");
				$(".login_frame").hide();
				$("#login_frame_1").show();
			})
			$("#btn_login_2").click(function() {
				$("#btn_login_2").css("color", "black");
				$("#btn_login_1").css("color", "#999");
				$(".login_frame").hide();
				$("#login_frame_2").show();
			})
			$("#registerFrame").click(function() {
				$(".login_frame").hide();
				$("#login_frame_3").show();
			})
			$("#btn_login_3").click(function(){
				if(phoneFlag && passwordFlag) {
					
				} else {
					$("#danger03").show();
				}
			})
			/*用户注册  */
			$("#registerFrame_complete").click(function() {
				let jsonmess=$("#register_form1").serialize();
				alert(jsonmess);
				$.ajax({
					url:"UserAction_register",
					type:"POST",
					dataType: "json",
					data:jsonmess,
					success:function(data){
						if(data.message){
							alert(data);
							$("#btn_login_1").triggerHandler("click");
						}else{
							alert(data.data);
						}
					}
				})
			})
			/*手机号验证*/
			function verifyPhone(phone) {
				var pattern = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
				return pattern.test(phone);
			}
			/*密码验证*/
			function verifyPassword(password) {
				return(password.length > 0 && password.length < 20);
			}
			/*验证码验证*/
			function verifyVerifyCode(code) {
				var pattern = /^\d{6}$/;
				return pattern.test(code);
			}
			/*表单验证成功特效*/
			/*p1为需要校验的表单*/
			function verifySuccessEffects(p1) {
				p1.removeClass("has-error");
				p1.addClass("has-success");
				var sp1 = p1.find("span").last();
				sp1.removeClass("glyphicon-remove");
				sp1.addClass("glyphicon-ok");
			}
			/*表单验证失败特效*/
			function verifyFailEffects(p1) {
				p1.removeClass("has-success");
				p1.addClass("has-error");
				var sp1 = p1.find("span").last();
				sp1.removeClass("glyphicon-ok");
				sp1.addClass("glyphicon-remove");
			}
			/*验证手机号*/
			$("#user_phone1,#user_phone2,#user_phone3").blur(function() {
				var p1 = $(this).parent().parent();
				if(verifyPhone($(this).val())) {
					verifySuccessEffects(p1);
					phoneFlag = true;
					if(phoneFlag && passwordFlag) {
					}
				} else {
					verifyFailEffects(p1);
					phoneFlag = false;
				}
			}).focus(function() {
				$(this).triggerHandler("blur");
			}).keyup(function() {
				$(this).triggerHandler("blur");
			})
			$("#user_phone3").blur(function(){
				let jsonmess=$("#user_phone3").val();
				$.ajax({
					url:"UserAction_existAccount",
					type:"POST",
					dataType: "json",
					data:{"user.useremail":jsonmess},
					success:function(data){
						if(data.message){
							$("#email_message").html("用户名已存在");
						}else{
							$("#email_message").html("");
						}
					}
				})
			})
			/*验证密码*/
			$("#user_password").blur(function() {
				var password = $(this).val();
				var p1 = $(this).parent().parent();
				if(verifyPassword(password)) {
					verifySuccessEffects(p1);
					passwordFlag = true;
					if(phoneFlag && passwordFlag) {
					}
				} else {
					verifyFailEffects(p1);
					passwordFlag = false;
				}
			}).focus(function() {
				$(this).triggerHandler("blur");
			}).keyup(function() {
				$(this).triggerHandler("blur");
			})
			/*验证验证码*/
			$("#register_verifyCode1,#register_verifyCode2").blur(function() {
				var password = $(this).val();
				var p1 = $(this).parent().parent();
				if(verifyVerifyCode(password)) {
					verifySuccessEffects(p1);
					if(phoneFlag && verifyCodeFlag) {
					}
				} else {
					verifyFailEffects(p1);
				}
			}).focus(function() {
				$(this).triggerHandler("blur");
			}).keyup(function() {
				$(this).triggerHandler("blur");
			})
		})
	</script>

	<body>

		<div class="container-fluid" style="height: 62px;border-bottom: 1px solid #d6dfea;background: #eff4fa;">
			<img src="${pageContext.request.contextPath }/img/logo.png"  style="width: 50px;">QQ空间
		</div>

		<div class="container" style="margin-top: 50px;">
			<div class="row">
				<!--版块一-->
				<div class="col-md-6 col-sm-12 hidden-xs" style="background: url(/web/img/ju_top.jpg) no-repeat center top;background-position: 0px top;">
					<div style="width: 100%;padding:5% 15% 0% 15%;line-height: 20px;margin: 75px auto 0 auto;">
						<p>落寞的孤辰，乱了谁的发梢，三生的河畔，许了谁的流年。</p>
						<p>奈何桥上谁饮了那孟婆汤刻下这悠远的思念，遗忘，感伤！</p>
						<p>月老手中错绑的红线，苍涩了千年。</p>
						<p>似水流年，允我相思不尽；</p>
						<p>蝶花陨落，许你一世柔情；</p>
						<p>残缺了月圆，凄美了誓言，终是那一世花开，这一生花落。</p>
					</div>
					<div style="background: url(/web/img/ju_bottom.jpg);width: 100%;min-height: 88px;"></div>
				</div>
				<!--板块二-->
				<!--<div class="col-md-4 " style="overflow: hidden;">
				</div>-->
				<!--板块三-->
				<div class="col-md-6 col-sm-12 col-xs-12">
					<div style="border:1px solid #a0b1c4;width: 332px;height: 380px;border-radius: 5px;margin:0 auto;">
						<!--登录标题-->
						<div style="height: 50px;border-bottom:1px solid #a0b1c4; background-color: #f9fbfe;border-radius: 6px 6px 0 0;">
							<div id="btn_login_1" class="col-md-6" style="font-size: 16px;line-height: 50px; float: left;text-align: center;cursor: pointer;color:black">
								账号密码登录
							</div>
							<div id="btn_login_2" class="col-md-6" style="font-size: 16px;line-height: 50px; float: left;text-align: center;cursor: pointer;color:#999">
								手机快速登录
							</div>
						</div>
						<!--------------------------------------------------------------------------------------------------------------->
						<!--has-error has-success has-warning-->
						<!--用户名密码登录-->
						<form id="form1" action="UserAction_login" method="post">
							<div class="login_frame" id="login_frame_1" style="display: block;margin: 20px;">
								<!--手机号-->
								<div class="form-group has-feedback" style="margin-top:50px ;">
									<div class="input-group">
										<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-envelope"></span></span>
										<label class="control-label sr-only" for="inputSuccess5">邮箱号</label>
										<input type="text" id="user_phone1" name="user.useremail" placeholder="Email" class="form-control" />
									</div>
									<!--验证图标-->
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
								<!--密码-->
								<div class="form-group has-feedback">
									<div class="input-group">
										<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-lock"></span></span>
										<label class="control-label sr-only" for="inputSuccess5">密码</label>
										<input type="password" id="user_password" name="user.userpassword" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
									</div>
									<!--验证图标-->
									<span id="login_frame_icon2" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
								<div>
									<div class="checkbox">
										<label>
							          <input type="checkbox"> 记住密码
							        </label>
									</div>
								</div>
								
								<input type="hidden" name="currpage" value="1"> 
								<input type="hidden" name="pagesize" value="10"> 
								<input type="submit" class="btn btn-primary btn-block btn-lg" value="登录"> 
								<div align="right">
									<a id="registerFrame">免费注册</a>
									<a>忘记密码</a>
								</div>
							</div>
						</form>
						<!---------------------------------------------------------------------------------------------------------------->
						<!--手机号验证登录-->
						<div class="login_frame" id="login_frame_2" style="display: none;padding: 20px;">
							<div class="form-group has-feedback" style="margin-top: 20px;">
								<label for="phonenumber">请输入手机号</label>
								<div class="input-group">
									<input type="text" id="user_phone2" name="user_phone" placeholder="Phone Number" class="form-control" />
									<a class="btn btn-primary"><span>60s后重新发送</span></a>
								</div>
								<!--验证图标-->
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
							</div>
							<div class="form-group has-feedback">
								<label for="register_verifyCode1">请输入获取的验证码</label>
								<div class="input-group">
									<input type="text" class="form-control" id="register_verifyCode1" placeholder="Verify Code">
								</div>
								<!--验证图标-->
								<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
							</div>
							<button type="button" id="btn_login_3" class="btn btn-primary btn-lg btn-block">登录</button>
						</div>
						<!--------------------------------------------------------------------------------------------------------------->
						<!--用户注册-->
						<form id="register_form1">
							<div class="login_frame" id="login_frame_3" style="display: none;padding: 20px;">
								<div class="form-group has-feedback" style="margin-top: 20px;">
									<label for="phonenumber">请输入邮箱号</label>
									<div class="input-group">
										<input type="text" id="user_phone3" name="user.useremail" placeholder="Email" class="form-control" />
										<span id="email_message"></span>
									</div>
									<!--验证图标-->
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
								<div class="form-group has-feedback">
									<label for="register_verifyCode2">请输入密码</label>
									<div class="input-group">
										<input type="text" name="user.userpassword" class="form-control" id="register_verifyCode2" placeholder="password">
									</div>
									<!--验证图标-->
									<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
								<a class="btn btn-primary btn-lg btn-block" id="registerFrame_complete">注册</a>
							</div>
						</form>
						<!--------------------------------------------------------------------------------------------------------------->
						<!--完善用户信息-->
						<div class="login_frame" id="login_frame_4" style="display: none;margin: 20px;">
							<!--验证图标-->
							<div class="form-group has-feedback" style="margin-top:50px ;">
								<h4 class="text-success">请完善个人信息</h4>
								<!--用户名-->
								<div class="input-group">
									<label class="control-label sr-only" for="inputSuccess5">用户名</label>
									<span class="input-group-addon" id="basic-addon1">用户名：</span>
									<input type="text" id="complete_user_name" name="user_name" class="form-control" placeholder="UserName" aria-describedby="basic-addon1">
									<span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
								</div>
								<span id="login_frame_icon1" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<span id="inputSuccess3Status" class="sr-only">(success)</span>
							</div>
							<!--用户密码-->
							<div class="form-group has-feedback">
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1">密码</span>
									<label class="control-label sr-only" for="inputSuccess5">密码</label>
									<input type="password" id="complete_user_password1" name="user_password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
								</div>
								<!--验证图标-->
								<span id="login_frame_icon2" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
							</div>
							<!--确认密码-->
							<div class="form-group has-feedback">
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1">确认密码</span>
									<label class="control-label sr-only" for="inputSuccess5">确认密码</label>
									<input type="password" id="complete_user_password2" name="user_password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
								</div>
								<!--验证图标-->
								<span id="login_frame_icon2" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								<span id="inputGroupSuccess3Status" class="sr-only">(success)</span>
							</div>
							<a class="btn btn-primary btn-block btn-lg" href="${pageContext.request.contextPath }/#">完成</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
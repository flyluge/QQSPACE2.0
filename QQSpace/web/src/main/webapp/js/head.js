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
					url:"user_existAccount",
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
$(function(){
	var regphone=/^(13[\d]{9}|15[\d]{9}|18[\d]{9})$/; //手机
	var regpass=/^[A-Za-z0-9]{6}$/;//密码	
	
	var phone=$("#tbxPhone").val();
	var pass=$.trim($("#tbxConfirmPwd").val());
	//加载完成时光标位置
	setTimeout(function() {
    	$("#tbxPhone").get(0).focus();
	}, 0);

	//即时验证文本内容是否正确
	$("#tbxPhone").bind("change",function(){
		setInterval(function(){
				if(!regpass.test($('#tbxPhone').val()) || !regphone.test($('#tbxConfirmPwd').val())){
					$("#confirm").css({"background":"#ccc","border-color":"#ccc"});
					$("#confirm").attr("disabled","disabled");
				}
				else if(regpass.test($('#tbxPhone').val())==true && regphone.test($('#tbxConfirmPwd').val())==true){
					$("#confirm").css({"background":"#5DADE2","border-color":"#5DADE2"});
					$("#confirm").removeAttr("disabled");
				}			
		},0)
	});
	//即时验证文本内容是否正确

	// 电话号码
	$("#tbxPhone").focus(function(){
		$(".phone_error").css({'display':'inline-block','color':'#FFAD08','font-size':'14px'}).text("请输入您的手机号码");
		$(".alertcontent").css('margin-top','80px');
	})
	$("#tbxPhone").blur(function(){
		if($("#tbxPhone").val()==""){
			$(".phone_error").css({'display':'inline-block','color':'red','font-size':'14px'}).text("'格式错误' 不能为空");
		}
		else if(!regphone.test($('#tbxPhone').val())){
			$(".phone_error").css({'display':'inline-block','color':'red','font-size':'14px'}).text("'格式错误' 请输入正确的手机号码");
		}
		else{
			$(".phone_error").css('display','inline-block').text("");
		}
	})
	// 电话号码

	// 密码
	$("#tbxConfirmPwd").focus(function(){
		$(".pass_error").css({'display':'inline-block','color':'#FFAD08'}).text("请输入您的密码");
		$(".alertcontent").css('margin-top','80px');
	})
	$("#tbxConfirmPwd").blur(function(){
		if($("#tbxConfirmPwd").val()==""){
			$(".pass_error").css({'display':'inline-block','color':'red','font-size':'14px'}).text("'格式错误' 不能为空");
		}
		else if(!regpass.test($('#tbxConfirmPwd').val())){
			$(".pass_error").css({'display':'inline-block','color':'red','font-size':'14px'}).text("'格式错误' 密码只6位字母或数字");
		}
		else{
			$(".pass_error").css('display','inline-block').text("");
		}
	})
	// 密码

	//提交
	$(".bigbutton").click(function(){
		if($("#tbxPhone").val()==""){
			$(".phone_error").css({'display':'inline-block','color':'red'}).text("'格式错误' 不能为空");
		}
		if($("#tbxConfirmPwd").val()==""){
			$(".pass_error").css({'display':'inline-block','color':'red'}).text("'格式错误' 不能为空");
		}
		else{
			//$(".alertwindow").hide();
		}
	})
	//提交

});
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>微信公众号设置 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="main-content" style="width:1008px;margin:0 auto; margin-top:10px;">
	<div class="page-content">
		<div class="span6" style=" width:100%;margin:10px auto; " >
		  <div class="widget-header header-color-blue2"  style="height:60px;" >
    			<h3 class="lighter smaller" style=" line-height:60px;">公众号对接设置</h3>
  		</div>
  		<form action="json/config!mpupdate.action" method="post" onsubmit="return singleSubmit()">
			<div style=" height:auto;margin:-4px auto; width:98%; border:4px solid #999999; " >
				<div class="form-horizontal" role="form"  style="margin-top:20px; padding-bottom:10px; width:75%; float:left;">
					<div class="control-group" >
						<label class="control-label" for="form-field-1" style="font-size:20px ;height:30px;line-height:30px; ">AppId</label>
						<div class="controls" style="font-size:14px;line-height:40px;color:#666">
							<input type="text" id="form-field-1" placeholder="" class="span4" style="height:30px; line-height:30px; font-size:16px;font-weight:700;color:#000  " name="appid" value="${(systemClass.appId)!}" /><br/> 微信认证后，在开发者中心会出现AppId（用于对接自定义菜单功能）
						</div>
					</div>
					<div class="control-group" >
						<label class="control-label" for="form-field-1" style="font-size:20px ;height:30px;line-height:30px; ">AppSecret</label>
						<div class="controls"style="font-size:14px;line-height:40px;color:#666">
                  			<input type="text" id="form-field-1" placeholder="" class="span4" style="height:30px; line-height:30px; font-size:16px;font-weight:700;color:#000  " name="appsecret" value="${(systemClass.appSecret)!}" /> <br/>微信认证后，您将会拥有AppSecret
						</div>
					</div>
					<div class="control-group" >
						<label class="control-label" for="form-field-1" style="font-size:20px ;height:30px;line-height:30px; ">微信支付密钥</label>
                      	<div class="controls"style="font-size:14px;line-height:40px;color:#666">
               				<input type="text" id="form-field-1" placeholder="" class="span4" style="height:30px; line-height:30px; font-size:16px;font-weight:700;color:#000  " name="wxpay" value="${(systemClass.wxpaySecret)!}" /> <br/>微信支付自行设置的密码
						</div>
                	</div>
                	<div class="control-group" >
                      	<label class="control-label" for="form-field-1" style="font-size:20px ;height:30px;line-height:30px; ">微信支付商户ID</label>
                     	<div class="controls"style="font-size:14px;line-height:40px;color:#666">
                     		<input type="text" id="form-field-1" placeholder="" class="span4" style="height:30px; line-height:30px; font-size:16px;font-weight:700;color:#000  " name="mchid" value="${(systemClass.mchid)!}" /> <br/>请查看微信支付验证邮件
						</div>
               		</div>
               		<div class="control-group" >
                      	<label class="control-label" for="form-field-1" style="font-size:20px ;height:30px;line-height:30px; ">关注url</label>
                     	<div class="controls"style="font-size:14px;line-height:40px;color:#666">
                     		<input type="text" id="form-field-1" placeholder="" class="span4" style="height:30px; line-height:30px; font-size:16px;font-weight:700;color:#000  " name="url" value="${(systemClass.suburl)!}" /> <br/>给用户关注的页面
						</div>
               		</div>
					<div class="control-group">
						<div class="controls">
						   <input id="loading-btn" type="submit" class="btn btn-success " style="font-size:20px; " data-loading-text="提交中..." value="确认编辑" />		</div>
						</div>
					</div>
					<div class="clearfix"></div>
			 </div>
		</div>
		</form>
   </div>
</div>

<script src="${base}/assets/js/bootstrap-tag.min.js"></script>

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${base}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->


<script src="${base}/assets/js/typeahead-bs2.min.js"></script>

<!--page specific plugin scripts-->
<!--ace scripts-->
<script src="${base}/assets/js/x-editable/bootstrap-editable.min.js"></script>
<script src="${base}/assets/js/x-editable/ace-editable.min.js"></script>
<script src="${base}/assets/js/jquery.maskedinput.min.js"></script>



<script>
$("form").validationEngine();
$(function() {
//another option is using modals
	$('#avatar1').bind('click', function(){
		$("#file").trigger("click");
	});
	$('#file').bind("change",function(){
	fileupload();
	});
});
function fileupload(){
$.ajaxFileUpload({
		url:'upload.action',       //需要链接到服务器地址
		secureuri:false,
		fileElementId:'file',                            //文件选择框的id属性
		dataType: 'text/html',                                   //服务器返回的格式，可以是json
		data:{width:'549', length:'327'},
		success: function (data, textStatus) {
		//兼容ie8以及以下版本
                	if(data.success){
                		$("#codeUrl").val("http://"+window.location.host+"/"+data.bigurl);
				$("#avatar1").attr("src",data.bigurl);
				$('#file').bind("change",function(){
					fileupload();
				})	
                	}
                	//兼容火狐、谷歌、ie8以上版本
			var dat = eval("("+data+")");
			if(dat.success){
				$("#codeUrl").val("http://"+window.location.host+"/"+dat.bigurl);
				$("#avatar1").attr("src","/"+dat.bigurl);
				$('#file').bind("change",function(){
					fileupload();
				})	
			}
		}
	});
}

$(function(){

$("form").ajaxForm({
	type:"post",
	beforeSubmit: function(){
		//var url = $("input[name$='attentionlink']").val();
		//if(url.indexOf("qq.com")<0){
		//	alert("您输入的链接有误，请重新输入！");
		//}
		
	},
   	success: function(data){
   		var dat = eval("("+data+")")
   		if(dat.success){
   			bootbox.alert('<br><center><font style="font-weight:700; font-size:18px;text-algin:center;" class="green"><i class="icon-ok bigger-120"></i> '+'修改成功!'+'</font></center><br>', function() {
				location.href = dat.url;
			});			
		}else{
			bootbox.alert('<br><center><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;" class="red"> <i class="icon-ban-circle bigger-120"></i> '+'修改失败,请查看是否登录成功!'+' </font></center><br>');
		}
		return false;
   	}
});
})

</script>

</body>
</html>

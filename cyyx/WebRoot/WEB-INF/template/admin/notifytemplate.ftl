<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>通知模板设置 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<link rel="stylesheet" type="text/css" href="${base}/assets/css/reg.css" />
</head>
<body>
<div class="admin_main">
	<div class="admin_pw">
		<div class="wx_mbody" style="border:0;">
			<form action="json/notifytemplate!update.action" method="post" id="perinfos">
			<div class="per_info">
				<div class="team_set pinfo2">
					<table cellspacing="0" cellpadding="0" class="table">
						<tr>
							<td class="ecard_ltd ">
								组团成功通知模板ID：
							</td>
							<td>
								<input class="dj_inp validate[require]" type="text" placeholder="请输入组团成功通知模板ID" name="gok" value="${(admin.grounpOkTemplateId)!}">
							</td>
						</tr>
						<tr class="noborder">
							<td colspan="2" class="ecard_center" style="text-align: center;">
								<button type="submit" class="ecard_save" data-loading-text="提交中...">确认</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
			</form>
		</div>
	</div>
</div>


<script src="assets/js/bootstrap-tag.min.js"></script>

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->


<script src="assets/js/typeahead-bs2.min.js"></script>

<!--page specific plugin scripts-->
<!--ace scripts-->
<script src="assets/js/x-editable/bootstrap-editable.min.js"></script>
<script src="assets/js/x-editable/ace-editable.min.js"></script>
<script src="assets/js/jquery.maskedinput.min.js"></script>
<script src="${base}/assets/js/jquery.cityselect.js"></script>
<script>
$("form").validationEngine();
$(function(){
$("form").ajaxForm({
	type:"post",
	beforeSubmit: function(){
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
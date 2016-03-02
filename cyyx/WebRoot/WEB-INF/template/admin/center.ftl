<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>管理后台</title>
<link rel="stylesheet" type="text/css" href="${base}/assets/css/reg.css" />
<script type="text/javascript" src="${base}/assets/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	var url="";
	$(document).ready(function(){
		$("#filepreview").bind("click",function(){
			$('#file').trigger("change");
		})
		$('#file').bind("change",function(){
			fileupload();
		});
	});
	function fileupload(){
		$.ajaxFileUpload({
                url:'${base}/upload',       //需要链接到服务器地址
                secureuri:false,
                fileElementId:'file',                            //文件选择框的id属性
                dataType: 'text/html',                                   //服务器返回的格式，可以是json
                data:{width:'549', length:'327'},
                success: function (data, textStatus) {
                //兼容ie8以及以下版本
                	if(data.success){
                		$("#pic").val("http://"+window.location.host+"/"+data.bigurl);
                		$("#filepreviewcontent").show();
                		$("#filepreview").attr("src",data.bigurl);
                		url = "http://"+window.location.host+"/"+data.bigurl;
                		$('#file').bind("change",function(){
                			fileupload();
                		});
                	}
                	//兼容火狐、谷歌、ie8以上版本
                	var dat = eval("("+data+")");
                	if(dat.success){
                		$("#pic").val("http://"+window.location.host+"/"+dat.bigurl);
                		$("#filepreviewcontent").show();
                		$("#filepreview").attr("src",dat.bigurl);
                		url = "http://"+window.location.host+"/"+dat.bigurl;
                		$('#file').bind("change",function(){
                			fileupload();
                		})	
                	}
                	$.ajax({
                		url:"user!picupdate",
                		data:{"url":url},
                		type:"post",
                		success:function(){
                		
                		}
                	})
                },
                error: function (data, status, e) {           //相当于java中catch语句块的用法
                    $('#imgPath').val('');
                }
            });
		}
</script>
</head>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="admin_main">
	<div class="admin_card">
		<div class="admin_cl">
			<div class="admin_fol">
				<table cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td class="admin_fol1">
							<div class="dj_upload">
								<div class="dj_index">
									<img id="filepreview" src="<#if admin.colorurl?? && admin.colorurl!="">${admin.colorurl}<#else>${base}/assets/img/face1.png</#if>">
									<input type="file" name="file" id="file" class="dj_file" />
									<input type="hidden" id="pic" value="${admin.colorurl!}" />
								</div>
							</div>
						</td>
						<td class="admin_fol2">
							<p>版本:<#if admin.versions=="company">公司版</#if><#if admin.versions=="agent">经销商版</#if><#if admin.versions=="staff">员工版</#if></p>
							<p>${admin.linkname}<#if admin.thejob??>（${admin.thejob}）</#if></p>
							<p>${admin.linkphone}</p>
							<#if admin.versions=="staff"><p>${company.linkname}</p></#if>
						</td>
					</tr>
				</table>
			</div>
			
			<div class="admin_citem">
				<table cellspacing="0" cellpadding="0" width="100%">
					
					<tr>
						<td class="cltd">微网首页</td>
						<td>http://${admin.cid}.wudianyi.com/index.action</td>
					</tr>
					<tr>
						<td class="cltd">个人中心</td>
						<td>http://${admin.cid}.wudianyi.com/center.action</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="admin_cr">
			<div class="reg_vl">
				<h1 class="reg_question">佣金情况</h1>
				<p class="reg_answer"><a href="wd!list.action?tt=success"><b>已发佣金：</b>${depositsuccesscount}</a></p>
				<p class="reg_answer"><a href="wd!list.action"><b>审核中佣金：</b>${depositingcount}</a></p>
				<p class="reg_answer"><b>未发佣金：</b>${depositingcount}</p>
				<!--<div class="reg_ewm">
					<p class="ewm_tit"></p>
					<p class="ewm_img"><img src=""></p>
					<p class="ewm_sao">微信扫一扫，即可访问</p>
				</div>-->
			</div>
		</div>
	</div>
	<div class="admin_access">
		<div class="admin_cl">
			<div class="admin_acc1" style="background:#019875">
				公众号对接
			</div>
			<div class="alter_weixin">
					<p style="padding-bottom:10px; font-size:16px;">根据下面信息对接公众号：</p>
				<div class="u_weixin" style="margin-top:3px;font-size:14px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="2">登录“微信公众号” →  开发者中心 → 修改配置  → 按下面信息对接</td>
						</tr>
						<tr>
							<td class="u_ltd4">URL：</td>
							<td><b>http://www.wudianyi.com/${admin.cid}.wx</b></td>
						</tr>
						<tr>
							<td class="u_ltd4">Token：</td>
							<td><b>${admin.cid}Token</b></td>
						</tr>
						<tr>
							<td class="u_ltd4"></td>
							<td>选择“明文模式”</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="admin_acc2">
			</div>
		</div>
		<div class="admin_cr">
			<div class="reg_vl" >
			<h1 class="reg_question">Q：如何让您的朋友通过微信公众号访问您的微网站？</h1>
			<p class="reg_answer"><b>A：</b>可以让你的朋友关注你的公众号，系统将会自动发送一条图文信息给关注者。微网站。</p>
				<div class="reg_ewm" >
					<#if admin.codeurl??>
					<p class="ewm_tit">${admin.weixinname}（${admin.weixinnum}）</p>
					<p class="ewm_img"><img src="${admin.codeurl}"></p>
					<p class="ewm_sao">微信扫一扫，即可关注</p>
					<#else>
					<p class="ewm_sao"><a href="wxmenu!menuupdateview.action">请完善您的公众号信息</a></p>
					</#if>
				</div>

			</div>
		</div>
	</div>
</div>


<!-- 透明背景 -->
<a href="javascript:;"><div class="mask"></div></a>

<!-- 查看公众号对接步骤弹出层 -->
<div class="reg_step4">
	<img src="${base}/web/img/img01/step4.png">
</div>

<script>

//修改微网名称
$(".alter_net_name").live("click", function(){
	
	$(".no_alter").hide();
	$(".is_alter").show();
	
	var net_name = $(".net_name").html();
	$(".net_name_text").val(net_name);
	
});

//保存微网名称
$(".save_net_name").live("click", function(){
	
	$(".no_alter").show();
	$(".is_alter").hide();
	var net_name = $(".net_name_text").val();
	$(".net_name").html(net_name);
	$.ajax({
		url:"admin!update",
		data:{name:net_name},
		type:"post",
		success:function(html){
		}
	})
});

//点击查看步骤
$(".show_step4").live("click", function(){
	$(".mask").fadeIn(300);
	$(".reg_step4").fadeIn(300);
});

//全部关闭
$(".mask").live("click", function(){
	$(".mask").fadeOut(300);
	$(".reg_step4").fadeOut(300);
});
</script>
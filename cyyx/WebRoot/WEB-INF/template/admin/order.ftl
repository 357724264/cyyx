<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>订单详情 - 系统管理中心</title>
<style type="text/css">
	@font-face { font-family: "iconfont"; src: url('/home/fonts/iconfont.eot'); /* IE9*/ src: url('/home/fonts/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */ url('/home/fonts/iconfont.woff') format('woff'), /* chrome、firefox */ url('/home/fonts/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/ url('/home/fonts/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */ }
	.txkddh-box{width:420px; height:280px; box-shadow:1px 1px 2px #ddd,-1px -1px 2px #ddd; position:fixed; top:140px; left:50%; background-color:#fff; z-index:9; margin-left:-210px; padding:35px 20px 10px 20px; box-sizing:border-box; display:none;}
	.txkddh-box .txkddh-closebtn{width:36px; height:36px; line-height:36px; position:absolute; top:0;right:0; display:block; text-align:center; text-decoration:none;}
	.txkddh-box .txkddh-closebtn i{font-style:normal; font-family:"iconfont"; font-size:2.4rem; position:relative; margin-top:-4px; display:block;}
	.txkddh-box .txkddh-group{width:100%; padding:10px 0; height:70px; box-sizing:border-box; font-size:14px;}
	.txkddh-box .txkddh-group .txkddh-tit{width:30%; line-height:50px; float:left; text-align:right; padding-right:8px; box-sizing:border-box; display:block;}
	.txkddh-box .txkddh-group .txkddh-inptbox{width:70%; height:100%; float:left;}
	.txkddh-box .txkddh-group .txkddh-inptbox input{width:100%;height:100%; margin:0;padding:0; outline:none; box-sizing:border-box; border:1px solid #c1c1c1; text-indent:6px; -webkit-appearance: none;}
	.txkddh-box .txkddh-confirmbtn{width:70%; float:right; height:40px; margin-top:30px;}
</style>
<#include "/WEB-INF/template/admin/header.ftl" />

<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
	<div class="page-content">
		<div class="page-header position-relative">
			<h1> <a href="order!list.action"><i class="icon-flag" style="font-size:20px"></i> 订单列表</a> <small> <i class="icon-double-angle-right"></i> 订单查询
		        <!--修改活动信息-->
		        </small> </h1>
		        <div class="ace-settings-container" id="ace-settings-container"  style="  margin-top:-55px; ">
        <div class="btn-toolbar">
          <div class="btn-group">
         
            <button data-toggle="dropdown" class="btn btn-success btn-lg dropdown-toggle"> <i class="icon-cog bigger-120"></i> 变更订单状态 <i class="icon-angle-down icon-on-right"></i> </button>
            <ul class="dropdown-menu dropdown-success statlist">
              <#if order.paymentStatus=="paid"><li style="line-height:40px; height:40px; margin-top:-6px; "> <a href="javascript:orderchange('send')" class="bgyfh" style="line-height:40px; height:40px;"><span class="badge badge-success">&nbsp;</span> 变更为已发货</a> </li></#if>
              <#if order.paymentStatus=="unpaid"><li style="line-height:40px; height:40px; margin-top:-6px; "> <a href="javascript:orderchange('free')" style="line-height:40px; height:40px;"><span class="badge badge-success">&nbsp;</span> 取消订单</a> </li></#if>
              <!--<#if order.paymentStatus=="unpaid"><li style="line-height:40px; height:40px; margin-top:-6px; "> <a href="javascript:orderchange('paid')" style="line-height:40px; height:40px;"><span class="badge badge-success">&nbsp;</span> 变更为已付款</a> </li></#if>-->
              <#if order.paymentStatus=="send"><li style="line-height:40px; height:40px; margin-top:-6px; "> <a href="javascript:orderchange('deal')" style="line-height:40px; height:40px;"><span class="badge badge-success">&nbsp;</span> 变更为已收货</a> </li></#if>
            </ul>
          </div>
        </div>
      </div>
		</div>
	</div>

	<div class="txkddh-box">
		<a href="javascript:;" class="txkddh-closebtn"><i>&#xe603;</i></a>
		<span>请填写快递信息：</span>
		<div class="txkddh-group">
			<span class='txkddh-tit'>快递公司：</span>
			<div class="txkddh-inptbox"><input type="text" id="kdgs" placeholder='请输入快递公司' /></div>
		</div>
		<div class="txkddh-group">
			<span class='txkddh-tit'>快递单号：</span>
			<div class="txkddh-inptbox"><input type="text" id="kddh" placeholder='请输入快递单号' /></div>
		</div>
		<button type="button" class='txkddh-confirmbtn' id="txkddh-confirmbtn">确认</button>
	</div>

	<div class="tdata">
		<ul>
			<li>
				<img src="${base}/assets/img/tdata1.png">
				<h1>${order.money!0}</h1>
				<p>交易金额（元）</p>
			</li>
			<li style="margin:0 6px;">
				<img src="${base}/assets/img/tdata3.png">
				<h1 id="pstat">
				<#if order.paymentStatus=="unpaid">
				未支付
				</#if>
				<#if order.paymentStatus=="paid">
				已经支付
				</#if>
				<#if order.paymentStatus=="send">
				已发货
				</#if>
				<#if order.paymentStatus=="free">
				订单取消
				</#if>
				<#if order.paymentStatus=="deal">
				支付成功
				</#if>
				</h1>
				<p>支付状态</p>
			</li>
			<li style="margin:0 6px;">
				<img src="${base}/assets/img/tdata2.png">
				<h1>${order.num}</h1>
				<p><span id="thismonth"></span>购买物品数量（件）</p>
			</li>
		</ul>
	</div>

	<form id="myform" action="teamorder!list" method="post" class="noajax">
		<div class="tfind">	
			<table cellspacing="0" cellpadding="0" class="ttable">
				<tr>
					<td class="ltd" style="width:30%">
						收货人：${order.name}
					</td>
					<td class="ltd" style="width:1%">
						|
					</td>
					<td  class="ltd" style="width:30%">
						电话：${order.phone}
					</td>
					<td class="ltd"  style="width:1%">
						|
					</td>
					<td class="ltd" style="width:30%">
						邮编：${order.code}
					</td>
				</tr>
				<tr>
					<td class="ltd">
						订单编号：${order.orderSn}
					</td>
					<td class="ltd" colspan="3">
						发货快递公司：${(order.carricompany)!}
					</td>
					<td class="ltd" colspan="3">
						发货快递单号：${(order.carrino)}
					</td>
				</tr>
				<tr>
					<td class="ltd" colspan="2">
						创建时间：${order.createDate?number_to_datetime?string("yyyy-MM-dd HH:mm")}
					</td>
					<td class="ltd" colspan="3">
						支付时间：<#if order.payDate??>${order.payDate?number_to_datetime?string("yyyy-MM-dd HH:mm")}<#else>-</#if>
					</td>
				</tr>
				<tr>
					<td  class="ltd" colspan="5">
					地址：${order.address}
					</td>
				</tr>
				
			</table>	
		</div>

		<div class="widget-header header-color-blue2" style="margin-top:20px;">
			<h4 class="lighter smaller">订单产品列表</h4>
		</div>
		
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
				<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" >
					<thead>
						<tr>
							<th>产品缩略图</th>
							<th>产品名字</th>
							<th>产品单价（元）</th>
							<th>订购数量</th>
							<th>小结（元）</th>
						</tr>				
					</thead>
					<tbody>
						
						<tr>
							<td><img src="${order.page}" style="width:100px;heigth:100px"/></td>
							<td>${order.pageName}<#if order.size??>(${order.size})</#if></td>
							<td>${order.money / order.num}</td>
							<td>${order.num}</td>
							<td>${order.money}</td>
						</tr>
						
					</tbody>
				</table>
				
				<#if list?? && ps gt 1>
				<div class="row-fluid">
					<div class="span6" style="float:right;">
						<div class="dataTables_paginate paging_bootstrap pagination">
							<script type="text/javascript">
								$().ready( function() {
									$("#pager").pager({
										pagenumber: ${pn},
										pagecount: ${ps},
										buttonClickCallback: $.gotoPageTwo
									});

								})
								
								// 页码跳转
								$.gotoPageTwo = function(id) {
									$("#pn").val(id);
									$("#myform").submit();
								}
							</script>
							<ul id="pager">

							</ul>
							<input type="hidden" id="pageSize" name="ps" value="${ps}" />
							<input type="hidden" id="pn" name="pn" value="${pn}" />
						</div>
					</div> 
				</div> 
				</#if>				
			</div>
		</div>
	</form>

</div>


<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="assets/js/date-time/bootstrap-timepicker.min.js"></script>

<script type="text/javascript">	
function orderchange(stat){
	if($(".statlist").hasClass("clicked")){
	return false;
	}
	$(".statlist").addClass("clicked");
	$.ajax({
		url:"json/order!change.action?type="+stat+"&id=${order.id}",
		success:function(html){			
			if(html!="-1"){
				$(".dropdown-toggle").removeClass("btn-success");
				$(".dropdown-toggle").addClass("btn-disabled");
				$(".dropdown-menu").remove();
				$("#pstat").html(html);
			}
			if(html=='已发货'){
				$('.txkddh-box').fadeIn();
			}
		}
	})

}

$(function() {
	
	$('.txkddh-closebtn').click(function(){
		$('.txkddh-box').fadeOut();
	})
	
	$('#txkddh-confirmbtn').click(function(){

		var user = {
           	carricompany:$('#kdgs').val(),
			carrino:$('#kddh').val()
        };
		$.ajax({
			url:"json/order!savecarry.action?&id=${order.id}",
			data:user,
			type:'post',
			success:function(html){
				if(html=="true"){
					$('.txkddh-box').fadeOut();
					self.location.reload();
				}
				
			}
		})
	})
	

	highlight();
	$('#begintime').datepicker({
		format:'yyyy-mm-dd',
		lang:'ch',
		step:10
	});
	$('#endtime').datepicker({
		format:'yyyy-mm-dd',
		lang:'ch',
		step:10
	});



});

//高亮
function highlight(){

	//获取当前月份
	var today=new Date();
	var month = today.getMonth() + 1;
	$("#thismonth").html(month);
	
	var pay_type = "${(pay_type)!}";
	var serve_type = "${(serve_type)!}";
	if(pay_type){
		$("#pay_type li").removeClass("on");
	}
	if(serve_type){
		$("#serve_type li").removeClass("on");
	}
	
	$("#pay_type li").each(function(){
		if($(this).data("type") == pay_type){
			$(this).addClass("on");
		}
	});
	
	$("#serve_type li").each(function(){
		if($(this).data("type") == serve_type){
			$(this).addClass("on");
		}
	});
}

//每页显示数目
$("#size").bind("change",function(){
	var size = $(this).val();
	var data={}, hash;
	if(window.location.href.indexOf('?')>=0){
	var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	}else{
		hashes = {};
	}
	var url = window.location.href.slice(0,window.location.href.indexOf('?')+1);
	for(var i = 0; i < hashes.length; i++)
	{
		hash = hashes[i].split('=');
		data[hash[0]] = hash[1];
	}

	data["size"] = size;
	var param = "";
	for(var key in data){
		param+=(key+"="+data[key]+"&");
	}	
	param = param.substring(0,param.length-1);
	if(window.location.href.indexOf('?')>=0){
		window.location.href=url+param;
	}else{
		window.location.href=url+"?"+param;
	}
})

//查询条件
$(".tfind li").bind("click", function(){
	$(this).parent().find("li").removeClass("on");
	$(this).addClass("on");
	
	var data = $(this).data("type");
	$(this).parent().find("input").val(data);
	
	gosearch();
});

//点击搜索按钮
$("#search_btn").bind("click", function(){

	//时间不能早于今天
	var today=new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	var day = today.getDate();
	var time = year;
	time += ((month < 10) ? "-0" : "-") + month + "";
	time += ((day < 10) ? "-0" : "-") + day + ""; 
	
	var begintime = $('#begintime').val();
	var endtime = $('#endtime').val();

	if(begintime > time){
		alert('开始时间不能大于今天');
		return false;
	}
	//if(endtime > time){
		//alert('结束时间不能大于今天');
		//return false;
	//}
	if((begintime !="" && endtime !="" && begintime > endtime)){
		alert('开始时间不能大于结束时间');
		return false;
	}
	
	gosearch();
	
});

//提交搜索
function gosearch(){
	$("#pn").val(0);
	$("#pageSize").val(0);
	$("#keyword").val('');
	$("#myform").submit();	
}

//重置
function goreset(){
	$('#begintime').val('');
	$('#endtime').val('');
	$('#pay_type').val('');
	$('#serve_type').val('');
	$('#keyword').val('');
	window.location.href="teamorder!list";
}

</script>
</body>
</html>

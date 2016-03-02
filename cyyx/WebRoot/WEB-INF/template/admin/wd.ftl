<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>提现详情 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />

<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
	<div class="page-content">
		<div class="page-header position-relative">
			<h1> <a href="wd!list.action"><i class="icon-flag" style="font-size:20px"></i> 提现列表</a> <small> <i class="icon-double-angle-right"></i> 提现查询
		        <!--修改活动信息-->
		        </small> </h1>
		        <div class="ace-settings-container" id="ace-settings-container"  style="  margin-top:-55px; ">
        <div class="btn-toolbar">
          <div class="btn-group">
            <button data-toggle="dropdown" class="btn btn-success btn-lg dropdown-toggle"> <i class="icon-cog bigger-120"></i> 变更订单状态 <i class="icon-angle-down icon-on-right"></i> </button>
            <ul class="dropdown-menu dropdown-success statlist">
            	<#if withdraw.stat = 0><li style="line-height:40px; height:40px; margin-top:-6px; "> <a href="javascript:orderchange(1)" style="line-height:40px; height:40px;"><span class="badge badge-success">&nbsp;</span> 变更为成功提现</a> </li></#if>
            	<#if withdraw.stat = 0 ><li style="line-height:40px; height:40px; margin-top:-6px; "> <a href="javascript:orderchange(-1)" style="line-height:40px; height:40px;"><span class="badge badge-success">&nbsp;</span> 取消提现</a> </li></#if>
            </ul>
          </div>
        </div>
      </div>
		</div>
	</div>

	<div class="tdata">
		<ul>
			<li>
				<img src="${base}/assets/img/tdata1.png">
				<h1>${withdraw.money}</h1>
				<p>提现金额（元）</p>
			</li>
			<li style="margin:0 6px;">
				<img src="${base}/assets/img/tdata3.png">
				<h1 id="pstat">
				<#if withdraw.stat = 0>
				申请中
				</#if>
				<#if withdraw.stat = 1>
				提现成功
				</#if>
				<#if withdraw.stat = -1>
				提现失败
				</#if>
				</h1>
				<p>提现状态</p>
			</li>
			<li style="margin:0 6px;">
				<img src="${base}/assets/img/tdata2.png">
				<h1>${(withdraw.username)!}</h1>
				<p>用户</p>
			</li>
		</ul>
	</div>

	<form id="myform" action="teamorder!list" method="post" class="noajax">
		<div class="tfind">	
			<table cellspacing="0" cellpadding="0" class="ttable">
				<tr>
					<td class="ltd" >
						收款人基本信息：${(withdraw.info)!}
					</td>
					
					
				</tr>
				<tr>
					<td class="ltd" colspan="2">
						申请时间：${withdraw.createDate?number_to_datetime?string("yyyy/MM/dd")}
					</td>
					
				</tr>
				<tr>
				<td class="ltd" colspan="3">
						操作记录：<#if withdraw.operlog??>${withdraw.operlog}<#else>-</#if>
					</td>
				
				</tr>
			</table>	
		</div>
		
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
				
			</div>
		</div>
	</form>

</div>


<script src="${base}/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${base}/assets/js/date-time/bootstrap-timepicker.min.js"></script>

<script type="text/javascript">	
function orderchange(stat){
	if($(".statlist").hasClass("clicked")){
	return false;
	}
	$(".statlist").addClass("clicked");
	$.ajax({
		
		url:"json/wd!change.action?stat="+stat+"&id=${withdraw.id}",
		success:function(html){
			if(html!="-1"){
				$(".dropdown-toggle").removeClass("btn-success");
				$(".dropdown-toggle").addClass("btn-disabled");
				$(".dropdown-menu").remove();
				$("#pstat").html(html);
			}
		}
	})

}
$(function() {
	
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

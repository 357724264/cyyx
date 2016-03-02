<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>订单管理 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
  <div class="page-content">
    <div class="page-header position-relative">
      <#if uid??>
      <h1> <a href="user!list.action"><i class="icon-flag" style="font-size:20px"></i> 用户列表</a> <small> <i class="icon-double-angle-right"></i> ${customer.name}的订单查询
		        <!--修改活动信息-->
		        </small> </h1>
      <#else>
      <h1> 订单管理</h1>
      </#if>
      <div class="ace-settings-container" id="ace-settings-container"  style="  margin-top:-55px; ">
       <div class="btn-toolbar">
          <div class="btn-group">
            <button class="btn btn-danger " onClick="location.href='excel!order.action?type=${type!}&uid=${uid}&begin=${begin}&end=${end}'"><i class="icon-edit"></i>
           	 导出
            <#if (!type??)||(type=="")>
           	 全部
            </#if>
            <#if type??&&type=="unpaid">
            未支付
            </#if>
            <#if type??&&type=="paid">
            已支付
            </#if>
            <#if type??&&type=="send">
            已发货
            </#if>
            <#if type??&&type=="free">
            已取消
            </#if>
            <#if type??&&type=="deal">
            已成交
            </#if>
                                    订单 
            </button>
           
          </div>
        </div>
      
      </div>
    </div>
    </div>
    <div class="clearfix"></div>
    <div class="widget-box" style="margin-top:0px;">
      <div class="widget-header header-color-blue2">
        <h4 class="lighter smaller">订单类型</h4>
      </div>
      <div class="widget-body" >
        <div class="widget-main">
          <div id="profile-feed-1" class="profile-feed" >
            <style>
			.profile-activity {
			border: 1px dotted #d0d8e0; margin-top:5px; 
			}.span2{ width:20%} .profile-active{ background-color:#d6ecfd;}
			</style>
			<div class="span2 profile-activity clearfix <#if (!type??)||(type=="")>profile-active</#if>">
              <div> <a class="user" href="order!list.action?uid=${uid}&begin=${begin}&end=${end}" >全部</a> </div>
            </div>
            <div class="span2 profile-activity clearfix <#if type??><#if type=="unpaid">profile-active</#if></#if>" id="ccidunpaid">
              <div> <a class="user" href="?type=unpaid&uid=${uid}&begin=${begin}&end=${end}" > 未支付 </a> </div>
            </div>
            <div class="span2 profile-activity clearfix <#if type??><#if type=="paid">profile-active</#if></#if>" id="ccidpaid">
              <div> <a class="user" href="?type=paid&uid=${uid}&begin=${begin}&end=${end}" > 已支付 </a> </div>
            </div>
            <div class="span2 profile-activity clearfix <#if type??><#if type=="send">profile-active</#if></#if>" id="ccidsend">
              <div> <a class="user" href="?type=send&uid=${uid}&begin=${begin}&end=${end}" > 已发货 </a> </div>
            </div>
            <div class="span2 profile-activity clearfix <#if type??><#if type=="free">profile-active</#if></#if>" id="ccidfree">
              <div> <a class="user" href="?type=free&uid=${uid}&begin=${begin}&end=${end}" > 已取消</a> </div>
            </div>
            <div class="span2 profile-activity clearfix <#if type??><#if type=="deal">profile-active</#if></#if>" id="cciddeal">
              <div> <a class="user" href="?type=deal&uid=${uid}&begin=${begin}&end=${end}" > 交易成功</a> </div>
            </div>
            <div class="clearfix"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="widget-header header-color-blue2" style="margin-top:20px;">
      <h4 class="lighter smaller">订单列表</h4>
    </div>
   <!-- 
    <form method="get" action="" id="unajax">
    <input type="hidden" value="${type}" name="type"/>
    <input type="hidden" value="${uid}" name="uid"/>
    <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
      <div class="row-fluid">
        <div class="span6" style="width:60%">
          <div id="sample-table-2_length" class="dataTables_length">
            <label >时间段：
           	<input type="text" name="begin" id="begin" value="${begin}" />-<input type="text" name="end" id="end" value="${end}" />
             <input id="itemsearchbtn" type="image" class="go" src="/assets/img/search_btn.gif" style="margin:0;margin-left:10px;">
            </label>
          </div>
          </div>
      </div>
      </form>
     -->
      <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
        <thead>
         <#if list??&&list?size lt 1>
                  <tr id="id1" class="odd" >
                    <td colspan="3"  style="font-size:24px; line-height:150px; height:150px; text-align:center"><#if nodeid??>分类下</#if>还没有任何订单！ </td>
				  </tr>
		<#else>
		 <tr>
		 	<th style="text-align:center">订单号</th>
            <th style="text-align:center">收货人</th>
            <th style="text-align:center">收货电话</th>
            <th style="text-align:center">收货地址</th>
            <th style="text-align:center">总金额</th>
            <th width=8%" style="margin-top:82px;text-align:center">支付状态</th>
            <th width=10%" style="text-align:center">下单时间</th>
            <th width=10%" style="text-align:center">支付时间</th>
            <th width="6%" style="text-align:center">备注</th>
          </tr>		  
				  </#if>
        </thead>
        <tbody role="alert" aria-live="polite" aria-relevant="all">
         <#list list as order>
          <tr class="<#if (order!index%2==0)>even<#else>odd</#if>" id="id${order.id}">
            <td class=" " style="text-align:center">${order.orderSn}</td>
            <td class=" " style="text-align:center">${order.name}</td>
            <td class=" " style="text-align:center">${order.phone}</td>
            <td class=" " style="text-align:center"> <#if order.scene==1>现场领取<#else>${order.address}</#if></td>
            <td class=" " style="text-align:center">${order.money}</td>
            <td class=" " style="text-align:center">
            <#if order.paymentStatus=="unpaid">
            	未支付
            </#if>
            <#if order.paymentStatus=="paid">
            	已支付
            </#if>
            <#if order.paymentStatus=="send">
            	已发货
            </#if>
            <#if order.paymentStatus=="free">
            	已取消
            </#if>
            <#if order.paymentStatus=="deal">
            	交易成功
            </#if>
            </td>
            <td class=" " style="text-align:center">${order.createDate?number_to_datetime?string("yyyy-MM-dd HH:mm")}</td>
            <td class=" " style="text-align:center"><#if order.payDate!=0>${order.payDate?number_to_datetime?string("yyyy-MM-dd HH:mm")}<#else>-</#if></td>
			<td class="td-actions" style="text-align:center"><div class="hidden-phone visible-desktop action-buttons">  <a class="green" href="order.action?id=${order.id}"  title="修改" > <i class="icon-pencil bigger-130"></i> </a><#if order.paymentStatus!="deal"><a class="red" href="javascript:deleteentity('order',${order.id},this,'no');" title="删除"><i class="icon-trash bigger-130"></i> </a></#if></div>
              <div class="hidden-desktop visible-phone">
                <div class="inline position-relative">
                  <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> <i class="icon-caret-down icon-only bigger-120"></i> </button>
                  <ul class="dropdown-menu dropdown-icon-only dropdown-yellow pull-right dropdown-caret dropdown-close">
                    <li> <a href="order!edit.action?id=${order.id}" class="tooltip-success" data-rel="tooltip" title="修改" data-original-title="Edit"> <span class="green"> <i class="icon-edit bigger-120"></i> </span> </a> </li>
                    <#if order.paymentStatus!="deal"><li> <a href="javascript:deleteentity('order',${order.id},this,'no');" class="tooltip-error" data-rel="tooltip" title="删除" data-original-title="Delete"> <span class="red"> <i class="icon-trash bigger-120"></i> </span> </a> </li></#if>
                  </ul>
                </div>
              </div></td>
          </tr>
          </#list>
        </tbody>
      </table>
      <div class="row-fluid">
        <div class="span6">
        </div>
        <!-- page -->
        <#if list??&&(ps gt 1)>
        <div class="span6">
          <div class="dataTables_paginate paging_bootstrap pagination">
            <#include "/WEB-INF/template/admin/pager.ftl" />
          </div>
         </div>  
         </#if> 
      </div>
    </div>
</div>
<script>
$(document).ready(function(){
	$("#filewjsc").bind("change",function(){
		
		if($(this).hasClass("clicked")){
			return;
		}
		$("#inbtn").attr("disabled","disabled");
		$("#inbtn").removeClass("btn-success").addClass("btn-fail");
		$(this).addClass("clicked");
		$.ajaxFileUpload({
                url:'order!xml.action',       //需要链接到服务器地址
                secureuri:false,
                fileElementId:'filewjsc',                            //文件选择框的id属性
                dataType: 'text/html',                                   //服务器返回的格式，可以是json
                success: function (data, textStatus) {
                	//兼容ie8以及以下版本
                	if(data.success){
                	alert("批量发货成功")
                	}
                	//兼容火狐、谷歌、ie8以上版本
                	var dat = eval("("+data+")");
                	if(dat.success){
                	alert("批量发货成功")
                	}
                	$(this).removeClass("clicked");
                	$("#inbtn").removeAttr("disabled");
                	$("#inbtn").removeClass("btn-fail").addClass("btn-success");
                	window.location.href="order!list.action?type=send";
                },
                error: function (data, status, e) {           //相当于java中catch语句块的用法
                }
            });
	});
})

$('#begin').datetimepicker({
			format:'Y-m-d H:i',
			lang:'ch',
			step:10
		});
$('#end').datetimepicker({
			format:'Y-m-d H:i',
			lang:'ch',
			step:10
		});
</script>
</body>
</html>

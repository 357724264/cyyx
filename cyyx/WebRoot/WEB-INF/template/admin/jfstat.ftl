<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>积分统计管理 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />

<link rel="stylesheet" href="${base}/assets/datenew/css/jquery-ui-1.9.2.custom.css" type="text/css">
<script src="${base}/assets/js/jquery.pager.js"></script>

<script type="text/javascript" src="${base}/assets/datenew/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${base}/assets/datenew/js/jquery-ui-1.9.2.custom.js"></script>
<script type="text/javascript" src="${base}/assets/datenew/js/share.js"></script>
<script src="${base}/assets/js/jquery.datetimepicker.js"></script>
<style>
  #sample-table-2 th{font-size:15px;}
  #ccidunpaid a{width:20%; display:inline-block; text-align:center; padding:10px 0; border:1px solid #c1c1c1;}
</style>
<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
  <div class="page-content">
    <div class="page-header position-relative">
      <h1> 积分核算</h1>
    </div>
    
    <div class="clearfix"></div>
    <div class="widget-header header-color-blue2" style="margin-top:20px;">
      <h4 class="lighter smaller" >积分核算</h4>
    </div>
    
   			
     <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
     <thead>
		 <tr>
            <th  width=25%">总积分：<#if jfstat??&&jfstat.jfintegral??>${jfstat.jfintegral}</#if> 分</th>
            <th  width=25%">已换积分：<#if jfstat??&&jfstat.jfconvert??>${jfstat.jfconvert}</#if> 分</th>
            <th  width=25%">已提现积分：<#if jfstat??&&jfstat.jfextract??>${jfstat.jfextract}</#if> 分</th>
            <th  width=25%">剩余积分：<#if jfstat??&&jfstat.jfbalance??>${jfstat.jfbalance}</#if> 分</th>
          </tr>		  
        </thead>
    </table>
    
    
    <form method="get" action="" id="unajax">
		<input type="hidden" value="${type}" name="type"/>
		<input type="hidden" value="${uid}" name="uid"/>
		<div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">            
            <div class="profile-activity clearfix" id="ccidunpaid">
            	<a class="user" href="?type=fl&begin=${begin}&end=${end}" > 返利积分</a> 
              <a class="user" href="?type=dh&begin=${begin}&end=${end}" > 已兑换积分</a>
              <a class="user" href="?type=tx&begin=${begin}&end=${end}" > 已提现积分</a>
			     </div>
                      
			
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
      </div>
      
      </form>
      

      <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
        <thead>
		 <tr>
            <th  width=25%">时间</th>
            <th  width=25%">用户</th>
            <th  width=25%">事项</th>
            <th  width=25%">状态</th>
          </tr>		  
        </thead>
        
        
		<#if jflist??&&jflist?size lt 1 || txlist??&&txlist?size lt 1 || jflist??&&txlist??>
                  <tr id="id1" class="odd" >
                    <td colspan="4"  style="font-size:24px; line-height:150px; height:150px; text-align:center">列表暂无信息！</td>
				  </tr>
		<#else>
        
			<#if jflist??>
			<#list jflist as jf>
			<tbody role="alert" aria-live="polite" aria-relevant="all">
				<td class=" " >${jf.createDate?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}</td>
				<td class=" " >${jf.userid}</td>
				<td class=" " ><#if jf.tt==0>积分发放</#if><#if jf.tt==-2>购物抵现</#if></td>
				<td class=" " >成功</td>
			</tbody>
          	</#list>
          	</#if>
          	<#if txlist??>
			<#list txlist as tx>
			<tbody role="alert" aria-live="polite" aria-relevant="all">
				<td class=" " >${tx.createDate?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}</td>
				<td class=" " >${tx.username}</td>
				<td class=" " >提现到<#if tx.tt==0>微信<#elseif tx.tt==1>银行卡</#if>：${tx.money} 元</td>
				<td class=" " ><#if tx.stat==0>申请中</#if>
								<#if tx.stat==1>提现成功</#if>
								<#if tx.stat==-1>申请失败</#if></td>
			</tbody>
          	</#list>
          	</#if>
          	
		</#if>
      </table>
     
      <div class="row-fluid">
        <div class="span6">
        </div>
        <!-- page -->
        <#if ps gt 0>
        <div class="span6">
          <div class="dataTables_paginate paging_bootstrap pagination">
            <#include "/WEB-INF/template/admin/pager.ftl" />
          </div>
         </div>  
         </#if> 
      </div>
    </div>
</div>

<script type="text/javascript">	


$(document).ready(function(){

	$('#statjf').bind('click',function(){
		var ttime = $(".ui-datepicker-time").val();
		$.ajax({
      type:'post',
			url:"jf!bulidstat.action?type="+ttime,
      success:function(html){
        if(html="1"){
          alert("ok")
        }
      },
      error:function(html){
        alert('数据错误，请联系管理员！');
      }
		})
	})
	
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

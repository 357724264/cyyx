<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>活动组团列表 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
<div class="page-content">
    <div class="page-header position-relative">
      <h1><i class="icon-laptop" style="font-size:20px"></i> 活动组团列表</h1>
    </div>
</div>
  <div class="clearfix"></div>
  

    <div class="clearfix"></div>
    
    <div class="widget-header header-color-blue2" style="margin-top:20px;">
  		<h4 class="lighter smaller">活动信息列表   ：<font color="#d0d0d0">${zongshu}条</font></h4>
  	</div>
    
  <div class="row-fluid">
    <div class="span12">
           
            <table id="sample-table-1" class="table table-striped table-bordered table-hover" >
              <thead>
               <#if list??&&list?size lt 1>
                  <tr id="id1" class="odd" >
                    <td colspan="3"  style="font-size:24px; line-height:150px; height:150px; text-align:center">还没有活动！ <button class="btn btn-danger" onClick="location.href='product!add.action'"><i class="icon-cloud-upload"></i>添加活动</button></td>
				  </tr>
				  <#else>
                <tr>
                  <th  width=20%">活动标题</th>
                  <th  width=12%">团长姓名</th>
                  <th  width="12%">参团人数/需求人数</th>
                  <th  width="22%">创建时间-结束时间</th>
                  <th  width="13%">组团资格/是否已支付</th>
                  <th  width="10%">是否已领取</th>
                 
                </tr>
                </#if>
              </thead>
              <tbody>
              	<#list mglist as ml>
                <tr id="id${ml.id}">
                	<td style="text-align:center"> <a class="green"  title="${ml.productname}" >${ml.productname}</a></td>
                	<td style="text-align:center">${ml.mastername}</td>
                	<td style="text-align:center"> ${ml.num}/${ml.minnum}</td>
                	<td style="text-align:center">${ml.createDate?number_to_datetime?string("yyyy/MM/dd")} - ${ml.endTime?number_to_datetime?string("yyyy/MM/dd")}</td>
                	<td style="text-align:center">${ml.zgmoney}元 / <#if ml.iszg==1>已支付<#else>
										<#if ml.num &lt; ml.minnum>未达资格领取<#else>未领取</#if>
									</#if></td>
					<td style="text-align:center"><#if isget==1>已领取<#else>未领取</#if></td>


                </tr>
                </#list>
              </tbody>
            </table>
         
      <!--/span-->
    </div>
  </div>
  
  
  		<#if mglist??>
 			<div class="span6">
          		<div class="dataTables_paginate paging_bootstrap pagination">
            	<#include "/WEB-INF/template/admin/pager.ftl" />
          		</div>
			</div> 
		</#if>
  
</div>
<!--/.row-fluid-->
</div>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>提现管理 -系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
  <div class="page-content">
    <div class="page-header position-relative">
      <h1> 提现管理</h1>
    </div>
    <div class="clearfix"></div>
    <div class="widget-box" style="margin-top:0px;">
      <div class="widget-header header-color-blue2">
        <h4 class="lighter smaller">提现状态</h4>
      </div>
      <div class="widget-body" >
        <div class="widget-main">
          <div id="profile-feed-1" class="profile-feed" >
            <style>
			.profile-activity {
			border: 1px dotted #d0d8e0; margin-top:5px; 
			}.span2{ width:20%} .profile-active{ background-color:#d6ecfd;}
			</style>
            <div class="span2 profile-activity clearfix <#if stat??><#if stat=0>profile-active</#if></#if>">
              <div> <a class="user" href="?stat=0" > 申请中 </a> </div>
            </div>
            <div class="span2 profile-activity clearfix <#if stat??><#if stat=1>profile-active</#if></#if>">
              <div> <a class="user" href="?stat=1" > 成功 </a> </div>
            </div>
            <div class="span2 profile-activity clearfix <#if stat??><#if stat=-1>profile-active</#if></#if>">
              <div> <a class="user" href="?stat=-1" > 取消 </a> </div>
            </div>
            <div class="clearfix"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="widget-header header-color-blue2" style="margin-top:20px;">
      <h4 class="lighter smaller">提现列表</h4>
    </div>
    <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
      <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
        <thead>
         <#if list??&&list?size lt 1>
                  <tr id="id1" class="odd" >
                    <td colspan="3"  style="font-size:24px; line-height:150px; height:150px; text-align:center"><#if tt??>该状态下</#if>还没有任何提现记录！</td>
				  </tr>
		<#else>
		 <tr>
            <th>用户名</th>
            <th>提现金额</th>
            <th>申请时间</th>
            <th>申请状态</th>
            <th style="width:100px;">操作</th>
          </tr>		  
				  </#if>
        </thead>
        <tbody role="alert" aria-live="polite" aria-relevant="all">
         <#list list as item>
          <tr class="<#if (item!index%2==0)>even<#else>odd</#if>" id="id${item.id}">
            <td class=" " >${item.username}</a> </td>
            <td class=" " >${item.money}</a> </td>
            <td class=" " >${item.createDate?number_to_datetime?string("yyyy-MM-dd HH:mm")}</a> </td>
            <td>
            <#if item.stat=0>
            	申请中
            </#if>
            <#if item.stat=1>
            	申请成功
            </#if>
            <#if item.stat=-1>
            	申请失败
            </#if>
            </td>
			<td class="td-actions "><div class="hidden-phone visible-desktop action-buttons">  <a class="green" href="wd!edit.action?id=${item.id}"  title="查看" > <i class="icon-pencil bigger-130"></i> </a></div>
              <div class="hidden-desktop visible-phone">
                <div class="inline position-relative">
                  <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> <i class="icon-caret-down icon-only bigger-120"></i> </button>
                  <ul class="dropdown-menu dropdown-icon-only dropdown-yellow pull-right dropdown-caret dropdown-close">
                    <li> <a href="wd!edit.action?id=${item.id}" class="tooltip-success" data-rel="tooltip" title="查看" data-original-title="Edit"> <span class="green"> <i class="icon-edit bigger-120"></i> </span> </a> </li>
                  </ul>
                </div>
              </div></td>
          </tr>
          </#list>
        </tbody>
      </table>
      <#if list??&&list?size gt 0>
      <div class="row-fluid">
        <div class="span6">
        </div>
       </#if>
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
</body>
</html>

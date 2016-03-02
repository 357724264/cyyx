<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>产品管理 - 系统管理中心</title>
<#assign admin = adminSystemClass />
<#include "/WEB-INF/template/admin/header.ftl" />
<style>
			.profile-activity {
			border: 1px dotted #d0d8e0; margin-top:5px; 
			}.span2{ width:20%} .profile-active{ background-color:#d6ecfd;}
      .newz{position:relative; display:inline; background:#dc5087; top:-5px; padding:0px 3px; border-radius:4px; color:#fff; left:10px; font-style:normal;}
      @font-face { font-family: "iconfont"; src: url('/home/fonts/iconfont.eot'); /* IE9*/ src: url('/home/fonts/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */ url('/home/fonts/iconfont.woff') format('woff'), /* chrome、firefox */ url('/home/fonts/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/ url('/home/fonts/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */ }
      .erweima-small{position:relative;}
      .erweima-small .small-img{font-family:"iconfont"; font-style:normal; display:block; cursor:pointer; text-align:center; font-size:18px;}
      .small-box{width:180px; height:180px; box-shadow:1px 1px 2px #ddd,-1px -1px 2px #ddd; padding:10px; box-sizing:border-box; position:absolute; top:-80px; left:-190px;z-index:99; background-color:#fff; transition: 0.5s all;
    -webkit-transition: 0.5s all; -moz-transition: 0.5s all; -o-transition: 0.5s all; -ms-transition: 0.5s all; opacity:0}
      .small-box img{width:100%; height:100%;}
      .small-box em{font-style:normal; font-size:30px; position:absolute; right:-9px; top:90px; color:#fff; z-index:3;}
      .small-box span{ position:absolute; right:-10px; font-size:30px; top:90px; color:#ddd; z-index:2}
      .small-img:hover+.small-box{opacity:1;}
			</style>

<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
  <div class="page-content">
    <div class="page-header position-relative">
      <h1> 产品管理</h1>
      <div class="ace-settings-container" id="ace-settings-container"  style="  margin-top:-55px; ">
        <div class="btn-toolbar">
         
           
          <!-- /btn-group -->
          <div class="btn-group">
            <button class="btn btn-danger " onClick="location.href='mallproduct!add.action'"><i class="icon-edit"></i>添加产品</button>
          </div>
        </div>
      </div>
    </div>
    <div class="clearfix"></div>

  
    <div class="widget-header header-color-blue2" style="margin-top:20px;">
      <h4 class="lighter smaller">产品列表</h4>
    </div>
    <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
      <div class="row-fluid">
        
    <!--
        <div class="span6">
          <div class="dataTables_filter" id="sample-table-2_filter">
            <label>搜索:
            <input type="text" id="search" attr-pro="productName"  aria-controls="sample-table-2" value="${keyword!}">
             <input id="searchbtn" type="image" class="go" src="/assets/img/search_btn.gif" style="margin:0;margin-left:-12px;">
            </label>
          </div>
        </div>
     -->
      </div>
      <table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
        <thead>
         <#if list??&&list?size lt 1>
                  <tr id="id1" class="odd" >
                    <td colspan="3"  style="font-size:24px; line-height:150px; height:150px; text-align:center">还没有添加产品！ <button class="btn btn-danger" onClick="location.href='mallproduct!add.action'"><i class="icon-cloud-upload"></i>添加产品</button></td>
				  </tr>
		<#else>
		 <tr>
            <th class="center" style="width:50px;"> <label>
              <input type="checkbox" class="allcheck"/>
              <span class="lbl"></span> </label>
            </th>
            <th>产品名称</th>
            <th>产品标题</th>
            <th style="width:50px;">二维码</th>
            <th style="width:50px;">排序</th>
            <th style="width:100px;">操作</th>
          </tr>		  
				  </#if>
        </thead>
        <tbody role="alert" aria-live="polite" aria-relevant="all">
         <#list list as mp>
          <tr class="" id="id${mp.id}">
            <td class="center  sorting_1"><label>
              <input type="checkbox" class="cc" attr-id="${mp.id}">
              <span class="lbl"></span> </label>
            </td>
            <td class="" ><a href="mallproduct!edit.action?id=${mp.id}"  id="title${mp.id}">${mp.name}</a></td>
			<td class="" ><a href="#"  id="title${mp.id}">${mp.title}</a></td>
            <td class="erweima-small">
              <i class='small-img' date-src=" ">&#xe62d;</i>
              <div class='small-box'>
                <img src='http://admin.wudianyi.com//secure!qrcode.action?bf=http://${mp.systemid}.wudianyi.com/mallproduct.action?id=${mp.id}' />
                <em>&#9670;</em>
                <span>&#9670;</span>
              </div>
            </td>
            
            <td>${mp.orderById!"0"}</td>
			<td class="td-actions "><div class="hidden-phone visible-desktop action-buttons">  <a class="green" href="mallproduct!edit.action?id=${mp.id}"  title="修改" > <i class="icon-pencil bigger-130"></i> </a> <a class="red" href="javascript:deleteentity('mallproduct',${mp.id},this,'no');" title="删除"> <i class="icon-trash bigger-130"></i> </a>  <!-- <a class="green" href="sale.action?id=${mp.id}" title="销售状况"> <i class="icon-gift bigger-130"></i> </a> --> </div>
              <div class="hidden-desktop visible-phone">
                <div class="inline position-relative">
                  <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> <i class="icon-caret-down icon-only bigger-120"></i> </button>
                  <ul class="dropdown-menu dropdown-icon-only dropdown-yellow pull-right dropdown-caret dropdown-close">
                    <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="展示" data-original-title="View"> <span class="blue"> <i class="icon-zoom-in bigger-120"></i> </span> </a> </li>
                    <li> <a href="mallproduct!edit.action?id=${mp.id}" class="tooltip-success" data-rel="tooltip" title="修改" data-original-title="Edit"> <span class="green"> <i class="icon-edit bigger-120"></i> </span> </a> </li>
                    <li> <a href="javascript:deleteentity('mallproduct',${mp.id},this,<#if mp.entity??>'yes'<#else>'no'</#if>);" class="tooltip-error" data-rel="tooltip" title="删除" data-original-title="Delete"> <span class="red"> <i class="icon-trash bigger-120"></i> </span> </a> </li>
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
          <div class="hidden-phone visible-desktop action-buttons" style="margin-left:15px;">
            <label>
            <input type="checkbox" class="allcheck">
            <span class="lbl"></span> </label>
            <a class="red" href="javascript:getdeleteall('mallproduct');" title="删除"> <i class="icon-trash bigger-130"></i> </a>  </div>
          <div class="hidden-desktop visible-phone">
            <div class="inline position-relative">
              <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> <i class="icon-caret-down icon-only bigger-120"></i> </button>
              <ul class="dropdown-menu dropdown-icon-only dropdown-yellow pull-right dropdown-caret dropdown-close">
                <li> <a href="javascript:getdeleteall();" class="tooltip-error" data-rel="tooltip" title="删除" data-original-title="Delete"> <span class="red"> <i class="icon-trash bigger-120"></i> </span> </a> </li>
              </ul>
            </div>
          </div>
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
<script type="text/javascript">
  $(function(){
    $(document).on('click','.erweima-small',function(){

    })
  })
</script>
</body>
</html>

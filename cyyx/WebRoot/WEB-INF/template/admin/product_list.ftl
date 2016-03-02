<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>活动管理 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
<div class="page-content">
    <div class="page-header position-relative">
      <h1><i class="icon-laptop" style="font-size:20px"></i> 活动管理</h1>
	   <div class="ace-settings-container" id="ace-settings-container"  style=" margin-right:15px; margin-top:-45px; ">
              <div class="btn-group">
                <button class="btn btn-danger btn-block" onClick="location.href='product!add.action'"><i class="icon-cloud-upload"></i>添加活动</button>
              </div>
            </div>
    </div>
</div>
  <div class="clearfix"></div>
  

    <div class="clearfix"></div>
    
    <div class="widget-header header-color-blue2" style="margin-top:20px;">
  		<h4 class="lighter smaller">活动信息列表</h4>
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
                  <th  width="20%">活动标题</th>
                  <th  width=35%">活动简介</th>
                  <th  width=35%">活动链接</th>
                  <th  width="10%">活动排序</th>
                  <th >操作</th>
                </tr>
                </#if>
              </thead>
              <tbody>
              	<#list list as product>
                <tr id="id${product.cid}">
                  <td> <a class="green" href="product!edit.action?id=${product.cid}"  title="${product.title}" >${product.title}</a></td>
                  <td >${product.intro}</td>
                  <td> ${product.systemid}.wudianyi.com/product.action?id=${product.cid}</td>
                  <td>${product.orderById}</td>
                  <td><div class="hidden-phone visible-desktop btn-group">
                      <button class="btn btn-mini btn-info"  onClick="window.location.href='product!edit.action?id=${product.cid}';" title="活动详情"> <i class="icon-edit bigger-120"></i> </button>
                      <button class="btn btn-mini btn-danger" onclick="deleteentity('product',${product.cid},this,'no')" title="删除本活动"> <i class="icon-trash bigger-120"></i> </button>
                      <button class="btn btn-mini btn-info"  onClick="window.location.href='product!mygrounplist.action?id=${product.cid}';" title="本活动热度"> <i class="icon-star bigger-120"></i> </button>
                      </div>
                  </td>
                </tr>
                </#list>
              </tbody>
            </table>
         
      <!--/span-->
    </div>
  </div>
</div>
<!--/.row-fluid-->
</div>
</body>
</html>

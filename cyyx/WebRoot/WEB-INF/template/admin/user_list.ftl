<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>会员管理 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
  <div class="page-content " >
    <div class="page-header position-relative">
      <h1> <a href="user!list.action"><i class="icon-flag" style="font-size:20px"></i> 会员管理</a></h1>
    </div>
  </div>
  <div class="clearfix"></div>
  <div class="widget-header header-color-blue2" style="margin-top:20px;">
  	<h4 class="lighter smaller">会员信息列表  (现有${usernumber}人)</h4>
  </div>
  <!--
  <div id="sample-table-2_wrapper" class="dataTables_wrapper" role="grid">
  <div class="row-fluid">
        <div class="span6">
          <div id="sample-table-2_length" class="dataTables_length">
            <label >显示
            <select size="1" id="size" name="sample-table-2_length" aria-controls="sample-table-2">
              <option value="10" <#if size==10>selected="selected"</#if>>10</option>
              <option value="25"<#if size==25>selected="selected"</#if>>25</option>
              <option value="50"<#if size==50>selected="selected"</#if>>50</option>
              <option value="100"<#if size==100>selected="selected"</#if>>100</option>
            </select>
            记录</label>
          </div>
        </div>
        <div class="span6">
          <div class="dataTables_filter" id="sample-table-2_filter">
            <label>搜索:
            <input type="text" id="search" attr-pro="name"  aria-controls="sample-table-2" value="${keyword!}">
             <input id="searchbtn" type="image" class="go" src="/assets/img/search_btn.gif" style="margin:0;margin-left:-12px;">
            </label>
          </div>
        </div>
      </div>
     -->
  	<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
		<thead>
		<#if list??&&list?size lt 1>
			<tr id="id1" class="odd" >
				<td colspan="3"  style="font-size:24px; line-height:150px; height:150px; text-align:center">还没有会员加入！ </td>
			</tr>
		<#else>
			<tr >
				<th  width=15%" style="text-align:center">电话</th>
				<th  width=15%" style="text-align:center">是否已关注</th>
				<th  width=15%" style="text-align:center">注册时间</th>
				<th  width=15%" style="text-align:center">积分</th>
				<th  style="text-align:center">备注</th>
 				<th  width=13%" style="text-align:center">操作</th>
			</tr>
		</#if>
		</thead>
		<tbody role="alert" aria-live="polite" aria-relevant="all">
		<#list list as user>
			<tr id="id${user.cid}" class="<#if (user_index)%2==0>odd<#else>even</#if>" >
				<td style="text-align:center">${user.name}</td>
				<td style="text-align:center"><#if user.issub==1>已关注<#else>未关注</#if></td>
				<td style="text-align:center"><#if user.createDate??>${user.createDate}<#else>--</#if></td>
				<td style="text-align:center">${user.point}</td>
				<td style="text-align:center">${user.note}</td>
				<td style="text-align:center">
					<div class="hidden-phone visible-desktop action-buttons">						
						<a class="green" href="user!edit.action?id=${user.cid}"  title="修改" >
							<i class="icon-pencil bigger-130"></i>
						</a>
						<a class="green" href="down!list.action?id=${user.cid}"  title="查看" > <i class="icon-users bigger-120"></i> </a> 
						<a class="green" href="user!list.action?up=${user.cid}&ll=one"  title="助力团员" > <i class="icon-asterisk bigger-120"></i> </a>
						<a class="green" href="order!list.action?uid=${user.cid}"  title="订单" > <i class="icon-gift bigger-120"></i> </a>
					</div>
                	<div class="hidden-desktop visible-phone">
                		<div class="inline position-relative">
                			<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">
                				<i class="icon-caret-down icon-only bigger-120"></i>
                			</button>
                			<ul class="dropdown-menu dropdown-icon-only dropdown-yellow pull-right dropdown-caret dropdown-close">  
                            	<li>
									<a href="user!edit.action?id=${user.cid}" class="tooltip-success" data-rel="tooltip" title="修改" data-original-title="Edit">
										<span class="green">
											<i class="icon-edit bigger-120"></i>
										</span>
									</a>
								</li>
								<li>
									<a href="javascript:deleteentity('user',${user.cid},this,'no');" class="tooltip-error" data-rel="tooltip" title="删除" data-original-title="Delete">
										<span class="red">
											<i class="icon-trash bigger-120">
											</i>
										</span>
									</a>
								</li>
							</ul>
                        </div>
                      </div>
					</td>
				</tr>
			</#list>
			</tbody>
		</table>
		<div class="row-fluid">
			<div class="span6">
				<div class="hidden-phone visible-desktop action-buttons" style="margin-left:15px;">
            	</div>
          		<div class="hidden-desktop visible-phone">
            		<div class="inline position-relative">
              			<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">
							<i class="icon-caret-down icon-only bigger-120"></i>
						</button>
              			<ul class="dropdown-menu dropdown-icon-only dropdown-yellow pull-right dropdown-caret dropdown-close">
                			<li>
								<a href="javascript:getdeleteconfirm(1,'yes');" class="tooltip-error" data-rel="tooltip" title="删除" data-original-title="Delete">
									<span class="red">
										<i class="icon-trash bigger-120"></i>
									</span>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
       		<#if list??&&(ps gt 1)>
        	<div class="span6">
          		<div class="dataTables_paginate paging_bootstrap pagination">
            	<#include "/WEB-INF/template/admin/pager.ftl" />
          		</div>
         	</div> 
         </#if>
    </div>
  </div>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>用户管理 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">
  <div class="page-content">
    <div class="page-header position-relative">
      <h1> <a href="user!list.action"><i class="icon-flag" style="font-size:20px"></i> 用户管理</a> <small> <i class="icon-double-angle-right"></i> 添加用户信息
        </small> </h1>
      <div class="ace-settings-container" id="ace-settings-container"  style=" margin-right:15px; margin-top:-45px; ">
        <div class="btn-group">
          <button class="btn btn-success btn-block" onClick="javascript:history.go(-1);"><i class="icon-cloud-upload"></i>返回上一页</button>
        </div>
      </div>
    </div>
  
    <div class="widget-box" style="margin-top:-12px; ">
      <div class="widget-header header-color-blue2">
        <h4 class="lighter smaller">用户信息<!--修改用户信息--></h4>
      </div>
      <!--/.page-header-->
      <div id="user-profile-2" class="user-profile row-fluid" style="border: 1px solid #d0d8e0; ">
        <div class="tabbable">
          <div class="tab-content no-border padding-24">
            <!--tab home-->
            <div id="home" class="tab-pane in active">
			 <#if id??>
             <#assign isEdit=true>
             <#else>
             <#assign isEdit=false>
             </#if>
             </div>
                  <form class="form-horizontal"  method="post" type="post" action="json/user!update.action" >
            <style>
            .control-label{height:40px;line-height:25px;font-size:16px;}
            </style>
              <div class="row-fluid">
               <input type="hidden" value="${id!}" name="id" />
                  <div class="space space-6"></div>
                </div>
                
                  <div class="control-group">
                    <label class="control-label" for="form-field-1">头像：</label>
                    <div class="controls" style="font-size:14px;">
                       <img class="editable" alt="Alex's Avatar" id="filepreview" src="<#if user??><#if user.pic!=null&&user.pic!=""&&user.pic!="/">${user.pic}<#else>assets/img/home.jpg</#if><#else>assets/img/home.jpg</#if>"  style="width:360px;height:200px;" />
   						<input type="file" id="file" name="file" style="*font-size:120px;opacity:0;filter:alpha(opacity=0);"/>
   						<input type="hidden" value="${(user.pic)!}" name="smallurl" id="smallurl"/>
                    </div>
                  </div>
                
                <div class="span12 " style="padding-left:-40px; margin-left:0px;">
                    <div class="control-group"> 
                    	<label class="control-label" for="name">名字：</label>
                   		<div class="controls">
                    		<input type="text" id="name" name="name" value="${(user.name)!}" placeholder="" class="span4 validate[required,minSize[2]]" style="height:40px;line-height:30px;font-size:16px;" />
                    	</div>
                    	
                  	</div>
                  	<div class="control-group"> 
                  		<label class="control-label" for="phone">手机：</label>
                    	<div class="controls">
                      		<input type="text" id="phone" name="phone" value="${(user.phone)!}" placeholder="" class="span4 validate[required,custom[phone]]" style="height:40px;line-height:30px;font-size:16px;" />
                    	</div>
                  	</div>
                  	<div class="control-group">
                    <label class="control-label" for="sex">性别：</label>
                    <div class="controls">
                      <select id="sex" name="sex" class="span4" style="height:40px;line-height:30px;font-size:16px;">
                        <option value="0" <#if user??><#if user.sex==0>selected="selected"</#if></#if>>女</option>
                        <option value="1" <#if user??><#if user.sex==1>selected="selected"</#if></#if>>男</option>
                      </select>
                    </div>
                  </div>
                  
                  <div class="control-group"> 
                    <label class="control-label" for="pwd">密码：</label>
                    <div class="controls">
                      <input type="password" id="password" name="password" value="${user.password}" placeholder="" class="span4 validate[minSize[6]]" style="height:40px;line-height:30px;font-size:16px;" />
                    </div>
                  </div>
                  <div class="control-group"> 
                    <label class="control-label" for="address">注册时间：</label>
                    <div class="controls">
                      <input type="text" id="createDate" name="createDate" value="${(user.createDate)!}" placeholder="" class="span4 validate[maxSize[20]" style="height:40px;line-height:30px;font-size:16px;" />
                    </div>
                  </div>
                  <div class="control-group"> 
                    <label class="control-label" for="address">微信ID：</label>
                    <div class="controls">
                      <input type="text" id="weixinid" name="weixinid" value="${(user.weixinid)!}" placeholder="" class="span4  style="height:40px;line-height:30px;font-size:16px;" />
                    </div>
                  </div>
                  
                   <div class="control-group"> 
                    <label class="control-label" for="address">积分数：</label>
                    <div class="controls">
                      <input type="text" id="point" name="point" value="${(user.point)!}" placeholder="" class="span4 validate[maxSize[20]" style="height:40px;line-height:30px;font-size:16px;" />
                    </div>
                  </div>
                  <div class="control-group"> 
                    <label class="control-label" for="address">魅力指数：</label>
                    <div class="controls">
                      <input type="text" id="charm" name="charm" value="${(user.charm)!}" placeholder="" class="span4 validate[maxSize[20]" style="height:40px;line-height:30px;font-size:16px;" />
                    </div>
                  </div>
                  
                  <div class="control-group"> 
                    <label class="control-label" for="pwd">email：</label>
                    <div class="controls">
                      <input type="text" id="email" name="email" value="${(user.email)!}" placeholder="" class="span7 validate[custom[email]]" style="height:40px;line-height:30px;font-size:16px;" />
                    </div>
                  </div>
                  <div class="control-group"> 
                    <label class="control-label" for="pwd">备注：</label>
                    <div class="controls">
                      <input type="text" id="intro" name="intro" value="${(user.intro)!}" placeholder="" class="span7" style="height:40px;line-height:30px;font-size:16px;" />
                    </div>
                  </div>
				
				</div>
					  <div class="control-group" style="padding-top:10px;">
						  <div class="controls"> 
						      <input type="submit" class="btn btn-danger span3" value="修改。"/><font color="#FF0000">  修改请谨慎！</font>
						  </div>
					  </div>
                  
				  </div>
				  
              </div>
			  </form>
            </div>
            <!--/tab home-->
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--/.page-content-->
</div>
<script type="text/javascript">	
$("form").validationEngine();
$(function() {
//another option is using modals
				$('#file').bind("change",function(){
				fileupload();
				});
			});
function fileupload(){
		$.ajaxFileUpload({
                url:'upload.action',       //需要链接到服务器地址
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
                		$('#file').bind("change",function(){
                			fileupload();
                		})		
                	}
                	//兼容火狐、谷歌、ie8以上版本
                	var dat = eval("("+data+")");
                	if(dat.success){
                		$("#pic").val("http://"+window.location.host+"/"+dat.bigurl);
                		$("#filepreviewcontent").show();
                		$("#filepreview").attr("src",dat.bigurl);
                		$('#file').bind("change",function(){
                			fileupload();
                		})	
                	}
                },
                error: function (data, status, e) {           //相当于java中catch语句块的用法
                    $('#imgPath').val('');
                }
            });
		}
		
	
</script>
</body>
</html>

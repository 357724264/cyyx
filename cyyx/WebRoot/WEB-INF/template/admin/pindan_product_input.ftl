<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>活动管理 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />
<script src="${base}/assets/js/geo.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/assets/css/manhuaDate.1.0.css">

<script type="text/javascript" src="${base}/assets/js/manhuaDate.1.0.js"></script>
<script type="text/javascript">
$(function (){

  $("input.mh_date").manhuaDate({                
    Event : "click",//可选               
    Left : 0,//弹出时间停靠的左边位置
    Top : -16,//弹出时间停靠的顶部边位置
    fuhao : "-",//日期连接符默认为-
    isTime : false,//是否开启时间值默认为false
    beginY : 2014,//年份的开始默认为1949
  });
  
});
</script>

<style>
  @font-face { font-family: "iconfont"; src: url('/home/fonts/iconfont.eot'); /* IE9*/ src: url('/home/fonts/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */ url('/home/fonts/iconfont.woff') format('woff'), /* chrome、firefox */ url('/home/fonts/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/ url('/home/fonts/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */ } .controls{position:relative;} .shanchu{position:absolute; left:200px; top:0; width:30px; height:30px; line-height:30px; text-align:center; background-color:red; color:#fff; font-size:1.4rem;} .shanchu{cursor: pointer;} .fhdd-set{padding-top:7px;} .fhdd-set label{display:inline-block; margin-right:8px;} .fhdd-set label input{opacity:1 !important; position:relative !important; top:-2px; margin:0; margin-right:3px; padding:0;} .provinces .provinces-box{display:inline-block; border:1px solid #d0d0d0; width:170px; padding:5px 5px; margin-right:10px; margin-bottom:6px; position:relative;} .provinces .provinces-box input{position:absolute; opacity:0 !important; top:0px; left:0;} .provinces .provinces-box .icon-radio{width:18px; height:18px; display:block;} .provinces .provinces-box .icon-radio.icon-empty{background:url(/assets/images/icon-empty.png) no-repeat; background-size:cover;} .provinces .provinces-box .icon-radio.icon-half{background:url(/assets/images/icon-half.png) no-repeat; background-size:cover;} .provinces .provinces-box .icon-radio.icon-full{background:url(/assets/images/icon-full.png) no-repeat 1px 1px; background-size:16px 16px;} .provinces .provinces-box a{position:absolute; top:0; left:0; padding-left:30px; width:100%; height:100%; box-sizing:border-box; line-height:28px; text-decoration:none;} .provinces .provinces-box .provinced-count{display:inline-block; color:#333;} .citys label{display:inline-block; border:1px solid #d0d0d0; padding:3px 5px; margin-right:10px; margin-bottom:6px; position:relative;} .citys label input{position:absolute; opacity:0 !important; top:0px; left:0;} .citys label .icon-selt{width:18px; height:18px; position:relative; top:4px; position:relative; background:url(/assets/images/icon-empty.png) no-repeat; margin-right:3px; background-size:cover;} .citys label input[type=checkbox]:checked+.icon-selt{background:url(/assets/images/icon-check.png) no-repeat; background-size:18px 18px;} .user-profile .form-horizontal .control-label{ width:180px !important; } .label-checkbox{ width:100%; height:40px; line-height:40px; display:block; margin:0; padding:0; position:relative; background-color:#fff; font-weight:100; font-size:14px; } .inp-ckb{ visibility:hidden; position:relative; z-index:0 } .inp-default{ width:40px; text-align:center; height:100%; position:absolute; top:0; left:0; z-index:2 } .inp-default .icon-form{ font-size:20px; line-height:40px; color:#c1c1c1; font-style:normal; font-family:"iconfont"; } .inp-ckb:checked+.inp-default .icon-form{ color:#f15353; } .inp-inner{ position:absolute; width:100%; height:100%; padding-left:40px; top:0; left:0; }
   #cpcs-box th, #cpcs-box td{
    border:0;
    border:1px solid #c1c1c1;
  } 
  #cpcs-box .col-3{
    width:205px;
  }
  #cpcs-box input{
    border:0;
    width:100%;
    height:100%;
    padding:0;
    box-sizing:border-box;
    outline:none;
    -webkit-appearance:none;
  }
  #cpcs-box .c-btnbox{
    border:0;
  }
  .close-cpcsbtn{
    width:40px;
    color:#fff;
    text-align:center !important;
    cursor:pointer;
    background-color:#CC3333;
  }
  #cpcs-box .c-btnbox button{
    width:100%;
    height:40px;
  }
</style>

<div class="main-content" style="width:1008px; margin:0 auto; margin-top:10px;">

	<div class="page-content">
  <div class="page-header position-relative">
      <h1> <a href="product!list.action"><i class="icon-laptop" style="font-size:20px"></i>活动管理</a> <small> <i class="icon-double-angle-right"></i> 编辑活动 </small> </h1>
	    <div class="ace-settings-container" id="ace-settings-container"  style=" margin-right:15px; margin-top:-45px; ">
              <div class="btn-group">
                <button class="btn btn-success btn-block" onClick="location.href='pindan_product!list.action'"><i class="icon-cloud-upload"></i>返回上一页</button>
              </div>
            </div>
    </div>
	  <div class="alert alert-block alert-success" style="line-height:30px;">
			<button type="button" class="close" data-dismiss="alert"> <i class="icon-remove"></i> </button>
			<i class="icon-ok green"></i> 温馨提醒：<br/>1、建议活动图尺寸比例为3:5最佳，以458*627px为例，大小不超过300KB。
	  </div>
	
  
    <!--/.page-header-->
    <div id="user-profile-2" class="user-profile row-fluid">
      <div class="tabbable">
       
        <div class="tab-content padding-24">
          <!--tab home-->
          <div id="home" class="tab-pane in active">
		 
            <div class="row-fluid">
             <#if id??>
             <#assign isEdit=true>
             <#else>
             <#assign isEdit=false>
             </#if>
              <div class="span12" style="margin-top:30px;">
                <form class="form-horizontal" class="mindform" type="post" action="<#if isEdit>json/pindan_product!update.action<#else>json/pindan_product!save.action</#if>" />
            <style>
            .control-label{height:40px;line-height:25px;font-size:16px;}
            </style>
                 <input type="hidden" name="id" value="${id!}" />
                 
                 <#if product??&&product.cid??>
                 <div class="control-group">
                  <label class="control-label" for="title">活动链接：</label>
                  <div class="controls" style="line-height:38px; text-indent:3px;">
                  	${product.systemid}.wudianyi.com/product.action?id=${product.cid}
                  </div>
                </div>
                </#if>
                
                <div class="control-group">
                  <label class="control-label" for="title">活动标题：</label>
                  <div class="controls">
                    <input type="text" name="title" id="title" placeholder="" value="${(product.title)!}" class="span6 validate[required]" style="height:40px;line-height:30px;font-size:16px;width:500px;"/>
                  </div>
                </div>
               
               	<div class="control-group"> 
               		<label class="control-label" for="hdjj">活动简介：</label>
                    <div class="controls">
                    	<input type="text" id="intro" name="intro" placeholder="" value="${(product.intro)!}" class="span8" style="height:40px;line-height:30px;font-size:16px;width:500px;" />
                	</div>
                </div>
              
              
               <div class="control-group">
                  <label class="control-label" for="cpmc">视频链接：</label>
                  <div class="controls">
                    <input type="text" id="pvideo" name="videoLink" placeholder="若无视频可不填写" value="${(product.videoLink)!}" class="span8" style="height:40px;line-height:30px;font-size:16px;width:500px;"/>
                  </div>
                </div>
               
               
               <div class="control-group">
                	<label class="control-label" for="form-field-1">列表缩略图：</label>
                	<div class="controls" style="line-height:40px;">
               			<img class="editable" alt="Alex's Avatar" id="file99-filepreview" src="<#if product??&&product.thumbnails??>${product.thumbnails}<#else>${base}/assets/img/cqpic.jpg</#if>"  style="width:229px;height:147px; " />
                		<input type="file" id="file99" name="file" class="fileupload" style="width:257px;height:126px;margin-left:-262px;opacity:0;margin-top:0;*font-size:80px;"/>
                		<input id="file99-pic" type="hidden"  name="thumbnails" value="${(product.thumbnails)!}"/>
                		<br/>（缩略图建议使用11:10图片，正方形亦可，大小不超过300KB。）
                	</div>
                </div>


				<div class="control-group">
                	<label class="control-label" for="form-field-1">活动说明：</label>
                	<div class="controls" style="line-height:40px;">
               			<img class="editable" alt="Alex's Avatar" id="file98-filepreview" src="<#if product??&&product.instruction??>${product.instruction}<#else>${base}/assets/img/cqpic.jpg</#if>"  style="width:355px;height:220px; " />
                		<input type="file" id="file98" name="file" class="fileupload" style="width:355px;height:220px;margin-left:-360px;opacity:0;margin-top:0;*font-size:80px;"/>
                		<input id="file98-pic" type="hidden"  name="instruction" value="${(product.instruction)!}"/>
                		<br/>（活动说明建议使用6:4图片，大小不超过300KB。）
                	</div>
                </div>



               
                <div class="control-group">
                  <label class="control-label" for="title">活动排序：</label>
                  <div class="controls">
                    <input type="text" name="displayOrder" id="displayOrder" placeholder="数字越大越靠前" value="${(product.displayOrder)!}" class="span4 validate[required]" style="height:40px;line-height:30px;font-size:16px;"/>
                  </div>
                </div>
                
                 <div class="control-group">
                  <label class="control-label" for="cpmc">产品名称：</label>
                  <div class="controls">
                    <input type="text" name="name" id="name" placeholder="" value="${(product.name)!}" class="span4 validate[required]" style="height:40px;line-height:30px;font-size:16px;"/>
                  </div>
                </div>
               
                <div class="control-group"  style="padding-bottom:10px;">
               		<label class="control-label" for="productgg">产品规格：</label>
                    <div class="controls"   style="font-size:14px;">
                    	<#if product??&&product.specifications??>
                    		<#list product.specifications as ggg>
                    		<input type="text" id="gginput${ggg_index}"  value="${ggg}" class="span2 gginput"  style="height:40px;width:170pxline-height:30px;font-size:16px;"  src="/assets/img/search_btn.gif" style="margin:0;margin-left:-12px;"/>
                   			<img id="ggclose1" class="theclose" attr-input="gginput${ggg_index}"  src="/assets/img/delete.png" style="margin:0;margin-left:-45px;" />	
                    		</#list>
                   		<#else>
                    		<input type="text" id="gginput1"  value="" class="span2 gginput"  style="height:40px;width:170px;line-height:30px;font-size:16px;"  src="/assets/img/search_btn.gif" style="margin:0;margin-left:-12px;"/>
                   			<img id="ggclose1" class="theclose" attr-input="gginput1"  src="/assets/img/delete.png" style="margin:0;margin-left:-45px;" />	
                    	</#if>
                    	<img src="${base}/assets/img/add.png" style="height:40px;weigth:40px" id="addgg">
                    	<input type="hidden" value="${(product.specification)!}" name="specification" id="gg" />
					</div>
				</div>
				
				
				<div class="control-group">
                  <label class="control-label" for="title">商品原价：</label>
                  <div class="controls">
                    <input type="text" name="price" id="rawmoney" placeholder="" value="${(product.price)!}" class="span4 validate[required]" style="height:40px;line-height:30px;font-size:16px;"/>
                 	元
                  </div>
                </div>
               	
              <div class="control-group">
              <label class="control-label" for="productgg">拼单方式：</label>
              <div class="controls" style="font-size:14px;">
                <table class="table" id="cpcs-box">
                  <tr>
                    <th class="col-3">拼单人数</th>
                    <th>拼单价格</th>
                    <th></th>
                  </tr>
                  <tr>
                 	<#if product??&&product.numOfPeopleList??&&product.pindanPriceList>
                 		<#list product.numOfPeopleList as qua>
                 			<tr>
                    				<td class='col-lg-3'><input type="text" class="qinput" value="${qua}" placeholder='请输入参数名' /></td>
                    		<#list product.pindanPriceList as min>
                    			<#if "${qua_index}"=="${min_index}">
                    				<td><input type="text" class='minput' id=minput${min_index} value="${min}" placeholder='请输入参数描述' /></td>
                    			</#if>
                    		</#list>
                    		<td class="close-cpcsbtn">删除</td>
                    		</tr>
                    	</#list>
                    <#else>
                    	<td class='col-lg-3'><input type="text" class="qinput" placeholder='请输入人数' /></td>
                    	<td><input type="text" class="minput" placeholder='请输入价格' /></td>
                    	<td class="close-cpcsbtn">删除</td>
                    </#if>
                  </tr>
                  <tr>
                    <td class="c-btnbox"><button type="button" id="add-cpcsbtn">新增拼单方式</button></td>
                    <input type="hidden" value="${(product.numOfPeople)!}" name="numOfPeople" id="quality" />
                    <input type="hidden" value="${(product.pindanPrice)!}" name="pindanPrice" id="minutia" />
                  </tr>
                </table>
              </div>
            </div>
               	
               	
                <div class="control-group">
                  <label class="control-label" for="zlt">拼单有效时限：</label>
                  <div class="controls">
                    <input type="text" name="days" id="zltime" placeholder="" value="${(product.days)!}" class="span4 validate[required]" style="height:40px;line-height:30px;font-size:16px;"/>
                  	天
                  </div>
                </div>
                
                 
                 <div class="control-group">
                  <label class="control-label" for="zlt">总活动结束时间：</label>
                  <div class="controls">
                  	<#if product??&&product.endDate??>
                 		<input type="text" class="mh_date span6" name="endDate" id="endtime" readonly="true" value="${product.endDate?string("yyyy-MM-dd")}" style="height:40px;line-height:30px;font-size:16px;" />
                  	<#else>
                  		<input type="text" class="mh_date span6" name="endDate" id="endtime" readonly="true" value="${(product.endDate)!}" style="height:40px;line-height:30px;font-size:16px;" />
                  	 </#if>
                  </div>
                </div>
               
				<#assign ii=0 >
               
				<#if product??&&product.imageList??>
				<#list product.imageList as image> 
				<#assign ii=ii+1>
				<div class="control-group">
                	<label class="control-label" for="form-field-1">活动轮询图片：</label>
                	<div class="controls" style="line-height:40px;">
               			<img class="editable" alt="Alex's Avatar" id="file${image_index+1}-filepreview" src="<#if product??><#if image??>${image}<#else>${base}/assets/img/cqproduct.jpg</#if><#else>${base}/assets/img/cqproduct.jpg</#if>"  style="width:355px;height:200px; " />
                		<input type="file" id="file${image_index+1}" name="file" class="fileupload" style="width:319.5px;height:180px;margin-left:-323px;opacity:0;margin-top:0;*font-size:80px;"/>
                		<input id="file${image_index+1}-pic" type="hidden"  name="images" value="${image}"/>
                		<br/>（建议活动图尺寸比例为7:4最佳，以710*400px为例，大小不超过300KB。）
                		
                		<span class="shanchu sdel" style="margin-left:157px;" >×</span>
                	</div>
                </div>
                </#list>
                </#if>
                
                <#if ii!=5>
                <#list 1..(5-ii) as iii>
                 <div class="control-group">
                  <label class="control-label" for="form-field-1">活动轮询图片：</label>
                  <div class="controls" style="line-height:40px;">
                   <img class="editable" alt="Alex's Avatar" id="file${ii+iii}-filepreview" src="${base}/assets/img/cqproduct.jpg"  style="width:319.5px;height:180px; " />
                	<input type="file" id="file${ii+iii}" name="file" class="fileupload" style="width:319.5px;height:180px;margin-left:-323px;opacity:0;margin-top:0;*font-size:80px;"/>
                	<input id="file${ii+iii}-pic" type="hidden"  name="images"/>
                	<br/>（建议活动图尺寸比例为7:4最佳，以710*400px为例，大小不超过300KB。）
                	</div>
                	
                </div>
                </#list>
                </#if>
                
                
                <#if id??>
             		<#assign isEdit=true>
             	<#else>
             		<#assign isEdit=false>
             	</#if>
                <div class="control-group">
                  <label class="control-label" for="mrly">默认团长留言：</label>
                  <div class="controls">
                    <textarea  id="pdlmessage" name="pdlmessage" placeholder="${systemClass.cdlmessage}" style="height:130px;line-height:20px;font-size:15px;width:50%; padding:8px; box-sizing:border-box;" class="userlm"></textarea>
                  </div>
                </div>
                
                <div class="control-group">
                  <label class="control-label" for="mrfxy">默认团长分享语：</label>
                  <div class="controls">
                  	<textarea  id="pdsmessage" name="pdsmessage"  placeholder="${systemClass.cdsmessage}" style="height:130px;line-height:20px;font-size:15px;width:50%; padding:8px; box-sizing:border-box;"  class="usersm"></textarea>
                  </div>
                </div>
                
                
                
                
                <hr style="border:1px dashed #c1c1c1">
                </br>
                

              
                
                
                
                
                <div class="control-group"> 
               		<label class="control-label" for="sjjf">上级获得积分：</label>
                    <div class="controls">
                    	<input type="text" id="jfOne" name="jfOne" value="${(product.jfOne)!}" placeholder="" class="span4" style="height:40px;line-height:30px;font-size:16px;" />%.(按团购价的比例，给予上一级相应的积分)
                	</div>
                </div>
				
               
           
                
                <div class="control-group" style="padding-top:30px;">
                  <div class="controls"> <input type="submit" class="btn btn-danger span3" value="保存"/></div>
                </div>
                </form>
              </div>
            </div>
          </div>
          <!--/tab home-->
        
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
				$('.fileupload').bind("change",function(){
				var id = $(this).attr("id");
				fileupload(id);
				
				});
        //删除项
      $(".sdel").click(function() {
          var btn = $(this);
          var id = btn.prevAll('img').attr('id');
          var picid=btn.prevAll('input').attr('id');
          $('#'+id).attr('src','${base}/assets/img/product.jpg');
          $('#'+picid).attr('value','')
          // $.ajax({
          //     type: "POST",
          //     url: URL,
          //     data: "id="+ id,
          //     success: function(msg) {
          //         if (msg == 1) {
          //             alert("删除成功!");
          //             id.attr('src','${base}/assets/img/product.jpg');
          //         } else {
          //             alert("操作失败!");
          //             return false;
          //         }
          //     }
          // });
        
        });
        
        
        
       
      
       

        
        
    	
		var cont2='${(product.pdlmessage)!}'.replace(/<br>/g,"\n");
      $('#pdlmessage').text(cont2);

   		var cont3='${(product.pdsmessage)!}'.replace(/<br>/g,"\n");
      $('#pdsmessage').text(cont3);
    
  });
function fileupload(id){
		$.ajaxFileUpload({
                url:'upload.action',       //需要链接到服务器地址
                secureuri:false,
                fileElementId:id,                            //文件选择框的id属性
                dataType: 'text/html',                                   //服务器返回的格式，可以是json
                data:{width:'549', length:'327'},
                success: function (data, textStatus) {
                //兼容ie8以及以下版本
                	if(data.success){
                		$("#"+id+"-pic").val("http://"+window.location.host+"/"+data.bigurl);
                		//$("#filepreviewcontent").show();
                		$("#"+id+"-filepreview").attr("src","/"+data.bigurl);
                		$('#'+id).bind("change",function(){
                			fileupload();
                		})	
                	}
                	//兼容火狐、谷歌、ie8以上版本
                	var dat = eval("("+data+")");
                	if(dat.success){
              
                		$("#"+id+"-pic").val("http://"+window.location.host+"/"+dat.bigurl);
                		//$("#filepreviewcontent").show();
                		$("#"+id+"-filepreview").attr("src","/"+dat.bigurl);
                		$('#'+id).bind("change",function(){
                			fileupload();
                		})	
                	}
                },
                error: function (data, status, e) {           //相当于java中catch语句块的用法
                    $('#imgPath').val('');
                }
            });
		}
	$("form").validationEngine();
		<#if product??&&product.specifications??>
			var ggnum = ${product.specifications?size};
		<#else>
			var ggnum = 1;
		</#if>

			
		<#if product??&&product.numOfPeopleList??>
			var qnum = ${product.numOfPeopleList?size};
		<#else>
			var qnum = 1;
		</#if>
		
		
		<#if product??&&product.pindanPriceList??>
			var mnum = ${product.pindanPriceList?size};
		<#else>
			var mnum = 1;
		</#if>
		
	$(function() {
		$('#file').bind("change",function(){
			fileupload();
		});
		$("#addgg").bind("click",function(){
			ggnum ++ ;
			$(this).before('<input type="text" id="gginput'+ggnum+'" class="span2 gginput"  style="height:40px;width:170px;line-height:30px;font-size:16px;"  src="/assets/img/search_btn.gif" style="margin:0;margin-left:-12px;"/><img id="ggclose'+ggnum+'" attr-input="gginput'+ggnum+'" class="theclose" src="/assets/img/delete.png" style="margin:0;margin-left:-45px;">')
		});
	
	});

	$(document).on("blur", ".gginput", function(){
		var ss = "";
		for(var i=0;i<$(".gginput").length;i++){
			ss = ss+"--"+$(".gginput").eq(i).val();
		}
		ss = ss.substring(2);
		$("#gg").val(ss);
	})
	

	
	$(document).on("click", ".theclose", function(){
		var theinput = $(this).attr("attr-input");
		$("#"+theinput).remove();
		$(this).remove();
		var ss = "";
		for(var i=0;i<$(".gginput").length;i++){
			ss = ss+"--"+$(".gginput").eq(i).val();
		}
		ss = ss.substring(2);
		$("#gg").val(ss);
	})
	
	
			
	$(document).on("blur",".qinput", function(){
		var qq = "";
		for(var i=0;i<$(".qinput").length;i++){
			qq +="--"+$(".qinput").eq(i).val();
		}
		qq = qq.substring(2);
		$("#quality").val(qq);
	})
	
	
	$(document).on("blur", ".minput", function(){
		var mm = "";
		for(var i=0;i<$(".minput").length;i++){
			mm +="--"+$(".minput").eq(i).val();
		}
		mm = mm.substring(2);
		$("#minutia").val(mm);
	})
	
	
	
	$(document).on("click", ".close-cpcsbtn", function(){
    $(this).parent('tr').remove();
		var qq = "";
		var mm = "";
		for(var i=0;i<$(".qinput").length;i++){
			qq = qq+"--"+$(".qinput").eq(i).val();
		}
		for(var i=0;i<$(".minput").length;i++){
			mm = mm+"--"+$(".minput").eq(i).val();
		}
		qq = qq.substring(2);
		mm = mm.substring(2);
		$("#quality").val(qq);
		$("#minutia").val(mm);
	})
	
	
	function initallprovince(){
	 var provinces = dsy.Items["0"];
	 var length = provinces.length;
	 for(var i=0;i<length;i++){
	 	var html = '<div class="provinces-box';
	 	if(i == 0){
	 		html+=' selected';
	 	}
	 	html+='"><i class="icon-radio icon-empty"></i><input type="checkbox" class="city_1" value="0_'+i+'" /><a href="javascript:;">'+provinces[i]+'<div class="provinced-count">(<span id="selected_0_'+i+'">0</span>/<span id="all_0_'+i+'">10</span>)</div></a></div>';
	 	$(".provinces").append(html);
	 }
	
	
	$(".provinces-box.selected").trigger("click");
	}	
	
	initallprovince();




$(document).ready(function() { 
 // 任何需要执行的js特效 
 $("table tr:nth-child(even)").addClass("even"); 
 
 $('#add-cpcsbtn').click(function(){
    var html= '<tr>'+
                '<td class="col-lg-3"><input type="text" class="qinput" placeholder="请输入参数名" /></td>'+
                '<td><input type="text" class="minput" placeholder="请输入参数描述" /></td>'+
                '<td class="close-cpcsbtn">删除</td>'+
              '</tr>';
    $(this).parent().parent('tr').before(html);
  })
}); 




		</script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>系统默认设置 - 系统管理中心</title>
<#include "/WEB-INF/template/admin/header.ftl" />


<style>
  @font-face { font-family: "iconfont"; src: url('/home/fonts/iconfont.eot'); /* IE9*/ src: url('/home/fonts/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */ url('/home/fonts/iconfont.woff') format('woff'), /* chrome、firefox */ url('/home/fonts/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/ url('/home/fonts/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */ } .controls{position:relative;} .shanchu{position:absolute; left:200px; top:0; width:30px; height:30px; line-height:30px; text-align:center; background-color:red; color:#fff; font-size:1.4rem;} .shanchu{cursor: pointer;} .fhdd-set{padding-top:7px;} .fhdd-set label{display:inline-block; margin-right:8px;} .fhdd-set label input{opacity:1 !important; position:relative !important; top:-2px; margin:0; margin-right:3px; padding:0;} .provinces .provinces-box{display:inline-block; border:1px solid #d0d0d0; width:170px; padding:5px 5px; margin-right:10px; margin-bottom:6px; position:relative;} .provinces .provinces-box input{position:absolute; opacity:0 !important; top:0px; left:0;} .provinces .provinces-box .icon-radio{width:18px; height:18px; display:block;} .provinces .provinces-box .icon-radio.icon-empty{background:url(/assets/images/icon-empty.png) no-repeat; background-size:cover;} .provinces .provinces-box .icon-radio.icon-half{background:url(/assets/images/icon-half.png) no-repeat; background-size:cover;} .provinces .provinces-box .icon-radio.icon-full{background:url(/assets/images/icon-full.png) no-repeat 1px 1px; background-size:16px 16px;} .provinces .provinces-box a{position:absolute; top:0; left:0; padding-left:30px; width:100%; height:100%; box-sizing:border-box; line-height:28px; text-decoration:none;} .provinces .provinces-box .provinced-count{display:inline-block; color:#333;} .citys label{display:inline-block; border:1px solid #d0d0d0; padding:3px 5px; margin-right:10px; margin-bottom:6px; position:relative;} .citys label input{position:absolute; opacity:0 !important; top:0px; left:0;} .citys label .icon-selt{width:18px; height:18px; position:relative; top:4px; position:relative; background:url(/assets/images/icon-empty.png) no-repeat; margin-right:3px; background-size:cover;} .citys label input[type=checkbox]:checked+.icon-selt{background:url(/assets/images/icon-check.png) no-repeat; background-size:18px 18px;} .user-profile .form-horizontal .control-label{ width:180px !important; } .label-checkbox{ width:100%; height:40px; line-height:40px; display:block; margin:0; padding:0; position:relative; background-color:#fff; font-weight:100; font-size:14px; } .inp-ckb{ visibility:hidden; position:relative; z-index:0 } .inp-default{ width:40px; text-align:center; height:100%; position:absolute; top:0; left:0; z-index:2 } .inp-default .icon-form{ font-size:20px; line-height:40px; color:#c1c1c1; font-style:normal; font-family:"iconfont"; } .inp-ckb:checked+.inp-default .icon-form{ color:#f15353; } .inp-inner{ position:absolute; width:100%; height:100%; padding-left:40px; top:0; left:0; }
</style>

<div class="main-content" style="width:1008px;margin:0 auto; margin-top:10px;">
	<div class="page-content">
		<div class="span6" style=" width:100%;margin:10px auto; " >
		  <div class="widget-header header-color-blue2"  style="height:60px;" >
    			<h3 class="lighter smaller" style=" line-height:60px;">系统默认团长留言、分享语</h3>
  		</div>
  		<form action="${base}/json/config!setup.action" method="post">
			<div style=" height:auto;margin:-4px auto; width:98%; border:4px solid #999999; " >
				<div class="form-horizontal" role="form"  style="margin-top:20px; padding-bottom:10px; width:75%; float:left;">
					
					
				<div class="control-group">
                	<label class="control-label" for="title">默认团长留言：</label>
   					<div class="controls">
                    <textarea  id="cdlmessage" name="cdlmessage" placeholder="请填写默认团长留言"  style="height:130px;line-height:20px;font-size:15px;width:80%; padding:8px; box-sizing:border-box;" class="userlm" ></textarea>
                    <label class="label-checkbox">
                      <input type='checkbox' class="inp-ckb" id="cly">
                      <div class='inp-default'>
                          <i class='icon-form'>&#xe61c;</i>
                      </div>
                      <div class="inp-inner">使用默认系统留言</div>
                    </label>
                  </div>
                </div>
                	
               		
					 
                <div class="control-group">
                  <label class="control-label" for="title">默认团长分享语：</label>
                  <div class="controls">
                  	<textarea  id="cdsmessage" name="cdsmessage" placeholder="请填写默认团长分享语"  style="height:130px;line-height:20px;font-size:15px;width:80%; padding:8px; box-sizing:border-box;"  class="usersm"></textarea>
                    <label class="label-checkbox">
                      <input type='checkbox' class="inp-ckb" id="cfx">
                      <div class='inp-default'>
                          <i class='icon-form'>&#xe61c;</i>
                      </div>
                      <div class="inp-inner">使用默认系统分享语</div>
                    </label>
                  </div>
                </div>
					
					<div class="control-group">
						<div class="controls">
						   <input id="loading-btn" type="submit" class="btn btn-success " style="font-size:20px; " data-loading-text="提交中..." value="确认编辑" />		</div>
						</div>
					</div>
					<div class="clearfix"></div>
			 </div>
		</div>
		</form>
   </div>
</div>

<script src="${base}/assets/js/bootstrap-tag.min.js"></script>

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${base}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->


<script src="${base}/assets/js/typeahead-bs2.min.js"></script>

<!--page specific plugin scripts-->
<!--ace scripts-->
<script src="${base}/assets/js/x-editable/bootstrap-editable.min.js"></script>
<script src="${base}/assets/js/x-editable/ace-editable.min.js"></script>
<script src="${base}/assets/js/jquery.maskedinput.min.js"></script>



<script>
$("form").validationEngine();
$(function() {
//another option is using modals
	$('#avatar1').bind('click', function(){
		$("#file").trigger("click");
	});
	$('#file').bind("change",function(){
	fileupload();
	});
});





$(function(){


		var lm = "亲，您好！ 非常感谢有您的支持助力，我真的很感动，虽然很多人会觉得这不算什么大事，但您这一行动足以让我终生难以忘记，让我深深感受到爱的力量的，这礼品很好，我真的很喜欢，谢谢！";
		var sm = "我最亲爱的朋友们，我正在参加一个很有趣的产品，希望你能帮我助力。谢谢。"
        
        $('#cly').bind('click',function(){
				if($(this).is(':checked')){
					$('.userlm').val(lm);
					$('#ly-text').attr('readonly','readonly');
				}else{
					$('.userlm').val("");
					$('#ly-text').removeAttr('readonly');
				}
			})
			
			$('#cfx').bind('click',function(){
				if($(this).is(':checked')){
					$('.usersm').val(sm);
					$('#ly-rdotext').attr('readonly','readonly');
				}else{
					$('.usersm').val("");
					$('#ly-rdotext').removeAttr('readonly');
				}
			});
        
      var cont1='${(systemClass.cdlmessage)!}';
      $('#cdlmessage').text(cont1);
     
      var cont2='${(systemClass.cdsmessage)!}';
      $('#cdsmessage').text(cont2);

  });
        
        
function initallprovince(){
	 var provinces = "";
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
                		$("#codeUrl").val("http://"+window.location.host+"/"+data.bigurl);
				$("#avatar1").attr("src",data.bigurl);
				$('#file').bind("change",function(){
					fileupload();
				})	
                	}
                	//兼容火狐、谷歌、ie8以上版本
                	
			var dat = eval("("+data+")");
			if(dat.success){
				$("#codeUrl").val("http://"+window.location.host+"/"+dat.bigurl);
				$("#avatar1").attr("src","/"+dat.bigurl);
				$('#file').bind("change",function(){
					fileupload();
				})	
			}
		}
	});
}


$(function(){

$("form").ajaxForm({
	type:"post",
	beforeSubmit: function(){
		
	},
   	success: function(data){
   		var dat = data;
   		if(dat.success){
   			bootbox.alert('<br><center><font style="font-weight:700; font-size:18px;text-algin:center;" class="green"><i class="icon-ok bigger-120"></i> '+'修改成功!'+'</font></center><br>', function() {
				location.href = dat.url;
			});			
		}else{
			bootbox.alert('<br><center><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;" class="red"> <i class="icon-ban-circle bigger-120"></i> '+'修改失败,请查看是否登录成功!'+' </font></center><br>');
		}
		return false;
   	}
});
})


</script>

</body>
</html>

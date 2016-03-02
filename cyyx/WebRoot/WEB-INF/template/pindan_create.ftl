<!doctype html>
<html>
<head>
	<title>发起人留言</title>
	<meta charset="utf-8">
	<meta name="keywords" content=""> <!-- seo网站关键字 -->
	<meta name="description" content=""> <!-- seo对网站的文字描述 -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<!-- IE使用最新渲染模式，chrome框架使用webkit内核 -->
	<meta name='renderer' content="webkit">
	<!-- 让360浏览器使用webkit内核 -->
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<!-- 让屏幕1：1缩放，并且在移动设备上禁止放大缩小 -->

	<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
	<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.${base}/home/js/1.4.2/respond.min.js"></script>
    <![endif]-->
        	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript" src="http://mp.weixin.qq.com/debug/zh_CN/htmledition/js/jsapisign/sha121d415.js"></script>
    
    <link rel="stylesheet" type="text/css" href="${base}/home/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
   	   	<script type="text/javascript" src="${base}/home/js/basis.js"></script>
   	 <#assign systemClass=frontSystemClass />
    <script>	
   		function urlencode(str) {  
		    str = (str + '').toString();   
		    return encodeURIComponent(str).replace(/!/g, '%21').replace(/'/g, '%27').replace(/\(/g, '%28').  
		    replace(/\)/g, '%29').replace(/\*/g, '%2A').replace(/%20/g, '+');  
		} 
   		var appId = '${systemClass.appId}'; 
   		var jsapi_ticket = '${tick}';
		var timestamp = "1";
		var nonceStr = '5K8264ILTKCH16CQ2502SI8ZNMTM67VS';
		var theUrl = document.URL;
		var string2 = 'jsapi_ticket=' + jsapi_ticket + '&noncestr=' + nonceStr + '&timestamp=' + timestamp + '&url=' + theUrl; 
		var signature2 = new jsSHA(string2,"TEXT"); //签名算法
		signature2 = signature2.getHash("SHA-1","HEX");	
		var jsApiList = ['chooseWXPay'];
		//通过config接口注入权限验证配置
		wx.config({
		    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId: appId, // 必填，公众号的唯一标识
		    timestamp: timestamp, // 必填，生成签名的时间戳
		    nonceStr: nonceStr, // 必填，生成签名的随机串
		    signature: signature2, // 必填，签名，见附录1
		    jsApiList: jsApiList // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
   	</script>
   	<script type="text/javascript">
   		$(document).ready(function(){
   			
   			var lm = '${(product.pdlmessage)!}';
   			var sm = '${(product.pdsmessage)!}';
   		
			
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
			
		
			
			
			
			$(".common-btn").bind("click",function(){
				
				$(this).addClass("clicked");
				 
				var hasChk = $('#cly').is(':checked');
				if(!hasChk){lm = $(".userlm").val();}
				var shasChk = $('#sfx').is(':checked');
				if(!shasChk){sm = $(".usersm").val();}
				
				$.ajax({
					url:"json/mypindan!create.action",
					data:{lm:lm,pid:${pid},price:${price},numOfPeople:${numOfPeople},sm:sm},
					type:"post",
					success:function(html){
						var dat = eval("("+html+")");
						
							if(dat.success){
								var oid = dat.message;
								if(dat.paySign!=null){
								var paySign = dat.paySign;
		 						var preid = dat.preid;
		 						wx.chooseWXPay({
									appId: appId,
								    timestamp: timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
								    nonceStr: nonceStr, // 支付签名随机串，不长于 32 位
								    package: 'prepay_id='+preid, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
								    signType: 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
								    paySign: paySign, // 支付签名
								    success: function (res) {
								    	window.location.href="tuan.action?tid="+oid
								    }
								});
							}else{
								window.location.href="tuan.action?tid="+oid	
							}
						}else{
							alert(dat.msg);
							window.location.href="center!mygrounp.action";
						}
					}
				})
			})
			
   		})
   	</script>

</head>
<body class="head_body">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="javascript:history.go(-1);"><i>&#xe611;</i></a></div>
            <div class='header-title'>团长留言</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
           
        </div>
    </div>

    <div class='container-fluid'>
        <div class="row">
        
            	<div class="ly-group">
                	<textarea id='ly-text' placeholder='请输入留言' class="userlm"></textarea>
             	<label class="label-checkbox">
             		<input type='checkbox' class="inp-ckb" id="cly">
             		<div class='inp-default'>
                		<i class='icon-form'>&#xe61c;</i>
             		</div>
             		<div class="inp-inner">默认系统留言</div>
             	</label>
            </div>
            
            <div class="ly-group">
                <div class='lyg-1'>
                    <textarea id='ly-rdotext' placeholder='请输入分享语' class="usersm"></textarea>
                    <label class="label-checkbox">
                        <input type='checkbox' class="inp-ckb" id="cfx">
                        <div class='inp-default'>
                            <i class='icon-form'>&#xe61c;</i>
                        </div>
                        <div class="inp-inner">默认系统分享语</div>
                    </label>
                </div>
            </div>
            <div class="btn-group" >
                <button class="common-btn">我要拼单[需支付${product.price}元]</button>
            </div>
        </div>
    </div>
    <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>
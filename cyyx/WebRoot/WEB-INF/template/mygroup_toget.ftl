
<!doctype html>
<html>
<head>
	<title>领取奖品</title>
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
    
    <link rel="stylesheet" type="text/css" href="${base}/home/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/dist/css/framework7.ios.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
    <!-- 数量加减 start -->
    <script type="text/javascript" src="${base}/home/js/jquery.Spinner.js"></script>
   	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript" src="http://mp.weixin.qq.com/debug/zh_CN/htmledition/js/jsapisign/sha121d415.js"></script>
     <#assign systemClass=frontSystemClass />
    <script>	
   		function urlencode(str) {  
		    str = (str + '').toString();   
		    return encodeURIComponent(str).replace(/!/g, '%21').replace(/'/g, '%27').replace(/\(/g, '%28').  
		    replace(/\)/g, '%29').replace(/\*/g, '%2A').replace(/%20/g, '+');  
		} 
   		var appId = '${systemClass.appId}'; 
   		var jsapi_ticket = '${tick}';
		var accessToken = '${webaccesstoken}'
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
        $(function(){ 
       		$("#wxpay").bind("click",function(){
	     			topay("wx")
	     	});
	     	$("#pointpay").bind("click",function(){
	     			if($(this).hasClass("noenough")){
	     				alert("积分不足");
	     				return false;
	     			}
	     			topay("point");
	     	})          
          $("#getbtn").bind("click",function(){
          	if($(this).hasClass("clicked")){
          		return false;
          	}
          	$(this).addClass("clicked");
          	var thesize = $("#thesize").val();
     		var addressid = <#if address??>"${address.id}"<#else>""</#if>;
     		$.ajax({
				url:"json/pay!tuan.action",
				data:{gid:"${id}",thesize:thesize,num:1,tt:"<#if mygrounp.minnum lte mygrounp.num>zutuan<#else>pingdan</#if>",ptype:"free",addressid:addressid},
				type:"post",
				success:function(html){
					var dat = eval("("+html+")");
					if(dat.success){
						alert("领取提交成功!");
						window.location.href="order.action?id="+dat.message;
					}else{
						alert(dat.msg);
					}
					}
				});
			});
        });
        function topay(tt){
     			var thesize = $("#thesize").val();
     		var addressid = <#if address??>"${address.id}"<#else>""</#if>;
			$.ajax({
				url:"json/pay!tuan.action",
				data:{gid:"${id}",thesize:thesize,num:1,tt:"pingdan",ptype:tt,addressid:addressid},
				type:"post",
				success:function(html){
					var dat = eval("("+html+")");
					if(dat.success){
						if(tt=="wx"){
							var paySign = dat.paySign;
	 						var preid = dat.preid;
	 						var oid = dat.oid;
	 						wx.chooseWXPay({
								appId: appId,
							    timestamp: timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
							    nonceStr: nonceStr, // 支付签名随机串，不长于 32 位
							    package: 'prepay_id='+preid, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
							    signType: 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
							    paySign: paySign, // 支付签名
							    success: function (res) {
							    	window.location.href="order.action?id="+oid
							    }
							});
						}else{
							alert("支付成功!")
							window.location.href="order.action?id="+dat.message;
						}
					}else{
						alert(dat.msg);
					}
				}
			})
     	}
    </script>
    <!-- 数量加减 end -->
</head>
<body style="padding-top:3.65rem;">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="#"><i>&#xe611;</i></a></div>
            <div class='header-title'>领取奖品</div>
            <div class='right-link'><a href="#"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class='container-fluid'>
        <div class="row">
            <div class='pay-addrbox'>
                <#if address??>
                <a href='address!list.action?tt=zt&tid=${id!}'>
                    <h5 class="p-adr-lx">${address.name} ${address.phone}</h5>
                    <p class='p-adr-dz'>${address.address}</p>
                    <i class='p-adr-jt'>&#xe609;</i>
                </a>
                <#else>
                <a href='address!list.action?tt=zt&tid=${id}' class="go-tianj">去添加一个地址</a>
                </#if>
            </div>

            <div class="pay-pro-inf">
                <div class="p-headbox">
                    <div class="p-h-img">
                        <img src="images/200017.jpg" />
                    </div>
                    <div class='p-tit'>
                        <p>${address.address}</p>
                        <#if (mygrounp.minnum lte mygrounp.num)||(mygrounp.failpay lte 0)>
                        	<span class='p-pic'>价格：￥ 0元</span>
                        <#else>
                        	<span class='p-pic'>价格：￥ ${mygrounp.failpay}元</span>
                        </#if>
                        <span class='p-cout'>数量：x1</span>
                    </div>
                </div>
                <div class='p-set-box'>
                <#if product.ggs??&&((product.ggs)!size gt 0)>
                    <div class='p-set-group'>
                        <label>规格：</label>
                        <div class='p-set-g-box'>
                            <select id="thesize">
                            	<#list product.ggs as gg>
                                <option value="${gg}">${gg}</option>
                            	</#list>
                            </select>
                        </div>
                    </div>
                 </#if>   
                </div>
            </div>
			<#if (mygrounp.minnum lte mygrounp.num)||(mygrounp.failpay lte 0)>
            <div class="btn-group">
                <button class="common-btn" id="getbtn">确认</button>
            </div>
            <#else>
             <div class="m-da-listbox">
                <div class='m-da-list' id="wxpay">
                    <a href="#">
                        <label><i>&#xe627;</i>微信支付[需支付${mygrounp.failpay}元]</label>
                        <span class="m-da-d"><i>&#xe609;</i></span>
                    </a>
                </div>
                <div class='m-da-list  <#if customer.point lt product.tgmoney>noenough</#if>' id="pointpay">
                    <a href="#">
                        <label><i class="mdl-jf">&#xe625;</i>积分支付[需支付${mygrounp.failpay}元]<small>（您有${customer.point}积分）<#if customer.point lt product.tgmoney>[余额不足]</#if></small></label>
                        <span class="m-da-d"><i>&#xe609;</i></span>
                    </a>
                </div>
            </div>
            </#if>
        </div>
    </div>
    <script type="text/javascript">
        $(function(){
            $('.noenough a').click(function(e){
                event.preventDefault();
            })
        })
    </script>
    <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>         
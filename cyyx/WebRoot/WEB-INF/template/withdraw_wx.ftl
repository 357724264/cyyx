<!doctype html>
<html>
<head>
	<title>积分兑换</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/home/css/swiper.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
   	   	<script type="text/javascript" src="${base}/home/js/basis.js"></script>
   	
   	<script type="text/javascript">
   		$(document).ready(function(){
   			$(".common-btn").bind("click",function(){
   				
   				var name = $("#name").val();
   				var wxnum = $("#wxnum").val();
   				var phone = $("#phone").val();
   				var money = $("#money").val();
   				if(name.length<2){
   					alert("请填写正确的名字");
   					return false;
   				}
   				if(wxnum.length<3){
   					alert("请填写正确微信号");
   					return false;
   				}
   				if(phone.length<11){
   					alert("请填写正确手机号");
   					return false;
   				}
   				if(money.length<1){
   					alert("请填写正确的金额");
   					return false;
   				}
   				if($(this).hasClass("clicked")){
   					return false;
   				}
   				$(this).addClass("clicked");
   				$.ajax({
   					url:"json/withdraw.action",
   					data:{name:name,wxnum:wxnum,phone:phone,money:money,tt:0},
   					type:"post",
   					success:function(html){
   						var dat = eval("("+html+")");
   						if(dat.success){
   							alert("申请提现成功!");
   						}else{
   							alert(dat.msg);
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
            <div class='left-link'><a href="center.action"><i>&#xe611;</i></a></div>
            <div class='header-title'>积分兑换</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class='common-group'>
                <div class="tixian-sum">
                    <h5>可兑换金额</h5>
                    <span>${user.point}<small>&nbsp;元</small></span>
                </div>
                <div class="tixian-way">
                   <div class="way-group xian waychecked">
                       <a href="javascript:;">
                           <i>&#xe61a;</i>
                           <span>兑换到微信</span>
                       </a>
                   </div>
                   <div class="way-group">
                       <a href="withdraw!bank.action">
                           <i>&#xe615;</i>
                           <span>兑换到银行卡</span>
                       </a>
                   </div>
                </div>
            </div>

            <div class="common-form-group common-margin">
                <div class="common-form-list">
                    <label>姓名</label>
                    <div class="text-box">
                        <input type="text" class="common-input" id="name" placeholder="请填写真实姓名" />
                    </div>
                </div>
                <div class="common-form-list">
                    <label>微信号</label>
                    <div class="text-box">
                        <input type="text" class="common-input" id="wxnum" placeholder="请填写微信号" />
                    </div>
                </div>
                <div class="common-form-list">
                    <label>手机号</label>
                    <div class="text-box">
                        <input type="text" class="common-input" id="phone" placeholder="请填写手机号" />
                    </div>
                </div>
                <div class="common-form-list">
                    <label>兑换金额</label>
                    <div class="text-box">
                        <input type="number" class="common-input" id="money" placeholder="您要兑换的金额" />
                    </div>
                </div>
            </div>

            <div class="btn-group">
                <button class="common-btn">确认兑换</button>
            </div>
        </div>
    </div>
    <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>         

<!doctype html>
<html>
<head>
	<title>订单详情</title>
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
    <link rel="stylesheet" type="text/css" href="dist/${base}/home/css/framework7.ios.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
   	   	<script type="text/javascript" src="${base}/home/js/basis.js"></script>
   	
   	<script type="text/javascript">
   	function sureorder(id,_this){
     		if($(_this).hasClass("clicked")){
     			return false;
     		}
     		$(_this).addClass("clicked");
     		$.ajax({
     			url:"json/order!sureorder.action",
     			data:{id:id},
     			type:"post",
     			success:function(html){
     				var dat = eval("("+html+")");
     				if(dat.success){
     					alert("订单确认成功!");
     					window.location.href="order.action?id="+id;
     				}
     			}
     		})
     	}
   	</script>

</head>
<body class="head_body">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="order!list.action"><i>&#xe611;</i></a></div>
            <div class='header-title'>订单详情</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class='container-fluid'>
        <div class="row">
            <div class="order-group-1">
                <div class="order-list"><label>订单状态：</label>
                <span class='addr-default'>
					<#if order.paymentStatus=="paid">
						待发货
					</#if>
					<#if order.paymentStatus=="send">
						已发货
					</#if>
					<#if order.paymentStatus=="deal">
						已收货
					</#if>
				</span></div>
                <div class="order-list"><label>订单编号：</label><span class='odl-lr'>${order.orderSn}</span></div>
                <div class="order-list"><label>下单时间：</label><span class='odl-lr'>${order.createDate?number_to_datetime?string("yyyy-MM-dd HH:mm")}</span></div>
                <div class="od-annu">
                	<#if order.paymentStatus=="send">
                    <a href='javascript:sureorder("${order.id}",this)' class="od-confirm">确认收货</a>
                    </#if>
                </div>
            </div>
            <div class="order-group-1">
                <div class="od-psxx">
                    <!--<div class="order-list"><label>供货商家：</label><span class='odl-lr'>某某某公司</span></div>-->
                    <div class="order-list"><label>收货地址：</label><span class='odl-lr'>${order.address}</span></div>
                    <div class="order-list"><label>收货人：</label><span class='odl-lr'>${order.name}&nbsp;${order.phone}</span></div>
                    <div class="order-list"><label>配送方式：</label><span class='odl-lr'>${order.carricompany}</span></div>
                    <div class="order-list"><label>快递单号：</label><span class='odl-lr'>${order.carrino}</span></div>
                </div>

                <div class="order-cont od-mcont">
                    <a href="#">
                        <div class="od-pro-img">
                            <img src="${order.page}" />
                        </div>
                        <div class="od-pro-info">
                            <p class="odm-pro-tit">
                            	${order.pageName}
                            </p>
                            <span>${order.num}</span>件
                        </div>
                    </a>
                </div>
            </div>

            <div class='order-group-1'>
                <div class='od-spjg'>
                    <span class="od-spjg-1">商品总额：</span>
                    <span class="od-spjg-2">￥${order.money}</span>
                </div>
                <div class='od-spjg'>
                    <span class="od-spjg-1">+运费：</span>
                    <span class="od-spjg-2">￥0.00</span>
                </div>
                <div class='od-spjg'>
                    <span class="od-spjg-1">实付款：</span>
                    <span class="od-spjg-2">￥${order.money}</span>
                </div>
            </div>
        </div>
    </div>
    <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>         
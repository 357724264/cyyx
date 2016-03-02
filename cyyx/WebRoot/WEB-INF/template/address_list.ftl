
<!doctype html>
<html>
<head>
	<title>收货地址</title>
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
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css?v=1">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
   	
   		<script type="text/javascript">
   			$(document).ready(function(){
   				 <#if tt??&&tt=="tg">
           			$(".addrli").bind("click",function(){
           				var id = $(this).attr("data-id");
           				window.location.href="buy!tg.action?gid=${tid!}&pid=${pid!}&addid="+id;
           			});
          	 	</#if>
          	 	<#if tt??&&tt=="zt">
           			$(".addrli").bind("click",function(){
           				var id = $(this).attr("data-id");
           				window.location.href="mygroup!toget.action?id=${tid!}&addid="+id;
           			});
          	 	</#if>
   				$(".swipeout-delete").bind("click",function(){
   					var _this = $(this);
   					var _li = $(this).parent().parent();
					var id = $(_li).attr("data-id");
					$.ajax({
						url:"json/address!delete.action",
						data:{id:id},
						type:"post",
						success:function(html){
							$(_li).remove();
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
            <div class='header-title'>收货地址</div>
            <div class='right-link' onclick="window.location.href='address!edit.action<#if tt??>?tt=${tt}&tid=${tid!}</#if>'"><a href="javascript:;" class="h-l-x">新增</a></div>
        </div>
    </div>

    <div class='container-fluid'>
        <div class="row">
            <div class="list-block">
                <ul class="addr-box">
                	<#list list as address>
                    <!-- li上额外的“swipeout”类 -->
                    <li class="swipeout addrli" data-id="${address.id}">
                        <!-- 被“swipeout-content”包裹起来的普通列表元素 -->                     
                        <div class="swipeout-content item-content item-link">
                            <!-- 你的列表元素放在这里 -->
                            <div class="addr-dz">
                                <span class="addr-info">${address.address}</span>
                                <div class="addr-lzfs">
                                    <span>${address.name}</span>
                                    <span>${address.phone}</span>
                                </div>
                            </div>
                        </div>
                        <!-- Swipeout actions right -->
                        <div class="swipeout-actions-right item-link">
                            <!-- Swipeout actions links/buttons -->
                            <a class="action1" href="address!edit.action?id=${address.id}">修改</a>
                            <a class="swipeout-delete" href="javascript:;">删除</a>
                        </div>
                    </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="${base}/home/dist/js/framework7.min.js"></script>
    <script type="text/javascript">
    	
        $(function(){
            // Initialize your app
            var myApp = new Framework7();
            var $$ = Dom7;

             $$('.action1').on('click', function () {
                 var link=this.href;
                 location.href=link;
             });
        })
    </script>
    <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>         
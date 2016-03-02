
<!doctype html>
<html>
<head>
	<title>更多活动</title>
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
   	<script type="text/javascript" src="${base}/home/js/base.js"></script>
   	<script type="text/javascript" src="${base}/home/js/basis.js"></script>
   	<script type="text/javascript">
   		var page = 1;
   		var hascontent = true;
   		$(document).ready(function(){
			loadpage(page);
			window.onscroll = function(){ 
				if(uiIsPageBottom()){
					if($(".lodingbox").length >0){
						if(!$(".lodingbox").hasClass("ling")){
							loadpage(++page);
						}
					}
				}
			}
     	});
     	function loadpage(pn){
     		if(!hascontent){
     			return false;
     		}
     		if($(".lodingbox").hasClass("ling")){
				return false;
			}
			$(".lodingbox").addClass("ling");
     		$.ajax({
     			url:"json/product!list.action",
     			data:{"pn":pn},
     			type:"post",
     			success:function(html){
     				if(html!=""){
	     				$(".lodingbox").before(html);
     				}else{
     					hascontent = false;
     					if(pn<2){
	     					$(".empty-group").show();
	     				}
     				}
     				$(".lodingbox").removeClass("ling");
     			}
     		})
     	}
     	function sureorder(id,_this){
     		if($(_this).hasClass("clicked")){
     			return false;
     		}
     		$(_this).addClass("clicked");
     		$.ajax({
     			url:"json/order!sureorder",
     			data:{id:id},
     			type:"post",
     			success:function(html){
     				var dat = eval("("+html+")");
     				if(dat.success){
     					window.location.href="product.action?id="+id;
     				}
     			}
     		})
     	}
   	</script>

</head>
<body class="head_body">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="center.action"><i>&#xe611;</i></a></div>
            <div class='header-title'>更多活动</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class='container-fluid'>
        <div class="row" id="row">
          <div class="lodingbox"><span id="loading"></span></div>  
        </div>
    </div>
    <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>         
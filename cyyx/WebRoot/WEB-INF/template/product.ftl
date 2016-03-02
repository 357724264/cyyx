
<!doctype html>
<html>
<head>


<#if product??&&product.title??&&product.canuse==0>


	<title>${product.title}</title>
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
    <script type="text/javascript" src="${base}/home/js/jquery.countdown.js"></script>
       	<script type="text/javascript" src="${base}/home/js/basis.js"></script>
    <script>
        var st = new showTime(1,'${.now?string("yyyy/MM/dd HH:mm:ss")}','${product.endtime?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}'); 
        //传递3个参数给JS处理（id,开始时间,结束时间）
        st.setTimeShow();
        $.ajax({
			url:"json/weixin!checkSubscribe.action",
			success:function(html){
				if(html!="1"){
					$(".gz-gzh").show();
					$(".zt-tz-team").bind("click",function(){
						alert("请先关注后组团。");
					});
				}else{
					$(".zt-tz-team").bind("click",function(){
						window.location.href="tuan!to.action?pid=${product.cid}";
					});
				}
			}
		})
		function close(){
			$(".confirm").hide();
		}
    </script>
    <!-- jquery 倒计时 -->
</head>
<body class="head_body">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="index.action"><i>&#xe611;</i></a></div>
            <div class='header-title'>${product.name}</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row" id="scroll-bar">
            <div class="pro-banner">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                    	<#list product.imageList as pic>
                        <div class="swiper-slide"><img class="img-responsive" src="${pic}" alt="banner img" /></div><!-- 700*400 -->
                       	</#list>
                    </div>
                    <!-- Add Pagination -->
                    <div class="swiper-pagination"></div>
                    <!-- <div style="position:absolute; bottom:0; left:0; width:100%; height:30px; line-height:30px; color:#fff; z-index:999; padding:0 0.8rem; background:rgba(51,51,51,0.7)">本期活动结束时间：${product.endtime?number_to_datetime?string("yyyy/MM/dd")}</div> -->
                </div>
            </div>
            
            <#if product.pvideo!=null>
            	<#assign isEdit=true>
            <#else>
            	<#assign isEdit=false>
            </#if>
		<#if isEdit>
            <div class="cg-group" style="position:relative; overflow:hidden; padding:0.65rem 0;">
                <iframe class="video_iframe" height="auto" width="100%" frameborder="0" data-src="https://v.qq.com/iframe/preview.html?vid=${product.pvideo}&amp;auto=0" allowfullscreen="" src="https://v.qq.com/iframe/player.html?vid=${product.pvideo}&amp;auto=0" scrolling="no"></iframe>
            </div>
		</#if>
		
  <!--          <a href="#" class='cg-cpxq'>产品详情<i>&#xe609;</i></a>  -->
            <div class="cg-group">
                <div class="cg-details">
                    <h5 class="cg-tit">活动介绍</h5>
                    <img src="${product.instruction}" width="100%" height="auto" />
                </div>
            </div>

            <div class="order-group">
                <div class="zt-tzinfo">
                    
                    <div class="zt-tz-btnbox">
                        <a href="buy!tg.action?pid=${product.cid}" class="zt-tz-tg">超值团购</a>
                        <#if customer.issub==0>
                        <a href="javascript:;" class="zt-tz-team">我要组团</a>
                        <#else>
                        <a href="javascript:;" class="zt-tz-team">我要组团</a>
                        </#if>
                    </div>
                </div>
            </div>
    </div>
    <script src="${base}/home/js/swiper.min.js"></script>
    <script>
        var swiper = new Swiper('.swiper-container', {
            pagination: '.swiper-pagination',
            paginationClickable: true,
            spaceBetween:0,
            centeredSlides: true,
            loop:true,
            autoplay:3000,
            speed:1000,
            autoplayDisableOnInteraction: false
        });
    </script>
     <!-- 弹出信息框关注公众号 -->
        	<div class="gz-gzh">
           		<h5>您还没有关注公众号！</h5>
            	<a href="javascript:;" class="gzh-close">&times;</a>
            	<#assign suburl = frontSystemClass.suburl >
            	<a href="${suburl}" class="gzh-gzbtn">现在去关注</a>
        	</div>
   <#include "/WEB-INF/template/footer.ftl" />
</body>




<#else>
	<title>活动已结束</title>
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

    <style type="text/css">
        #identifying-btn{
            height:200px;
            display:block;
            display: -webkit-box;
            display: -ms-flexbox;
            display: -webkit-flex;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            -webkit-align-items: center;
            align-items: center;
        }
    </style>

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>

    </head>
	<body class="head_body">
	
	<p id='identifying-btn'><p>
    <script type="text/javascript">
        $(document).ready(function(){
            var InterValObj; //timer变量，控制时间
            var count = 5; //间隔函数，5秒执行
            var curCount; //当前剩余秒数

            curCount = count;
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次

            function SetRemainTime() {
                if (curCount == 0) {                
                    window.clearInterval(InterValObj);//停止计时器
                    window.location.href="${base}/product!list.action";
                }
                else {
                    curCount--;
                    $("#identifying-btn").html("该活动已结束，"+curCount + "秒后跳转至其他最新活动，请稍等");
                }
            }
        })
    </script>
	   <#include "/WEB-INF/template/footer.ftl" />
	</body>
</#if>       	



</html>         
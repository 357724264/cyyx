<!doctype html>
<html>
<head>
	<title>${mproduct.title}</title>
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
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link rel="stylesheet" type="text/css" href="${base}/home/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/swiper.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css?v=1.1">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${base}/home/js/basis.js"></script>
</head>
<body style="padding-top:3.65rem;">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="#"><i>&#xe611;</i></a></div>
            <div class='header-title'>${mproduct.name}</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row" id="scroll-bar">
            <div class="pro-banner">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                    	<#if mproduct??&&mproduct.imageList??>
        					<#list mproduct.imageList as image>
            					<div class="swiper-slide"><img class="img-responsive" src="${image}" alt="banner img" /></div><!-- 700*400 -->
            				</#list>
        				</#if>
                    
                    
                    </div>
                    <!-- Add Pagination -->
                    <div class="swiper-pagination"></div>
                </div>
            </div>
            
            <#if mproduct.rawmoney==0>
            <div class="d-pictit">
                <h5>产品说明</h5>
                <p class="d-tit">${mproduct.intro}</p>
            </div>
            <#else>
            <div class="d-pictit">
                <div class="d-pic"><span style="color:#333">全国统一零售价：</span>￥${mproduct.rawmoney}</div>
                <h5>产品说明</h5>
                <p class="d-tit">${mproduct.intro}</p>
            </div>
			</#if>
			
			 
			
            <div class='d-proxq'>
                <div class='de-tabs'>
                    <ul class='tabs'>                        
                        <li class="active"><a href="#tab2">商品参数</a></li>
                        <li><a href="#tab1">图文详情</a></li>
                    </ul>
                    <div class="tab_container">                        
                          
                        <div id="tab2" class="tab_content" style="display: block; ">  
                            <#if mproduct??&&mproduct.qualityList??&&mproduct.minutiaList>
                                    <#list mproduct.qualityList as qua>
                                        <div class='de-group'>
                                            <div class="deg-tit">${qua}</div>
                                            <#list mproduct.minutiaList as min>
                                                <#if "${qua_index}"=="${min_index}">
                                                    <div class="deg-lr">${min}</div>
                                                </#if>
                                            </#list>
                                        </div>
                                    </#list>
                                </#if>
                        </div> 
                        <div id="tab1" class="tab_content" style="display: none; ">  
                            <p>${mproduct.detail}</p>                           
                        </div>  
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="footer">
            <p>本活动由五点一科技提供技术支持</p>
            <p><i>&#xe62a;</i>联系电话：0755-23765117</p>
        </div>
    </footer>

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

        $(document).ready(function() {    
            //Default Action  
            $(".tab_content").hide(); //Hide all content  
            $("ul.tabs li:first").addClass("active").show(); //Activate first tab  
            $(".tab_content:first").show(); //Show first tab content  
              
            //On Click Event  
            $("ul.tabs li").click(function() {  
                $("ul.tabs li").removeClass("active"); //Remove any "active" class  
                $(this).addClass("active"); //Add "active" class to selected tab  
                $(".tab_content").hide(); //Hide all tab content  
                var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content  
                $(activeTab).fadeIn(); //Fade in the active content  
                return false;  
            });  
          
        });    
        
    </script>
</body>
</html>         
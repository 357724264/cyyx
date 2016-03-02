<!doctype html>
<html>
<head>

<#if product??&&product.title??&&product.status==0>

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
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link rel="stylesheet" type="text/css" href="${base}/home/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/swiper.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/pingdan.css">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${base}/home/js/basis.js"></script>
    <script type="text/javascript" src="${base}/home/js/jquery.countdown.js"></script>
    <script>
        var st = new showTime(1,'${.now?string("yyyy/MM/dd HH:mm:ss")}','${product.endDate?string("yyyy/MM/dd HH:mm:ss")}'); 
        //传递3个参数给JS处理（id,开始时间,结束时间）
        st.setTimeShow();
    </script>
    <!-- jquery 倒计时 -->
</head>
<body class='head_body' style="padding-bottom:7rem;">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="#"><i>&#xe611;</i></a></div>
            <div class='header-title'>${product.name}</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row" id="scroll-bar">
            <div class="pro-banner">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                    	<#list product.imageList as image>
                        <div class="swiper-slide"><img class="img-responsive" src="${image}" alt="banner img" /></div><!-- 700*400 -->
                        </#list>
                    </div>
                    <!-- Add Pagination -->
                    <div class="swiper-pagination"></div>
                </div>
            </div>
            
            <#if product.pvideo!=null>
            	<#assign isEdit=true>
            <#else>
            	<#assign isEdit=false>
            </#if>
			<#if isEdit>
	            <div class="cg-group" style="position:relative; overflow:hidden; padding:0.65rem 0;">
	                <video width="100%" height="auto" controls='false' style="margin:0; padding:0; min-height:180px; box-sizing:border-box;" poster='images/banner1.jpg'>
	                    <source src="${product.pvideo}" type="video/mp4">
	                    <source src="${product.pvideo}" type="video/ogg">
	                  	  您的浏览器不支持 HTML5 video 标签。
	                </video>
	            </div>
			</#if>

            <div class="cg-group">
                <div class="cg-details">
                    <h5 class="cg-tit">活动介绍</h5>
                    <img src="${product.instruction}" width="100%" height="auto" />
                </div>
            </div>

            <div class='pd-cpdet'>
                <div class="pd-cpdet-box">
                    <div class="pro-banner">
                        <img src="../images/banner1.jpg" />
                    </div>
                    <div class='cpdet-tit'>
                   		${product.intro}
                    </div>
                    <span class='cpdet-pic'>￥${product.price}</span>
                </div>
                <div class='cpdet-time zttime-animate'>
                    <div id='lefttime_1' style="display:inline-block"></div>活动结束
                </div>
            </div>

            <a href="#" class='cg-cpxq'>已经有<span style="color:#f15353">${product.num}人</span>参与本活动<i>&#xe609;</i></a>

            <div class="pd-sppjarea">
                <div class="more-sppj">
                    <a href="#">商品评价<span class='more-sppj-rs'>125人评论<i>&#xe609;</i></span></a>
                </div>
                <ul class="sppj-lrarea">
                    <li class='sppj-lr-group'>
                        <div class='pjlr-head'>
                            <img src="../images/200017.jpg" alt="头像" />
                        </div>
                        <div class="pjlr-info">
                            <div class="pjlr-info-1">
                                <div class="pjlr-info-name">小小小小小</div>
                                <div class='pjlr-info-time'>2015-10-10</div>
                            </div>
                            <div class="pjlr-xingji" data-val="20"></div>
                            <div class='pjlr-pj'>
                                物品还不错，质量也不错！
                            </div>
                        </div>                        
                    </li>
                    <li class='sppj-lr-group'>
                        <div class='pjlr-head'>
                            <img src="../images/200017.jpg" alt="头像" />
                        </div>
                        <div class="pjlr-info">
                            <div class="pjlr-info-1">
                                <div class="pjlr-info-name">小小小小小</div>
                                <div class='pjlr-info-time'>2015-10-10</div>
                            </div>
                            <div class="pjlr-xingji" data-val="90%">
                                
                            </div>
                            <div class='pjlr-pj'>
                                物品还不错，质量也不错！
                            </div>
                        </div>                        
                    </li>
                </ul>
            </div>

            <div class="cg-area" id="cg-area">
                <div class="cg-box">
                    <ul id="cg-ulbox">
                        <span class="cg-sj">&#9670;</span>
                        <li class="cg-list">asdf</li>                        
                        <li class="cg-list">asdf</li>
                    </ul>
                </div>                
            </div>
        </div>
    </div>

    <div class='pt-listbox'>
    	<#if product??&&product.numOfPeopleList??&&product.pindanPriceList>
    
    		<#list product.pindanPriceList as price>
		        <div class="pt-listgroup">
		        	
		            <div class="pt-lgst-1" >
                        <a href='#'>
    		                <span>￥${price?number?string('0.0')}</span>
    		              
    		                <#list product.numOfPeopleList as num>
    			                <#if price_index == num_index>
    			                	<span>${num}人拼单</span>
    			                </#if>
    		                </#list>
                        </a>
		            </div>
		        </div>
        	</#list>
        </#if>
         <div class="pt-listgroup">
            <div class="pt-lgst-2">
                <a href='#'>
                    <span>￥${product.price?number?string('0.0')}</span>
                    <span>独立购买</span>
                </a>
            </div>
        </div>
    </div>

    <script src="${base}/home/js/swiper.min.js"></script>
    <script src="${base}/home/js/xingji.js"></script><!-- 星级方法 -->
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
        $(function(){
            
            var fatearea=document.getElementById('cg-area'),
                fatebox=document.getElementById('cg-ulbox');            
            
            $('#mor_btn').click(function(){
                $('.cg-area').fadeIn();
            })
            eventuti.addHandler(fatebox,'click',function(event){
                eventuti.stopPropagation(event);
            })
            eventuti.addHandler(fatearea,'click',function(event){
                eventuti.preventDefault(event);
                $('.cg-area').fadeOut();
            })

            xingji('.pjlr-xingji');//星级方法
        })
        
        $(document).ready(function(){
        	  $('.pt-lgst-1').bind('click',function(){
					var price = $(this).find("span").eq(0).html().replace("￥","");
					alert(price + " " + ${product.id});
				
			});
        
        })
        
        
       
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
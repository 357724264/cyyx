
<!doctype html>
<html>
<head>
	<title>个人中心</title>
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
    <script src="https://oss.maxcdn.com/libs/respond/home/js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link rel="stylesheet" type="text/css" href="${base}/home/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css?v=1">

   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
   	<script type="text/javascript" src="${base}/home/js/basis.js"></script>

</head>
<body class="head_body">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="javascript:history.go(-1)"><i>&#xe611;</i></a></div>
            <div class='header-title'>个人中心</div>
            <div class='right-link'><a href="javascript:;" id="mor_btn"><i>&#xe601;</i></a></div>
        </div>
    </div>

    <div class='container-fluid'>
        <div class="row">
            <div class='mc-headbox'>
                <div class="mc-head-img">
                    <img src='${user.pic}' alt='头像' />
                </div>
                <div class="mc-cont">
                    <h5>${user.name}</h5>
                    <div class="mc-zs">魅力指数<span>${user.charm}</span></div>
                </div>
            </div>

            <ul class="mc-linkbox">
                <li class="mc-list">
                    <a href="center!mygrounp.action">
                        我是团长<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
                 <li class="mc-list">
                    <a href="center!joingrounp.action">
                        我的参团<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
                <li class="mc-list">
                    <a href="order!list.action">
                        我的订单<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
              
                <li class="mc-list">
                    <a href="center!myuser.action">
                        我的助力团友<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
                <li class="mc-list">
                    <a href="center!point.action">
                        我的积分<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
                <li class="mc-list">
                    <a href="withdraw!wx.action">
                        申请积分兑换<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
                <li class="mc-list">
                    <a href="#">
                        我的二维码<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
                  <li class="mc-list">
                    <a href="center!info.action">
                   我的资料<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
                <li class="mc-list">
                    <a href="tel:0755-23765117">
                  联系客服<i class="mcl-icon">&#xe609;</i>
                    </a>
                </li>
            </ul>
        </div>
    </div> 
   <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>         
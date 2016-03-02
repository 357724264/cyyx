<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!--ie最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--basic styles-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<!-- IE使用最新渲染模式，chrome框架使用webkit内核 -->
<meta name='renderer' content="webkit">
<!-- 让360浏览器使用webkit内核 -->
<link href="${base}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="${base}/assets/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${base}/assets/css/font-awesome.min.css" />
<!--start编辑框样式+js-->
<link rel="stylesheet" type="text/css" href="${base}/assets/css/reg.css" />

<link href="${base}/umeditor/themes/default/css/ueditor.css" type="text/css"
	rel="stylesheet">
<link href="${base}/umeditor/themes/default/css/ueditor.min.css" type="text/css"
	rel="stylesheet">
<link href="${base}/umeditor/themes/iframe.css" type="text/css" rel="stylesheet">
<link href="${base}/umeditor/themes/default/dialogbase.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="${base}/umeditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${base}/umeditor/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${base}/umeditor/ueditor.parse.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${base}/umeditor/lang/zh-cn/zh-cn.js"></script>
<!--end编辑框样式+js-->

<!-- <link rel="stylesheet" href="${base}/assets/css/validationEngine.jquery.css"
	type="text/css" /> -->
<link rel="stylesheet" href="${base}/assets/css/validation_UpdateCn.jquery.css"
type="text/css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="${base}/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<!--page specific plugin styles-->
<!--fonts-->
<!--ace styles-->
<link rel="stylesheet" href="${base}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${base}/assets/css/ace-responsive.min.css" />
<link rel="stylesheet" href="${base}/assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${base}/assets/css/ace-ie.min.css" />
		<![endif]-->
<!--inline styles related to this page-->

<link rel="stylesheet" href="${base}/assets/css/datepicker.css" />
<link rel="stylesheet" href="${base}/assets/css/bootstrap-timepicker.css" />

<link rel="stylesheet" href="${base}/assets/css/jquery.datetimepicker.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--[if !IE]>-->
<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='${base}/assets/js/jquery-2.0.3.min.js'>"
					+ "<"+"/script>");
</script>
<!--<![endif]-->
<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${base}/assets/js/jquery-1.7.2.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='${base}/assets/js/jquery.mobile.custom.min.js'>"
				+ "<"+"/script>");
</script>
<script src="${base}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${base}/assets/js/menu.js"></script>
<!--page specific plugin scripts-->
<!--ace scripts-->
<script src="${base}/assets/js/ace-elements.min.js"></script>
<script src="${base}/assets/js/ace.min.js"></script>
<script src="${base}/assets/js/bootbox.min.js"></script>
<script src="${base}/assets/js/list.js" type="text/javascript"></script>
<script src="${base}/assets/js/jquery.pager.js"></script>
<script src="${base}/assets/js/entity.js"></script>
<script src="${base}/assets/js/ace-extra.min.js"></script>
<script src="${base}/assets/js/jquery.datetimepicker.js"></script>
<script type="text/javascript"
	src="${base}/assets/js/jquery.ajaxfileupload.js"></script>
<style type="text/css">
.overlay {
	position: fixed;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 999;
	width: 100%;
	height: 100%;
	_padding: 0 20px 0 0;
	background: #f6f4f5;
	display: none;
}

.showbox {
	position: fixed;
	top: 0;
	left: 45%;
	z-index: 999;
	opacity: 0;
	filter: alpha(opacity = 0);
	margin-left: -80px;
}

.showbox,.overlay {
	position: absolute;
	top: expression(eval(document.documentElement.scrollTop) );
}

#AjaxLoading {
	margin-top: -100px;
	border: 0px solid #8CBEDA;
	color: #37a;
	font-size: 16px;
	font-weight: bold;
	width: 20%;
}

#AjaxLoading div.loadingWord {
	width: 100%;
	height: 80px;
	line-height: 80px;
	border: 10px solid #D6E7F2;
	border-radius: 40px;
	background: #fff;
}

#AjaxLoading img {
	margin: 25px 15px;
	float: left;
	display: inline;
	width: auto;
}

.fileInputContainer {
	height: 247px;
	position: relative;
	background-repeat: no-repeat;
	width: 510px;
}

.fileInput {
	height: 247px;
	overflow: hidden;
	font-size: 300px;
	position: absolute;
	right: 0;
	top: 0;
	opacity: 0;
	filter: alpha(opacity = 0);
	cursor: pointer;
}

#file {
	opacity: 0;
	filter: alpha(opacity = 0);
	width: 362px;
	height: 202px;
	margin-top: -225px;
	cursor: pointer;
	*margin-top: -212px;
	*margin-left: -140px;
	background: #aaa;
	font-size: 120px\9;
}
</style>
<script src="${base}/assets/js/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${base}/assets/js/jquery.validationEngine.js"></script>
<script src="${base}/assets/js/jquery.form.js"></script>
<script>
	$(function() {
		$("input").bind("blur",function(){
			$(this).val($(this).val().trim());
		})
		var iddiv = $("input[name='id']");
		var id = "";
		if (iddiv != null) {
			id = iddiv.val()
		}
		var msg = "添加成功!";
		if (id != null && id != "") {
			msg = "修改成功!";
		}
		$("form:not(#unajax)")
				.ajaxForm(
						{
							type : "post",
							//beforeSubmit: function(){
							//alert("kaishi");
							//},
							semantic:true,
							beforeSubmit : function() {
								$(".overlay").css({
									'display' : 'block',
									'opacity' : '0.8'
								});
								$(".showupdate").stop(true).animate({
									'margin-top' : '300px',
									'opacity' : '1'
								}, 200);
							},
							success : function(data) {
								
								var dat = eval("(" + data + ")");
								if (dat.msg) {
									msg = dat.msg;
								}
								if (dat.msg != null) {
									msg = dat.msg;
								}
								$(".showupdate").stop(true).animate({
										'margin-top' : '250px',
										'opacity' : '0'
									}, 400);
									$(".overlay").css({
										'display' : 'none',
										'opacity' : '0'
									});
								if (dat.success) {
									
									bootbox
											.alert(
													'<br><center><font style="font-weight:700; font-size:18px;text-algin:center;" class="green"><i class="icon-ok bigger-120"></i> '
															+ msg
															+ '</font></center><br>',
													function() {
														window.location.href = dat.url;
													});

								} else {
							
									bootbox
											.alert('<br><center><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;" class="red"> <i class="icon-ban-circle bigger-120"></i> '
													+ dat.msg
													+ ' </font></center><br>');

													
								}
								return false;
							}
						});
	})
</script>
</head>
<style>
.menulist {
	line-height: 40px;
	height: 40px;
	font-size: 16px;
}
.ace-nav>li {background:#036C54;}
.ace-nav>li.light-blue{background:#019875;}
.header-color-blue2{background:#019875;border-color:#019875;lin-height:30px;}
</style>
<#assign usersys=adminSystemClass />
<#assign functionitems=usersys.functionitems />
<body>
	<div class="navbar" style="z-index:9999;margin-top:0px;top:0px;">
		<div class="navbar-inner" style="background:#019875">
			<div class="container-fluid">
				<a href="#" class="brand" style="padding:4px 20px 5px;"> <small>管理中心 </small>
				</a>
				
				<!--/.brand-->
				<div class="pull-right">
					<ul class="nav ace-nav">
						
						<#if functionitems?index_of(",user,") gte 0>
								<li class="light-blue user">
								<a href="user!list.action"style="font-size:16px; width:80px; font-weight:700;"> 
								<i class="iconfont icon-scguanliyuan"></i> 用户
								</a>
								</li>
						</#if>
						<#if functionitems?index_of(",order,") gte 0>	
								<li class="light-blue order">
								<a href="order!list.action" style="font-size:16px; width:80px; font-weight:700;"> 
								<i class="iconfont icon-dingdan1"></i> 订单
								</a>
								</li>
						</#if>	
						<#if functionitems?index_of(",product,") gte 0>				
								<li class="light-blue mallproduct">
								<a href="mallproduct!list.action"> 
								<i class="iconfont icon-gouwuche1"></i>商品管理
								</a>
								</li>
						</#if>
						<#if functionitems?index_of(",pindan,") gte 0>			
								<li class="light-blue pindan">
								<a href="pindan_product!list.action" style="font-size:16px; width:80px; font-weight:700;"> 
								<i class="iconfont icon-huodongguanli"></i> 拼单
								</a>
								</li>
						</#if>
						<#if functionitems?index_of(",activity,") gte 0>			
								<li class="light-blue product">
								<a href="product!list.action" style="font-size:16px; width:80px; font-weight:700;"> 
								<i class="iconfont icon-huodongguanli"></i> 活动
								</a>
								</li>
						</#if>		
						<#if functionitems?index_of(",point,") gte 0>				
								<li class="light-blue jf">
								<a href="jfstat.action" style="font-size:16px; width:80px; font-weight:700;"> 
								<i class="iconfont icon-jifen6"></i> 积分
								</a>
								</li>
						</#if>
						<#if functionitems?index_of(",withdraw,") gte 0>
								<li class="light-blue wd">
								<a href="wd!list.action" style="font-size:16px; width:80px; font-weight:700;"> 
								<i class="iconfont icon-tixian"></i> 提现
								</a>
								</li>
						</#if>
						<#if functionitems?index_of(",wechatnotify,") gte 0>
								<li class="light-blue notifytemplate"> 
								<a href="notifytemplate.action"> <i class="iconfont icon-weixin1"></i> 微信通知设置 
								</a> 
								</li>
						</#if>
						<#if functionitems?index_of(",mpconfig,") gte 0>
								<li class="light-blue config"> 
								<a href="config!mp.action"> <i class="iconfont icon-shanghuguanli"></i>公众号设置
								</a> 
								</li>
						</#if>
						<#if functionitems?index_of(",webconfig,") gte 0>
								<li class="light-blue webconfig"> 
								<a href="webconfig!setup.action"> <i class="iconfont icon-guanli1"></i> 网站设置
								</a> 
								</li>
						</#if>
						<li class="light-blue"> 
								<a href="logout.action"> <i class="iconfont icon-tuichu1"></i> 退出登录
								</a> 
						</li>
						<!--"1"end-->
				</div>
				<!--/.ace-nav-->
			</div>
			<!--/.container-fluid-->
		</div>
		<!--/.navbar-inner-->
	</div>
	<div class="overlay"></div>

	<div id="AjaxLoading" class="showbox showdelete">
		<div class="loadingWord">
			<img src="${base}/assets/img/waiting.gif">数据删除中，请稍候...
		</div>
	</div>
	<div id="AjaxLoading" class="showbox showupdate">
		<div class="loadingWord">
			<img src="${base}/assets/img/waiting.gif">数据<#if
			id??>修改<#else>保存</#if>中，请稍候...
		</div>
	</div>
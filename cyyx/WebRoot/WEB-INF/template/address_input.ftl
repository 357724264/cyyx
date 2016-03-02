
<!doctype html>
<html>
<head>
	<title>新增收货地址</title>
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
    <script src="https://oss.maxcdn.com/libs/respond.${base}/static/js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link rel="stylesheet" type="text/css" href="${base}/home/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/dist/css/framework7.ios.css">
    <link rel="stylesheet" type="text/css" href="${base}/home/css/style.css?v=1">
    
   	<script type="text/javascript" src="${base}/home/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${base}/home/js/jquery.cityselect.js"></script>
    <script type="text/javascript">
        $(function(){           
            $("#city").citySelect({
                prov:"请选择", 
                city:"请选择",
                dist:"请选择",
                nodata:"none"
            }); 
        });
    </script>
     <script type="text/javascript">
     	function updateaddress(){
     		var name = $("#name").val();
     		var phone = $("#phone").val();
     		var province = $(".prov").val();
     		var city = $(".city").val();
     		var dist = $(".dist").val();
     		var address = $("#address").val();
     		if(name.length<2){
				alert("请填写正确的名字。");
				return false;     		
     		}
     		if(phone.length<7){
				alert("请填写正确的联系方式");
				return false;     		
     		}
     		if(province.length<2){
				alert("请选择省份");
				return false;     		
     		}
     		if(city.length<2){
				alert("请选择城市");
				return false;     		
     		}
     		if(address.length<2){
				alert("请输入详细地址");
				return false;     		
     		}
     		var addr = province + " "+ city+" "+ (dist==null?"":dist) + " "+address;
     		$.ajax({
     			url:"json/address!edit.action",
     			data:{id:"${id!}",phone:phone,name:name,addr:addr},
     			type:"post",
     			success:function(html){
     				var dat = eval("("+html+")");
     				if(dat.success){
     					alert("编辑成功！")
     					<#if tt??>
     					<#if tt=="tg">
     					window.location.href="buy!tg.action?gid=${tid!}&pid=${pid!}&addid="+dat.message;
     					<#else>
     					window.location.href="mygroup!toget.action?id=${tid!}&addid="+dat.message;
     					</#if>
     					<#else>
     					window.location.href="address!list.action";
     					</#if>
     				}
     			}
     		})
     	}
     </script>
</head>
<body class="head_body">
    <div class="header">
        <div class="header-inner">
            <div class='left-link'><a href="address!list.action<#if tt??&&tt=="tg">?tt=tg&tid=${tid!}&pid=${pid!}</#if>"><i>&#xe611;</i></a></div>
            <div class='header-title'>收货地址编辑</div>
            <div class='right-link'><a href="javascript:updateaddress()" class="h-l-x">完成</a></div>
        </div>
    </div>

    <div class='container-fluid'>
        <div class="row">
            <div class="common-form-group common-margin">
                <div class="common-form-list">
                    <label>收货人</label>
                    <div class="text-box">
                        <input type="text" class="common-input" placeholder="请填写收货人" value="${(address.name)!}" id="name"/>
                    </div>
                </div>
                <div class="common-form-list">
                    <label>联系方式</label>
                    <div class="text-box">
                        <input type="text" class="common-input" placeholder="请填写联系方式" value="${(address.phone)!}" id="phone"/>
                    </div>
                </div>
                <div class="common-form-list">
                    <label>所在地区</label>
                    <div class="text-box" id="city">
                        <select class="prov"></select> 
                        <select class="city" disabled="disabled"></select>
                        <select class="dist" disabled="disabled"></select>
                    </div>
                </div>
                <div class="common-form-list">
                    <label>详细地址</label>
                    <div class="text-box">
                        <input type="text" class="common-input" placeholder="请填写详细地址" value="${(address.address)!}" id="address"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "/WEB-INF/template/footer.ftl" />
</body>
</html>         
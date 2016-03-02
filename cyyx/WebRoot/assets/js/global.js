
$(function(){
	lazy();
	show_book();
	show_foot();
	show_search();
	member_img();
	data_color();
	pro_color();
	fixed_foot();
});

//图片延迟加载
function lazy(){
//	$(".lazyload img").each(function(){
//		var _this = $(this);
//		var src = _this.attr("src");
//		_this.removeAttr("src");
//		_this.attr("data-src",src);
//	});
//	
//	$(".lazyload img").lazyload({
//		threshold : 100
//	});
}

//固定底部
function fixed_foot(){
	
    //滚动，我要订购固定
    if($(".footer").length > 0){
    	
    	$("body").css({"padding-bottom":"56px"});
    	$(".footer").css({
			"position": "fixed",
			"bottom": "0",
			"width": "100%",
			"background": "#fff",
			"border-top": "1px solid #ccc"
		});
    	
    }
	
}

//列表数量少的时候，使尾部位于最下方
function show_foot(){
	
	//条状列表（培训）
	if($(".barlist").length > 0){
		foot_css();
	}
	
	//块状列表（活动、资讯）
	if($(".blocklist").length > 0){
		foot_css();
	}
	
	//双块列表（相册）
	if($(".piclist").length > 0){
		foot_css();
	}
	
	//项目列表（团队课程表）
	if($(".itemlist").length > 0){
		foot_css();
	}
	
	//团队精英列表
	if($(".member_pic").length > 0){
		foot_css();
	}
	
}

//footer固定样式
function foot_css(){
	$("body").css({"background":"#ccc"});
}

//我要订购固定
function show_book(){
	
	//为窗口的scroll事件绑定处理函数
    $(window).scroll(function(){
        //获取窗口的滚动条的垂直位置
        var s = $(window).scrollTop();
	    
	    //滚动，我要订购固定
	    if(s > 0 && $(".book").length > 0){
	    	
            $(".book").css({
				"position": "fixed",
				"bottom": "0",
				"border-bottom": "0"
			});
            
        }
        
    });
}


//回到顶部
$(".gotop").live("click", function(){
	$('html, body').animate({scrollTop:0});
});

//关注提示 - 开启
$("#follow").live("click", function(){
//	if($("#no_follow").length>0){
		$(".mask").fadeIn(300);
		$("#no_follow").addClass("tip");
//	}else{
//		var url = $(this).attr("data-url");
//		window.location.href=url;
//	}
});

//关注提示 - 关闭
$("#close_follow").live("click", function(){
	closeFollow();
});

//关闭关注提示
function closeFollow(){
	$(".mask").fadeOut(300);
	$("#no_follow").removeClass("tip");
}

////我要报名 - 开启
//$(".action").live("click", function(){
//	$(".mask").fadeIn(300);
//	$("#do_action").addClass("tip");
//});
//
////我要报名 - 关闭
//$("#close_action").live("click", function(){
//	closeAction();
//});

//关闭我要报名
function closeAction(){
	$(".mask").fadeOut(300);
	$("#do_action").removeClass("tip");
}

//切换城市 - 开启
$(".search_city input").live("click", function(){
	$(".mask").fadeIn(300);
	$("#change_city").addClass("tip");
});

//切换城市 - 关闭
$(".ccity_title span").live("click", function(){
	closeCity();
});

//关闭切换城市
function closeCity(){
	$(".mask").fadeOut(300);
	$("#change_city").removeClass("tip");
}


//全部关闭
$(".mask").live("click", function(){
	closeAction();
	closeFollow();
	closeCity();
});

//点击加载
$("#load").live("click", function(){
	$(this).html("加载中...");
});

//显示loading图片
//window.onscroll = function(){ 
//	if(uiIsPageBottom()){
//		$("#loading").show();
//	}else{
//		$("#loading").hide();
//	}
//}

//判断是滚动到页面底部  
function uiIsPageBottom() {  
    var scrollTop = 0;  
    var clientHeight = 0;  
    var scrollHeight = 0;  
    if (document.documentElement && document.documentElement.scrollTop) {  
        scrollTop = document.documentElement.scrollTop;  
    } else if (document.body) {  
        scrollTop = document.body.scrollTop;  
    }  
    if (document.body.clientHeight && document.documentElement.clientHeight) {  
        clientHeight = (document.body.clientHeight < document.documentElement.clientHeight) ? document.body.clientHeight: document.documentElement.clientHeight;  
    } else {  
        clientHeight = (document.body.clientHeight > document.documentElement.clientHeight) ? document.body.clientHeight: document.documentElement.clientHeight;  
    }  
    // 比较大小，取最大值返回  
    scrollHeight = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight); 
		
    if (scrollTop + clientHeight >= scrollHeight-1.0) {  
        return true;  
    } else {  
        return false;  
    }  
}

//加入购物车
$(".elist .el_btn").live("click", function(){
	
	if($("#pro_num").length <= 0){
		return false;
	}
	
	if($(".book").css("position") != "fixed"){
		$(".book").css({
			"position": "fixed",
			"bottom": "0",
			"border-bottom": "0"
		});
	}
	
	var y = $(window).height() - 300;
	var yy = $(window).height() - 60;
	
	var _img = $(this).parent().parent().find(".el_img img");
	var clone = _img.clone();
	clone.appendTo($(this));
	
	clone.css({
		"position": "fixed",
		"z-index": "99",
		"width": "100px",
		"height": "50px",
		"top": y, 
		"right": "10px" 
	});
	
	clone.animate({
		"width": "0",
		"opacity": '0.1',
		"top": yy,
		"right": "50%"
	}, 700 ,function(){
		clone.remove();
		$("#pro_num").html(parseInt($("#pro_num").html())+1);
	});

});

//课程的日期选择
$(".study_date span").live("click", function(){
		
	if($(this).hasClass("none")){
		alert("暂无课程");
		return false;
	}
	
	$(".study_date span").removeClass("active");
	
	$(this).addClass("active");
	
});


//全网搜索，栏目固定
function show_search(){
	
    if($(".search_tab").length > 0){
    	$(".search_fixed").html($(".search_tab").clone())
    }else{
    	return false;
    }
	
    var search = $(".search_tab").offset().top;
    
	//为窗口的scroll事件绑定处理函数
    $(window).scroll(function(){
        //获取窗口的滚动条的垂直位置
        var s = $(window).scrollTop();
    	
    	if(s < (search+41)){
    		$(".search_fixed").hide();
    	}
	    
    	if(s >= search){
    		$(".search_fixed").show();
    	}
          
    });
	
}

//团队精英图片自适应
function member_img(){
	
	var bwidth = document.body.clientWidth;
	var width = (bwidth*0.86)/3; 
	var height = Math.round(width);
	$(".memberlist2 img").css({"height":height});
	
}

$(function(){
	//登录框获得焦点
	$(".log_div input").focus(function(){
		$(this).parent().addClass("active");
	});
	
	//登录框失去焦点
	$(".log_div input").blur(function(){
		$(this).parent().removeClass("active");
	});
	
});

//滑动，进入注册页面
$(".toreg").live("click", function(){
	
	$("#head_title").html("注册");
	$(".log_block").addClass("left_hide");
	$(".reg_block").removeClass("right_hide");
	
});

//滑动，返回登录页面
$(".tolog").live("click", function(){
	
	$("#head_title").html("登录");
	$(".log_block").removeClass("left_hide");
	$(".reg_block").addClass("right_hide");
	
});


//免费版分享给好友
$(".user_free").live("click", function(){
	$("#mcover").show();
});



//未同步数据颜色
function data_color(){
	for(var i=0;i<4;i++){
		$(".data_s5").find("span").eq(i).addClass("data_color" + i);
	}
}

//详情页颜色
function pro_color(){
	for(var i=0;i<5;i++){
		$(".intro2").find("li").eq(i).addClass("pro_color" + i);
		$(".user_number").find("span").eq(i).addClass("city_color" + i);
	}
}

//定时跳转
/*function settime_jump(){
	setTimeout("location.href='success.html'", 2000);
}*/

//修改微网名称
$(".alter_net_name").live("click", function(){
	
	$(".no_alter").hide();
	$(".is_alter").show();
	
	var net_name = $(".net_name").html();
	$(".net_name_text").val(net_name);
	
});

//保存微网名称
$(".save_net_name").live("click", function(){
	
	$(".no_alter").show();
	$(".is_alter").hide();
	
	var net_name = $(".net_name_text").val();
	$(".net_name").html(net_name);
	$.ajax({
		url:"user!wxnameedit.jsp",
		data:{content:net_name},
		type:"post",
		success:function(data){
			if(data == "success"){
				
			}
		}
	});
	
	
});


//保存对接微信公众号
//$(".dj_save").live("click", function(){
//	$(".mask_dj").fadeIn(300);
//	$(".dj_tip").html("保存成功！").fadeIn(300);
//	
//	setTimeout(function(){
//		location.href="user.html";
//	}, 1500);
//	
//});


//没数据，邀请完善信息
$(".nodata_a").live("click", function(){
	$(".mask_nodata").show();
	$(".nodata_tip p").html("信息发送成功！");
	$(".nodata_tip").show();
	$.ajax({
	url:"user!sendSms.jsp?content="+$("#noDataShowMsg").val(),
	type:"GET",
	success:function(data){
	}
	});
});

//查看图文描述
$(".load_media").live("click", function(){
	$(this).hide();
	$(".detail_media").show();
	
	var media = $(".detail_media").offset().top;
	$('html,body').animate({scrollTop:media},500);
});
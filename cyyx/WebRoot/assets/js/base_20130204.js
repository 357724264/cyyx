
$(function(){
	lazy();
	show_book();
	show_foot();
	fixed_foot();
});

//图片延迟加载
function lazy(){
	$(".lazyload img").each(function(){
		var _this = $(this);
		var src = _this.attr("src");
		_this.removeAttr("src");
		_this.attr("data-src",src);
	});
	
	$(".lazyload img").lazyload({
		threshold : 100
	});
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
	
	//公司子列表、招商
	if($(".business").length > 0){
		foot_css();
	}
	
	//付费首页
	if($(".home_nav").length > 0){
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



//右侧资料-开启
$(".user").live("click", function(){
	$(".mask").fadeIn();
	$(".home_right").addClass("show");
});

//右侧资料-开启
$(".hh_user").live("click", function(){
	$(".mask").fadeIn();
	$(".home_right").addClass("show");
});

//右侧资料-关闭
function close_home_right(){
	$(".mask").fadeOut();
	$(".home_right").removeClass("show");
}

//点击遮罩层
$(".mask").live("click", function(){
	close_home_right();
});

//点击退出右侧
$(".hr_out").live("click", function(){
	close_home_right();
});
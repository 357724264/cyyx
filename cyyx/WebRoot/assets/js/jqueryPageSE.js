// 商品分类弹出层
		$(function() {
        $(".pop").click(function() {
                var div = $(".comm_cft");
                if(div.hasClass("dest")) {
                        //div.removeClass("dest").animate({left: -170}, 600);
                } else {
                        div.addClass("dest").animate({left: 0}, 600);
                }
        })
         $(".comm_cft").click(function() {
                var div = $(".comm_cft");
                if(div.hasClass("dest")) {
                        div.removeClass("dest").animate({left: "-100%"}, 600);
                } else {
                        //div.addClass("dest").animate({left: 0}, 600);
                }
        })
         $(".J_SiftCommit").click(function() {
                var div = $(".comm_cft");
                if(div.hasClass("dest")) {
                        div.removeClass("dest").animate({left: "-100%"}, 600);
                } else {
                        //div.addClass("dest").animate({left: 0}, 600);
                }
        })
	});

		// 搜索框弹出层
		$(function(){
			$(".search_box").css({"display":"none"});
      
			$(".sec_clik").bind("click",function(){
				if($(".search_box").is(":visible")){
					$(".search_box").slideUp();
				}
				else{
					$(".search_box").slideDown();
				}
			})
		});

		// 滚动条滚动超过高度显示菜单
		$(function () {              
          $(window).bind("scroll", function () {  
              var sTop = $(window).scrollTop();  
              var sTop = parseInt(sTop);  
              if (sTop >= 200) { 
              	$("#nav_1").show();
              }
              else {  
                  $("#nav_1").hide();
              }   
          });  
      })  
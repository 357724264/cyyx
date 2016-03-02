$(function(){
	//搜索框下拉
	$(".s-input-tab-txt").on("click",function(){
		var $target = $(".s-input-tab-nav");
		if($target.hasClass("off")){
			$target.removeClass("off").addClass("on");
		}else{
			$target.removeClass("on").addClass("off");
		}
	});
	
	
	//篩選
	$(".top-bar-e").on("click",function(){
		if($("html").hasClass("sift-move")){
			$("html").removeClass("sift-move").addClass("sift-back");
			$(".sift-mask").fadeOut("fast");
			$("html").delay(500).removeClass("sift-back");
			$(".sift-content").fadeOut("fast");
		}else{
			$("html").addClass("sift-move");
			$(".sift-mask").fadeIn("fast");
			$(".sift-content").fadeIn("fast");
		}
	});
	
	
	$(".J_SiftConditionBox").on("click",function(){
		if($(this).hasClass("sift-show")){
			$(this).removeClass("sift-show");
			$("#downshow").hide();
			var ptselect = $(".pt.selected");
			for(var i=0;i<ptselect.length;i++){
				var pt = $(ptselect[i]).attr("data-name");
				var hh = "全部";
				if(pt!=null){
					hh = pt;
				}
				$(ptselect[i]).html(hh);
			}
			
		}else{
			$(this).removeClass("sift-show");
			$(this).addClass("sift-show");
			$("#downshow").show();
			var ptselect = $(".pt.selected");
			for(var i=0;i<ptselect.length;i++){
				var pt = $(ptselect[i]).html();
				if(pt!=null){
					$(ptselect[i]).html(pt);
				}
			}
		}
	})
})

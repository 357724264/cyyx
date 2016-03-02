var type=0;	
var pn =0;
var min;
var max;
var sort=0;
var ord = "down";
var keyword=null;
var level=0;
var pro;
var city;
var dist;
function choice(id,that){
		$(that).addClass("selected").siblings().removeClass("selected");
		type = id;
}
function nextpage(){
	pn = pn+1;
	$(".eloading").hide();
	page();
}
function page(){
	level = 0;
	if($(".pt2.selected").length>0){
	if($(".pt2.selected").attr("data-value")!=0){
		level = 1;
	}
	}
	min = $("#start_price").val();
	max = $("#end_price").val();
	$.ajax({
		url:"shopunion!jsonlist.action",
		data:{type:type,pn:pn,pro:pro,city:city,dist:dist,sort:sort,ord:ord,keyword:keyword},
		success:function(html){
			$(".page-container").append(html);
		}
	});
}
$(document).ready(function(){
	min =null;
	max=null;
	pn=1;
	page();
	$(".pt").bind("click",function(event){
		event.stopPropagation();
		type=$(this).attr("data-value");
		var name = $(this).attr("data-name");
		$(this).addClass("selected").siblings().removeClass("selected");
		if(type==0){
			$("#downclazz").html("");
			return false;
		}
		pro = $(".prov").val();
		city = $(".city").val();
		dist = $(".dist").val();
		$.ajax({
			url:"shopunion!category.action?cid="+type,
			success:function(html){
				var dat = eval("("+html+")")
				var length = dat.length;
				$("#downclazz").html("");
				$("#downclazz").append('<li data-value="0" class="selected pt2"><i class="icons-sift-select"></i>全部</li>');
				for(var i=0;i<length;i++){
					var clzz = dat[i];
					$("#downclazz").append('<li class="pt2" onclick="choice('+clzz.id+',this)">'+clzz.name+'</li>')
				}
				$("#downshow").show();
			}
		})
	});
	//tab切換
	$(".sort-tab li").on("click",function(){
		var $this = $(this);
		var val =$this.attr("data-value");
		sort = val;
		ord = $this.attr("data-order");
		if(ord == "down"){
			$this.attr("data-order","up");
		}else{
			$this.attr("data-order","down");
		}
		$this.addClass("selected").siblings().removeClass("selected");
//		if($this.hasClass("selected")){
//			return false;
//		}else{
//			
//		}
		$(".page-container").html("");
		pn = 1;
		page();
		
	});
	$(".sift-btn-ok").bind("click",function(){
		$("html").removeClass("sift-move").addClass("sift-back");
		$(".sift-mask").fadeOut("fast");
		$("html").delay(500).removeClass("sift-back");
		$(".sift-content").fadeOut("fast");
		$(".page-container").html("");
		page();
	});	
	
	$(".searchbtn").bind("click",function(){
		keyword = $("#keyword").val();
		type=0;	
		pn =1;
		min = null;
		max = null;
		sort=0;
		ord = "down";
		$(".page-container").html("");
		page();
	});
	
	$("#J_SiftClear").bind("click",function(){
		type=0;	
		pn =0;
		level=0;
		$(".pt").eq(0).addClass("selected").siblings().removeClass("selected");
		$("#downclazz").html("");
		$("#start_price").val("");
		$("#end_price").val("");
	})
})
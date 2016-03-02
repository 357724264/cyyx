$(function(){
	$("form").bind("submit",function(){
		var inputs = $("[name]");
		var length=inputs.length;
		for(var i=0;i<length;i++){
			var input = inputs[i];
			var pattern = $(input).attr("pattern")
			if(pattern!= null){
				pattern = "/"+$(input).attr("pattern")+"/";
				var reg = eval(pattern);
				if(!reg.test($(input).val())){
					$("#tips").addClass("tips-err");
					$("#tips").html($(input).attr("data-err"));
					return false;
				}
			}
		}
	});
})

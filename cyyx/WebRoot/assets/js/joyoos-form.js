$(document).ready(function() {
	$("form").ajaxForm({
		type : "post",
		beforeSubmit : function() {
		},
		success : function(data) {
			var dat = eval("("+data+")");
			if(dat.success){
				window.location.href=dat.url;
			}else{
				alert(dat.msg);
			}
		}
	});
});
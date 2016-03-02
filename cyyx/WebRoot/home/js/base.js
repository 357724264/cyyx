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
		clientHeight = (document.body.clientHeight < document.documentElement.clientHeight) ? document.body.clientHeight
				: document.documentElement.clientHeight;
	} else {
		clientHeight = (document.body.clientHeight > document.documentElement.clientHeight) ? document.body.clientHeight
				: document.documentElement.clientHeight;
	}
	// 比较大小，取最大值返回
	scrollHeight = Math.max(document.body.scrollHeight,
			document.documentElement.scrollHeight);

	if (scrollTop + clientHeight >= scrollHeight - 1.0) {
		return true;
	} else {
		return false;
	}
	// 列表倒计时function countdown(pn){
	var myDate = new Date();
	var now = myDate.getFullYear() + "/" + (myDate.getMonth() * 1 + 1) + "/"
			+ myDate.getDate() + " " + myDate.getHours() + ":"
			+ myDate.getMinutes() + ":" + myDate.getSeconds();
	var timeli = $(".timeli" + pn);
	for ( var i = 0; i < timeli.length; i++) {
		var time = $(timeli[i]).attr("data-endtime");
		var id = $(timeli[i]).attr("data-id");
		var st = new showTime(id, now, time);
		// 传递3个参数给JS处理（id,开始时间,结束时间）
		st.setTimeShow();
	}
}
function countdown(pn) {
	var myDate = new Date();
	var now = myDate.getFullYear() + "/" + (myDate.getMonth() * 1 + 1) + "/"
			+ myDate.getDate() + " " + myDate.getHours() + ":"
			+ myDate.getMinutes() + ":" + myDate.getSeconds();
	var timeli = $(".timeli" + pn);
	for ( var i = 0; i < timeli.length; i++) {
		var time = $(timeli[i]).attr("data-endtime");
		var id = $(timeli[i]).attr("data-id");
		var st = new showTime(id, now, time);
		// 传递3个参数给JS处理（id,开始时间,结束时间）
		st.setTimeShow();
	}
}
wx.ready(function() {
	var title = "分享页面";
	if ($("meta[name ='sharetitle']").length > 0) {
		title = $("meta[name ='sharetitle']").attr("content");
	} else {
		if ($(".nav-header").length < 1) {
			if ($("meta[name='share']").length < 1) {
				title = $("title").html();
			} else {
				title = $("meta[name='share']").attr("content");
			}
		} else {
			title = $(".nav-header").html();
		}
	}
	var desc = title;
	if ($("meta[name ='sharedesc']").length > 0) {
		desc = $("meta[name ='sharedesc']").attr("content");
	}
	var lineLink = document.URL;
	if (lineLink.indexOf("?") < 0) {
		lineLink += "?v=" + Math.random();
	} else {
		lineLink += "&v=" + Math.random();
	}
	
	var pic ="";
	if ($("meta[name='sharepic']").length < 1) {
		pic = $("img").eq(0).attr("src");
	}else{
		
		pic =$("meta[name='sharepic']").attr("content");
	}
	if (pic.indexOf("http") < 0) {
		pic = webSite + pic;
	}

	wx.onMenuShareTimeline({
		title : title, // 分享标题
		link : url, // 分享链接
		imgUrl : pic, // 分享图标
		success : function() {
			// 用户确认分享后执行的回调函数
			$.ajax({
				url : "jf!pointget.action?tt=share",
				success : function(html) {
				}
			})
		},
		cancel : function() {
			// 用户取消分享后执行的回调函数
			// alert("取消啦");
		}
	});
	wx.onMenuShareAppMessage({
		title : title, // 分享标题
		desc : desc, // 分享描述
		link : url, // 分享链接
		imgUrl : pic, // 分享图标
		type : '', // 分享类型,music、video或link，不填默认为link
		dataUrl : '', // 如果type是music或video，则要提供数据链接，默认为空
		success : function() {
			// 用户确认分享后执行的回调函数
			$.ajax({
				url : "jf!pointget.action?tt=share",
				success : function(html) {
				}
			});
		},
		cancel : function() {
			// 用户取消分享后执行的回调函数
			// alert("取消啦");
		}
	});
});
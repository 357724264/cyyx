$().ready(function() {
	// 判断菜单是否被选中
	var url = window.location.href;
	var gindex = url.lastIndexOf("/");
	var jspindex = url.lastIndexOf("!");
	if (jspindex == -1) {
		jspindex = url.lastIndexOf(".action");
	}
	var clzz = url.substring(gindex + 1, jspindex);
	clzz = clzz.replace("class", "");
	if (url.indexOf("wxaccess")>-1) {
		clzz = "wxmenu1";

	}
	if (url.indexOf("menuupdateview")>-1) {

		clzz = "wxmenu2";

	}
	$("li." + clzz).removeClass("light-blue");
	if ($("li." + clzz).parent().hasClass("dropdown-menu")) {
		$("li." + clzz).addClass("active");
		$("li." + clzz).parent().parent().removeClass("light-blue");
	}
});
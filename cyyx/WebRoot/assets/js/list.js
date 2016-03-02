var now="";

$().ready( function() {
	if($("#searchbtn").length>0){
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	$("#searchbtn").trigger("click");
		     }
		}
	}
	
	now = $("#search").val();
	$(".allcheck").bind("click",function(){
		if(!$(this).is(':checked')){
			$(".cc").removeAttr("checked");
			$(".allcheck").removeAttr("checked");   
		}else{
			$(".cc").removeAttr("checked");
			$(".cc").trigger("click");
			$(".allcheck").attr("checked",true);
		}
	});
//	$(".cc").bind("click",function(){
//		if($(this).attr("checked")=="checked"){
//			$(this).removeAttr("checked");
//		}else{
//			$(this).attr("checked",true);     
//		}
//	})
	
	
	$("#size").bind("change",function(){
		var id=1;
		var size = $(this).val();
		var data={}, hash;
		if(window.location.href.indexOf('?')>=0){
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		}else{
			hashes = {};
		}
		var url = window.location.href.slice(0,window.location.href.indexOf('?')+1);
		for(var i = 0; i < hashes.length; i++)
		{
			hash = hashes[i].split('=');
			data[hash[0]] = hash[1];
		}
		data["pn"] = id;
		data["ps"]=0;
		data["size"] = size;
		var param = "";
		for(var key in data){
			param+=(key+"="+data[key]+"&");
		}
		
		param = param.substring(0,param.length-1);
		if(window.location.href.indexOf('?')>=0){
			window.location.href=url+param;
		}else{
		window.location.href=url+"?"+param;
		}
	})
	
	$("#searchbtn").bind("click",function(){
		var id=1;
		var pro = $("#search").attr("attr-pro");
		var keyword=$("#search").val();
		if(keyword == now){
			return false;
		}else{
			now = keyword;
		}
		var data={}, hash;
		if(window.location.href.indexOf('?')>=0){
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		}else{
			hashes = {};
		}
		var url = window.location.href.slice(0,window.location.href.indexOf('?')+1);
		for(var i = 0; i < hashes.length; i++)
		{
			hash = hashes[i].split('=');
			data[hash[0]] = hash[1];
		}
		data["pn"] = id;
		data["ps"]=0;
		data["pro"] = pro;
		data["keyword"] = keyword;
		var param = "";
		for(var key in data){
			param+=(key+"="+data[key]+"&");
		}
		
		param = param.substring(0,param.length-1);
		if(window.location.href.indexOf('?')>=0){
			window.location.href=url+param;
		}else{
		window.location.href=url+"?"+param;
		}
	});
	
	var $allCheck = $(".list input.allCheck");// 全选复选框
	var $idsCheck = $(".list input[name='ids']");// ID复选框
	var $deleteButton = $(".list input.deleteButton");// 删除按钮
	
	var $listForm = $(".list form");// 列表表单
	var $searchButton =  $("#searchButton");// 查询按钮
	var $pageNumber = $("#pageNumber");// 当前页码
	var $pageSize = $("#pageSize");// 每页显示数
	var $sort = $(".list .sort");// 排序
	var $orderBy = $("#orderBy");// 排序方式
	var $order = $("#order");// 排序字段
	
	// 全选
	$allCheck.click( function() {
		if ($(this).attr("checked") == true) {
			$idsCheck.attr("checked", true);
			$deleteButton.attr("disabled", false);
		} else {
			$idsCheck.attr("checked", false);
			$deleteButton.attr("disabled", true);
		}
	});
	
	// 无复选框被选中时,删除按钮不可用
	$idsCheck.click( function() {
		var $idsChecked = $(".list input[name='ids']:checked");
		if ($idsChecked.size() > 0) {
			$deleteButton.attr("disabled", false);
		} else {
			$deleteButton.attr("disabled", true)
		}
	});
	
	// 批量删除
	$deleteButton.click( function() {
		var url = $(this).attr("url");
		var $idsCheckedCheck = $(".list input[name='ids']:checked");
		if (confirm("您确定要删除吗？") == true) {
			$.ajax({
				url: url,
				data: $idsCheckedCheck.serialize(),
				dataType: "json",
				async: false,
				beforeSend: function(data) {
					$deleteButton.attr("disabled", true)
				},
				success: function(data) {
					$deleteButton.attr("disabled", false)
					if (data.status == "success") {
						$idsCheckedCheck.parent().parent().remove();
					}
					$.message(data.status, data.message);
				}
			});
		}
	});

	// 查找
	$searchButton.click( function() {
		$pageNumber.val("1");
		$listForm.submit();
	});

	// 每页显示数
	$pageSize.change( function() {
		$pageNumber.val("1");
		$listForm.submit();
	});

	// 排序
	$sort.click( function() {
		var $currentOrderBy = $(this).attr("name");
		if ($orderBy.val() == $currentOrderBy) {
			if ($order.val() == "") {
				$order.val("asc")
			} else if ($order.val() == "desc") {
				$order.val("asc");
			} else if ($order.val() == "asc") {
				$order.val("desc");
			}
		} else {
			$orderBy.val($currentOrderBy);
			$order.val("asc");
		}
		$pageNumber.val("1");
		$listForm.submit();
	});

	// 排序图标效果
	sortStyle();
	function sortStyle() {
		var orderByValue = $orderBy.val();
		var orderValue = $order.val();
		if (orderByValue != "" && orderValue != "") {
			$(".sort[name='" + orderByValue + "']").after('<span class="' + orderValue + 'Sort">&nbsp;</span>');
		}
	}
	// 页码跳转
	$.gotoPage = function(id) {
		var data={}, hash;
		if(window.location.href.indexOf('?')>=0){
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		}else{
			hashes = {};
		}
		var url = window.location.href.slice(0,window.location.href.indexOf('?')+1);
		for(var i = 0; i < hashes.length; i++)
		{
			hash = hashes[i].split('=');
			data[hash[0]] = hash[1];
		}
		data["pn"] = id;
		if($("#pageSize").val()!=null && $("#pageSize").val()!=""){
			data["ps"] = $("#pageSize").val();
		}
		var param = "";
		for(var key in data){
			param+=(key+"="+data[key]+"&");
		}
		param = param.substring(0,param.length-1);
		if(window.location.href.indexOf('?')>=0){
			window.location.href=url+param;
		}else{
		window.location.href=url+"?"+param;
		}
	}
});
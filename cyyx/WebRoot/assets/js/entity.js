var basePath = "http://localhost:9080/";
function getdeleteall(clzz) {
	var cc = $(".cc");
	var length = cc.length;
	var ids = "";
	for ( var i = 0; i < length; i++) {
		if ($(cc[i]).is(':checked')) {
			ids += ($(cc[i]).attr("attr-id") + ",");
		}
	}
	ids = ids.substr(0,ids.length-1);
	bootbox
			.confirm(
					'<br><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;">您确定要删除<font style="color:red">这些内容吗？<br/>删除以后将无法恢复</font><br><br>',
					function(result) {
						if (result) {
							$(".overlay").css({'display':'block','opacity':'0.8'});
							$(".showdelete").stop(true).animate({'margin-top':'300px','opacity':'1'},200);
							$.ajax({
										url : clzz + "!deleteall.action",
										data:{ids:ids},
										type:"post",
										success : function(html) {
//											if (html=="success") {
											$(".showdelete").stop(true).animate({'margin-top':'250px','opacity':'0'},400);
											$(".overlay").css({'display':'none','opacity':'0'});
												bootbox
												.alert(
														'<br><center><font style="font-weight:700; font-size:18px;text-algin:center;" class="green"><i class="icon-ok bigger-120"></i> 删除成功!</font></center><br>',
														function() {
															window.location.reload();
														});
												
//											}else{
//												bootbox
//												.alert('<br><center><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;" class="red"> <i class="icon-trash bigger-120"></i> 删除失败! <br/>'
//														+ dat.msg
//														+ '</font></center><br>');
//											}
										}
									})
						}
					})
}

function deleteclazz(clzz, id, that, issystem) {
	if ($(that).hasClass("clicked")) {
		return false;
	}
	$(that).addClass("clicked");
	var strconfirm = "";
	if (issystem == "yes") {
		strconfirm = '<br><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;">您确定要删除<font style="color:red">系统默认分类</font>吗？<br/>删除以后将无法恢复</font><br><br>';
	} else {
		strconfirm = '<br><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;">您确定要删除分类吗？<br/>删除以后将无法恢复</font><br><br>';
	}
	bootbox
			.confirm(
					strconfirm,
					function(result) {
						if (result) {
							$(".overlay").css({'display':'block','opacity':'0.8'});
							$(".showdelete").stop(true).animate({'margin-top':'300px','opacity':'1'},200);
							$
									.ajax({
										url : clzz + "!delete.action?id=" + id,
										success : function(html) {
											var dat = eval("(" + html + ")");
											if (dat.success) {
												$(".showdelete").stop(true).animate({'margin-top':'250px','opacity':'0'},400);
												$(".overlay").css({'display':'none','opacity':'0'});
												bootbox
														.alert(
																'<br><center><font style="font-weight:700; font-size:18px;text-algin:center;" class="green"><i class="icon-ok bigger-120"></i> 删除成功!</font></center><br>',
																function() {
																	$(
																			"#ccid"
																					+ id)
																			.hide(
																					1000);
																	$(
																			"#ccid"
																					+ id)
																			.remove();
																});
											} else {
												$(".showdelete").stop(true).animate({'margin-top':'250px','opacity':'0'},400);
												$(".overlay").css({'display':'none','opacity':'0'});
												bootbox
														.alert('<br><center><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;" class="red"> <i class="icon-trash bigger-120"></i> 删除失败! <br/>'
																+ dat.msg
																+ '</font></center><br>');
											}
										}
									})
						}
					})
}
function deleteentity(clzz, id, that, issystem) {
	if ($(that).hasClass("clicked")) {
		return false;
	}
	$(that).addClass("clicked");
	var strconfirm = "";
	if (issystem == "yes") {
		strconfirm = '<br><font style="font-weight:700; font-size:18px;line-height:30px;">您确定要删除此条<font style="color:red">系统默认内容</font>吗？<br/>删除以后将无法恢复</font><br><br>';
	} else {
		strconfirm = '<br><font style="font-weight:700; font-size:18px;line-height:30px;">您确定要删除<font style="color:red">此条内容</font>吗？<br/><font style="color:red">删除以后将无法恢复</font><br><br>';
	}
	
	bootbox
			.confirm(
					strconfirm,
					function(result) {
						if (result) {
							$(".overlay").css({'display':'block','opacity':'0.8'});
							$(".showdelete").stop(true).animate({'margin-top':'300px','opacity':'1'},200);
							$
									.ajax({
										url : clzz + "!delete.action?id=" + id,
										success : function(html) {
											$(".showdelete").stop(true).animate({'margin-top':'250px','opacity':'0'},400);
											$(".overlay").css({'display':'none','opacity':'0'});
//											if (html == "success") {
												bootbox
														.alert(
																'<br><center><font style="font-weight:700; font-size:18px;text-algin:center;" class="green"><i class="icon-ok bigger-120"></i> 删除成功!</font></center><br>',
																function() {
																	$(
																			"#id"
																					+ id)
																			.hide(
																					1000);
																	$(
																			"#id"
																					+ id)
																			.remove();
																});
//											} else {
//												bootbox
//														.alert('<br><center><font style="font-weight:700; font-size:18px;line-height:30px;text-algin:center;" class="red"> <i class="icon-trash bigger-120"></i> 删除失败! <br/>需要删除分类下所有产品信息，才能删除此分类。</font></center><br>');
//											}
										}
									})
						}
					})
}

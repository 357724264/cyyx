
<script type="text/javascript">
$().ready( function() {
	$("#pager").pager({
		pagenumber: ${pn},
		pagecount: ${ps},
		buttonClickCallback: $.gotoPage
	});

})
</script>
<ul id="pager">

</ul>
<input type="hidden" id="pageSize" value="${ps}" />
<input type="hidden" id="upro" value="${pro}" />
<input type="hidden" id="ukeyword" value="${keyword}" />
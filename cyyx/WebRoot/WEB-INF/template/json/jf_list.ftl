<#list list as jf>
<tr>
	<td>${jf.createDate?number_to_datetime?string("yyyy/MM/dd HH:mm")}</td>
	<td style="color:<#if jf.tt lt 0>red<#else>green</#if>"><#if jf.tt lt 0>-</#if>${jf.point}</td>
	<td>${jf.content}</td>
</tr>
</#list>
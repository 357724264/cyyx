<#list list as grounp>
<div class="order-group  timeli${pn}"  data-id="${grounp.id}" data-endtime="${grounp.endTime?number_to_datetime?string("yyyy/MM/dd HH:mm:ss")}">
	<div class="order-cont">
		<a href="#">
        	<div class="od-pro-img">
              	<img src="${grounp.pic}" />
         	</div>
            <div class="od-pro-info">
           		<p class="pro-tit">${grounp.createDate?number_to_datetime?string("yyyy-MM-dd HH:mm")} 组团 <span class="od-zt-rs">已组团<i>${grounp.num}</i>人</span></p>
   				<div class="od-zt-sj">
					<div class="od-zt-tim" id="lefttime_${grounp.id}"></div>活动结束
               	</div>
           	 </div>
		</a>
	</div>
	<div class="order-det">
		<div class="od-btnbox">
			<#if grounp.stat=="unget">
				<a href='mygroup!toget.action?id=${grounp.id}' class="od-btn-del" style="background:#00cc66">去领取</a>
			</#if>
			<#if grounp.stat=="geted">
				<a href='order.action?id=${grounp.orderid}' class="od-btn-del">查看订单</a>
			</#if>
			<#if grounp.stat=="end">
				<a href='mygroup!toget.action?id=${grounp.id}' class="od-btn-del" style="background:#00cc66">去拼单购买</a>
			</#if>
			<a href='tuan.action?tid=${grounp.id}' class="od-btn-xq">查看组团</a>
		</div>
	</div>
</div>
</#list>
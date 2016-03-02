<#list list as order>
<div class="order-group">
	<div class="order-cont">
		<a href="order.action?id=${order.id}">
			<div class="od-pro-img">
				<img src="${order.page}" />
			</div>
			<div class="od-pro-info">
				<p class="pro-tit">
					<#if order.paymentStatus=="paid">
						待发货
					</#if>
					<#if order.paymentStatus=="send">
						已发货
					</#if>
					<#if order.paymentStatus=="deal">
						已收货
					</#if>
				</p>
				<span>${order.num}</span>件
			</div>
		</a>
	</div>
	<div class="order-det">
		<div class="order-picbox">
			实付款：￥<span>${order.money}</span>
		</div>
		<div class="od-btnbox">
			<#if order.paymentStatus=="paid">
			 请等待卖家发货
			</#if>
			<#if order.paymentStatus=="send">
				<a href='javascript:sureorder("${order.id}",this)' class="confirm-sh">确认收货</a>
			</#if>
			<#if order.paymentStatus=="deal">
			订单已经完成
			</#if>                
		</div>
	</div>
</div>
</#list>
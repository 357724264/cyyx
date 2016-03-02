<#list list as user>
<li class="swipeout">
	<div class="swipeout-content item-content item-link">
	<!-- 你的列表元素放在这里 -->
		<div class="item-media"><img src='${user.userpic}' /></div>
		<div class="item-inner">
			<div class='friend-name'>${user.username}</div>
			<span class="friend-sign"><span class="fi-time">${user.createDate?number_to_datetime?string("yyyy-MM-dd HH:mm")}</span>为我助力！</span>
		</div>
	</div>
</li>
</#list>
<#list list as product>
<div class='more-hdgroup'>
    <a href="product.action?id=${product.cid}">                    
        <div class='mhdg-box'>
            <div class='mhdg-headimg'>
                <img src="${product.pic}" />
            </div>
            <div class="mhdg-cont">
                <h5>${product.name}</h5>
                <p>${product.intro}</p>
                <div class="mhdg-edtm">结束时间：${product.endtime?number_to_datetime?string("yyyy/MM/dd HH:mm")}</div>
            </div>
        </div>
    </a>
</div>
</#list>
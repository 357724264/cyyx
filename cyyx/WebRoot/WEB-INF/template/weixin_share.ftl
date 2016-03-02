<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js?v=${nowTime}"></script>
<script type="text/javascript" src="http://mp.weixin.qq.com/debug/zh_CN/htmledition/js/jsapisign/sha121d415.js?v=${nowTime}"></script>
<#assign ttick = tick>
<script>
<#if ttick??>
//需要动态从后台获取
var jsapi_ticket = '${ttick}';
var url = window.location.href;


if(url.indexOf("?")>-1){
url = url+"&uid=${session_customer_id}";
}else{
url = url+"?uid=${session_customer_id}";
}
var reg=new RegExp("code{1}={1}[0-9A-Za-z]{1,}\\&{0,}","gmi");
url = url.replace(reg,"") 
var webSite = "${systemName}.joyoos.com/"
var appId = '${frontSystemClass.appId}'; 
var timestamp = '1414587457';
var nonceStr = '1';
var theUrl = document.URL;
var string1 = 'jsapi_ticket=' + jsapi_ticket + '&noncestr=' + nonceStr + '&timestamp=' + timestamp + '&url=' + theUrl; 
var signature = new jsSHA(string1,"TEXT"); //签名算法
	signature = signature.getHash("SHA-1","HEX");
var jsApiList = ['onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','hideOptionMenu'];

//通过config接口注入权限验证配置
wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: appId, // 必填，公众号的唯一标识
    timestamp: timestamp, // 必填，生成签名的时间戳
    nonceStr: nonceStr, // 必填，生成签名的随机串
    signature: signature, // 必填，签名，见附录1
    jsApiList: jsApiList // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});
</#if>
</script>
<script src="${base}/assets/js/share.js?v=1.12"></script>
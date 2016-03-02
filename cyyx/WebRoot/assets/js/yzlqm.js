/*获取Ajax对象*/
function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		xhr = new XHLHttpRequest();
	}else{
		xhr = new ActiveXObject("Microsoft.XMLHttp");
	}
	return xhr;
}
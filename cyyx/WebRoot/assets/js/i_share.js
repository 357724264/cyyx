// JavaScript Document

/*
* 智能机浏览器版本信息:
*
*/

  var browser={
    versions:function(){
           var u = navigator.userAgent, app = navigator.appVersion;
           return {//移动终端浏览器版本信息
                trident: u.indexOf('Trident') > -1, //IE内核
                presto: u.indexOf('Presto') > -1, //opera内核
                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
                mobile: !!u.match(/AppleWebKit.*Mobile.*/)||!!u.match(/AppleWebKit/), //是否为移动终端
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
                iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
                iPad: u.indexOf('iPad') > -1, //是否iPad
                webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
            };
         }(),
         language:(navigator.browserLanguage || navigator.language).toLowerCase()
}
if(browser.versions.android==false && browser.versions.ios==false)
{
	if(navigator.userAgent.indexOf('Mobile')==-1){
	if(marketingId=="KM0001")
	{
		window.location.href="http://m.bnufo.com/tips_KM0001.html";
	}else if(marketingId=="admin"){
		
		window.location.href="http://m.bnufo.com/tips_admin.html";
	}else if(marketingId=="A0001admin"){
		
		window.location.href="http://m.bnufo.com/tips_A0001admin.html";
	}else if(marketingId.indexOf("pxc")>=0){
		marketingId=marketingId.replace("pxc","");
	}else{
		window.location.href="http://www.elenjoy.com";
	}
	}
	
}



	


if(pageName=="index"){
	if(mid=="KMZX")
	{
		var imgUrl = 'http://xfm.elenjoy.com/km/kmyy.jpg';
		var shareTitle = '康美移动商务中心【康美在线E点通】';
	}
	else if(mid=="JRZX")
	{
		var imgUrl = 'http://xfm.elenjoy.com/market/jrgroup.jpg';
		var shareTitle = '金日移动商务中心【金日E点通】';
	}
	else if(mid=="XFQQ")
	{
		var imgUrl = 'http://xfm.elenjoy.com/market/jrgroup.jpg';
		var shareTitle = '幸福国际移动商务中心【金日E点通】';
	}
	var lineLink = document.URL;
	var descContent = "随时在线查看所有产品详细介绍、奖金制度、加盟方案、公司优势、系统优势、最新促销、最新会议通告等内容。";
	var appid = '';
}
else if(pageName=="product_class"){
	if(mid=="KM")
	{
		var imgUrl = 'http://xfm.elenjoy.com/upload/20140325/1395741983815.png';
		var shareTitle = '康美产品库【康美在线E点通】';
		var descContent = "康美药业成立于1997年，是一家以中药饮片、化学原料药及制剂生产为主导，集药品生产、研发及药品、医疗器械营销于一体的现代化大型医药企业、国家级重点高新技术企业。";
	}
	else if(mid=="JR")
	{
		var imgUrl = 'http://xfm.elenjoy.com/market/jrgroup.jpg';
		var shareTitle = '金日产品库【金日E点通】';
		var descContent = "金日系列产品,源自现代高科技与独特创新的科学配方，性质温和，气味清香，从护发到护体，从驻颜到口腔护理，贴心关怀，无间呵护，细意满足个人洁净、滋养和护理的需要，令沟通更亲密，绽放生活温情色彩，尽享幸福美好人生。";
	}
	
	var lineLink = document.URL;
	var appid = '';
}else if(pageName=="product_List"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = '康美'+className+'系列产品【康美在线E点通】';
		var descContent = "康美"+className+"系列产品,秉承东方养生理念，特选优质 道地草本原料，科学组方精制而成。";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = '金日'+className+'系列产品【金日E点通】';
		var descContent = "金日"+className+"系列产品,源自现代高科技与独特创新的科学配方，性质温和，气味清香，从护发到护体，从驻颜到口腔护理，贴心关怀，无间呵护，细意满足个人洁净、滋养和护理的需要，令沟通更亲密，绽放生活温情色彩，尽享幸福美好人生。";
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="product_desc"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = productName+'【康美在线E点通】';
		var descContent = prodectDesc;
	}
	else if(mid=="JR")
	{
		
			var imgUrl = wximg;
		var shareTitle = productName+'【金日E点通】';
		var descContent = prodectDesc;
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="news_class"){
	if(mid=="KM")
	{
		var shareTitle = '康美实时资讯中心【康美在线E点通】';
		var descContent = "这里有最新最实时的康美全球动态信息：行业动态、康美全球动态、公司活动、健康生活分享以及最新的促销信息。";
	}
	else if(mid=="JR")
	{
		var shareTitle = '金日实时资讯中心【金日E点通】';
		var descContent = "这里有最新最实时的金日全球动态信息：行业动态、金日全球动态、公司活动、健康生活分享以及最新的促销信息。";
	}
	var imgUrl = "http://xfm.elenjoy.com/km/news.jpg";
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="news_List"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = '康美:'+className+'【康美在线E点通】';
		var descContent = "这里有最新最实时的康美全球动态信息：行业动态、康美全球动态、公司活动、健康生活分享以及最新的促销信息。";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = '金日:'+className+'【金日E点通】';
		var descContent = "这里有最新最实时的金日全球动态信息：行业动态、金日全球动态、公司活动、健康生活分享以及最新的促销信息。";
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="jinyh_List"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = className+'【康美在线E点通】';
		var descContent = "成功者都在这里！汇聚精英正能量！ ";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = className+'【金日E点通】';
		var descContent = "成功者都在这里！汇聚精英正能量！ ";
	}
	
	var lineLink = document.URL;
	var appid = '';
}else if(pageName=="elite_desc"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = eliteName+'【康美在线E点通】';
		var descContent = eliteDesc;
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = eliteName+'【金日E点通】';
		var descContent = eliteDesc;
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="news_desc"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = newsName+'【康美在线E点通】';
		var descContent = newsDesc;
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = newsName+'【金日E点通】';
		var descContent = newsDesc;
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="course_class"){
	if(mid=="KM")
	{
		var shareTitle = '康美事业在线培训中心【康美在线E点通】';
		var descContent = "众所周知，培训是直销工作的灵魂，学习是直销业绩的保障;提高团队学习力就是提高团队战斗力!传统地面培训成本高，学习效率低;因为记忆的自然规律，听完一堂课到第二天基本遗忘40%左右，复制给团队的就更有限。";
	}
	else if(mid=="JR")
	{
		var shareTitle = '金日事业在线培训中心【金日E点通】';
		var descContent = "众所周知，培训是直销工作的灵魂，学习是直销业绩的保障;提高团队学习力就是提高团队战斗力!传统地面培训成本高，学习效率低;因为记忆的自然规律，听完一堂课到第二天基本遗忘40%左右，复制给团队的就更有限。";
	}
	var imgUrl = "http://xfm.elenjoy.com/km/course.jpg";
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="coursevideo_list" || pageName=="course_list"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = '康美培训中心:'+className+'【康美在线E点通】';
		var descContent = "众所周知，培训是直销工作的灵魂，学习是直销业绩的保障;提高团队学习力就是提高团队战斗力!传统地面培训成本高，学习效率低;因为记忆的自然规律，听完一堂课到第二天基本遗忘40%左右，复制给团队的就更有限。";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = '金日培训中心:'+className+'【金日E点通】';
		var descContent = "众所周知，培训是直销工作的灵魂，学习是直销业绩的保障;提高团队学习力就是提高团队战斗力!传统地面培训成本高，学习效率低;因为记忆的自然规律，听完一堂课到第二天基本遗忘40%左右，复制给团队的就更有限。";
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="news_desc"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = courseName+'【康美在线E点通】';
		var descContent = courseDesc;
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = courseName+'【金日E点通】';
		var descContent = courseDesc;
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="book_classify"){
	if(mid=="KM")
	{
		var shareTitle = '康美商学院：口袋里的直销大学【康美在线E点通】';
		var descContent = "让我们在手机里随时学习所有课程，文字、课件、视频多样化展示，大大提高学习效率;可供团队所有人在手机里享受统一的学习和服务，彻底解决直销学习难、培训难、复制难!";
	}
	else if(mid=="JR")
	{
		var shareTitle = '金日商学院:口袋里的直销大学【金日E点通】';
		var descContent = "让我们在手机里随时学习所有课程，文字、课件、视频多样化展示，大大提高学习效率;可供团队所有人在手机里享受统一的学习和服务，彻底解决直销学习难、培训难、复制难!";
	}
	var imgUrl = "http://xfm.elenjoy.com/km/xy.jpg";
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="book_list"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = '康美商学院:'+className+'【康美在线E点通】';
		var descContent = "让我们在手机里随时学习所有课程，文字、课件、视频多样化展示，大大提高学习效率;可供团队所有人在手机里享受统一的学习和服务，彻底解决直销学习难、培训难、复制难!";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = '金日商学院:'+className+'【金日E点通】';
		var descContent = "让我们在手机里随时学习所有课程，文字、课件、视频多样化展示，大大提高学习效率;可供团队所有人在手机里享受统一的学习和服务，彻底解决直销学习难、培训难、复制难!";
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="book_desc"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = bookName+'【康美在线E点通】';
		var descContent = bookDesc;
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = bookName+'【金日E点通】';
		var descContent = bookDesc;
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="activity_list"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = '康美药业近期活动【康美在线E点通】';
		var descContent = "活动：招商会、培训会、小组会、网络培训会、发布会等等";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = '金日药业近期活动【金日E点通】';
		var descContent = "活动：招商会、培训会、小组会、网络培训会、发布会等等";
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="activity_desc"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = activityName+'【康美在线E点通】';
		var descContent = activityDesc;
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = activityName+'【金日E点通】';
		var descContent = activityDesc;
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="opp_list"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = '康美事业商务中心【康美在线E点通】';
		var descContent = "康美药业股份有限公司创建于1997年，2001年在沪交所挂牌上市，是一家以中药饮片生产为核心，业务涵盖中药全产业链的现代化大型医药资源型企业、国家重点高新技术企业。";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = '金日事业商务中心【金日E点通】';
		var descContent = "香港金日投资集团有限公司，她是一家集医疗、保健、金融、贸易、房地产为一体的多元化国际集团。公司业务立足国内，遍及欧美、东南亚等国家和地区。";
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="opp_desc"){
	
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = oppName+'【康美在线E点通】';
		var descContent = oppDesc;
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = oppName+'【金日E点通】';
		var descContent = oppDesc;
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="contact"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = '康美集团【康美在线E点通】';
		var descContent = "康美药业股份有限公司创建于1997年，2001年在沪交所挂牌上市，是一家以中药饮片生产为核心，业务涵盖中药全产业链的现代化大型医药资源型企业、国家重点高新技术企业。";
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = '金日集团【金日E点通】';
		var descContent = "香港金日投资集团有限公司，她是一家集医疗、保健、金融、贸易、房地产为一体的多元化国际集团。公司业务立足国内，遍及欧美、东南亚等国家和地区。";
	}
	
	var lineLink = document.URL;
	var appid = '';
}
else if(pageName=="contact_desc"){
	if(mid=="KM")
	{
		var imgUrl = wximg;
		var shareTitle = conName;
		var descContent = conDesc+'【康美在线E点通】';
	}
	else if(mid=="JR")
	{
		var imgUrl = wximg;
		var shareTitle = conName;
		var descContent = conDesc+'【金日E点通】';
	}
	
	var lineLink = document.URL;
	var appid = '';
}







if(lineLink.indexOf("marketingId")<0){
 if(lineLink.indexOf("?")>=0)
 {
	 lineLink=lineLink+'&marketingId='+marketingId;
 }
 else{
	 lineLink=lineLink+'?marketingId='+marketingId;
 }
}



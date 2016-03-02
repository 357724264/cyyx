package com.wdy.cyyx.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.WxmenuDao;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.entity.Wxmenu;
import com.wdy.cyyx.service.CacheService;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.WxmenuService;
import com.wdy.cyyx.util.ImageMarkLogoByIcon;
import com.wdy.cyyx.util.StringUtils;
import com.wdy.cyyx.util.WxMenuUtils;

@Service
public class WxmenuServiceImpl extends BaseServiceImpl<Wxmenu, String>
		implements WxmenuService {
	static String defaulticoPath = "assets/img/defaultico.png";
	static String defaulthb = "assets/img/hb.jpg";

	@Resource
	public void setBaseDao(WxmenuDao wxmenuDao) {
		super.setBaseDao(wxmenuDao);
	}

	@Resource
	private CacheService cacheService;
	@Resource
	private CustomerService customerService;

	@Override
	public String getAccessToken(String appId, String appSecret)
			throws Exception {
		if (cacheService.getData("accessToken_" + appId) == null) {
			String token = WxMenuUtils.getAccessToken(appId, appSecret);
			cacheService.setData("accessToken_" + appId, token, 2000);
			return token;
		} else {
			return (String) cacheService.getData("accessToken_" + appId);
		}
	}

	@Override
	public String getTicket(String appId, String appSecret) throws Exception {
		if (cacheService.getData("jsapiTicket_" + appId) == null) {
			String token = getAccessToken(appId, appSecret);
			String tick = WxMenuUtils.getJsapiTicket(token);
			cacheService.setData("jsapiTicket_" + appId, tick, 3600);
			return token;
		} else {
			return (String) cacheService.getData("jsapiTicket_" + appId);
		}
	}

	// public String saveOrgetTgHbUrl(Customer customer, SystemClass
	// systemClass,
	// String realPath, String accessToken) throws Exception {
	// String hbUrlurl = "/up/hb" + new Date().getTime()
	// + systemClass.getCid() + ".jpg";
	// String hbUrl = realPath + hbUrlurl;
	// String smallurl = customer.getSmallurl();
	// if (StringUtils.isEmpty(smallurl)) {// 如果没有小头像 则要剪切成小头像
	// String colorurl = customer.getPic();
	// if (StringUtils.isEmpty(colorurl)) {
	// smallurl = realPath + defaulticoPath;
	// } else {
	// String smallurlurl = "up/" + new Date().getTime()
	// + customer.getCid() + ".png";
	// smallurl = realPath + smallurlurl;
	// if (colorurl.indexOf("joyoos.com") > -1) {// 本机的
	// String filePath = realPath
	// + colorurl.substring(colorurl.indexOf("/up/"));
	// // 缩小尺寸
	// ImageMarkLogoByIcon
	// .resize(filePath, smallurl, 64, 64, true);
	// } else {// 把头像下载下来
	// ImageMarkLogoByIcon.downloadImg(
	// colorurl.replace("/0", "/64"), smallurl);
	// }
	// customer.setSmallurl("/" + smallurlurl);
	// }
	// }else{
	// smallurl = realPath + smallurl;
	// }
	// String qrPath =customer.getTgqr();
	// if (StringUtils.isEmpty(customer.getTgqr())) {// 下载推广二维码
	// String webqrPath = WxMenuUtils.getParamQcode(accessToken,
	// "scene_str", customer.getCid() + "");
	// // 下载推广二维码
	// String bigqrPath = realPath + "/up/qr" + new Date().getTime()
	// + customer.getCid() + ".png";
	// // 下载下来并缩放
	// ImageMarkLogoByIcon.downloadImg(
	// "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="
	// + webqrPath, bigqrPath);
	// String qrurl = "/up/qr" + new Date().getTime() + customer.getCid()
	// + "-small.png";
	// ImageMarkLogoByIcon.resize(bigqrPath, realPath + qrurl, 202, 159,
	// true);
	// qrPath = realPath + qrurl;
	// customer.setTgqr(qrurl);
	// } else {
	// qrPath = realPath + customer.getTgqr();
	// }
	// System.err.println("customer.getName()========="+customer.getName());
	// ImageMarkLogoByIcon
	// .markImageByIcon(
	// smallurl,
	// customer.getName() == null ? " " : customer.getName(),
	// customer.getHbsign() == null ? " " : customer
	// .getHbsign(),
	// qrPath,
	// StringUtils.isEmpty(systemClass.getHb()) ? (realPath + defaulthb)
	// : (realPath + systemClass.getHb().substring(
	// systemClass.getHb().indexOf("/up/"))),
	// hbUrl);
	// customer.setHburl(hbUrlurl);
	// customer.setHbbg(systemClass.getHb());
	// customerService.update(customer);
	// return hbUrlurl;
	// }


}

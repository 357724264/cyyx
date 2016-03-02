package com.wdy.cyyx.action.admin.json;

import java.util.Date;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.SystemClass;

public class ConfigAction extends BaseAction {
	private String appid;
	private String appsecret;
	private String wxpay;
	private String mchid;
	private String url;
	private String cdlmessage;// CompanyDefaultLeaveMessage商家默认留言
	private String cdsmessage;// CompanyDefaultShareMessage商家默认分享语

	public String mpupdate() {
		Date date = new Date();
		
		SystemClass systemClass = getAdminSystemClass();
		systemClass.setCreateDate(date);
		systemClass.setAppId(appid);
		systemClass.setAppSecret(appsecret);
		systemClass.setWxpaySecret(wxpay);
		systemClass.setMchid(mchid);
		systemClass.setSuburl(url);
		systemClassService.update(systemClass);
		return ajaxJson("{\"success\":true,\"url\":\"config!mp.action\"}");
	}

	public String setupupdate() {
		SystemClass systemClass = getAdminSystemClass();
		systemClass.setCdlmessage(cdlmessage);
		systemClass.setCdsmessage(cdsmessage);
		systemClassService.update(systemClass);
		return ajaxJson("{\"success\":true,\"url\":\"config!setup.action\"}");
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getWxpay() {
		return wxpay;
	}

	public void setWxpay(String wxpay) {
		this.wxpay = wxpay;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getCdlmessage() {
		return cdlmessage;
	}

	public void setCdlmessage(String cdlmessage) {
		this.cdlmessage = cdlmessage;
	}

	public String getCdsmessage() {
		return cdsmessage;
	}

	public void setCdsmessage(String cdsmessage) {
		this.cdsmessage = cdsmessage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

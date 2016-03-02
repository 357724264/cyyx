package com.wdy.cyyx.action;

import javax.annotation.Resource;

import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.service.NotifyService;
import com.wdy.cyyx.service.TestService;

public class TestAction extends BaseAction {

	@Resource
	private NotifyService notifyService;
	@Resource
	private TestService testService;

	@Override
	public String execute() throws Exception {
//		Mygrounp mygrounp = new Mygrounp();
//		String weixinid = "onYHuv00W-YsfJL6TJ7ifAR0XW0c";
//		String appid = "wx8364b2611ffdfa81";
//		String appsecret = "401bc34b68de81e1867a18012247f24c";
//		mygrounp.setSystemid(97);
//		mygrounp.setMastername("魏日锐");
//		mygrounp.setProductname("黄色的产品");
//		notifyService.grounpOktoMaster(mygrounp, appid, appsecret,
//				"LQzVuM2OV3LEB8cFCPxyGeiPV27KmfVvhsET47BmJGQ", weixinid);
		testService.saveauser();
		return ajaxHtml("ok!");
	}
}

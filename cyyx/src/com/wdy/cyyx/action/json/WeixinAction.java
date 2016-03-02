package com.wdy.cyyx.action.json;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.WxUser;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.util.StringUtils;
import com.wdy.cyyx.util.WxMenuUtils;

public class WeixinAction extends BaseAction {

	@Resource
	private CustomerService customerService;

	public String checkSubscribe() throws ClientProtocolException, IOException,
			Exception {
		Object userIdobj = getSession(Const.SESSION_CUSTOMER_ID);
		SystemClass systemClass = getFrontSystemClass();
		if (userIdobj == null || systemClass.getAppId() == null
				|| systemClass.getAppSecret() == null) {
			return ajaxHtml("-1");
		}
		Customer customer = customerService.get((Integer) userIdobj);
		String weixinid = customer.getWeixinid();
		if (!StringUtils.isEmpty(weixinid)) {
			WxUser user = WxMenuUtils.getUserInfo(wxmenuService.getAccessToken(
					systemClass.getAppId(), systemClass.getAppSecret()),
					weixinid);
			if (user.getIsSubscribe() == null || user.getIsSubscribe()) {
				return ajaxHtml("1");
			}
		}
		return ajaxHtml("0");

	}
}

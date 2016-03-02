package com.wdy.cyyx.common;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.CacheService;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.SystemClassService;
import com.wdy.cyyx.util.StringUtils;
import com.wdy.cyyx.util.WxMenuUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginVerifyInterceptor extends AbstractInterceptor {

	@Resource
	private CustomerService customerService;
	@Resource
	private SystemClassService systemClassService;

	@Resource
	private CacheService cacheService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = (HttpServletRequest) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
		String uu = request.getParameter("uu");
		String code = request.getParameter("code");
		String test = request.getParameter("test");

		uu = "1";
		// if (uu == null || uu.equals("") || uu.equals("www")) {
		// response.sendRedirect("/home/index.htm");
		// return null;
		// }
		SystemClass systemClass = systemClassService.get(Integer.parseInt(uu));

		String statusid = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("cookie2")) {
					statusid = c.getValue();
					break;
				}

			}
		}
		if (statusid == null) {
			statusid = UUID.randomUUID().toString();
			request.setAttribute("cookie2", statusid);
			// 保存cookie
			Cookie cookie = new Cookie("cookie2", statusid);
			cookie.setPath("/");
			// cookie.setDomain(Const.BASE_WEB_SITE);
			cookie.setMaxAge(3600 * 24 * 365);
			response.addCookie(cookie);
		}

		cacheService
				.set(CacheService.CACHE_SESSION + statusid + "_"
						+ Const.SESSION_CUSTOMER_ID, 1,
						CacheService.CACHE_SESSION_TIME);

		if (cacheService.get(CacheService.CACHE_SESSION + statusid + "_"
				+ Const.SESSION_SYSTEMCLASS_NAME) == null
				|| (uu != null && !cacheService.get(
						CacheService.CACHE_SESSION + statusid + "_"
								+ Const.SESSION_SYSTEMCLASS_NAME).equals(
						Integer.parseInt(uu)))) {
			System.err.println("hhhhh---in");

			cacheService.remove(CacheService.CACHE_SESSION + statusid + "_"
					+ Const.SESSION_CUSTOMER_ID);
			cacheService.remove(CacheService.CACHE_SESSION + statusid + "_"
					+ Const.SESSION_WEIXINID);
			cacheService.set(CacheService.CACHE_SESSION + statusid + "_"
					+ Const.SESSION_SYSTEMCLASS_NAME, Integer.parseInt(uu),
					CacheService.CACHE_SESSION_TIME);
		}

		String weixinid = null;
		Object weixinidobj = cacheService.get(CacheService.CACHE_SESSION
				+ statusid + "_" + Const.SESSION_WEIXINID);
		if (weixinidobj != null) {
			weixinid = weixinidobj.toString();
		}

		// String from = request.getParameter("from");
		// if (from == null || from.equals("singlemessage")
		// || from.equals("timeline")) {
		if (!StringUtils.isEmpty(code)) {
			if (!StringUtils.isEmpty(systemClass.getAppId())
					&& !StringUtils.isEmpty(systemClass.getAppSecret())) {
				Snsapi snsapi = WxMenuUtils.getOpenidByCode(
						systemClass.getAppId(), systemClass.getAppSecret(),
						code);
				String access_token = snsapi.getAccess_token();
				weixinid = snsapi.getOpenid();

				// 保存weixinid
				cacheService.set(CacheService.CACHE_SESSION + statusid + "_"
						+ Const.SESSION_WEIXINID, weixinid,
						CacheService.CACHE_SESSION_TIME);
				Customer customer = customerService.saveorGetCustomer(
						access_token, weixinid, systemClass.getCid());
				// 保存用户id
				cacheService.set(CacheService.CACHE_SESSION + statusid + "_"
						+ Const.SESSION_CUSTOMER_ID, customer.getCid(),
						CacheService.CACHE_SESSION_TIME);
			}
		}
		
		System.err.println(cacheService.get(CacheService.CACHE_SESSION + statusid + "_"
				+ Const.SESSION_CUSTOMER_ID));

		// }
		// 判断是否登录
		if (cacheService.get(CacheService.CACHE_SESSION + statusid + "_"
				+ Const.SESSION_CUSTOMER_ID) == null) {
			if (test == null && code == null) {// 是微信浏览器
				if (!StringUtils.isEmpty(systemClass.getAppId())
						&& !StringUtils.isEmpty(systemClass.getAppSecret())) {
					System.err.println("准备跳转了");
					response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="
							+ systemClass.getAppId()
							+ "&redirect_uri="
							+ URLEncoder.encode(
									"http://"
											+ systemClass.getCid()
											+ "."
											+ Const.BASE_URL
											+ request.getRequestURI()
													.toString()
											+ "?"
											+ request
													.getQueryString()
													.replaceAll(
															"uu{1}={1}[0-9A-Za-z]{1,}\\&{0,}",
															""), "UTF-8")
							+ "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
					return null;
				}
			}
		}

		return invocation.invoke();
	}
}

package com.wdy.cyyx.common;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.service.CacheService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminVerifyInterceptor extends AbstractInterceptor {
	@Resource
	private CacheService cacheService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletRequest request = (HttpServletRequest) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);

		String statusid = null;
		//System.err.println("-==============");

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				//System.err.println(c.getName() + "=============");
				if (c.getName().equals("cookie2")) {
					statusid = c.getValue();
					break;
				}

			}
		}
		if (statusid == null) {
			statusid = UUID.randomUUID().toString();
			request.setAttribute("cookie1", statusid);
			// 保存cookie
			Cookie cookie = new Cookie("cookie2", statusid);
			cookie.setPath("/");
			// cookie.setDomain(Const.BASE_WEB_SITE);
			cookie.setMaxAge(3600 * 24 * 365);
			response.addCookie(cookie);
		}

		if (cacheService.get(CacheService.CACHE_SESSION + statusid + "_"
				+ Const.SESSION_ADMIN_NAME) == null) {
			response.sendRedirect("/admin/login.action");
		}

		return invocation.invoke();

	}
}

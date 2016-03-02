package com.wdy.cyyx.action.admin;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.Cookie;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.SystemClass;

public class LoginAction extends BaseAction {

	private String username;
	private String pwd;

	@Override
	public String execute() throws Exception {
		String statusid = null;
		Cookie[] cookies = getRequest().getCookies();
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
			getRequest().setAttribute("cookie2", statusid);
			// 保存cookie
			Cookie cookie = new Cookie("cookie2", statusid);
			cookie.setPath("/");
			// cookie.setDomain(Const.BASE_WEB_SITE);
			cookie.setMaxAge(3600 * 24 * 365);
			getResponse().addCookie(cookie);
		}

		return super.execute();
	}

	public String in() throws IOException {
		if (username.equals("admin")) {// 管理员
			setSession(Const.SESSION_ADMIN_NAME, 0);
			getResponse().sendRedirect("life!list.action");
			return null;
		}
		SystemClass systemClass = systemClassService.get(
				new QueryParam(2).add("username", username).add("pwd", pwd),
				false);
		if (systemClass != null) {
			// if (username.equals("wrr")) {// 店家版
			// setSession(Const.SESSION_ADMIN_NAME, 1);
			// }
			// if (username.equals("staff")) {// 员工版
			// setSession(Const.SESSION_ADMIN_NAME, 7);
			// }
			// if (username.equals("agent")) {// 经销商
			// setSession(Const.SESSION_ADMIN_NAME, 8);
			// }

			// if (username.equals("mm")) {// 面膜
			// setSession(Const.SESSION_ADMIN_NAME, 9);
			// }
			setSession(Const.SESSION_ADMIN_NAME, systemClass.getCid());
			getResponse().sendRedirect("product!list.action");
			// return null;
		}
		//
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}

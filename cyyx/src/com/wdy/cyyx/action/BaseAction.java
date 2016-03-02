package com.wdy.cyyx.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.CacheService;
import com.wdy.cyyx.service.SystemClassService;
import com.wdy.cyyx.service.WxmenuService;
import com.wdy.cyyx.util.StringUtils;


public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 6718838811223344556L;

	protected static final String FONT_SYSTEM_KEY = "systemClass.cid";
	public static final String VIEW = "view";
	public static final String LIST = "list";
	public static final String STATUS = "status";
	public static final String WARN = "warn";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final String CONTENT = "content";
	protected static int ADMIN_PAGE_SIZE = 10;
	protected static int FRONT_PAGE_SIZE = 10;
	protected int pn = 1;
	protected int ps;
	protected String keyword;
	protected String pro;
	protected String msg;
	protected List list;
	protected int size;
	protected String ids;
	protected String logInfo;// 日志记录信息
	protected String redirectionUrl;// 操作提示后的跳转URL,为null则返回前一页

	@Resource
	protected SystemClassService systemClassService;
	@Resource
	protected WxmenuService wxmenuService;
	@Resource
	private CacheService cacheService;

	public String input() {
		return null;
	}

	// 获取Attribute
	public Object getAttribute(String name) {
		return ServletActionContext.getRequest().getAttribute(name);
	}

	// 设置Attribute
	public void setAttribute(String name, Object value) {
		ServletActionContext.getRequest().setAttribute(name, value);
	}

	public String getParameter(String name) {
		// 获取Parameter
		return getRequest().getParameter(name);
	}

	// 获取Parameter数组
	public String[] getParameterValues(String name) {
		return getRequest().getParameterValues(name);
	}

	public String getVersion_name() {
		return (String) getSession(Const.SESSION_VESION_NAME);
	}

	// 获取Session
	public Object getSession(String name) {
		// ActionContext actionContext = ActionContext.getContext();
		// Map<String, Object> session = actionContext.getSession();
		// return session.get(name);
		return cacheService.get(CacheService.CACHE_SESSION + getStatusid()
				+ "_" + name);
	}

	public void removeSession(String name) {
		cacheService.remove(CacheService.CACHE_SESSION + getStatusid() + "_"
				+ name);
	}

	// 获取Session
	public Map<String, Object> getSession() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		return session;
	}

	// 设置Session
	public void setSession(String name, Object value) {
		// ActionContext actionContext = ActionContext.getContext();
		// Map<String, Object> session = actionContext.getSession();
		// session.put(name, value);
		if (value != null) {
			cacheService.set(CacheService.CACHE_SESSION + getStatusid() + "_"
					+ name, value, CacheService.CACHE_SESSION_TIME);
		}
	}

	public Object getAdmin_name() {
		return getSession(Const.SESSION_ADMIN_NAME);
	}

	// 获取Request
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	// 获取Response
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	// 获取Application
	public ServletContext getApplication() {
		return ServletActionContext.getServletContext();
	}

	protected String getStatusid() {
		String statusid = cookieGet("cookie2");
		if (statusid == null) {
			statusid = (String) getAttribute("cookie2");
		}
		return statusid;
	}

	protected String cookieGet(String key) {
		Cookie[] cookies = getRequest().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(key)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * @param isfront
	 *            是否前台的
	 * @return
	 */
	public String[] getAppInfo(boolean isfront) {
		String[] infos = new String[2];
		SystemClass systemClass = null;
		if (isfront) {
			systemClass = getFrontSystemClass();
		} else {
			systemClass = getAdminSystemClass();
		}

		if (StringUtils.isEmpty(systemClass.getAppId())
				|| StringUtils.isEmpty(systemClass.getAppSecret())) {
			return null;
		} else {
			infos[0] = systemClass.getAppId();
			infos[1] = systemClass.getAppSecret();
			return infos;
		}
	}

	// AJAX输出，返回null
	public String ajax(String content, String type) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// AJAX输出文本，返回null
	public String ajaxText(String text) {
		return ajax(text, "text/plain");
	}

	// AJAX输出HTML，返回null
	public String ajaxHtml(String html) {
		return ajax(html, "text/html");
	}

	// AJAX输出XML，返回null
	public String ajaxXml(String xml) {
		return ajax(xml, "text/xml");
	}

	// 根据字符串输出JSON，返回null
	public String ajaxJson(String jsonString) {
		return ajax(jsonString, "text/html");
	}

	// 根据Map输出JSON，返回null
	public String ajaxJson(Map<String, String> jsonMap) {
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return ajax(jsonObject.toString(), "text/html");
	}

	// 输出JSON警告消息，返回null
	public String ajaxJsonWarnMessage(String message) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		return ajax(jsonObject.toString(), "text/html");
	}

	// 输出JSON成功消息，返回null
	public String ajaxJsonSuccessMessage(String message) {
		if (StringUtils.isEmpty(message)) {
			return ajaxJson("{\"success\":true}");
		}
		return ajaxJson("{\"success\":true,\"message\":\"" + message + "\"}");
	}

	// 输出JSON错误消息，返回null
	public String ajaxJsonErrorMessage(String message) {
		return ajaxJson("{\"success\":false,\"msg\":\"" + message + "\"}");
	}

	// 设置页面不缓存
	public void setResponseNoCache() {
		getResponse().setHeader("progma", "no-cache");
		getResponse().setHeader("Cache-Control", "no-cache");
		getResponse().setHeader("Cache-Control", "no-store");
		getResponse().setDateHeader("Expires", 0);
	}

	public Integer getSystemName() {
		if (getParameter("uu") != null) {
			return Integer.parseInt(getParameter("uu"));
		} else {
			return (Integer) getSession(Const.SESSION_SYSTEMCLASS_NAME);
		}
	}

	public SystemClass getAdminSystemClass() {

		return systemClassService
				.get((Integer) getSession(Const.SESSION_ADMIN_NAME));
	}

	public Object getSession_customer_id() {
		if (getSession(Const.SESSION_CUSTOMER_ID) == null) {
			return null;
		}
		return getSession(Const.SESSION_CUSTOMER_ID);
	}

	public SystemClass getFrontSystemClass() {
		return systemClassService.get(getSystemName());
	}

	public String getAdminAccessToken() throws Exception {

		SystemClass systemClass = getAdminSystemClass();
		if (systemClass.getAppId() == null
				|| systemClass.getAppSecret() == null) {
			return null;
		}
		return wxmenuService.getAccessToken(systemClass.getAppId(),
				systemClass.getAppSecret());
	}

	public String getAccessToken() throws Exception {

		SystemClass systemClass = getFrontSystemClass();
		if (systemClass.getAppId() == null
				|| systemClass.getAppSecret() == null) {
			return null;
		}
		return wxmenuService.getAccessToken(systemClass.getAppId(),
				systemClass.getAppSecret());
	}

	public String getTick() throws Exception {
		SystemClass systemClass = getFrontSystemClass();
		return wxmenuService.getTicket(systemClass.getAppId(),
				systemClass.getAppSecret());
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public String getRedirectionUrl() {
		return redirectionUrl;
	}

	public void setRedirectionUrl(String redirectionUrl) {
		this.redirectionUrl = redirectionUrl;
	}

	public List getList() {
		return list;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
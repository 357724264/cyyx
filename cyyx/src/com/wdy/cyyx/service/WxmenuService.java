package com.wdy.cyyx.service;

import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.entity.Wxmenu;



public interface WxmenuService extends BaseService<Wxmenu, String>  {

	
	public String getAccessToken(String appId, String appSecret)
			throws Exception;

	public String getTicket(String appId, String appSecret) throws Exception;

	/**
	 * 
	 * @param customer
	 *            用户
	 * @param systemClass
	 *            系统
	 * @param realPath
	 *            系统的真实路径
	 * @param accessToken
	 * @return 海报的相对路径
	 */
	// public String saveOrgetTgHbUrl(Customer customer, SystemClass
	// systemClass,
	// String realPath, String accessToken) throws Exception;
}

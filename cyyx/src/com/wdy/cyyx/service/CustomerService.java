package com.wdy.cyyx.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.wdy.cyyx.entity.Customer;

public interface CustomerService extends BaseService<Customer, Integer> {

	/**
	 * 
	 * @param access_token
	 * @param weixinid
	 * @param systemid
	 * @return
	 */
	public Customer saveorGetCustomer(String access_token, String weixinid,
			int systemid) throws ClientProtocolException, IOException;

	public double getAllUserComiision(Integer systemClassid, String type);
}

package com.wdy.cyyx.service.impl;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.common.WxUser;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.SystemClassService;
import com.wdy.cyyx.service.WxmenuService;
import com.wdy.cyyx.util.StringUtils;
import com.wdy.cyyx.util.WxMenuUtils;
import com.wdy.cyyx.dao.CustomerDao;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.service.CustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Integer>
		implements CustomerService {

	@Resource
	private CustomerDao customerDao;
	@Resource
	private WxmenuService wxmenuService;

	@Resource
	private SystemClassService systemClassService;

	@Resource
	public void setBaseDao(CustomerDao customerDao) {
		super.setBaseDao(customerDao);
	}

	public Customer saveorGetCustomer(String access_token, String weixinid,
			int systemid) throws ClientProtocolException, IOException {
		Customer customer = customerDao.get(
				new QueryParam(1).add("weixinid", weixinid), false);
		boolean has = false;
		if (customer != null) {
			has = true;
		}
		if (customer == null && access_token != null) {
			if (!has) {
				customer = new Customer();
				customer.setWeixinid(weixinid);
				customer.setSystemid(systemid);
				customer.setCreateDate(new Date());
			}
			WxUser user = WxMenuUtils.getUserInfobyWeb(access_token, weixinid);
			if (user != null) {
				String nickname = user.getNickname();
				if (nickname != null) {
					nickname = nickname.replaceAll(
							"[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", "");
				}
				customer.setName(nickname);
				customer.setPic(user.getHeadimgurl());
			}

		}
		try {
			if (has) {
				customerDao.update(customer);
			} else {
				customerDao.save(customer);
			}

		} catch (Exception e) {
			customer.setName("");
			if (has) {
				customerDao.update(customer);
			} else {
				customerDao.save(customer);
			}
		}

		return customer;
	}

	@Override
	public double getAllUserComiision(Integer systemClassid, String type) {
		// TODO Auto-generated method stub
		return customerDao.getAllUserComiision(systemClassid, type);
	}
}

package com.wdy.cyyx.action;

import javax.annotation.Resource;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.service.CustomerService;

public class WithdrawAction extends BaseAction {

	@Resource
	private CustomerService customerService;

	public String bank() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Customer user = customerService.get(userid);
		setAttribute("user", user);
		return "bank";
	}

	public String wx() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Customer user = customerService.get(userid);
		setAttribute("user", user);
		return "wx";
	}
}

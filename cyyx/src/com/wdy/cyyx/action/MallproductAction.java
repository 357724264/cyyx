package com.wdy.cyyx.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Mallproduct;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.MallproductService;

//@ParentPackage("front")
public class MallproductAction extends BaseAction {

	@Resource
	private MallproductService mpService;


	private int id;

	@Override
	public String execute() throws Exception {
		Mallproduct mproduct = mpService.get(id);
//		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
//		Customer customer = customerService.get(userid);
//		setAttribute("customer", customer);
		 setAttribute("mproduct", mproduct);
		return "mallproduct";
	}

	/**
	 * 产品列表
	 */
	public String list() {

		return LIST;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

package com.wdy.cyyx.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.MygrounpService;


@ParentPackage("front")
public class CenterAction extends BaseAction {

	@Resource
	private CustomerService customerService;

	private Customer user;
	private int tt;

	@Override
	public String execute() throws Exception {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		user = customerService.get(userid);
		return "center";
	}

	public String mygrounp() {
		return "mygrounp";
	}

	public String myuser() {
		return "myuser";
	}

	public String joingrounp() {
		return "joingrounp";
	}

	public String point() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		user = customerService.get(userid);
		return "point";
	}

	public String info() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		user = customerService.get(userid);
		return "info";
	}

	public Customer getUser() {
		return user;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

}

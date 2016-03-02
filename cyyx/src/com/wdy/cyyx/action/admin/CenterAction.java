package com.wdy.cyyx.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Deposit.DepositStat;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.DepositService;

@ParentPackage("admin")
public class CenterAction extends BaseAction {

	@Resource
	private DepositService depositService;
	@Resource
	private CustomerService customerService;

	@Override
	public String execute() throws Exception {
		SystemClass admin = getAdminSystemClass();
		setAttribute("admin", admin);
		return "center";
	}
}

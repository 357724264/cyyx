package com.wdy.cyyx.action.admin;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.SystemClass;

public class NotifytemplateAction extends BaseAction {

	@Override
	public String execute() throws Exception {
		SystemClass admin = getAdminSystemClass();
		setAttribute("admin", admin);
		return "notifytemplate";
	}

}

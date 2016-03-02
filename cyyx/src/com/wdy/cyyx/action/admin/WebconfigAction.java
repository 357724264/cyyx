package com.wdy.cyyx.action.admin;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.SystemClass;

public class WebconfigAction extends BaseAction {
	private SystemClass systemClass;

	public String setup() {
		systemClass = getAdminSystemClass();
		return "setup";
	}

	public SystemClass getSystemClass() {
		return systemClass;
	}
}

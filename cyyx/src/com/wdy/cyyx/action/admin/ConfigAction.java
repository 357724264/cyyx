package com.wdy.cyyx.action.admin;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.SystemClass;

public class ConfigAction extends BaseAction {

	private SystemClass systemClass;

	public String mp() {
		systemClass = getAdminSystemClass();
		return "mp";
	}

	public SystemClass getSystemClass() {
		return systemClass;
	}

}

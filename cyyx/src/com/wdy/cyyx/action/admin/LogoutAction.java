package com.wdy.cyyx.action.admin;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.Const;

@ParentPackage("admin")
public class LogoutAction extends BaseAction {
	@Override
	public String execute() throws Exception {
		setSession(Const.SESSION_ADMIN_NAME, null);
		getResponse().sendRedirect("login.action");
		return null;
	}

}

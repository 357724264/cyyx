package com.wdy.cyyx.action.admin.json;

import net.sf.json.JSONObject;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.SystemClass;

public class NotifytemplateAction extends BaseAction {
	private String gok;

	public String update() {
		SystemClass admin = getAdminSystemClass();
		JSONObject object = new JSONObject();
		object.put("grounpok", gok);
		admin.setNotifyjson(object.toString());
		systemClassService.update(admin);
		return ajaxJson("{\"success\":true,\"url\":\"notifytemplate.action\"}");
	}

	public String getGok() {
		return gok;
	}

	public void setGok(String gok) {
		this.gok = gok;
	}

}

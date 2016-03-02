package com.wdy.cyyx.action.json;

import javax.annotation.Resource;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.service.JflogService;

public class PointAction extends BaseAction {
	@Resource
	private JflogService jflogService;

	private int pn;

	public String list() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		list = jflogService.getList(new QueryParam(1).add("userid", userid),
				FRONT_PAGE_SIZE * (pn - 1), FRONT_PAGE_SIZE, "createDate",
				"desc", false);
		return LIST;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

}

package com.wdy.cyyx.action;

import javax.annotation.Resource;

import com.wdy.cyyx.entity.Order;
import com.wdy.cyyx.service.OrderService;
import com.wdy.cyyx.util.StringUtils;

public class OrderAction extends BaseAction {

	private String tt;
	private String id;
	@Resource
	private OrderService orderService;

	public String list() {
		if (StringUtils.isEmpty(tt)) {
			tt = "paid";
		}
		return LIST;
	}

	@Override
	public String execute() throws Exception {
		Order order = orderService.get(id);
		setAttribute("order", order);
		// TODO Auto-generated method stub
		return "order";
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

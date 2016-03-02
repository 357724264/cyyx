package com.wdy.cyyx.action.json;

import java.util.Date;

import javax.annotation.Resource;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Jflog;
import com.wdy.cyyx.entity.Order;
import com.wdy.cyyx.entity.Order.PaymentStatus;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.JflogService;
import com.wdy.cyyx.service.OrderService;
import com.wdy.cyyx.util.StringUtils;

public class OrderAction extends BaseAction {

	@Resource
	private OrderService orderService;
	@Resource
	private CustomerService customerService;
	@Resource
	private JflogService jflogService;

	private String tt;
	private int pn;
	private String id;

	public String list() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		if (StringUtils.isEmpty(tt)) {
			tt = "paid";
		}
		list = orderService.getList(new QueryParam(2).add("userid", userid)
				.add("paymentStatus", PaymentStatus.valueOf(tt)),
				FRONT_PAGE_SIZE * (pn - 1), FRONT_PAGE_SIZE, "payDate", "desc",
				false);
		return LIST;
	}

	public String sureorder() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Order order = orderService.get(id);
		if (order != null && (order.getPaymentStatus() == PaymentStatus.send)
				&& order.getUserid().equals(userid)) {
			order.setPaymentStatus(PaymentStatus.deal);
			orderService.update(order);
			// 订单成功，给上级佣金
			if (order.getUpuserid() != null) {
				Customer upuser = customerService.get(order.getUpuserid());
				upuser.setPoint(upuser.getPoint() + order.getUpusercomm());
				customerService.update(upuser);
				// 记录积分
				Jflog jflog = new Jflog();
				jflog.setContent("团购佣金");
				jflog.setCreateDate(new Date().getTime());
				if (order.getOrigin() != null) {
					jflog.setExtendstr(order.getOrigin() + "-"
							+ order.getUserid());
				}

				jflog.setPoint(order.getUpusercomm());
				jflog.setSystemid(upuser.getSystemid());
				jflog.setTt(0);
				jflog.setUserid(upuser.getCid());
				jflogService.save(jflog);
			}
		}
		return ajaxJsonSuccessMessage(null);
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

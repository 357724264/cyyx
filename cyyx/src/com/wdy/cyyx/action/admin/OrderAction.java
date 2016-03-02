package com.wdy.cyyx.action.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Order.PaymentStatus;
import com.wdy.cyyx.util.StringUtils;
import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Order;
import com.wdy.cyyx.service.OrderService;

import freemarker.template.SimpleDate;

@ParentPackage("admin")
public class OrderAction extends BaseAction {

	private static final String UPLOAD_FOLD = "up";
	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Resource
	private OrderService orderService;
	@Resource
	private CustomerService customerService;

	private String type;
	private Order order;
	private String begin;// 创建时间
	private String end;// 结束时间
	private String id;
	private Integer uid;

	public String list() throws ParseException {
		Date bb = null;
		Date ee = null;
		QueryParam params = new QueryParam(4);

		PaymentStatus stat = null;
		if (!StringUtils.isEmpty(type)) {
			stat = PaymentStatus.valueOf(type);
		}
		if (!StringUtils.isEmpty(begin)) {
			bb = sdf.parse(begin);
		}
		if (!StringUtils.isEmpty(end)) {
			ee = sdf.parse(end);

		}

		if (uid != null) {
			Customer customer = customerService.get(uid);
			setAttribute("customer", customer);
		}
		params.add("systemid", getSession(Const.SESSION_ADMIN_NAME))
				.add("paymentStatus", stat).add("userid", uid);

		if (pn == 0 || pn == 1 || ps == 0) {
			pn = 1;
			int pc = orderService.getLikestatics(pro, keyword, params,
					"createDate", bb, ee);
			// orderService.getLikeTotalCount(pro, keyword, null, params,
			// false);
			if (pc % ADMIN_PAGE_SIZE == 0) {
				ps = pc / ADMIN_PAGE_SIZE;
			} else {
				ps = pc / ADMIN_PAGE_SIZE + 1;
			}

		}

		list = orderService.getStaticsLikeList(pro, keyword, params,
				"createDate", bb, ee, ADMIN_PAGE_SIZE * (pn - 1),
				ADMIN_PAGE_SIZE, "createDate", "desc");

		return LIST;
	}

	
	@Override
	public String execute() throws Exception {
		order = orderService.get(id);
		setAttribute("order", order);
		return "order";
	}

	public String delete() {
		orderService.delete(id);
		return ajaxHtml("success");
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}

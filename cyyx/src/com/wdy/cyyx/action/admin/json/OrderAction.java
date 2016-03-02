package com.wdy.cyyx.action.admin.json;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.entity.Order.PaymentStatus;
import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.Order;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.OrderService;

@ParentPackage("admin")
public class OrderAction extends BaseAction {

	@Resource
	private OrderService orderService;
	@Resource
	private CustomerService customerService;

	private Order order;

	private String id;
	private String type;
	private String carricompany;// 快递公司
	private String carrino;// 快递编号

	private PaymentStatus paymentStatus;

	public String change() throws ClientProtocolException, IOException,Exception {
		Order order = orderService.get(id);
		
		String ret = "已发货";
		
		if (type.equals("send")) {
			ret = "已发货";
			order.setPaymentStatus(PaymentStatus.valueOf(type));
		}
		if (type.equals("free")) {
			ret = "已取消";
			order.setPaymentStatus(PaymentStatus.valueOf(type));
		}
		if (type.equals("deal")) {
			ret = "已收货";
			order.setPaymentStatus(PaymentStatus.valueOf(type));
		}
	
		orderService.update(order);
		
		return ajaxHtml(ret);
	}

	public String savecarry() {
		Order order = orderService.get(id);
		order.setCarricompany(carricompany);
		order.setCarrino(carrino);
		orderService.update(order);
		return ajaxHtml("true");
	}
	
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getCarricompany() {
		return carricompany;
	}

	public void setCarricompany(String carricompany) {
		this.carricompany = carricompany;
	}

	public String getCarrino() {
		return carrino;
	}

	public void setCarrino(String carrino) {
		this.carrino = carrino;
	}
	

}

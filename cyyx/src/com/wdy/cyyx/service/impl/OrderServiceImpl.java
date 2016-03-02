package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.dao.OrderDao;
import com.wdy.cyyx.entity.Order;
import com.wdy.cyyx.service.OrderService;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, String>implements OrderService{

	@Resource
	private CustomerService customerService;
	@Resource
	private OrderDao orderDao;
	
	@Resource
	public void setBaseDao(OrderDao orderDao) {
		super.setBaseDao(orderDao);
	}
	
	
}

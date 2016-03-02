package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Resource
	private TaskExecutor taskExecutor;
	@Resource
	private CustomerService customerService;

	public String hello() {
		taskExecutor.execute(new Runnable() {
			public void run() {
				Customer customer = customerService.get(1);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.err.println(customer.getName());
			}
		});
		return null;
	}

	public String saveauser() {
		taskExecutor.execute(new Runnable() {
			public void run() {
				Customer customer = new Customer();
				customer.setName("new user");
				customerService.save(customer);
			}
		});
		return null;
	}
}

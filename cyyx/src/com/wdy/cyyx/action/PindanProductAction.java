package com.wdy.cyyx.action;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.PindanProduct;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.PindanProductService;

@ParentPackage("front")
public class PindanProductAction extends BaseAction{
	
	@Resource
	private PindanProductService pindanProductService;
	
	@Resource
	private CustomerService customerService;
	

	
	private Integer id;
	
	@Override
	public String execute() throws Exception {

		PindanProduct product = pindanProductService.get(id);
		if(product != null) {
			if(product.getStatus() == 0 && product.getEndDate().before(new Date())) {
				product.setStatus(1);
				pindanProductService.update(product);
				
			}
			System.out.println(product.getImageList());
			
			Customer customer = customerService.get((Integer)getSession(Const.SESSION_CUSTOMER_ID));
			
			setAttribute("customer", customer);
		}
		
		setAttribute("product", product);
		
		return "pindan_proudct";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}

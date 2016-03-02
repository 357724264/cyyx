package com.wdy.cyyx.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.ProductService;

@ParentPackage("front")
public class IndexAction extends BaseAction{
	
	@Resource
	private CustomerService customerService;
	@Resource
	private ProductService productService;
	
	private Integer id;
	
	
	
	@Override
	public String execute() throws Exception {
		SystemClass systemClass = systemClassService.get(getSystemName()); 
		if (systemClass.getTemplate() != null
				&& systemClass.getTemplate().equals("wdy")) {
			Integer isfx = 0;

			Object userobj = getSession(Const.SESSION_CUSTOMER_ID);
			if (userobj != null) {
				Customer customer = customerService.get((Integer) userobj);
				setAttribute("customer", customer);
				
			}
		}
		
		
		if (id != null) {
			Product product = productService.get(id);
			setAttribute("pp", product);
		} else {
			List<Product> list = productService.getList(new QueryParam(
					1).add("systemClass.cid", getSystemName()), 0, 0,
					"orderById", "desc", false);
			if (list == null || list.isEmpty()) {
				return "noproduct";
			}
			setAttribute("pp", list.get(0));
		}
		setAttribute("webaccesstoken",
				getSession(Const.SESSION_WEB_ACCESSTOKEN_NOREFRESH));
		return "cyyx";

	
	}


	
	
	public String zutuan(){
		SystemClass systemClass = systemClassService.get(getSystemName()); 
		if (systemClass.getTemplate() != null
				&& systemClass.getTemplate().equals("wdy")) {
			Integer isfx = 0;

			Object userobj = getSession(Const.SESSION_CUSTOMER_ID);
			if (userobj != null) {
				Customer customer = customerService.get((Integer) userobj);
				setAttribute("customer", customer);
				
			}
		}
		
		
		if (id != null) {
			Product product = productService.get(id);
			setAttribute("pp", product);
		} else {
			List<Product> list = productService.getList(new QueryParam(
					1).add("systemClass.cid", getSystemName()), 0, 0,
					"orderById", "desc", false);
			if (list == null || list.isEmpty()) {
				return "noproduct";
			}
			setAttribute("pp", list.get(0));
		}
		setAttribute("webaccesstoken",
				getSession(Const.SESSION_WEB_ACCESSTOKEN_NOREFRESH));
		return "zutuan";
	}
	
	
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	

}

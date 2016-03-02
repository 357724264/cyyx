package com.wdy.cyyx.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.ProductService;
@ParentPackage("front")
public class ProductAction extends BaseAction {

	@Resource
	private ProductService productService;
	@Resource
	private CustomerService customerService;

	private Product product;
	private int id;

	@Override
	public String execute() throws Exception {
		product = productService.get(id);
		// TODO Auto-generated method stub
		Date date = new Date();
		if(product!=null){

		//如果时间到了，转态改为活动结束
		if(date.getTime() > product.getEndtime()){
			product.setCanuse(1);
			productService.update(product);
		}
			Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
			Customer customer = customerService.get(userid);
			setAttribute("customer", customer);
		
		}
		return "product";
	}

	/**
	 * 产品列表
	 */
	public String list() {

		return LIST;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

}

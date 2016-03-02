package com.wdy.cyyx.action;

import java.util.List;

import javax.annotation.Resource;

import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Address;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.service.AddressService;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.MygrounpService;
import com.wdy.cyyx.service.ProductService;

public class MygroupAction extends BaseAction {

	private String id;
	private String addid;
	@Resource
	private MygrounpService mygrounpService;
	@Resource
	private AddressService addressService;

	@Resource
	private ProductService productService;
	@Resource
	private CustomerService customerService;

	public String toget() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Customer customer = customerService.get(userid);
		Address address = null;
		if (addid != null) {
			address = addressService.get(addid);
		} else {
			List<Address> addrs = addressService.getList(
					new QueryParam(1).add("userid", userid), 0, 1,
					"createDate", "desc", false);
			if (addrs != null && !addrs.isEmpty()) {
				address = addrs.get(0);
			}
		}
		setAttribute("address", address);
		Mygrounp mygrounp = mygrounpService.get(id);
		Integer productid = mygrounp.getProductid();
		Product product = productService.get(productid);
		setAttribute("mygrounp", mygrounp);
		setAttribute("customer", customer);
		setAttribute("product", product);
		return "toget";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddid() {
		return addid;
	}

	public void setAddid(String addid) {
		this.addid = addid;
	}

}

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
import com.wdy.cyyx.service.GrounpService;
import com.wdy.cyyx.service.JflogService;
import com.wdy.cyyx.service.MygrounpService;
import com.wdy.cyyx.service.OrderService;
import com.wdy.cyyx.service.ProductService;

public class BuyAction extends BaseAction {
	@Resource
	private MygrounpService mygrounpService;
	@Resource
	private ProductService productService;
	@Resource
	private CustomerService customerService;
	@Resource
	private AddressService addressService;
	private String addid;
	private String gid;
	private Integer pid;

	public String tg() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Customer customer = customerService.get(userid);
		setAttribute("customer", customer);
		Product product;
		if (gid != null) {
			Mygrounp mygrounp = mygrounpService.get(gid);
			product = productService.get(mygrounp.getProductid());
		} else {
			product = productService.get(pid);
		}

		setAttribute("product", product);
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

		return "tg";
	}

	public String getAddid() {
		return addid;
	}

	public void setAddid(String addid) {
		this.addid = addid;
	}

	public String getGid() {
		return gid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

}

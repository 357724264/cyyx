package com.wdy.cyyx.action.json;

import java.util.Date;

import javax.annotation.Resource;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.Address;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.service.AddressService;

public class AddressAction extends BaseAction {

	private String id;

	private String phone;
	private String name;
	private String addr;
	@Resource
	private AddressService addressService;

	public String delete() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Address address = addressService.get(id);
		if (address != null && (address.getUserid() == userid.intValue())) {
			addressService.delete(address);
		}
		return ajaxJsonSuccessMessage(null);
	}

	public String edit() {
		boolean update = false;
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Address address = new Address();
		if (id != null) {
			address = addressService.get(id);
			if (address == null) {
				address = new Address();
			} else {
				update = true;
			}
		}

		address.setAddress(addr);
		address.setCreateDate(new Date().getTime());
		address.setName(name);
		address.setPhone(phone);
		address.setUserid(userid);
		if (update) {
			addressService.update(address);
		} else {
			id = addressService.save(address);
		}
		return ajaxJsonSuccessMessage(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}

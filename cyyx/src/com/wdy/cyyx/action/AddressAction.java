package com.wdy.cyyx.action;

import javax.annotation.Resource;

import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Address;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.service.AddressService;
import com.wdy.cyyx.util.StringUtils;

public class AddressAction extends BaseAction {
	@Resource
	private AddressService addressService;

	private String id;

	private Address address;

	private String tt;
	private String tid;
	private Integer pid;

	public String list() {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		list = addressService.getList(new QueryParam(1).add("userid", userid),
				0, 0, "createDate", "desc", false);
		return LIST;
	}

	public String edit() {
		if (StringUtils.isNotEmpty(id)) {
			address = addressService.get(id);
		}
		return INPUT;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

}

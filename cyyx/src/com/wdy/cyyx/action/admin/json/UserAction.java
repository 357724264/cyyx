package com.wdy.cyyx.action.admin.json;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.util.StringUtils;

public class UserAction extends BaseAction {

	@Resource
	private CustomerService customerService;
	private String phone;
	private String name;
	private Integer sex;
	private String pwd;
	private String email;
	private String pic;
	private Integer id;
	private String note;

	public String update() {
		Customer customer = customerService.get(id);
		if (customer.getPhone() == null || !customer.getPhone().equals(phone)) {
			Customer checkCustomer = customerService.get(
					new QueryParam(2).add("phone", phone).add(
							Const.SYSTEMCLASS_KEY,
							getSession(Const.SESSION_ADMIN_NAME)), false);
			if (checkCustomer != null) {
				return ajaxJson("{\"success\":false,\"msg\":\"手机号已经存在\"}");
			}
		}
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		if (!StringUtils.isEmpty(pwd)) {
			customer.setPassword(md5PasswordEncoder.encodePassword(pwd, null));
		}
		customer.setPic(pic);
		customer.setEmail(email);
		customer.setSex(sex);
		customer.setNote(note);
		customer.setName(name);
		customer.setSystemid((Integer) getAdmin_name());
		customer.setPhone(phone);
		customerService.update(customer);
		return ajaxJson("{\"success\":true,\"url\":\"user!list.action\"}");
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}

package com.wdy.cyyx.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.util.StringUtils;
@ParentPackage("admin")
public class UserAction extends BaseAction {

	@Resource
	private CustomerService customerService;
	private String type;
	private String phone;
	private String name;
	private String num;
	private Integer sex;
	private String ctype;
	private String pwd;
	private String address;
	private String email;
	private String pic;
	private Integer id;
	private Customer user;
	private String note;
	private Integer up;
	private String ll;

	public String list() {
		if (type == null) {
			type = "customer";
		}
		
		if(up!=null){
			Customer customer = customerService.get(up);
			setAttribute("customer", customer);			
		}

		QueryParam params = new QueryParam(2);
		params.add(Const.SYSTEMCLASS_KEY, getSession(Const.SESSION_ADMIN_NAME)).add(ll,up);

		if (pn == 0 || pn == 1 || ps == 0) {
			pn = 1;
			int pc = customerService.getLikeTotalCount(pro, keyword, null,
					params, false);
			if (pc % ADMIN_PAGE_SIZE == 0) {
				ps = pc / ADMIN_PAGE_SIZE;
			} else {
				ps = pc / ADMIN_PAGE_SIZE + 1;
			}

		}
		list = customerService.getLikeList(pro, keyword, null, params,
				ADMIN_PAGE_SIZE * (pn - 1), ADMIN_PAGE_SIZE, "id",
				"desc", false);
		
		int usernumber = customerService.getLikeList(pro, keyword, null, params,
				0, 0, "id","desc", false).size();
		setAttribute("usernumber", usernumber);
		
		return LIST;
	}

	//添加用户
	// public String add() {
	// return INPUT;
	// }

	public String edit() {
		user = customerService.get(id);
		return INPUT;
	}
	
	public String delete(){
		customerService.delete(id);
		return ajaxHtml("success");
	}

	// public String save() {
	// // 判断用户是否已经存在
	// Customer customer = customerService.get(
	// new QueryParam(2).add("phone", phone).add(
	// Const.SYSTEMCLASS_KEY,
	// getSession(Const.SESSION_ADMIN_NAME)), false);
	// if (customer != null) {
	// return ajaxJson("{\"success\":false,\"msg\":\"手机号已经存在\"}");
	// }
	//
	// customer = new Customer();
	// Customer checkCustomer = null;
	// if (!StringUtils.isEmpty(num)) {
	// checkCustomer = customerService.get(
	// new QueryParam(2).add("cardnum", num).add(
	// FONT_SYSTEM_KEY,
	// getSession(Const.SESSION_ADMIN_NAME)), false);
	// if (checkCustomer == null) {
	// customer.setCardnum(num);
	// } else {
	// return ajaxJson("{\"success\":false,\"msg\":\"此卡号已经存在\"}");
	// }
	// } else {
	// boolean hasnum = true;
	// String cardNum = "";
	// // 给用户编号
	// while (hasnum) {
	// cardNum = NumberUtil.getCardNum(8);
	// // 判断编号是否已经存在
	// checkCustomer = customerService.get(
	// new QueryParam(2).add("cardnum", cardNum).add(
	// FONT_SYSTEM_KEY,
	// getSession(Const.SESSION_ADMIN_NAME)), false);
	// if (checkCustomer == null) {
	// hasnum = false;
	// }
	// }
	// customer.setCardnum(cardNum);
	// }
	//
	// Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
	// if (!StringUtils.isEmpty(pwd)) {
	// customer.setPassword(md5PasswordEncoder.encodePassword(pwd, null));
	// }
	// customer.setPic(pic);
	// customer.setEmail(email);
	// customer.setSex(sex);
	// customer.setName(name);
	// customer.setCreateDate(new Date());
	// customer.setSystemClass(getAdminSystemClass());
	// customer.setPhone(phone);
	// customer.setCtype(CustomerType.valueOf(ctype));
	// customerService.save(customer);
	// return ajaxJson("{\"success\":true,\"url\":\"user!list.action?type="
	// + ctype + "\"}");
	// }

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Customer getUser() {
		return user;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getUp() {
		return up;
	}

	public void setUp(Integer up) {
		this.up = up;
	}

	public String getLl() {
		return ll;
	}

	public void setLl(String ll) {
		this.ll = ll;
	}
	
	
	

}

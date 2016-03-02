package com.wdy.cyyx.action.json;

import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Customer;
import com.wdy.cyyx.entity.Withdraw;
import com.wdy.cyyx.service.CustomerService;
import com.wdy.cyyx.service.WithdrawService;

public class WithdrawAction extends BaseAction {
	@Resource
	private CustomerService customerService;
	@Resource
	private WithdrawService withdrawService;
	private int tt;
	private String name;
	private double money;
	private String wxnum;
	private String phone;
	private String cardnum;
	private String bank;

	@Override
	public String execute() throws Exception {
		Integer userid = (Integer) getSession(Const.SESSION_CUSTOMER_ID);
		Customer user = customerService.get(userid);
		// 先判断用户有没有那么多钱
		if (money > user.getPoint()) {
			return ajaxJsonErrorMessage("金额不足");
		}
		JSONObject jsonObject = new JSONObject();
		Withdraw withdraw = new Withdraw();
		withdraw.setTt(tt);
		withdraw.setCreateDate(new Date().getTime());
		withdraw.setMoney(money);
		withdraw.setStat(0);
		withdraw.setHasmoney(user.getPoint());
		withdraw.setUserid(userid);
		withdraw.setSystemid(getSystemName());
		withdraw.setUsername(user.getName());
		jsonObject.put("name", name);
		if (tt == 0) {// 微信提现
			jsonObject.put("wxnum", wxnum);
		} else {
			jsonObject.put("card", cardnum);
			jsonObject.put("bank", bank);
		}
		withdraw.setInfo(jsonObject.toString());
		withdrawService.save(withdraw);
		user.setPhone(phone);
		//扣掉用户现在的积分
		user.setPoint(user.getPoint() - money);
		customerService.update(user);
		return ajaxJsonSuccessMessage(null);
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getWxnum() {
		return wxnum;
	}

	public void setWxnum(String wxnum) {
		this.wxnum = wxnum;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}

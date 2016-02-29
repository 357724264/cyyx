package com.wudianyi.wb.scshop.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.Column;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.scshop.common.QueryParam;
import com.wudianyi.wb.scshop.entity.Bankcard;
import com.wudianyi.wb.scshop.entity.Const;
import com.wudianyi.wb.scshop.service.BankCardService;

@ParentPackage("user")
public class BankcardAction extends BaseAction{
	
	private Integer id;
	private String cardHolder;//持卡人
	private String cardNumber;//银行卡号码
	private String phone;//手机
	private int isDefault;//是否默认 0否 1是
	private String bankName;//银行支行信息
	
	@Resource
	private BankCardService bankCardService;
	
	public String list() {
		
		Integer userid = (Integer)getSession(Const.SESSION_CUSTOMER_ID);
		
		QueryParam params = new QueryParam(1).add("userid", userid);
		
		list = bankCardService.getList(params, 0, 0, null, null, false);
		
		return LIST;
	}
	
	public String edit() {
		Bankcard  bankcard = null;
		if(id != null) {
			bankcard = bankCardService.get(id);
		}else {
			bankcard = new Bankcard();
		}
		
		setAttribute("bankcard", bankcard);
		return "edit";
	}
	
	public String updateOrSave() throws IOException {
		Bankcard bankcard = null;
		Integer userid = (Integer)getSession(Const.SESSION_CUSTOMER_ID);
		boolean isUdpate = false;
		if(id==null || id==0) {
			bankcard = new Bankcard();
			bankcard.setUserid(userid);
		}else {
			bankcard = bankCardService.get(id);
			isUdpate = true;
		
		}
		bankcard.setBankName(bankName);
		bankcard.setCardHolder(cardHolder);
		bankcard.setCardNumber(cardNumber);
		bankcard.setPhone(phone);
		bankcard.setIsDefault(isDefault);
		if(isDefault==1) {
			QueryParam params = new QueryParam().add("isDefault", 1).add("userid", userid);
			//查看之前是否有默认银行卡
			Bankcard defaultCard = bankCardService.get(params, false);
			//如果之前有默认银行卡的话，解除其默认状态
			if(defaultCard != null) {
				defaultCard.setIsDefault(0);
				bankCardService.update(defaultCard);
			}
		}
		
		
		if(isUdpate) {
			bankCardService.update(bankcard);
		}else {
			bankCardService.save(bankcard);
		}
		
		return ajaxJsonSuccessMessage("bankcard!list.action");
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

package com.wudianyi.wb.scshop.action.json;

import javax.annotation.Resource;

import com.wudianyi.wb.scshop.action.BaseAction;
import com.wudianyi.wb.scshop.common.QueryParam;
import com.wudianyi.wb.scshop.entity.Bankcard;
import com.wudianyi.wb.scshop.entity.Const;
import com.wudianyi.wb.scshop.service.BankCardService;

public class BankcardAction extends BaseAction{
	
	private Integer id;
	
	@Resource
	private BankCardService bankCardService;
	
	public String delete() {
		
		bankCardService.delete(id);
		
		return ajaxJsonSuccessMessage("");
	}
	
	public String setDefault() {
		
		Integer userid = (Integer)getSession(Const.SESSION_CUSTOMER_ID);
		
		QueryParam params = new QueryParam().add("isDefault", 1).add("userid", userid);
		
		//查看之前是否有默认银行卡
		Bankcard defaultCard = bankCardService.get(params, false);
		//如果之前有默认银行卡的话，解除其默认状态
		if(defaultCard != null) {
			defaultCard.setIsDefault(0);
			bankCardService.update(defaultCard);
		}
		//将新的卡设为默认
		Bankcard bankcard = bankCardService.get(id);
		bankcard.setIsDefault(1);
		bankCardService.update(bankcard);
		return ajaxJsonSuccessMessage("");
	}
	
	
}

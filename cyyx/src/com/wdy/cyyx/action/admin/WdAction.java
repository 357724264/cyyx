package com.wdy.cyyx.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;


import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Withdraw;
import com.wdy.cyyx.service.WithdrawService;

@ParentPackage("admin")
public class WdAction extends BaseAction{
/**
 * 提现审核
 */
	@Resource
	private WithdrawService withdrawService;
	
	private Withdraw withdraw;
	private String id;
	private int stat;
	
	public String list(){
	
		QueryParam param = new QueryParam(2);
		param.add("systemid", getSession(Const.SESSION_ADMIN_NAME)).add("stat",
				stat);
		
		if (pn == 0 || pn == 1 || ps == 0) {
			pn = 1;
			int pc = withdrawService.getTotalCount(param, false);
			if (pc % ADMIN_PAGE_SIZE == 0) {
				ps = pc / ADMIN_PAGE_SIZE;
			} else {
				ps = pc / ADMIN_PAGE_SIZE + 1;
			}
		}
		
		list = withdrawService.getList(param, ADMIN_PAGE_SIZE * (pn - 1),
				ADMIN_PAGE_SIZE, "createDate", "desc", false);
		
		return LIST;
	}
	
	
	public String edit(){
		withdraw=withdrawService.get(id);
		//用于显示
		withdraw.setInfo(withdraw.getInfo().replaceAll("\"", "").replaceAll("name", "姓名")
					.replaceAll("wxnum", "微信号").replaceAll("card", "银行卡号").replaceAll("bank", "所属银行")
					.replace("{", "").replace("}", ""));
		
		setAttribute("withdraw", withdraw);
		return "wd";
	}
	
	
	public String delete() {
		withdrawService.delete(id);
		return ajaxHtml("success");
	}
	

	public Withdraw getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Withdraw withdraw) {
		this.withdraw = withdraw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}
	
	
	
	
	
}

package com.wdy.cyyx.action.admin.json;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeansException;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.Jflog;
import com.wdy.cyyx.entity.Withdraw;
import com.wdy.cyyx.service.JflogService;
import com.wdy.cyyx.service.WithdrawService;

@ParentPackage("admin")
public class WdAction extends BaseAction {
	@Resource
	private WithdrawService withdrawService;
	@Resource
	private JflogService jflogService;

	private Withdraw withdraw;
	private String id;
	private int stat;

	public String change() {
		Integer adminid = (Integer) getAdmin_name();
		Withdraw withdraw = withdrawService.get(id);
		Date date = new Date();
		String ret = "提现失败";
		if (withdraw != null && withdraw.getSystemid() == adminid) {
			withdraw.setStat(stat);
			withdraw.setOperlog(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));//操作时间
			withdrawService.update(withdraw);
			// 积分记录
			Jflog jflog = new Jflog();
			jflog.setContent("提现");
			jflog.setCreateDate(new Date().getTime());
			jflog.setExtendstr(withdraw.getId());
			jflog.setPoint(withdraw.getMoney());
			jflog.setSystemid((Integer) getAdmin_name());
			jflog.setTt(-1);
			jflog.setUserid(withdraw.getUserid());
			jflogService.save(jflog);
		}
		if (stat == 1) {
			ret = "提现成功";
		} else {
			ret = "提现失败";
		}

		return ajaxHtml(ret);
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

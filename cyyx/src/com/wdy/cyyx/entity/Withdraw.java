package com.wdy.cyyx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cyyx_withdraw")
public class Withdraw implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private double money;
	private long createDate;
	private int stat;// 0申请中，1：申请成功，-1申请失败
	private String operlog;// 操作记录[{"时间"："xxx","事件":"xxxx","备注":"xxx"}]
	private double hasmoney;// 申请时用户的剩余余额
	private int userid;// 申请用户
	private String username;//申请用户名
	private int systemid;// 所属系统
	private int tt;// 体现方式0：微信，1：银行卡
	private String info;// 提现信息

	@Id
	@Column(length = 32, nullable = true)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public String getOperlog() {
		return operlog;
	}

	public void setOperlog(String operlog) {
		this.operlog = operlog;
	}

	public double getHasmoney() {
		return hasmoney;
	}

	public void setHasmoney(double hasmoney) {
		this.hasmoney = hasmoney;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}

package com.wdy.cyyx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_jfstat")
public class Jfstat { //积分统计

	private int id;
	private int systemid;//商家id
	private Long creatDate;//当天是几号
	
	//总统计
	private double jfintegral;//截止当天，总发放积分
	private double jfextract;//截止当天，总共已提现多少积分
	private double jfconvert;//截止当天，总共已兑换多少积分
	private double jfbalance;//截止当天，总共还余多少积分没提现
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSystemid() {
		return systemid;
	}
	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}
	public Long getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Long creatDate) {
		this.creatDate = creatDate;
	}
	public double getJfintegral() {
		return jfintegral;
	}
	public void setJfintegral(double jfintegral) {
		this.jfintegral = jfintegral;
	}
	public double getJfextract() {
		return jfextract;
	}
	public void setJfextract(double jfextract) {
		this.jfextract = jfextract;
	}
	public double getJfconvert() {
		return jfconvert;
	}
	public void setJfconvert(double jfconvert) {
		this.jfconvert = jfconvert;
	}
	public double getJfbalance() {
		return jfbalance;
	}
	public void setJfbalance(double jfbalance) {
		this.jfbalance = jfbalance;
	}
	
	
	

	
}

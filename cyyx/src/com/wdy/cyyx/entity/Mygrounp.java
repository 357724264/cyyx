package com.wdy.cyyx.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cyyx_mygrounp")
public class Mygrounp implements Serializable {

	public static void main(String[] args) {
		System.err.println(new Date().getTime());
	}

	private String id;// 主键，由 masterid-productid变换组成【masterid六十-进制 + G +
						// productid六十-进制】
	private int masterid;// 团长id
	private int productid;// 产品id
	private String productname;// 商品名字
	private long createDate;// 创建时间
	private String leavemessage;// 留言信息
	private String sharemessqage;// 分享信息
	private String mastername;// 团长名字
	private String masterpic;// 团长头像
	private int num;// 参团人数
	private long endTime;// 结束时间
	private String pic;// 产品图片
	private int minnum;// 最少人数
	private int systemid;// 商家的id，对应着systemclass的cid
	private int isget;// 是否领取产品，0未领取，1已领取
	private String orderid;// 领取后的orderid
	private Double zgmoney;// 组团资格金
	private int iszg;// 判断是否已支付资格金。0未支付，1已支付
	private String payret;// 支付的返回信息
	private double failpay;// 组团失败后购买需要支付的费用

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMasterid() {
		return masterid;
	}

	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public String getLeavemessage() {
		return leavemessage;
	}

	public void setLeavemessage(String leavemessage) {
		this.leavemessage = leavemessage;
	}

	public String getMastername() {
		return mastername;
	}

	public void setMastername(String mastername) {
		this.mastername = mastername;
	}

	public String getMasterpic() {
		return masterpic;
	}

	public void setMasterpic(String masterpic) {
		this.masterpic = masterpic;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

	public int getMinnum() {
		return minnum;
	}

	public void setMinnum(int minnum) {
		this.minnum = minnum;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getIsget() {
		return isget;
	}

	public void setIsget(int isget) {
		this.isget = isget;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Double getZgmoney() {
		return zgmoney;
	}

	public void setZgmoney(Double zgmoney) {
		this.zgmoney = zgmoney;
	}

	public int getIszg() {
		return iszg;
	}

	public void setIszg(int iszg) {
		this.iszg = iszg;
	}

	public String getSharemessqage() {
		return sharemessqage;
	}

	public void setSharemessqage(String sharemessqage) {
		this.sharemessqage = sharemessqage;
	}

	public String getPayret() {
		return payret;
	}

	public void setPayret(String payret) {
		this.payret = payret;
	}

	public double getFailpay() {
		return failpay;
	}

	public void setFailpay(double failpay) {
		this.failpay = failpay;
	}

	/**
	 * 得到该团的状态
	 * 
	 * @return
	 */
	@Transient
	public String getStat() {
		long now = new Date().getTime();
		if (isget == 1) {
			return "geted";
		}
		if (num >= minnum && isget == 0) {
			return "unget";
		}
		if (now > endTime) {
			return "end";
		}
		return "being";
	}
}

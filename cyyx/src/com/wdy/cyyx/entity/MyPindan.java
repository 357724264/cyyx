package com.wdy.cyyx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_mypindan")
public class MyPindan implements Serializable {

	public static void main(String[] args) {
		System.err.println(new Date().getTime());
	}

	private String id;// 主键，由 masterid-productid变换组成【masterid六十-进制 + G +
						// productid六十-进制】
	private int masterid;// 发起人id
	private int productid;// 产品id(PindanProduct)
	private String productName;// 商品名字
	private Date createTime;// 创建时间
	private Date endDTime;// 结束时间
	private String leaveMessage;// 留言信息
	private String shareMessqage;// 分享信息
	private String masterName;// 发起人名字
	private String masterPic;// 发起人头像
	private int numOfPeople;// 拼单要求人数
	private int num;// 已参与人数
	private String pic;// 产品图片
	private int systemid;// 商家的id，对应着systemclass的cid
	private String orderid;// 领取后的orderid
	private Double price;// 拼单后的单价
	private String payret;// 支付的返回信息


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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEndDTime() {
		return endDTime;
	}

	public void setEndDTime(Date endDTime) {
		this.endDTime = endDTime;
	}

	public String getLeaveMessage() {
		return leaveMessage;
	}

	public void setLeaveMessage(String leaveMessage) {
		this.leaveMessage = leaveMessage;
	}

	public String getShareMessqage() {
		return shareMessqage;
	}

	public void setShareMessqage(String shareMessqage) {
		this.shareMessqage = shareMessqage;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getMasterPic() {
		return masterPic;
	}

	public void setMasterPic(String masterPic) {
		this.masterPic = masterPic;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPayret() {
		return payret;
	}

	public void setPayret(String payret) {
		this.payret = payret;
	}

	
}

package com.wdy.cyyx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cyyx_order")
public class Order {

	// 订单状态（未付款、已支付、已发货、已完成、取消）
	public enum PaymentStatus {
		unpaid, paid, send, deal, free
	};

	// 订单类型（组团、团购、拼单）
	public enum OrderType {
		zutuan, tuangou, pingdan
	}

	private String id;
	private String orderSn;// 订单编号
	private int paytype;// 0:网上支付，1：积分支付
	private PaymentStatus paymentStatus;// 支付状态
	private Integer userid;// 用户id
	private String weixinid;
	private long createDate;// 创建时间and订单开始时间
	private long payDate;// 支付时间
	private double money;
	private double point;//使用积分
	private String phone;
	private int systemid;
	private String name;
	private String address;
	private String page;// 封面
	private String pageName;// 封面名字
	private String size;// 规格
	private int num;// 购买数量
	private OrderType orderType;
	private String payret;// 支付返回内容
	private Integer upuserid;// 上级用户
	private double upusercomm;// 上级用户得到的佣金
	private String carricompany;// 快递公司
	private String carrino;// 快递编号
	private String origin;// 来源

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

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

	public String getPayret() {
		return payret;
	}

	public void setPayret(String payret) {
		this.payret = payret;
	}

	public double getUpusercomm() {
		return upusercomm;
	}

	public void setUpusercomm(double upusercomm) {
		this.upusercomm = upusercomm;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Integer getUpuserid() {
		return upuserid;
	}

	public void setUpuserid(Integer upuserid) {
		this.upuserid = upuserid;
	}

	public String getCarricompany() {
		return carricompany;
	}

	public void setCarricompany(String carricompany) {
		this.carricompany = carricompany;
	}

	public String getCarrino() {
		return carrino;
	}

	public void setCarrino(String carrino) {
		this.carrino = carrino;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public long getPayDate() {
		return payDate;
	}

	public void setPayDate(long payDate) {
		this.payDate = payDate;
	}

	public int getPaytype() {
		return paytype;
	}

	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
	
	
	

}

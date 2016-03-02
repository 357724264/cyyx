package com.wdy.cyyx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.util.StringUtils;

@Entity
@Table(name = "cyyx_customer")
public class Customer {

	private int cid;
	private String weixinid;
	private String phone;
	private String password;
	private String email;
	private String name;
	private int sex;// 0女，1男
	private int systemid;// 对应的系统
	private String pic;
	private Date createDate;
	private String intro;
	private double point = 0.00;// 积分
	private String note;// 备注
	private Integer upid;// 上级，带你入坑的人，你帮他助力的
	private Integer one;// 上级，带你入坑的人，你帮他助力的
	private String wxnum;// 微信号码
	private String smallurl;// 头像url，小图
	private int issub;// 是否关注过了
	private String theHelps;// 参与过的助力，用于判断如果里面有对应活动的id，就不能再助力
	private int charm;// 魅力指数

	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getUpid() {
		return upid;
	}

	public void setUpid(Integer upid) {
		this.upid = upid;
	}

	public String getWxnum() {
		return wxnum;
	}

	public void setWxnum(String wxnum) {
		this.wxnum = wxnum;
	}

	public String getSmallurl() {
		return smallurl;
	}

	public void setSmallurl(String smallurl) {
		this.smallurl = smallurl;
	}

	@Transient
	public String getJudgecid() {
		return "," + cid + ",";
	}

	@Transient
	public String getSecretPhone() {
		if (!StringUtils.isEmpty(phone)) {
			return phone.substring(0, 3) + "*****";
		}
		return "****";
	}

	public Integer getOne() {
		return one;
	}

	public void setOne(Integer one) {
		this.one = one;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getTheHelps() {
		return theHelps;
	}

	public void setTheHelps(String theHelps) {
		this.theHelps = theHelps;
	}

	public int getCharm() {
		return charm;
	}

	public void setCharm(int charm) {
		this.charm = charm;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getIssub() {
		return issub;
	}

	public void setIssub(int issub) {
		this.issub = issub;
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

}

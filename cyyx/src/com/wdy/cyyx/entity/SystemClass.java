package com.wdy.cyyx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wdy.cyyx.util.StringUtils;

import net.sf.json.JSONObject;

@Entity
@Table(name = "cyyx_systemclass")
public class SystemClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String linkname;// 联系人名字
	private String linkphone;// 联系电话
	private String linkemail;
	private String linkqq;
	private String username;// 商家账号
	private String pwd;// 密码
	private String company;// 公司
	private String intro;
	private Date createDate;
	private String template;// 模板
	private String footercompany;// 底部显示公司
	private String footertel;// 底部显示的电话
	private double pointscale;// 多少积分换一块
	// 公众号相关
	private String appId;
	private String appSecret;// appSecret
	private String suburl;// 关注链接
	// 微信支付相关
	private String wxpaySecret;// 微信支付密钥
	private String mchid;// 微信支付商户ID
	private int stat;// 账户状态 -1删除，0正常 1：禁用
	private String notifyjson;// 通知模板{"grounpok":"xxxxx"}
	private String cdlmessage;// CompanyDefaultLeaveMessage商家默认留言
	private String cdsmessage;// CompanyDefaultShareMessage商家默认分享语
	private String functionitems;// 可享有的功能列表，用双逗号隔开，例如：（,user,order,）;

	@Id
	@GeneratedValue
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getLinkname() {
		return linkname;
	}

	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}

	public String getLinkphone() {
		return linkphone;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}

	public String getLinkemail() {
		return linkemail;
	}

	public void setLinkemail(String linkemail) {
		this.linkemail = linkemail;
	}

	public String getLinkqq() {
		return linkqq;
	}

	public void setLinkqq(String linkqq) {
		this.linkqq = linkqq;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getFootercompany() {
		return footercompany;
	}

	public void setFootercompany(String footercompany) {
		this.footercompany = footercompany;
	}

	public String getFootertel() {
		return footertel;
	}

	public void setFootertel(String footertel) {
		this.footertel = footertel;
	}

	public String getWxpaySecret() {
		return wxpaySecret;
	}

	public void setWxpaySecret(String wxpaySecret) {
		this.wxpaySecret = wxpaySecret;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getSuburl() {
		return suburl;
	}

	public void setSuburl(String suburl) {
		this.suburl = suburl;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public double getPointscale() {
		return pointscale;
	}

	public void setPointscale(double pointscale) {
		this.pointscale = pointscale;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public String getNotifyjson() {
		return notifyjson;
	}

	public void setNotifyjson(String notifyjson) {
		this.notifyjson = notifyjson;
	}

	@Transient
	public String getGrounpOkTemplateId() {
		if (StringUtils.isEmpty(notifyjson)) {
			return null;
		}
		JSONObject jsonObject = JSONObject.fromObject(notifyjson);
		if (jsonObject.get("grounpok") == null) {
			return null;
		}
		return jsonObject.getString("grounpok");
	}

	public String getCdlmessage() {
		return cdlmessage;
	}

	public void setCdlmessage(String cdlmessage) {
		this.cdlmessage = cdlmessage;
	}

	public String getCdsmessage() {
		return cdsmessage;
	}

	public void setCdsmessage(String cdsmessage) {
		this.cdsmessage = cdsmessage;
	}

	public String getFunctionitems() {
		return functionitems;
	}

	public void setFunctionitems(String functionitems) {
		this.functionitems = functionitems;
	}

}

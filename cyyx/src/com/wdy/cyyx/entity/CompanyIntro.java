package com.wdy.cyyx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_companyintro")
public class CompanyIntro {
	/**
	 * 
	 */
	private Integer cid;
	private String alias;//别名
	private Integer orderbyId;
	private String title;//公司名称
	private String picUrl;//头像logo
	private String intro;//简介
	private String newsDesc;
	private Date createDate;
	private Integer nodeid;
	private int systemid;
	private String cdlmessage;//CompanyDefaultLeaveMessage商家默认流言
	private String cdsmeaasge;//CompanyDefaultShareMessage商家默认分享语

	@Id
	@GeneratedValue
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getNewsDesc() {
		return newsDesc;
	}

	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}

	public Integer getOrderbyId() {
		return orderbyId;
	}

	public void setOrderbyId(Integer orderbyId) {
		this.orderbyId = orderbyId;
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getNodeid() {
		return nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

	public String getCdlmessage() {
		return cdlmessage;
	}

	public void setCdlmessage(String cdlmessage) {
		this.cdlmessage = cdlmessage;
	}

	public String getCdsmeaasge() {
		return cdsmeaasge;
	}

	public void setCdsmeaasge(String cdsmeaasge) {
		this.cdsmeaasge = cdsmeaasge;
	}
	
	
	
	
	

}

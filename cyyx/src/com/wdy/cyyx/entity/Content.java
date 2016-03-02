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
@Table(name = "cyyx_content")
public class Content {

	private int cid;
	private String pic;
	private String htmldesc;
	private String intro;
	private Date createDate;
	private Integer nodeid;
	private Integer orderbyId;
	private SystemClass systemClass;

	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getHtmldesc() {
		return htmldesc;
	}

	public void setHtmldesc(String htmldesc) {
		this.htmldesc = htmldesc;
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

	public Integer getNodeid() {
		return nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

	public Integer getOrderbyId() {
		return orderbyId;
	}

	public void setOrderbyId(Integer orderbyId) {
		this.orderbyId = orderbyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "systemClass")
	public SystemClass getSystemClass() {
		return systemClass;
	}

	public void setSystemClass(SystemClass systemClass) {
		this.systemClass = systemClass;
	}

}

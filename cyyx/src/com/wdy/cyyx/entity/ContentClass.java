package com.wdy.cyyx.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_contentclass")
public class ContentClass {

	private int cid;
	private String displayName;
	private String pic;
	private Integer orderbyId;
	private SystemClass systemClass;
	private String url;

	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}

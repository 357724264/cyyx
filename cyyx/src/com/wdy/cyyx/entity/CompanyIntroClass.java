package com.wdy.cyyx.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_companyintroclass")
public class CompanyIntroClass {

	private int cid;
	private String name;
	private String intro;
	private String pic;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "systemClass")
	public SystemClass getSystemClass() {
		return systemClass;
	}

	public void setSystemClass(SystemClass systemClass) {
		this.systemClass = systemClass;
	}

	public Integer getOrderbyId() {
		return orderbyId;
	}

	public void setOrderbyId(Integer orderbyId) {
		this.orderbyId = orderbyId;
	}

}

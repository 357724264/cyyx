package com.wdy.cyyx.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_grounp")
public class Grounp implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;// 主键，由 mygroundid-userid组成
	private int userid;// 用户id
	private String userpic;// 用户头像
	private String username;// 用户名字
	private String grounpid;// 组团id
	private int masterid;// 团长ID
	private int productid;// 产品id
	private long createDate;// 加入时间
	private Integer recommenid;// 推荐人

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public String getUserpic() {
		return userpic;
	}

	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}

	public String getGrounpid() {
		return grounpid;
	}

	public void setGrounpid(String grounpid) {
		this.grounpid = grounpid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public Integer getRecommenid() {
		return recommenid;
	}

	public void setRecommenid(Integer recommenid) {
		this.recommenid = recommenid;
	}

	public int getMasterid() {
		return masterid;
	}

	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

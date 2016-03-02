package com.wdy.cyyx.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cyyx_pindan_member")
public class PindanMember {
	private String id;// 主键，由 pindanid-userid组成
	private int userid;// 用户id
	private String userPic;// 用户头像
	private String userName;// 用户名字
	private String pindanid;// mypindan的id
	private int masterid;// 发起人id
	private int productid;// 产品id
	private Date createTime;// 参加时间
	private int recommenid;// 推荐人

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


	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getRecommenid() {
		return recommenid;
	}

	public void setRecommenid(int recommenid) {
		this.recommenid = recommenid;
	}

	public int getMasterid() {
		return masterid;
	}

	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPindanid() {
		return pindanid;
	}

	public void setPindanid(String pindanid) {
		this.pindanid = pindanid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}

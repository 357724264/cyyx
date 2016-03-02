package com.wdy.cyyx.entity;

import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.wdy.cyyx.util.StringUtils;

@Entity
@Table(name = "cyyx_mallproduct")
public class Mallproduct {

	/**
	 * 商城商品
	 */

	private int id;
	private String title;// 产品链接名称
	private String name;// 产品名称
	private String pic;// 缩略图
	private String images;// 轮询图
	private int systemid;
	private long createDate;

	private String gg;// 规格
	private Double rawmoney;// 原价
	private String detail;//图文
	private String quality;// 属性
	private String minutia;// 参数
	private int orderById;// 排序
	
	private String intro;//简介

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Transient//属性
	public String[] getQualityList() {
		if (StringUtils.isEmpty(quality)) {
			return null;
		}
		return quality.split("--");
	}

	@Transient//参数
	public String[] getMinutiaList() {
		if (StringUtils.isEmpty(minutia)) {
			return null;
		}
		return minutia.split("--");
	}

	@Transient//图片
	public String[] getImageList() {
		if (images == null) {
			return null;
		}
		return images.split(", ");
	}
	
	@Transient//规格
	public String[] getGgs() {
		if (StringUtils.isEmpty(gg)) {
			return null;
		}
		return gg.split("--");
	}
	
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getMinutia() {
		return minutia;
	}

	public void setMinutia(String minutia) {
		this.minutia = minutia;
	}

//	public Integer getIshot() {
//		return ishot;
//	}
//
//	public void setIshot(Integer ishot) {
//		this.ishot = ishot;
//	}

	public int getOrderById() {
		return orderById;
	}

	public void setOrderById(int orderById) {
		this.orderById = orderById;
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public Double getRawmoney() {
		return rawmoney;
	}

	public void setRawmoney(Double rawmoney) {
		this.rawmoney = rawmoney;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	

}

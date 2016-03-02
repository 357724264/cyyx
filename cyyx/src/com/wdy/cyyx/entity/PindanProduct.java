package com.wdy.cyyx.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wdy.cyyx.util.StringUtils;

@Entity
@Table(name = "cyyx_pindan_product")
public class PindanProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;// 活动标题
	private String intro;// 活动简介
	private int displayOrder;// 排序
	private String name;// 产品名
	private String thumbnails;// 列表用的缩略图
	private String images;// 明细图
	private String specification;// 规格
	private String instruction;// 活动说明
	private String jfinstruction;//积分说明
	private double jfOne;// 一级积分比率 60 即60%。买100块的东西，上一级就积60分
	private int systemid;
	private String pdlmessage;//productDefaultLeaveMessage商家默认流言
	private String pdsmessage;//productDefaultShareMessage商家默认分享语
	private Double price;//价格
	private int days;//申请拼单后的有效天数
	private Date endDate;// 整个活动的结束日期
	private String videoLink;//视屏链接
	private int status;//活动是否结束   0未结束  1结束
	private String numOfPeople;//拼单方式中的人数(与拼单方式中的价格相对应)
	private String pindanPrice;//拼单方式中的价格
	private int num;//参加拼单总人数
	
	@Transient
	public String[] getSpecifications() {
		
		if(StringUtils.isEmpty(specification)) {
			
			return null;
		}
			
			return specification.split("--");
		
		
	}
	
	@Transient
	public String[] getNumOfPeopleList() {
		
		if(StringUtils.isEmpty(numOfPeople)) {
			
			return null;
		}
		
		return numOfPeople.split("--");
	}
	
	@Transient
	public List<String> getImageList() {
		
		if(StringUtils.isEmpty(images)) {
			
			return null;
		}
		//去除空的照片地址，保持前端页面整洁
		List<String> imageList = new ArrayList<String>();
		String[] strList = images.split(",");
		for (int i = 0; i < strList.length; i++) {
			if(!"".equals(strList[i].trim())) {
				imageList.add(strList[i]);
			}
		}
		return imageList;
	}
	
	@Transient
	public String[] getPindanPriceList() {
		
		if(StringUtils.isEmpty(pindanPrice)) {
			
			return null;
		}
		
		return pindanPrice.split("--");
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getJfinstruction() {
		return jfinstruction;
	}
	public void setJfinstruction(String jfinstruction) {
		this.jfinstruction = jfinstruction;
	}
	public double getJfOne() {
		return jfOne;
	}
	public void setJfOne(double jfOne) {
		this.jfOne = jfOne;
	}
	public int getSystemid() {
		return systemid;
	}
	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}
	public String getPdlmessage() {
		return pdlmessage;
	}
	public void setPdlmessage(String pdlmessage) {
		this.pdlmessage = pdlmessage;
	}
	public String getPdsmessage() {
		return pdsmessage;
	}
	public void setPdsmessage(String pdsmessage) {
		this.pdsmessage = pdsmessage;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNumOfPeople() {
		return numOfPeople;
	}
	public void setNumOfPeople(String numOfPeople) {
		this.numOfPeople = numOfPeople;
	}
	public String getPindanPrice() {
		return pindanPrice;
	}
	public void setPindanPrice(String pindanPrice) {
		this.pindanPrice = pindanPrice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
}

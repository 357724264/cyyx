package com.wdy.cyyx.entity;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.lulu.tool.DateUtil;
import com.wdy.cyyx.util.StringUtils;

@Entity
@Table(name = "cyyx_product")
public class Product {

	private int cid;
	private String title;// 活动标题
	private String intro;// 活动简介
	private int orderById;// 排序
	private String name;// 产品名
	private String pic;// 列表用的缩略图
	private String images;// 明细图
	private String gg;// 规格
	private String instruction;// 活动说明
	private String jfinstruction;//积分说明
	private double jfOne;// 一级积分比率 60 即60%。买100块的东西，上一级就积60分
	private int systemid;
	private String pdlmessage;//productDefaultLeaveMessage商家默认流言
	private String pdsmessage;//productDefaultShareMessage商家默认分享语
	
	
	private Double rawmoney;//原价
	//我是团长
	private Double zgmoney;// 组团资格（先给多少钱）
	private Double sbmoney;//助力失败后再给多少钱
	private Integer zltime;//一个小团的时效（天）
	private long endtime;// 整个组团期限（日期）
	private int minnum;// 最少助力人数
	//团购
	private Double tgmoney;// 团购价格
	
	private String pvideo;//视屏链接
	private int canuse;//活动是否结束   0未结束  1结束
	
	

	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public int getOrderById() {
		return orderById;
	}

	public void setOrderById(int orderById) {
		this.orderById = orderById;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTgmoney() {
		return tgmoney;
	}

	public void setTgmoney(Double tgmoney) {
		this.tgmoney = tgmoney;
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

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public double getJfOne() {
		return jfOne;
	}

	public void setJfOne(double jfOne) {
		this.jfOne = jfOne;
	}

	public long getEndtime() {
		return endtime;
	}

	public void setEndtime(long endtime) {
		this.endtime = endtime;
	}

	public Integer getZltime() {
		return zltime;
	}

	public void setZltime(Integer zltime) {
		this.zltime = zltime;
	}

	public int getMinnum() {
		return minnum;
	}

	public void setMinnum(int minnum) {
		this.minnum = minnum;
	}

	@Transient
	public String[] getImageList() {
		if (images == null) {
			return null;
		}
		return images.split(", ");
	}

	@Transient
	public String[] getGgs() {
		if (StringUtils.isEmpty(gg)) {
			return null;
		}
		return gg.split("--");
	}

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

	public Double getRawmoney() {
		return rawmoney;
	}

	public void setRawmoney(Double rawmoney) {
		this.rawmoney = rawmoney;
	}

	public Double getZgmoney() {
		return zgmoney;
	}

	public void setZgmoney(Double zgmoney) {
		this.zgmoney = zgmoney;
	}

	public Double getSbmoney() {
		return sbmoney;
	}

	public void setSbmoney(Double sbmoney) {
		this.sbmoney = sbmoney;
	}

	public String getJfinstruction() {
		return jfinstruction;
	}

	public void setJfinstruction(String jfinstruction) {
		this.jfinstruction = jfinstruction;
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

	public String getPvideo() {
		return pvideo;
	}

	public void setPvideo(String pvideo) {
		this.pvideo = pvideo;
	}

	public int getCanuse() {
		return canuse;
	}

	public void setCanuse(int canuse) {
		this.canuse = canuse;
	}


	
	
	

	
}

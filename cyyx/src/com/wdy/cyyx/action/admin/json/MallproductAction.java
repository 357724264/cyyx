package com.wdy.cyyx.action.admin.json;

import java.util.Date;

import javax.annotation.Resource;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.Mallproduct;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.MallproductService;

public class MallproductAction extends BaseAction {

	@Resource
	private MallproductService mpService;

	private int id;
	private String title;// 链接标题
	private String name;// 产品名称
	private String pic;// 缩略图
	private String images;// 详情图
	private int systemid;
	private long createDate;

	private String gg;// 规格
	private Double rawmoney;// 原价
	private String quality;// 属性
	private String minutia;// 参数
	private int orderById;// 排序
	private String intro;// 简介
	private String detail;// 图文

	public String save() {

		SystemClass systemClass = getAdminSystemClass();
		Date date = new Date();
		systemid = (Integer) getAdmin_name();

		Mallproduct mproduct = new Mallproduct();

		mproduct.setCreateDate(date.getTime());
		mproduct.setTitle(title);
		mproduct.setName(name);
		mproduct.setPic(pic);

		mproduct.setGg(gg);
		mproduct.setRawmoney(rawmoney);
		mproduct.setSystemid(systemid);
		mproduct.setOrderById(orderById);
		// mproduct.setIshot(ishot);
		mproduct.setImages(images);// 详图
		// 商品参数
		mproduct.setQuality(quality);// 属性
		mproduct.setMinutia(minutia);// 参数
		mproduct.setIntro(intro);
		mproduct.setDetail(detail);

		mpService.save(mproduct);

		return ajaxJson("{\"success\":true,\"url\":\"mallproduct!list.action\"}");
	}

	public String update() {
		Mallproduct mproduct = mpService.get(id);
		mproduct.setTitle(title);
		mproduct.setName(name);
		mproduct.setPic(pic);
		mproduct.setOrderById(orderById);
		// mproduct.setIshot(ishot);
		mproduct.setImages(images);// 详图
		mproduct.setGg(gg);
		mproduct.setRawmoney(rawmoney);
		// 商品参数
		mproduct.setQuality(quality);// 属性
		mproduct.setMinutia(minutia);// 参数
		mproduct.setIntro(intro);
		mproduct.setDetail(detail);

		mpService.update(mproduct);

		return ajaxJson("{\"success\":true,\"url\":\"mallproduct!list.action\"}");

	}

	public String delete() {
		mpService.delete(id);
		return ajaxHtml("success");
	}

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

	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
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

	public int getOrderById() {
		return orderById;
	}

	public void setOrderById(int orderById) {
		this.orderById = orderById;
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

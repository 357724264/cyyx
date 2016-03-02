package com.wdy.cyyx.action.admin.json;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.PindanProduct;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.PindanProductService;

public class PindanProductAction extends BaseAction {

	@Resource
	private PindanProductService pindanProductService;

	private Integer id;
	private String title;// 活动名称
	private String intro;// 广告语
	private int displayOrder;// 排序
	private String name;// 产品名
	private Double price;// 原价
	private String thumbnails;// 列表用的缩略图
	private String images;// 明细图
	private String specification;// 规格
	private String instruction;// 活动说明
	private String jfinstruction;// 积分说明
	private double jfOne;// 一级积分比率 60 即60%。买100块的东西，上一级就积60分
	private Integer days;// 组团期限
	private Date endDate;// 活动结束时间
	private int systemid;
	private String pdlmessage;// productDefaultLeaveMessage商家默认流言
	private String pdsmessage;// productDefaultShareMessage商家默认分享语
	private String videoLink;// 视屏链接
	private String numOfPeople;
	private String pindanPrice;

	public static void main(String[] args) {
		System.err.println(new Date().getTime());
	}

	public String save() throws IOException, BeansException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, InstantiationException {

		SystemClass systemClass = getAdminSystemClass();
		systemid = (Integer) getAdmin_name();

		PindanProduct product = new PindanProduct();
		product.setStatus(0);
		product.setTitle(title);
		product.setIntro(intro);
		product.setDisplayOrder(displayOrder);
		product.setName(name);
		product.setPrice(price);// 原价
		product.setVideoLink(videoLink);
		product.setThumbnails(thumbnails);
		product.setImages(images);
		product.setSpecification(specification);
		product.setDays(days);
		product.setEndDate(endDate);
		product.setJfOne(jfOne);
		if (pdlmessage.equals("")) {
			product.setPdlmessage(systemClass.getCdlmessage());// 默认流言
		} else {
			product.setPdlmessage(pdlmessage);// 默认流言
		}
		if (pdsmessage.equals("")) {
			product.setPdsmessage(systemClass.getCdsmessage());
		} else {
			product.setPdsmessage(pdsmessage);// 默认分享语
		}

		product.setSystemid(systemid);
		product.setInstruction(instruction);
		product.setNumOfPeople(numOfPeople);
		product.setPindanPrice(pindanPrice);
		
		pindanProductService.save(product);

		return ajaxJson("{\"success\":true,\"url\":\"pindan_product!list.action\"}");
	}

	public String update() {
		PindanProduct product = pindanProductService.get(id);
		product.setTitle(title);
		product.setIntro(intro);
		product.setDisplayOrder(displayOrder);
		product.setName(name);
		product.setPrice(price);// 原价
		product.setVideoLink(videoLink);
		product.setThumbnails(thumbnails);
		product.setImages(images);
		product.setSpecification(specification);
		product.setDays(days);
		product.setEndDate(endDate);
		product.setJfOne(jfOne);
		product.setPdlmessage(pdlmessage);// 默认流言
		product.setPdsmessage(pdsmessage);// 默认分享语
		product.setInstruction(instruction);
		product.setNumOfPeople(numOfPeople);
		product.setPindanPrice(pindanPrice);
		

		pindanProductService.update(product);

		return ajaxJson("{\"success\":true,\"url\":\"pindan_product!list.action\"}");
	}

	public String delete() {
		pindanProductService.delete(id);
		return ajaxHtml("success");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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



	public int getSystemid() {
		return systemid;
	}

	public void setSystemid(int systemid) {
		this.systemid = systemid;
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

	public PindanProductService getPindanProductService() {
		return pindanProductService;
	}

	public void setPindanProductService(PindanProductService pindanProductService) {
		this.pindanProductService = pindanProductService;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
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
	
	

}

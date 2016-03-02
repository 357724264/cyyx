package com.wdy.cyyx.action.admin.json;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.CompanyIntroService;
import com.wdy.cyyx.service.ProductService;
import com.wdy.cyyx.service.SystemClassService;

public class ProductAction extends BaseAction {

	@Resource
	private ProductService productService;

	private Integer id;
	private String title;// 活动名称
	private String intro;// 广告语
	private int orderById;// 排序
	private String name;// 产品名
	private Double rawmoney;// 原价
	private Double zgmoney;// 组团资格（先给多少钱）
	private Double sbmoney;// 助力失败后再给多少钱
	private Double tgmoney;// 团购价格
	private String pic;// 列表用的缩略图
	private String images;// 明细图
	private String gg;// 规格
	private String instruction;// 活动说明
	private String jfinstruction;// 积分说明
	private double jfOne;// 一级积分比率 60 即60%。买100块的东西，上一级就积60分
	private Integer zltime;// 组团期限
	private Date endtime;// 活动结束时间
	private int minnum;// 最少参与人数
	private int systemid;
	private String pdlmessage;// productDefaultLeaveMessage商家默认流言
	private String pdsmessage;// productDefaultShareMessage商家默认分享语
	private String pvideo;// 视屏链接

	public static void main(String[] args) {
		System.err.println(new Date().getTime());
	}

	public String save() throws IOException, BeansException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, InstantiationException {

		SystemClass systemClass = getAdminSystemClass();
		systemid = (Integer) getAdmin_name();

		Product product = new Product();
		product.setCanuse(0);
		product.setTitle(title);
		product.setIntro(intro);
		product.setOrderById(orderById);
		product.setName(name);
		product.setRawmoney(rawmoney);// 原价
		product.setZgmoney(zgmoney);// 组团资格价
		product.setSbmoney(sbmoney);// 组团失败价
		product.setTgmoney(tgmoney);// 团购价
		product.setPvideo(pvideo);
		product.setPic(pic);
		product.setImages(images);
		product.setGg(gg);
		product.setZltime(zltime);
		product.setEndtime(endtime.getTime());
		product.setMinnum(minnum);
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

		productService.save(product);

		return ajaxJson("{\"success\":true,\"url\":\"product!list.action\"}");
	}

	public String update() {
		Product product = productService.get(id);
		product.setTitle(title);
		product.setIntro(intro);
		product.setOrderById(orderById);
		product.setName(name);
		product.setRawmoney(rawmoney);// 原价
		product.setZgmoney(zgmoney);// 组团资格价
		product.setSbmoney(sbmoney);// 组团失败价
		product.setTgmoney(tgmoney);// 团购价
		product.setPvideo(pvideo);
		product.setPic(pic);
		product.setImages(images);
		product.setGg(gg);
		product.setZltime(zltime);
		product.setEndtime(endtime.getTime());
		product.setMinnum(minnum);
		product.setJfOne(jfOne);
		product.setPdlmessage(pdlmessage);// 默认流言
		product.setPdsmessage(pdsmessage);// 默认分享语
		product.setInstruction(instruction);

		productService.update(product);

		return ajaxJson("{\"success\":true,\"url\":\"product!list.action\"}");
	}

	public String delete() {
		productService.delete(id);
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

	public Integer getZltime() {
		return zltime;
	}

	public void setZltime(Integer zltime) {
		this.zltime = zltime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public int getMinnum() {
		return minnum;
	}

	public void setMinnum(int minnum) {
		this.minnum = minnum;
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

}

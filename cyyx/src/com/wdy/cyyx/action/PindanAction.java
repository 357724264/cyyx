package com.wdy.cyyx.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.entity.PindanProduct;
import com.wdy.cyyx.service.PindanProductService;

@ParentPackage("front")
public class PindanAction extends BaseAction{
	
	private Integer pid;//PindanProduct的id
	
	private Double price;
	
	private int numOfPeople;
	
	@Resource
	private PindanProductService pindanProductService;
	
	//发起拼单
	public String toCreate() {
		
		PindanProduct product = pindanProductService.get(pid);
		setAttribute("product", product);
		System.out.println("price===" +price);
		System.out.println("numOfPeople===" + numOfPeople);
		return "create";
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}
	
	
	
	
	
	
	
	
}

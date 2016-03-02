package com.wdy.cyyx.action.json;

import javax.annotation.Resource;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.service.ProductService;

public class ProductAction extends BaseAction {

	@Resource
	private ProductService productService;

	private Integer id;
	private int pn;

	public String list() {
		list = productService
				.getList(
						new QueryParam(1).add("systemid",
								getSystemName()),
						FRONT_PAGE_SIZE * (pn - 1), FRONT_PAGE_SIZE,
						"orderById", "desc", false);
		return LIST;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

}

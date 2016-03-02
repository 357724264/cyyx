package com.wdy.cyyx.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.PindanProduct;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.PindanProductService;
@ParentPackage("admin")
public class PindanProductAction extends BaseAction{
	
	@Resource
	private PindanProductService pindanProductService;
	
	private Integer id;
	
	@Override
	public String execute() throws Exception {
		System.out.println("execute");
		return "";
	}
	
	public String list() {
		
		QueryParam params = new QueryParam(1).add("systemid",
								(Integer)getSession(Const.SESSION_ADMIN_NAME));
		
		list = pindanProductService.getList(params, 0, 0, "displayOrder", "desc", false);
		
		
		return LIST;
	}
	
	public String add() {
		SystemClass systemClass = getAdminSystemClass();
		
		setAttribute("systemClass", systemClass);
		
		return INPUT;
	}
	
	public String edit() {
		
		
		SystemClass systemClass = getAdminSystemClass();
		
		PindanProduct product = pindanProductService.get(id);
		setAttribute("systemClass", systemClass);
		setAttribute("product", product);
		return INPUT;
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
	
	
}

package com.wdy.cyyx.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Mallproduct;
import com.wdy.cyyx.service.MallproductService;

@ParentPackage("admin")
public class MallproductAction extends BaseAction {

	@Resource
	private MallproductService mpService;

	private Mallproduct mproduct;

	private Integer id;
	
	
	
	

	public String list() {
		QueryParam param = new QueryParam(1).add("systemid",
				(Integer) getSession(Const.SESSION_ADMIN_NAME));
	
		//分页
		if (pn == 0 || pn == 1 || ps == 0) {
			pn = 1;
			int pc = mpService.getLikeTotalCount(pro, keyword, null, param, false);
			if (pc % ADMIN_PAGE_SIZE == 0) {
				ps = pc / ADMIN_PAGE_SIZE;
			} else {
				ps = pc / ADMIN_PAGE_SIZE + 1;
			}
		}
		
		list = mpService.getLikeList(pro, keyword, null, param,
					ADMIN_PAGE_SIZE * (pn - 1), ADMIN_PAGE_SIZE, "orderById", "desc", false);

		return LIST;
	}
	
	public String add() {
		SystemClass systemClass = getAdminSystemClass();
		setAttribute("systemClass", systemClass);
		return INPUT;
	}
	
	public String edit(){
		mproduct = mpService.get(id);
		return INPUT;
	}

	public String delete(){
		mpService.delete(id);
		return ajaxHtml("success");
	}
	
	
	
	
	public Mallproduct getMproduct() {
		return mproduct;
	}

	public void setMproduct(Mallproduct mproduct) {
		this.mproduct = mproduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}

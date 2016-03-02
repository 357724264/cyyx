package com.wdy.cyyx.action.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wdy.cyyx.action.BaseAction;
import com.wdy.cyyx.common.QueryParam;
import com.wdy.cyyx.entity.Const;
import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.MygrounpService;
import com.wdy.cyyx.service.ProductService;
import com.wdy.cyyx.service.SystemClassService;

@ParentPackage("admin")
public class ProductAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private ProductService productService;
	@Resource
	private SystemClassService systemClassService; 
	@Resource
	private MygrounpService mygrounpService;

	private Product product;
	private Integer id;

	public String list() {
		QueryParam param = new QueryParam(1).add("systemid",
				(Integer) getSession(Const.SESSION_ADMIN_NAME));
		list = productService.getList(param, 0, 0, "orderById", "desc", false);

		return LIST;
	}

	public String edit() {
		SystemClass systemClass = getAdminSystemClass();
		setAttribute("systemClass", systemClass);
		product = productService.get(id);
		
		return INPUT;
	}
	public String delete() {
		productService.delete(id);
		return ajaxHtml("success");
	}

	public String add() {
		SystemClass systemClass = getAdminSystemClass();
		setAttribute("systemClass", systemClass);
		return INPUT;
	}

	//查看该活动有多少团
	public String mygrounplist(){
		SystemClass systemClass = getAdminSystemClass();
		int systemid = (Integer) getAdmin_name();
		
		QueryParam params = new QueryParam(2);
		params.add("systemid", systemid).add("productid", id);
		if (pn == 0 || pn == 1 || ps == 0) {
			pn = 1;
			int pc = mygrounpService.getLikeTotalCount(pro, keyword, null, params,
					 false);// 总条数
			if (pc % ADMIN_PAGE_SIZE == 0) {
				ps = pc / ADMIN_PAGE_SIZE;
			} else {
				ps = pc / ADMIN_PAGE_SIZE + 1;
			}
		}
		List<Mygrounp> mglist = mygrounpService.getLikeList(pro, keyword, null, params,
				ADMIN_PAGE_SIZE * (pn - 1), ADMIN_PAGE_SIZE, "createDate",
				"desc", false);
		int zongshu = mygrounpService.getLikeList(pro, keyword, null, params,
				0, 0, "createDate","desc", false).size();
		setAttribute("zongshu", zongshu);
		setAttribute("mglist", mglist);
		
		return "mglist";
	}
	
	public Product getProduct() {
		return product;
	} 

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}

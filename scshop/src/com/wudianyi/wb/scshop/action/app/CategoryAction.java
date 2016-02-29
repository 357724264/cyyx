package com.wudianyi.wb.scshop.action.app;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.wudianyi.wb.scshop.action.BaseAction;
import com.wudianyi.wb.scshop.common.QueryParam;
import com.wudianyi.wb.scshop.entity.Brand;
import com.wudianyi.wb.scshop.entity.Category;
import com.wudianyi.wb.scshop.entity.Country;
import com.wudianyi.wb.scshop.service.BrandService;
import com.wudianyi.wb.scshop.service.CategoryService;
import com.wudianyi.wb.scshop.service.CountryService;

@ParentPackage("front")
public class CategoryAction extends BaseAction {

	@Resource
	private CategoryService categoryService;

	@Resource
	private BrandService brandService;
	@Resource
	private CountryService countryService;
	
	private Integer index;

	public String execute() {
		if (index == null) {
			index = 0;
		}
		QueryParam params = new QueryParam(2).add("del", 0).add("nodeid", 0).add("categoryType",0);
		List<Category> categorylist = categoryService.getList(params, 0, 0,
				"displayOrder", "desc", true);
		params = new QueryParam(1).add("del", 0);
		List<Brand> brandList = brandService.getList(params, 0, 0,
				"displayOrder", "desc", true);
		List<Country> countrylist = countryService.getList(
				params, 0, 0, "displayOrder", "desc",
				true);

		setAttribute("brandList", brandList);
		JSONObject retObject = new JSONObject();
		JSONArray categoryJsonArray = new JSONArray();
		JSONArray brandJsonArray = new JSONArray();
		JSONArray countryJsonArray = new JSONArray();
		
		for (int i=0; i<categorylist.size(); i++) {
			JSONObject categoryobject = new JSONObject();
			categoryobject.put("id", categorylist.get(i).getId());
			categoryobject.put("name", categorylist.get(i).getName());
			if(i==index) {
				Set<Category> down = categorylist.get(i).getDownList();
				JSONArray downArray = new JSONArray();
				for (Category downlist : down) {
					JSONObject downObject = new JSONObject();
					downObject.put("id", downlist.getId());
					downObject.put("name", downlist.getName());
					downObject.put("logo", downlist.getLogo());
					downArray.add(downObject);
				}
				retObject.put("down", downArray);
				retObject.put("name", categorylist.get(i).getName());
			}
			categoryJsonArray.add(categoryobject);
		}
		retObject.put("categorylist", categoryJsonArray);

		for (Brand brand : brandList) {
			JSONObject brandObject = new JSONObject();
			brandObject.put("id", brand.getId());
			brandObject.put("log", brand.getLogo());
			brandJsonArray.add(brandObject);
		}
		for (Country country : countrylist) {
			JSONObject countryObject = new JSONObject();
			countryObject.put("id", country.getId());
			countryObject.put("flagIcon", country.getFlagIcon());
			countryJsonArray.add(countryObject);
		}
		retObject.put("brandlist", brandJsonArray);
		retObject.put("countryList", countryJsonArray);
		retObject.put("index",index);
		return ajaxJson(retObject.toString());
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}

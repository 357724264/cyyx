package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.ProductDao;
import com.wdy.cyyx.entity.Product;
import com.wdy.cyyx.service.ProductService;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,Integer> implements ProductService{
	
	@Resource
	public void setBaseDao(ProductDao productDao){
		super.setBaseDao(productDao);
	}
	

}

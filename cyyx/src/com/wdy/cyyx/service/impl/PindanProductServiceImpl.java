package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.PindanProductDao;
import com.wdy.cyyx.entity.PindanProduct;
import com.wdy.cyyx.service.PindanProductService;

@Service
public class PindanProductServiceImpl extends BaseServiceImpl<PindanProduct, Integer> implements PindanProductService{
	
	@Resource
	public void setBaseDao(PindanProductDao pindanProductDao) {
		
		super.setBaseDao(pindanProductDao);
	}
	
}

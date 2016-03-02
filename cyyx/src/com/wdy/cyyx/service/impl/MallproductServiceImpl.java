package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.MallproductDao;
import com.wdy.cyyx.entity.Mallproduct;
import com.wdy.cyyx.service.MallproductService;

@Service
public class MallproductServiceImpl extends BaseServiceImpl<Mallproduct, Integer>
				implements MallproductService{

	@Resource
	public void setBaseDao(MallproductDao mallproductDao){
		super.setBaseDao(mallproductDao);
	}
}

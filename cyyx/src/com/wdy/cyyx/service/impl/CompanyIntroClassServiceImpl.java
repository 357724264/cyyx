package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.CompanyIntroClassDao;
import com.wdy.cyyx.entity.CompanyIntroClass;
import com.wdy.cyyx.service.CompanyIntroClassService;

@Service
public class CompanyIntroClassServiceImpl extends
		BaseServiceImpl<CompanyIntroClass, Integer> implements
		CompanyIntroClassService {

	@Resource
	public void setBaseDao(CompanyIntroClassDao companyIntroClassDao) {
		super.setBaseDao(companyIntroClassDao);
	}

}

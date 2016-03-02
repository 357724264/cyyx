package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.CompanyIntroDao;
import com.wdy.cyyx.entity.CompanyIntro;
import com.wdy.cyyx.service.CompanyIntroService;

@Service
public class CompanyIntroServiceImpl extends
		BaseServiceImpl<CompanyIntro, Integer> implements CompanyIntroService {

	@Resource
	public void setBaseDao(CompanyIntroDao companyIntroDao) {
		super.setBaseDao(companyIntroDao);
	}
}

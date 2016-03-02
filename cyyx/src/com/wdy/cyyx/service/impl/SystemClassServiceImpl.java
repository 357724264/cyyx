package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.SystemClassDao;
import com.wdy.cyyx.entity.SystemClass;
import com.wdy.cyyx.service.SystemClassService;



@Service
public class SystemClassServiceImpl extends
			BaseServiceImpl<SystemClass, Integer> implements SystemClassService {

	@Resource
	public void setBaseDao(SystemClassDao systemClassDao) {
		super.setBaseDao(systemClassDao);
	}
}

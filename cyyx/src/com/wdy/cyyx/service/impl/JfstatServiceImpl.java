package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.JfstatDao;
import com.wdy.cyyx.entity.Jfstat;
import com.wdy.cyyx.service.JfstatService;

@Service
public class JfstatServiceImpl extends BaseServiceImpl<Jfstat, Integer> implements JfstatService{

	@Resource
	public void setBaseDao(JfstatDao jfstatDao){
		super.setBaseDao(jfstatDao);
	}
	
	
}

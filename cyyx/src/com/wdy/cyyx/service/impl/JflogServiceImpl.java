package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.JflogDao;
import com.wdy.cyyx.entity.Jflog;
import com.wdy.cyyx.service.JflogService;

@Service
public class JflogServiceImpl extends BaseServiceImpl<Jflog, String> implements
		JflogService {
	@Resource
	public void setBaseDao(JflogDao jflogDao) {
		super.setBaseDao(jflogDao);
	}
}

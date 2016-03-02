package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.ContentClassDao;
import com.wdy.cyyx.entity.ContentClass;
import com.wdy.cyyx.service.ContentClassService;

@Service
public class ContentClassServiceImpl extends
		BaseServiceImpl<ContentClass, Integer> implements ContentClassService {

	@Resource
	public void setBaseDao(ContentClassDao contentClassDao) {
		super.setBaseDao(contentClassDao);
	}

}

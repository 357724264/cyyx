package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.ContentDao;
import com.wdy.cyyx.entity.Content;
import com.wdy.cyyx.service.ContentService;

@Service
public class ContentServiceImpl extends BaseServiceImpl<Content, Integer>
		implements ContentService {

	@Resource
	public void setBaseDao(ContentDao contentDao) {
		super.setBaseDao(contentDao);
	}

}

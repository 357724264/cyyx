package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.GrounpDao;
import com.wdy.cyyx.entity.Grounp;
import com.wdy.cyyx.service.GrounpService;

@Service
public class GrounpServiceImpl extends BaseServiceImpl<Grounp, String>
		implements GrounpService {

	@Resource
	public void setBaseDao(GrounpDao grounpDao) {
		super.setBaseDao(grounpDao);
	}

}

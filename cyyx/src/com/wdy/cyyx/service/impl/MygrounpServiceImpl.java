package com.wdy.cyyx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.MygrounpDao;
import com.wdy.cyyx.entity.Mygrounp;
import com.wdy.cyyx.service.MygrounpService;

@Service
public class MygrounpServiceImpl extends BaseServiceImpl<Mygrounp, String>
		implements MygrounpService {
	@Resource
	private MygrounpDao mygrounpDao;

	@Resource
	public void setBaseDao(MygrounpDao mygrounpDao) {
		super.setBaseDao(mygrounpDao);
	}

	@Override
	public List<Mygrounp> getMyGroup(Integer masterid, Integer systemid,
			Integer tt, int start, int limit, String orderby, String order) {
		// TODO Auto-generated method stub
		return mygrounpDao.getMyGroup(masterid, systemid, tt, start, limit,
				orderby, order);
	}

	@Override
	public List<Mygrounp> getUserJoinGroup(int userid, int tt, int pn, int ps) {
		// TODO Auto-generated method stub
		return mygrounpDao.getUserJoinGroup(userid, tt, pn, ps);
	}

}

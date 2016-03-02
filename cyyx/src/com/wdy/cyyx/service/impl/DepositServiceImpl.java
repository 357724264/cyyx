package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.DepositDao;
import com.wdy.cyyx.entity.Deposit;
import com.wdy.cyyx.entity.Deposit.DepositStat;
import com.wdy.cyyx.service.DepositService;

@Service
public class DepositServiceImpl extends BaseServiceImpl<Deposit, String>
		implements DepositService {
	@Resource
	private DepositDao depositDao;

	@Resource
	public void setBaseDao(DepositDao depositDao) {
		super.setBaseDao(depositDao);
	}

	@Override
	public double countDeposit(Integer systemClassid,DepositStat stat) {
		// TODO Auto-generated method stub
		return depositDao.countDeposit(systemClassid,stat);
	}

}

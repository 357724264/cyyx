package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.WithdrawDao;
import com.wdy.cyyx.entity.Withdraw;
import com.wdy.cyyx.service.WithdrawService;

@Service
public class WithdrawServiceImpl extends BaseServiceImpl<Withdraw, String>
		implements WithdrawService {

	@Resource
	public void setBaseDao(WithdrawDao withdrawDao) {
		super.setBaseDao(withdrawDao);
	}

}

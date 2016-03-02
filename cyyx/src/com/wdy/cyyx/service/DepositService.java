package com.wdy.cyyx.service;

import com.wdy.cyyx.entity.Deposit;
import com.wdy.cyyx.entity.Deposit.DepositStat;

public interface DepositService extends BaseService<Deposit, String> {

	public double countDeposit(Integer systemClassid,DepositStat stat);
}

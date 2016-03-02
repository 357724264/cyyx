package com.wdy.cyyx.dao;

import com.wdy.cyyx.entity.Deposit;
import com.wdy.cyyx.entity.Deposit.DepositStat;

public interface DepositDao extends BaseDao<Deposit, String> {
	public double countDeposit(Integer systemClassid,DepositStat stat);
}

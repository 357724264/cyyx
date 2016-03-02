package com.wdy.cyyx.dao.impl;

import org.springframework.stereotype.Repository;

import com.wdy.cyyx.dao.DepositDao;
import com.wdy.cyyx.entity.Deposit;
import com.wdy.cyyx.entity.Deposit.DepositStat;

@Repository
public class DepositDaoImpl extends BaseDaoImpl<Deposit, String> implements
		DepositDao {

	@Override
	public double countDeposit(Integer systemClassid, DepositStat stat) {

		String hql = "select sum(money) from Deposit where sysid=:systemClassid and stat=:stat";
		Object count = this.getSession().createQuery(hql)
				.setParameter("systemClassid", systemClassid)
				.setParameter("stat", stat).uniqueResult();
		if (count == null) {
			return 0;
		}
		return (Double) count;
	}

}

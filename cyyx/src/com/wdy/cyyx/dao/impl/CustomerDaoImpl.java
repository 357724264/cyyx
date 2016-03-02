package com.wdy.cyyx.dao.impl;

import org.springframework.stereotype.Repository;

import com.wdy.cyyx.dao.CustomerDao;
import com.wdy.cyyx.entity.Customer;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer, Integer> implements CustomerDao {

	
	@Override
	public double getAllUserComiision(Integer systemClassid, String type) {
		String hql = "select";
		if (type.equals("unin")) {
			hql += " sum(uppaidcommission + paidcommission)";
		} else {
			hql += " sum(" + type + ")";
		}
		hql += " from Customer where systemClass.cid=:systemClassid";
		Object count = this.getSession().createQuery(hql)
				.setParameter("systemClassid", systemClassid).uniqueResult();
		if (count == null) {
			return 0;
		}
		return (Double) count;
	}
	
	
}

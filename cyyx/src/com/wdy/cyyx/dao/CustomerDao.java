package com.wdy.cyyx.dao;

import com.wdy.cyyx.entity.Customer;

public interface CustomerDao extends BaseDao<Customer, Integer> {

	public double getAllUserComiision(Integer systemClassid,String type);
}

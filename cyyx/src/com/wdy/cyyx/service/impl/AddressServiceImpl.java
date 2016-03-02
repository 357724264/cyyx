package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.AddressDao;
import com.wdy.cyyx.entity.Address;
import com.wdy.cyyx.service.AddressService;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, String>
		implements AddressService {
	@Resource
	public void setBaseDao(AddressDao addressDao) {
		super.setBaseDao(addressDao);
	}

}

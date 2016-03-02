package com.wdy.cyyx.dao.impl;

import org.springframework.stereotype.Repository;

import com.wdy.cyyx.dao.ProductDao;
import com.wdy.cyyx.entity.Product;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product,Integer> implements ProductDao{

}

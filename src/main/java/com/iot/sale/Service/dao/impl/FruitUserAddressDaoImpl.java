package com.iot.sale.Service.dao.impl;

import com.iot.sale.Base.dao.impl.BaseJdbcDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.iot.sale.Service.dao.FruitUserAddressDao;
import com.iot.sale.Service.entity.FruitUserAddress;

/******************************************
* @fileName: FruitUserAddressDaoImpl 
* @author: entity code gen 
* @company: (C) Copyright 2017 
* @since: JDK 1.8 
******************************************/ 

@Service("fruitUserAddressDao")
public class FruitUserAddressDaoImpl extends BaseJdbcDaoImpl<FruitUserAddress> implements FruitUserAddressDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public JdbcTemplate getJDBCTemplate() { return jdbcTemplate; }
}

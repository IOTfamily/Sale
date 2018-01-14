package com.iot.sale.Service.dao.impl;

import com.iot.sale.Base.dao.impl.BaseJdbcDaoImpl;
import com.iot.sale.Service.dao.FruitGoodOrderDao;
import com.iot.sale.Service.entity.FruitGoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/******************************************
* @fileName: FruitBuyListDaoImpl 
* @author: entity code gen 
* @company: (C) Copyright 2017 
* @since: JDK 1.8 
******************************************/ 

@Service("fruitBuyListDao")
public class FruitBuyListDaoImpl extends BaseJdbcDaoImpl<FruitGoodOrder> implements FruitGoodOrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public JdbcTemplate getJDBCTemplate() { return jdbcTemplate; }
}

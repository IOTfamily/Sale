package com.iot.sale.Service.dao.impl;

import com.iot.sale.Base.dao.impl.BaseJdbcDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.iot.sale.Service.dao.FruitGoodSizeDao;
import com.iot.sale.Service.entity.FruitGoodSize;

/******************************************
* @fileName: FruitGoodSizeDaoImpl 
* @author: entity code gen 
* @company: (C) Copyright 2017 
* @since: JDK 1.8 
******************************************/ 

@Service("fruitGoodSizeDao")
public class FruitGoodSizeDaoImpl extends BaseJdbcDaoImpl<FruitGoodSize> implements FruitGoodSizeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public JdbcTemplate getJDBCTemplate() { return jdbcTemplate; }
}

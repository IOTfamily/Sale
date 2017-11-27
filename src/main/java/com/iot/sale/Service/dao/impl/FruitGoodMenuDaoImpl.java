package com.iot.sale.Service.dao.impl;

import com.iot.sale.Base.dao.impl.BaseJdbcDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.iot.sale.Service.dao.FruitGoodMenuDao;
import com.iot.sale.Service.entity.FruitGoodMenu;

/******************************************
* @fileName: FruitGoodMenuDaoImpl 
* @author: entity code gen 
* @company: (C) Copyright 2017 
* @since: JDK 1.8 
******************************************/ 

@Service("fruitGoodMenuDao")
public class FruitGoodMenuDaoImpl extends BaseJdbcDaoImpl<FruitGoodMenu> implements FruitGoodMenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public JdbcTemplate getJDBCTemplate() { return jdbcTemplate; }
}

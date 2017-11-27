package com.iot.sale.Service.dao.impl;

import com.iot.sale.Base.dao.impl.BaseJdbcDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.iot.sale.Service.dao.FruitWechatPositionDao;
import com.iot.sale.Service.entity.FruitWechatPosition;

/******************************************
* @fileName: FruitWechatPositionDaoImpl 
* @author: entity code gen 
* @company: (C) Copyright 2017 
* @since: JDK 1.8 
******************************************/ 

@Service("fruitWechatPositionDao")
public class FruitWechatPositionDaoImpl extends BaseJdbcDaoImpl<FruitWechatPosition> implements FruitWechatPositionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public JdbcTemplate getJDBCTemplate() { return jdbcTemplate; }
}

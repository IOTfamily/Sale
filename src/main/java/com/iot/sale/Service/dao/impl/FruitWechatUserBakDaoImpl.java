package com.iot.sale.Service.dao.impl;

import com.iot.sale.Base.dao.impl.BaseJdbcDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.iot.sale.Service.dao.FruitWechatUserBakDao;
import com.iot.sale.Service.entity.FruitWechatUserBak;

/******************************************
* @fileName: FruitWechatUserBakDaoImpl 
* @author: entity code gen 
* @company: (C) Copyright 2017 
* @since: JDK 1.8 
******************************************/ 

@Service("fruitWechatUserBakDao")
public class FruitWechatUserBakDaoImpl extends BaseJdbcDaoImpl<FruitWechatUserBak> implements FruitWechatUserBakDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public JdbcTemplate getJDBCTemplate() { return jdbcTemplate; }
}

package com.iot.sale.Service.dao.impl;

import com.iot.sale.Base.dao.impl.BaseJdbcDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.iot.sale.Service.dao.FruitArticleMenuDao;
import com.iot.sale.Service.entity.FruitArticleMenu;

/******************************************
* @fileName: FruitArticleMenuDaoImpl 
* @author: entity code gen 
* @company: (C) Copyright 2017 
* @since: JDK 1.8 
******************************************/ 

@Service("fruitArticleMenuDao")
public class FruitArticleMenuDaoImpl extends BaseJdbcDaoImpl<FruitArticleMenu> implements FruitArticleMenuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public JdbcTemplate getJDBCTemplate() { return jdbcTemplate; }
}

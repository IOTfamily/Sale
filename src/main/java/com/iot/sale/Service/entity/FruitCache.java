package com.iot.sale.Service.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.sale.Base.dao.annotation.Column;
import com.iot.sale.Base.dao.annotation.Table;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/******************************************
 * @table: fruit_cache 
 * @tableDesc: 缓存表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_cache", pk = "id")
@ApiModel(value = "FruitCache", description = "缓存表")
public class FruitCache implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@Column(name = "cachekey")
	@JsonProperty("cachekey")
	private String cachekey;


	@Column(name = "expire")
	@JsonProperty("expire")
	private Integer expire;


	@Column(name = "data")
	@JsonProperty("data")
	private String data;


	@Column(name = "datacrc")
	@JsonProperty("datacrc")
	private String datacrc;

}

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
 * @table: fruit_award_openid_relation 
 * @tableDesc: 奖品和微信用户关系表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_award_openid_relation", pk = "id")
@ApiModel(value = "FruitAwardOpenidRelation", description = "奖品和微信用户关系表")
public class FruitAwardOpenidRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "openid")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "微信openid")
	@Column(name = "openid")
	@JsonProperty("openid")
	private String openid;


	@ApiModelProperty(value = "奖品等级 0没有奖 1一等奖 2二等奖 3三等奖 4四等奖 5五等奖100特等奖")
	@Column(name = "level")
	@JsonProperty("level")
	private Integer level;


	@ApiModelProperty(value = "状态 0未分配奖品 1已分配但未抽奖 2已抽奖")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "抽奖时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "exchange_time")
	@JsonProperty("exchangeTime")
	private Date exchangeTime;

}

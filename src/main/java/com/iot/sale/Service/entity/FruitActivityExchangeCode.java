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
 * @table: fruit_activity_exchange_code 
 * @tableDesc: 兑奖码表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_activity_exchange_code", pk = "id")
@ApiModel(value = "FruitActivityExchangeCode", description = "兑奖码表")
public class FruitActivityExchangeCode implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "兑奖码")
	@Column(name = "code")
	@JsonProperty("code")
	private String code;


	@ApiModelProperty(value = "奖品等级 0特等奖 1一等奖 2二等奖 3三等奖 4没有奖")
	@Column(name = "level")
	@JsonProperty("level")
	private Integer level;


	@ApiModelProperty(value = "状态 0未兑换 1已兑换 -1已失效")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "兑奖码生成时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "兑奖码兑换时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "exchange_time")
	@JsonProperty("exchangeTime")
	private Date exchangeTime;

}

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
 * @table: fruit_pay_polling 
 * @tableDesc: 支付查询表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_pay_polling", pk = "id")
@ApiModel(value = "FruitPayPolling", description = "支付查询表")
public class FruitPayPolling implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "查询参数")
	@Column(name = "data")
	@JsonProperty("data")
	private String data;


	@ApiModelProperty(value = "支付id")
	@Column(name = "pay_id")
	@JsonProperty("payId")
	private String payId;


	@ApiModelProperty(value = "回调状态")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "查询结果")
	@Column(name = "search_result")
	@JsonProperty("searchResult")
	private String searchResult;


	@ApiModelProperty(value = "查询次数")
	@Column(name = "count")
	@JsonProperty("count")
	private Integer count;


	@ApiModelProperty(value = "查询结果")
	@Column(name = "result")
	@JsonProperty("result")
	private String result;


	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "update_time")
	@JsonProperty("updateTime")
	private Date updateTime;

}

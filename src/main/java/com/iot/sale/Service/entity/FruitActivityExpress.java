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
 * @table: fruit_activity_express 
 * @tableDesc: 奖品发放信息表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_activity_express", pk = "id")
@ApiModel(value = "FruitActivityExpress", description = "奖品发放信息表")
public class FruitActivityExpress implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "openid")
	@Column(name = "openid")
	@JsonProperty("openid")
	private String openid;


	@ApiModelProperty(value = "手机号")
	@Column(name = "mobile")
	@JsonProperty("mobile")
	private String mobile;


	@ApiModelProperty(value = "真实姓名")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@ApiModelProperty(value = "收货地址")
	@Column(name = "address")
	@JsonProperty("address")
	private String address;


	@ApiModelProperty(value = "0未发货 ，1已发货")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;

}

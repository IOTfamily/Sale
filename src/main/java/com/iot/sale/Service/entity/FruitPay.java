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
 * @table: fruit_pay 
 * @tableDesc: 支付表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_pay", pk = "id")
@ApiModel(value = "FruitPay", description = "支付表")
public class FruitPay implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "用户id")
	@Column(name = "uid")
	@JsonProperty("uid")
	private Integer uid;


	@ApiModelProperty(value = "支付总金额")
	@Column(name = "funds")
	@JsonProperty("funds")
	private Integer funds;


	@ApiModelProperty(value = "手续费")
	@Column(name = "fee")
	@JsonProperty("fee")
	private Integer fee;


	@ApiModelProperty(value = "0待支付，1成功，2失败")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "支付通道")
	@Column(name = "pay_channel")
	@JsonProperty("payChannel")
	private Integer payChannel;


	@ApiModelProperty(value = "支付结果")
	@Column(name = "pay_return")
	@JsonProperty("payReturn")
	private String payReturn;


	@ApiModelProperty(value = "业务类型")
	@Column(name = "business")
	@JsonProperty("business")
	private Integer business;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "return_time")
	@JsonProperty("returnTime")
	private Date returnTime;


	@ApiModelProperty(value = "支付订单号")
	@Column(name = "pay_no")
	@JsonProperty("payNo")
	private String payNo;


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

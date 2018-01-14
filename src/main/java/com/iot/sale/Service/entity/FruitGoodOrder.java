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
 * @table: fruit_buy_list 
 * @tableDesc: 购物清单 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_buy_list", pk = "id")
@ApiModel(value = "FruitBuyList", description = "购物清单")
public class FruitGoodOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "商品id")
	@Column(name = "good_id")
	@JsonProperty("goodId")
	private Integer goodId;


	@ApiModelProperty(value = "购买数量")
	@Column(name = "count")
	@JsonProperty("count")
	private Integer count;


	@ApiModelProperty(value = "支付成功订单号")
	@Column(name = "pay_no")
	@JsonProperty("payNo")
	private String payNo;


	@ApiModelProperty(value = "0待支付，1支付成功，2支付失败")
	@Column(name = "pay_status")
	@JsonProperty("payStatus")
	private Integer payStatus;


	@ApiModelProperty(value = "购买者说的话")
	@Column(name = "buyer_need")
	@JsonProperty("buyerNeed")
	private String buyerNeed;


	@ApiModelProperty(value = " 发货地址")
	@Column(name = "address")
	@JsonProperty("address")
	private String address;


	@ApiModelProperty(value = "提交时间")
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

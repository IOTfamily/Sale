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
 * @table: fruit_shop_car 
 * @tableDesc: 购物车表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_shop_car", pk = "id")
@ApiModel(value = "FruitShopCar", description = "购物车表")
public class FruitShopCar implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品id")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "商品id")
	@Column(name = "good_id")
	@JsonProperty("goodId")
	private Integer goodId;


	@ApiModelProperty(value = "名字")
	@Column(name = "good_name")
	@JsonProperty("goodName")
	private String goodName;


	@ApiModelProperty(value = "购买数量")
	@Column(name = "num")
	@JsonProperty("num")
	private Integer num;


	@ApiModelProperty(value = "价格")
	@Column(name = "price")
	@JsonProperty("price")
	private Integer price;


	@ApiModelProperty(value = "阅读数")
	@Column(name = "read_num")
	@JsonProperty("readNum")
	private Integer readNum;


	@ApiModelProperty(value = "购买数")
	@Column(name = "buy_num")
	@JsonProperty("buyNum")
	private Integer buyNum;


	@ApiModelProperty(value = "评价等级")
	@Column(name = "level")
	@JsonProperty("level")
	private Integer level;


	@ApiModelProperty(value = "文字评价")
	@Column(name = "remarks")
	@JsonProperty("remarks")
	private String remarks;


	@ApiModelProperty(value = "0表示待发货，1表示在途，2表示待评价3表示已评价）")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


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

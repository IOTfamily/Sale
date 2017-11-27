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
 * @table: fruit_award_count 
 * @tableDesc: 奖品数量表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_award_count", pk = "id")
@ApiModel(value = "FruitAwardCount", description = "奖品数量表")
public class FruitAwardCount implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "奖品种类 1一等奖2 ... ")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "奖品剩余数量")
	@Column(name = "count")
	@JsonProperty("count")
	private Integer count;

}

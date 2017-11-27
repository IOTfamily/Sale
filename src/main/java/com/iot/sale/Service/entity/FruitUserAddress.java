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
 * @table: fruit_user_address 
 * @tableDesc: 收货地址管理 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_user_address", pk = "id")
@ApiModel(value = "FruitUserAddress", description = "收货地址管理")
public class FruitUserAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "用户id")
	@Column(name = "uid")
	@JsonProperty("uid")
	private Integer uid;


	@ApiModelProperty(value = "1默认，0不默认")
	@Column(name = "use")
	@JsonProperty("use")
	private Integer use;


	@ApiModelProperty(value = "收货地址")
	@Column(name = "address")
	@JsonProperty("address")
	private String address;


	@ApiModelProperty(value = "1用，0删除")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;

}

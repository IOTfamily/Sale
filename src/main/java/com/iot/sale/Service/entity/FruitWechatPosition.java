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
 * @table: fruit_wechat_position 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_wechat_position", pk = "id")
@ApiModel(value = "FruitWechatPosition", description = "")
public class FruitWechatPosition implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@Column(name = "openid")
	@JsonProperty("openid")
	private String openid;


	@ApiModelProperty(value = "经度")
	@Column(name = "latitude")
	@JsonProperty("latitude")
	private String latitude;


	@ApiModelProperty(value = "纬度")
	@Column(name = "longitude")
	@JsonProperty("longitude")
	private String longitude;


	@ApiModelProperty(value = "精度")
	@Column(name = "precision")
	@JsonProperty("precision")
	private String precision;


	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;

}

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
 * @table: fruit_agent 
 * @tableDesc: 代理申请记录表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_agent", pk = "id")
@ApiModel(value = "FruitAgent", description = "代理申请记录表")
public class FruitAgent implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "姓名")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@ApiModelProperty(value = "手机号")
	@Column(name = "mobile")
	@JsonProperty("mobile")
	private String mobile;


	@ApiModelProperty(value = "身份证")
	@Column(name = "ic_number")
	@JsonProperty("icNumber")
	private String icNumber;


	@ApiModelProperty(value = "邮箱")
	@Column(name = "email")
	@JsonProperty("email")
	private String email;


	@ApiModelProperty(value = "性别")
	@Column(name = "sex")
	@JsonProperty("sex")
	private Integer sex;


	@ApiModelProperty(value = "省")
	@Column(name = "province")
	@JsonProperty("province")
	private String province;


	@ApiModelProperty(value = "市")
	@Column(name = "city")
	@JsonProperty("city")
	private String city;


	@ApiModelProperty(value = "区")
	@Column(name = "district")
	@JsonProperty("district")
	private String district;


	@ApiModelProperty(value = "代理级别")
	@Column(name = "level")
	@JsonProperty("level")
	private Integer level;


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

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
 * @table: fruit_login_log 
 * @tableDesc: 用户登录记录表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_login_log", pk = "id")
@ApiModel(value = "FruitLoginLog", description = "用户登录记录表")
public class FruitLoginLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "错误次数")
	@Column(name = "error_times")
	@JsonProperty("errorTimes")
	private Integer errorTimes;


	@ApiModelProperty(value = "最后一次登陆时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "login_time")
	@JsonProperty("loginTime")
	private Date loginTime;


	@ApiModelProperty(value = "登录ip")
	@Column(name = "ip")
	@JsonProperty("ip")
	private Integer ip;

}

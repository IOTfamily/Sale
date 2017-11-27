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
 * @table: fruit_vcode 
 * @tableDesc: 验证码表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_vcode", pk = "id")
@ApiModel(value = "FruitVcode", description = "验证码表")
public class FruitVcode implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "手机号")
	@Column(name = "mobile")
	@JsonProperty("mobile")
	private String mobile;


	@ApiModelProperty(value = "下发手机的验证码")
	@Column(name = "vcode")
	@JsonProperty("vcode")
	private String vcode;


	@ApiModelProperty(value = "最有一次发送时间")
	@Column(name = "send_time")
	@JsonProperty("sendTime")
	private Integer sendTime;


	@ApiModelProperty(value = "验证码是否验证通过：0-未通过 1-通过")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "设备id")
	@Column(name = "device_id")
	@JsonProperty("deviceId")
	private String deviceId;


	@ApiModelProperty(value = "校验码")
	@Column(name = "ccode")
	@JsonProperty("ccode")
	private String ccode;


	@ApiModelProperty(value = "短信渠道,Alidayu,MdSms")
	@Column(name = "chanel")
	@JsonProperty("chanel")
	private String chanel;

}

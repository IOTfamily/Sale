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
 * @table: fruit_user 
 * @tableDesc: 用户表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_user", pk = "uid")
@ApiModel(value = "FruitUser", description = "用户表")
public class FruitUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "uid")
	@JsonProperty("uid")
	private Integer uid;


	@ApiModelProperty(value = "用户名")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@Column(name = "phone_number")
	@JsonProperty("phoneNumber")
	private String phoneNumber;


	@ApiModelProperty(value = "性别")
	@Column(name = "sex")
	@JsonProperty("sex")
	private Integer sex;


	@ApiModelProperty(value = "邮箱")
	@Column(name = "email")
	@JsonProperty("email")
	private String email;


	@Column(name = "money")
	@JsonProperty("money")
	private Integer money;


	@Column(name = "open_id")
	@JsonProperty("openId")
	private Integer openId;


	@ApiModelProperty(value = "账户名")
	@Column(name = "account")
	@JsonProperty("account")
	private String account;


	@ApiModelProperty(value = "密码")
	@Column(name = "password")
	@JsonProperty("password")
	private String password;


	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "用户等级99 root")
	@Column(name = "power_level")
	@JsonProperty("powerLevel")
	private Integer powerLevel;

}

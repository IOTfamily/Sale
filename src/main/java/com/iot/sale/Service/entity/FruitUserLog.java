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
 * @table: fruit_user_log 
 * @tableDesc: 用户基本信息日志表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_user_log", pk = "id")
@ApiModel(value = "FruitUserLog", description = "用户基本信息日志表")
public class FruitUserLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "用户id")
	@Column(name = "uid")
	@JsonProperty("uid")
	private Integer uid;


	@ApiModelProperty(value = "手机号")
	@Column(name = "phone_number")
	@JsonProperty("phoneNumber")
	private String phoneNumber;


	@ApiModelProperty(value = "头像地址")
	@Column(name = "icon")
	@JsonProperty("icon")
	private String icon;


	@ApiModelProperty(value = "真实姓名")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@ApiModelProperty(value = "身份证号")
	@Column(name = "ic_number")
	@JsonProperty("icNumber")
	private String icNumber;


	@ApiModelProperty(value = "登录密码")
	@Column(name = "login_pass")
	@JsonProperty("loginPass")
	private String loginPass;


	@ApiModelProperty(value = "交易密码")
	@Column(name = "trade_pass")
	@JsonProperty("tradePass")
	private String tradePass;


	@ApiModelProperty(value = "注册时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "个人资料完善程度")
	@Column(name = "profile_status")
	@JsonProperty("profileStatus")
	private String profileStatus;


	@ApiModelProperty(value = "就业状况，1学生，2工薪族，3其他，4企业主")
	@Column(name = "job_type")
	@JsonProperty("jobType")
	private Integer jobType;


	@ApiModelProperty(value = "用户征信授权时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "credit_auth_time")
	@JsonProperty("creditAuthTime")
	private Date creditAuthTime;


	@ApiModelProperty(value = "绑定的微信openid")
	@Column(name = "wx_openid")
	@JsonProperty("wxOpenid")
	private String wxOpenid;


	@ApiModelProperty(value = "绑定的微信unionid")
	@Column(name = "wx_unionid")
	@JsonProperty("wxUnionid")
	private String wxUnionid;


	@ApiModelProperty(value = "操作人员uid")
	@Column(name = "op_uid")
	@JsonProperty("opUid")
	private Integer opUid;


	@ApiModelProperty(value = "操作时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "op_time")
	@JsonProperty("opTime")
	private Date opTime;


	@ApiModelProperty(value = "操作类型，1修改交易密码，2修改登录密码")
	@Column(name = "op_type")
	@JsonProperty("opType")
	private Integer opType;


	@ApiModelProperty(value = "操作描述")
	@Column(name = "op_detail")
	@JsonProperty("opDetail")
	private String opDetail;

}

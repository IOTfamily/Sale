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
 * @table: fruit_wechat_user 
 * @tableDesc: 微信用户资料表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_wechat_user", pk = "id")
@ApiModel(value = "FruitWechatUser", description = "微信用户资料表")
public class FruitWechatUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "unionid")
	@Column(name = "unionid")
	@JsonProperty("unionid")
	private String unionid;


	@ApiModelProperty(value = "openid")
	@Column(name = "openid")
	@JsonProperty("openid")
	private String openid;


	@ApiModelProperty(value = "昵称")
	@Column(name = "nickname")
	@JsonProperty("nickname")
	private String nickname;


	@ApiModelProperty(value = "头像地址")
	@Column(name = "photo_url")
	@JsonProperty("photoUrl")
	private String photoUrl;


	@ApiModelProperty(value = "性别：0未知，1男，2女")
	@Column(name = "sex")
	@JsonProperty("sex")
	private Integer sex;


	@ApiModelProperty(value = "省份")
	@Column(name = "province")
	@JsonProperty("province")
	private String province;


	@ApiModelProperty(value = "城市")
	@Column(name = "city")
	@JsonProperty("city")
	private String city;


	@ApiModelProperty(value = "国家")
	@Column(name = "country")
	@JsonProperty("country")
	private String country;


	@ApiModelProperty(value = "关注时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "使用关注公众号0未关注，1已关注")
	@Column(name = "subscribe")
	@JsonProperty("subscribe")
	private Integer subscribe;


	@ApiModelProperty(value = "关注公号时间，多次关注取最后一次")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "subscribe_time")
	@JsonProperty("subscribeTime")
	private Date subscribeTime;

}

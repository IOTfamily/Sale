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
 * @table: bx_spider_queue 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bx_spider_queue", pk = "id")
@ApiModel(value = "BxSpiderQueue", description = "")
public class BxSpiderQueue implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "网页url")
	@Column(name = "url")
	@JsonProperty("url")
	private String url;


	@ApiModelProperty(value = "请求的相关数据 body post/get headers")
	@Column(name = "data")
	@JsonProperty("data")
	private String data;


	@ApiModelProperty(value = "爬虫的队列key 用来区分不同的爬虫")
	@Column(name = "prefix")
	@JsonProperty("prefix")
	private String prefix;


	@ApiModelProperty(value = "请求重试次数")
	@Column(name = "times")
	@JsonProperty("times")
	private Integer times;


	@ApiModelProperty(value = "状态 0初始状态 1已处理 -1请求失败")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "添加时间")
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

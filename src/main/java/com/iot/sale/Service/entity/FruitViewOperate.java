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
 * @table: fruit_view_operate 
 * @tableDesc: 运营位操作表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_view_operate", pk = "id")
@ApiModel(value = "FruitViewOperate", description = "运营位操作表")
public class FruitViewOperate implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "运营位名字")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@ApiModelProperty(value = "运营位类型1，banner。2，首页导航")
	@Column(name = "type")
	@JsonProperty("type")
	private Integer type;


	@ApiModelProperty(value = "资源地址")
	@Column(name = "src")
	@JsonProperty("src")
	private String src;


	@ApiModelProperty(value = "页面跳转")
	@Column(name = "href")
	@JsonProperty("href")
	private String href;


	@ApiModelProperty(value = "标题")
	@Column(name = "title")
	@JsonProperty("title")
	private String title;


	@ApiModelProperty(value = "描述")
	@Column(name = "describe")
	@JsonProperty("describe")
	private String describe;


	@ApiModelProperty(value = "状态，1，在线，0下线")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "顺序，大的在前边")
	@Column(name = "order")
	@JsonProperty("order")
	private Integer order;

}

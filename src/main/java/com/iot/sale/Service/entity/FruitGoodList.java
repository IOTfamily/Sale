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
 * @table: fruit_good_list 
 * @tableDesc: 商品列表表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_good_list", pk = "id")
@ApiModel(value = "FruitGoodList", description = "商品列表表")
public class FruitGoodList implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "商品名")
	@Column(name = "title")
	@JsonProperty("title")
	private String title;


	@ApiModelProperty(value = "goodlist类型1,50%,2,100%")
	@Column(name = "type")
	@JsonProperty("type")
	private Integer type;


	@ApiModelProperty(value = "分类")
	@Column(name = "classify")
	@JsonProperty("classify")
	private Integer classify;


	@ApiModelProperty(value = "尺寸")
	@Column(name = "size")
	@JsonProperty("size")
	private Integer size;


	@ApiModelProperty(value = "作者")
	@Column(name = "author")
	@JsonProperty("author")
	private Integer author;


	@ApiModelProperty(value = "价格")
	@Column(name = "price")
	@JsonProperty("price")
	private Integer price;


	@ApiModelProperty(value = "简述")
	@Column(name = "intro")
	@JsonProperty("intro")
	private String intro;


	@ApiModelProperty(value = "标志")
	@Column(name = "mark")
	@JsonProperty("mark")
	private String mark;


	@ApiModelProperty(value = "图片地址")
	@Column(name = "src")
	@JsonProperty("src")
	private String src;


	@ApiModelProperty(value = "商品介绍")
	@Column(name = "content")
	@JsonProperty("content")
	private String content;


	@ApiModelProperty(value = "阅读数")
	@Column(name = "read_num")
	@JsonProperty("readNum")
	private Integer readNum;


	@ApiModelProperty(value = "购买数")
	@Column(name = "buy_num")
	@JsonProperty("buyNum")
	private Integer buyNum;


	@ApiModelProperty(value = "商品创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "修改时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "change_time")
	@JsonProperty("changeTime")
	private Date changeTime;


	@ApiModelProperty(value = "是否在线")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "其他")
	@Column(name = "extra")
	@JsonProperty("extra")
	private Integer extra;

}

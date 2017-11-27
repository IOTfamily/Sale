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
 * @table: fruit_article_list 
 * @tableDesc: 文章里表表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_article_list", pk = "id")
@ApiModel(value = "FruitArticleList", description = "文章里表表")
public class FruitArticleList implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "标题")
	@Column(name = "title")
	@JsonProperty("title")
	private String title;


	@ApiModelProperty(value = "简介")
	@Column(name = "intro")
	@JsonProperty("intro")
	private String intro;


	@ApiModelProperty(value = "文章内容")
	@Column(name = "content")
	@JsonProperty("content")
	private String content;


	@ApiModelProperty(value = "图片介绍")
	@Column(name = "src")
	@JsonProperty("src")
	private String src;


	@ApiModelProperty(value = "article list type css")
	@Column(name = "type")
	@JsonProperty("type")
	private Integer type;


	@ApiModelProperty(value = "分类")
	@Column(name = "classify")
	@JsonProperty("classify")
	private Integer classify;


	@ApiModelProperty(value = "关系")
	@Column(name = "level")
	@JsonProperty("level")
	private Integer level;


	@ApiModelProperty(value = "作者id")
	@Column(name = "author")
	@JsonProperty("author")
	private Integer author;


	@ApiModelProperty(value = "是否在线")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "文章创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "阅读数")
	@Column(name = "read_num")
	@JsonProperty("readNum")
	private Integer readNum;


	@ApiModelProperty(value = "标志,右上角的标志")
	@Column(name = "mark")
	@JsonProperty("mark")
	private Integer mark;


	@ApiModelProperty(value = "其他")
	@Column(name = "extra")
	@JsonProperty("extra")
	private String extra;

}

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
 * @table: fruit_crawl_articles 
 * @tableDesc: 抽取文章资源 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_crawl_articles", pk = "id")
@ApiModel(value = "FruitCrawlArticles", description = "抽取文章资源")
public class FruitCrawlArticles implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@Column(name = "title")
	@JsonProperty("title")
	private String title;


	@Column(name = "read_num")
	@JsonProperty("readNum")
	private String readNum;


	@Column(name = "content")
	@JsonProperty("content")
	private String content;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "modify_time")
	@JsonProperty("modifyTime")
	private Date modifyTime;


	@Column(name = "tag")
	@JsonProperty("tag")
	private String tag;


	@Column(name = "extra")
	@JsonProperty("extra")
	private String extra;

}

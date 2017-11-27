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
 * @table: fruit_movie_list 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_movie_list", pk = "id")
@ApiModel(value = "FruitMovieList", description = "")
public class FruitMovieList implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@Column(name = "title")
	@JsonProperty("title")
	private String title;


	@Column(name = "number")
	@JsonProperty("number")
	private String number;


	@Column(name = "type")
	@JsonProperty("type")
	private String type;


	@Column(name = "daoyan")
	@JsonProperty("daoyan")
	private String daoyan;


	@Column(name = "zhuyan")
	@JsonProperty("zhuyan")
	private String zhuyan;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "time")
	@JsonProperty("time")
	private Date time;


	@Column(name = "bianjv")
	@JsonProperty("bianjv")
	private String bianjv;


	@Column(name = "jianjie")
	@JsonProperty("jianjie")
	private String jianjie;


	@Column(name = "poster")
	@JsonProperty("poster")
	private String poster;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "modify_time")
	@JsonProperty("modifyTime")
	private Date modifyTime;


	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;

}

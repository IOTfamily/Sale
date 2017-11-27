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
 * @table: fruit_kind_bak 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_kind_bak", pk = "fid")
@ApiModel(value = "FruitKindBak", description = "")
public class FruitKindBak implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "fid")
	@JsonProperty("fid")
	private Integer fid;


	@ApiModelProperty(value = "水果名字")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@ApiModelProperty(value = "父级")
	@Column(name = "pid")
	@JsonProperty("pid")
	private Integer pid;


	@Column(name = "icon")
	@JsonProperty("icon")
	private String icon;


	@Column(name = "detail_path")
	@JsonProperty("detailPath")
	private String detailPath;


	@ApiModelProperty(value = "体质")
	@Column(name = "tag_title")
	@JsonProperty("tagTitle")
	private String tagTitle;


	@ApiModelProperty(value = "颜色")
	@Column(name = "tag_color")
	@JsonProperty("tagColor")
	private Integer tagColor;


	@ApiModelProperty(value = "描述")
	@Column(name = "desc")
	@JsonProperty("desc")
	private String desc;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "modify_time")
	@JsonProperty("modifyTime")
	private Date modifyTime;


	@ApiModelProperty(value = "背景图片")
	@Column(name = "background")
	@JsonProperty("background")
	private String background;


	@ApiModelProperty(value = "适合人群")
	@Column(name = "shrq")
	@JsonProperty("shrq")
	private String shrq;


	@ApiModelProperty(value = "食材物性")
	@Column(name = "scwx")
	@JsonProperty("scwx")
	private String scwx;


	@ApiModelProperty(value = "食材功效")
	@Column(name = "scgx")
	@JsonProperty("scgx")
	private String scgx;


	@ApiModelProperty(value = "如何挑选")
	@Column(name = "select")
	@JsonProperty("select")
	private String select;


	@ApiModelProperty(value = "食材详情")
	@Column(name = "scxq")
	@JsonProperty("scxq")
	private String scxq;

}

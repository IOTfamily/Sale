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
 * @table: fruit_kind 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_kind", pk = "fid")
@ApiModel(value = "FruitKind", description = "")
public class FruitKind implements Serializable {

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


	@ApiModelProperty(value = "背景图片")
	@Column(name = "background")
	@JsonProperty("background")
	private String background;


	@ApiModelProperty(value = "体质")
	@Column(name = "tag_title")
	@JsonProperty("tagTitle")
	private String tagTitle;


	@ApiModelProperty(value = "颜色")
	@Column(name = "tag_color")
	@JsonProperty("tagColor")
	private Integer tagColor;


	@ApiModelProperty(value = "内容json")
	@Column(name = "content")
	@JsonProperty("content")
	private String content;


	@ApiModelProperty(value = "微信分享")
	@Column(name = "share_info")
	@JsonProperty("shareInfo")
	private String shareInfo;


	@ApiModelProperty(value = "百科")
	@Column(name = "biref")
	@JsonProperty("biref")
	private String biref;


	@ApiModelProperty(value = "描述")
	@Column(name = "kind_desc")
	@JsonProperty("kindDesc")
	private String kindDesc;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "modify_time")
	@JsonProperty("modifyTime")
	private Date modifyTime;


	@ApiModelProperty(value = "分类1.水果")
	@Column(name = "cate")
	@JsonProperty("cate")
	private Integer cate;

}

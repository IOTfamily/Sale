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
 * @table: fruit_area 
 * @tableDesc: 全国行政区域编码表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_area", pk = "id")
@ApiModel(value = "FruitArea", description = "全国行政区域编码表")
public class FruitArea implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "区域名称")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@ApiModelProperty(value = "中文拼音")
	@Column(name = "spell")
	@JsonProperty("spell")
	private String spell;


	@ApiModelProperty(value = "首字母简拼")
	@Column(name = "short_spell")
	@JsonProperty("shortSpell")
	private String shortSpell;


	@ApiModelProperty(value = "国标编码")
	@Column(name = "code")
	@JsonProperty("code")
	private String code;


	@ApiModelProperty(value = "区号 例如 北京：010")
	@Column(name = "areacode")
	@JsonProperty("areacode")
	private String areacode;


	@ApiModelProperty(value = "父级区域编码")
	@Column(name = "pcode")
	@JsonProperty("pcode")
	private String pcode;


	@ApiModelProperty(value = "区域等级 省级：province 市级：city 区级：district")
	@Column(name = "level")
	@JsonProperty("level")
	private String level;


	@ApiModelProperty(value = "经纬度")
	@Column(name = "coordinate")
	@JsonProperty("coordinate")
	private String coordinate;


	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "update_time")
	@JsonProperty("updateTime")
	private Date updateTime;


	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;

}

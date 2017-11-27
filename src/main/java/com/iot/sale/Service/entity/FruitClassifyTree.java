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
 * @table: fruit_classify_tree 
 * @tableDesc: 分类树表 
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_classify_tree", pk = "id")
@ApiModel(value = "FruitClassifyTree", description = "分类树表")
public class FruitClassifyTree implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "父类id")
	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Integer parentId;


	@ApiModelProperty(value = "权重")
	@Column(name = "level")
	@JsonProperty("level")
	private Integer level;


	@ApiModelProperty(value = "名字")
	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@ApiModelProperty(value = "英文名")
	@Column(name = "english_name")
	@JsonProperty("englishName")
	private Integer englishName;


	@ApiModelProperty(value = "推荐标签")
	@Column(name = "tags")
	@JsonProperty("tags")
	private Integer tags;


	@ApiModelProperty(value = "说明")
	@Column(name = "describe")
	@JsonProperty("describe")
	private Integer describe;


	@ApiModelProperty(value = "标记的人数")
	@Column(name = "mark_num")
	@JsonProperty("markNum")
	private Integer markNum;

}

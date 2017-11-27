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
 * @table: fruit_good 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_good", pk = "id")
@ApiModel(value = "FruitGood", description = "")
public class FruitGood implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@ApiModelProperty(value = "目录id")
	@Column(name = "menu_id")
	@JsonProperty("menuId")
	private Integer menuId;


	@ApiModelProperty(value = "作者")
	@Column(name = "author")
	@JsonProperty("author")
	private String author;


	@ApiModelProperty(value = "价格单位分")
	@Column(name = "price")
	@JsonProperty("price")
	private Integer price;


	@ApiModelProperty(value = "折扣")
	@Column(name = "discount")
	@JsonProperty("discount")
	private Integer discount;


	@ApiModelProperty(value = "优惠金额")
	@Column(name = "favourable")
	@JsonProperty("favourable")
	private Integer favourable;


	@ApiModelProperty(value = "种类id")
	@Column(name = "kind_id")
	@JsonProperty("kindId")
	private Integer kindId;


	@ApiModelProperty(value = "标题")
	@Column(name = "title")
	@JsonProperty("title")
	private String title;


	@ApiModelProperty(value = "尺寸")
	@Column(name = "size")
	@JsonProperty("size")
	private String size;


	@ApiModelProperty(value = "颜色")
	@Column(name = "color")
	@JsonProperty("color")
	private String color;


	@ApiModelProperty(value = "是否有效1有效 2无效 3待审核")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;


	@ApiModelProperty(value = "文章描述")
	@Column(name = "describe")
	@JsonProperty("describe")
	private String describe;


	@ApiModelProperty(value = "文章描述")
	@Column(name = "good_desc")
	@JsonProperty("goodDesc")
	private String goodDesc;


	@ApiModelProperty(value = "轮播图")
	@Column(name = "banner")
	@JsonProperty("banner")
	private String banner;


	@ApiModelProperty(value = "首图")
	@Column(name = "show")
	@JsonProperty("show")
	private String show;


	@ApiModelProperty(value = "文章内容")
	@Column(name = "content")
	@JsonProperty("content")
	private String content;


	@ApiModelProperty(value = "内容链接")
	@Column(name = "content_url")
	@JsonProperty("contentUrl")
	private String contentUrl;


	@ApiModelProperty(value = "排序")
	@Column(name = "sort")
	@JsonProperty("sort")
	private Integer sort;


	@ApiModelProperty(value = "点击次数")
	@Column(name = "click")
	@JsonProperty("click")
	private Integer click;


	@ApiModelProperty(value = "类型")
	@Column(name = "type")
	@JsonProperty("type")
	private Integer type;


	@ApiModelProperty(value = "样式类型")
	@Column(name = "classify")
	@JsonProperty("classify")
	private Integer classify;


	@ApiModelProperty(value = "资源md5")
	@Column(name = "source_md5")
	@JsonProperty("sourceMd5")
	private String sourceMd5;


	@ApiModelProperty(value = "创建时间")
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

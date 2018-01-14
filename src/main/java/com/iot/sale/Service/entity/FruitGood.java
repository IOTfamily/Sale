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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getFavourable() {
		return favourable;
	}

	public void setFavourable(Integer favourable) {
		this.favourable = favourable;
	}

	public Integer getKindId() {
		return kindId;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getGoodDesc() {
		return goodDesc;
	}

	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

	public String getSourceMd5() {
		return sourceMd5;
	}

	public void setSourceMd5(String sourceMd5) {
		this.sourceMd5 = sourceMd5;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

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

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
 * @table: fruit_fsky_task 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "fruit_fsky_task", pk = "id")
@ApiModel(value = "FruitFskyTask", description = "")
public class FruitFskyTask implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增主键")
	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@Column(name = "uid")
	@JsonProperty("uid")
	private Integer uid;


	@ApiModelProperty(value = "手机号")
	@Column(name = "phone_number")
	@JsonProperty("phoneNumber")
	private String phoneNumber;


	@ApiModelProperty(value = "地址")
	@Column(name = "address")
	@JsonProperty("address")
	private String address;


	@ApiModelProperty(value = "亩数")
	@Column(name = "count")
	@JsonProperty("count")
	private Integer count;


	@ApiModelProperty(value = "作业日期")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "date")
	@JsonProperty("date")
	private Date date;


	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "create_time")
	@JsonProperty("createTime")
	private Date createTime;


	@ApiModelProperty(value = "作业时间是否可调整")
	@Column(name = "date_select")
	@JsonProperty("dateSelect")
	private Integer dateSelect;


	@ApiModelProperty(value = "0已完成，1未完成")
	@Column(name = "status")
	@JsonProperty("status")
	private Integer status;

}

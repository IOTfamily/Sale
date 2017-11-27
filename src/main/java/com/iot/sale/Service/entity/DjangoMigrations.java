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
 * @table: django_migrations 
 * @tableDesc:  
 * @author: entity code gen 
 * @company: (C) Copyright 2017 
 * @since: JDK 1.8 
***************************************/ 

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "django_migrations", pk = "id")
@ApiModel(value = "DjangoMigrations", description = "")
public class DjangoMigrations implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@JsonProperty("id")
	private Integer id;


	@Column(name = "app")
	@JsonProperty("app")
	private String app;


	@Column(name = "name")
	@JsonProperty("name")
	private String name;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name = "applied")
	@JsonProperty("applied")
	private Date applied;

}

package com.iot.sale.Service.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.sale.Base.dao.annotation.Column;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "AlbumVO", description = "图片资源")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Album {

    @ApiModelProperty(value = "自增主键")
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;


    @ApiModelProperty(value = "资源地址")
    @Column(name = "value")
    @JsonProperty("value")
    private String value;


    @ApiModelProperty(value = "提及")
    @Column(name = "alt")
    @JsonProperty("alt")
    private String alt;


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

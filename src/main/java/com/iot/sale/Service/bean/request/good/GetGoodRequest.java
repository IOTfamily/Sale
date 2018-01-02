package com.iot.sale.Service.bean.request.good;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Data
@ApiModel(value = "GetGoodRequest", description = "查找商品详细信息")
public class GetGoodRequest implements Serializable {


    @NotEmpty
    @ApiModelProperty(value = "商品ID", example = "1", required = true)
    @JsonProperty("id")
    public Integer id;

}
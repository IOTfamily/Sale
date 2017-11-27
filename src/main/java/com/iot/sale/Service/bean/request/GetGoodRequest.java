package com.iot.sale.Service.bean.request;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/11/27
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Data
@ApiModel(value = "GetCompanyRequest", description = "查找保险公司详细信息")
public class GetGoodRequest implements Serializable {


    @ApiModelProperty(value = "公司id", example = "公司id", required = true)
    @NotNull(message = "公司id不能为空")
    private Integer id;

}
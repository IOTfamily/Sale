package com.iot.sale.Service.bean.request.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.sale.Base.dao.annotation.Column;
import com.iot.sale.Service.bean.vo.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/4
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Data
@ApiModel(value = "AddOrderRequest", description = "添加订单")
public class AddOrderRequest implements Serializable{

    @ApiModelProperty(value = "订单列表")
    private List<Order> orderList;
}

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
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.util.Date;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/4
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "OrderVO", description = "订单资源")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @ApiModelProperty(value = "商品id")
    @Column(name = "good_id")
    @JsonProperty("goodId")
    private Integer goodId;

    @Min(1)
    @NotEmpty
    @ApiModelProperty(value = "购买数量")
    @Column(name = "count")
    @JsonProperty("count")
    private Integer count;


    @ApiModelProperty(value = "支付成功订单号")
    @Column(name = "pay_no")
    @JsonProperty("payNo")
    private String payNo;


    @ApiModelProperty(value = "0待支付，1支付成功，2支付失败")
    @Column(name = "pay_status")
    @JsonProperty("payStatus")
    private Integer payStatus;


    @ApiModelProperty(value = "购买者说的话")
    @Column(name = "buyer_need")
    @JsonProperty("buyerNeed")
    private String buyerNeed;

    @NotEmpty
    @ApiModelProperty(value = " 发货地址")
    @Column(name = "address")
    @JsonProperty("address")
    private String address;
}

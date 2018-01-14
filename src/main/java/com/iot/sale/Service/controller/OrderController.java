package com.iot.sale.Service.controller;

import com.iot.sale.Base.web.ApiRequest;
import com.iot.sale.Base.web.ApiResponse;
import com.iot.sale.Base.web.BaseController;
import com.iot.sale.Service.bean.request.good.GetGoodRequest;
import com.iot.sale.Service.bean.request.order.AddOrderRequest;
import com.iot.sale.Service.bean.response.good.GetGoodResponse;
import com.iot.sale.Service.entity.FruitGood;
import com.iot.sale.Service.entity.FruitGoodOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/4
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Api(value = "OrderController",description="订单相关数据")
@RequestMapping("/order")
@Slf4j
@RestController
public class OrderController extends BaseController {

    /**
     * 获取用户订单列表
     */
    public ApiResponse getOrderList(){
        List<FruitGoodOrder> list = new LinkedList<>();

        ApiResponse res = ApiResponse.buildSuccess();
        res.put("orderList","");

        return res;
    };

    /**
     * 获取用户订单详情
     */
    @ResponseBody
    @ApiOperation(value="获取订单详情",httpMethod = "POST", response = ApiResponse.class, notes = "订单详情")
    @ApiImplicitParam(paramType="query", name = "id", value = "订单编号", required = true, dataType = "String")
    @PostMapping("/get")
    public ApiResponse getOrder(@ApiParam("商品ID") @RequestParam String id){

        ApiResponse res = ApiResponse.buildSuccess();
        res.put("orderList","");

        return res;
    };

    /**
     * 添加订单
     */
    @ResponseBody
    @ApiOperation(value="添加商品订单",httpMethod = "POST", response = ApiResponse.class, notes = "商品订单")
    @ApiImplicitParam(name = "request", required = true, dataType = "AddOrderRequest")
    @PostMapping("/add")
    public ApiResponse addOrder(@RequestBody @Valid ApiRequest<AddOrderRequest> request){
        AddOrderRequest addOrderRequest = request.getData();
        System.out.println(addOrderRequest.getOrderList());


        ApiResponse res = ApiResponse.buildSuccess();
        res.put("orderList","");

        return res;
    };

    /**
     * 删除订单
     */
    public ApiResponse delOrder(){
        ApiResponse res = ApiResponse.buildSuccess();
        res.put("orderList","");

        return res;
    };
}

package com.iot.sale.Service.controller;

import com.iot.sale.Base.web.ApiRequest;
import com.iot.sale.Base.web.BaseController;
import com.iot.sale.Base.web.JsonResult;
import com.iot.sale.Service.bean.request.good.GetGoodRequest;
import com.iot.sale.Service.bean.response.good.GetGoodResponse;
import com.iot.sale.Service.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Api(value = "GoodController",description="商品相关数据")
@RequestMapping("/good")
@Slf4j
@RestController
public class GoodController extends BaseController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("list")
    public JsonResult show(HttpServletRequest request) {
        JsonResult res =  createSuccessResult();
        List<Map<String, Object>> list = goodService.getGoodListInHome();
        for(Map<String, Object> item: list){
            for(String key :item.keySet()){
                System.out.println(key);
            }
            System.out.println("<><>>");
            res.setData(item);
        }
        return res;
    }

    @ApiOperation(value="获取商品详情",httpMethod = "POST", response = GetGoodResponse.class, notes = "商品详情")
    @ApiImplicitParam(name = "request", required = true, dataType = "GetGoodRequest")
    // Todo 没有request bean 的注释方式
    //@ApiImplicitParam(paramType="query", name = "id", value = "商品编号", required = true, dataType = "String")
    @PostMapping("/get")
    ///public JsonResult getGood(@ApiParam("商品ID") @RequestParam String id){
    public JsonResult getGood(@RequestBody ApiRequest<GetGoodRequest> request){
        GetGoodRequest goodRequestBean = request.getData();
        GetGoodResponse fruitGood = goodService.getGood(goodRequestBean.getId().toString());

        JsonResult res = this.createSuccessResult();
        res.put("goodDetail",fruitGood);
        return res;
    }

    @ApiOperation(value="获取商品详情",httpMethod = "POST", response = GetGoodResponse.class, notes = "商品详情")
    @ApiImplicitParam(paramType="query", name = "id", value = "商品编号", required = true, dataType = "String")
    @PostMapping("/test")
    public JsonResult test(@ApiParam("商品ID") @RequestParam String id){
        GetGoodResponse fruitGood = goodService.getGood(id);

        JsonResult res = this.createSuccessResult();
        res.put("goodDetail",fruitGood);
        return res;
    }
}

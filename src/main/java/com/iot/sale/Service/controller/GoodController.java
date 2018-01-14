package com.iot.sale.Service.controller;

import com.iot.sale.Base.web.ApiRequest;
import com.iot.sale.Base.web.ApiResponse;
import com.iot.sale.Base.web.BaseController;
import com.iot.sale.Base.web.JsonResult;
import com.iot.sale.Service.bean.request.good.GetGoodRequest;
import com.iot.sale.Service.bean.request.good.GetHomeListRequest;
import com.iot.sale.Service.bean.response.good.GetGoodResponse;
import com.iot.sale.Service.bean.response.good.GetHomeListResponse;
import com.iot.sale.Service.entity.FruitGood;
import com.iot.sale.Service.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
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

    //TODO: 统一成 ApiResponse和 ApiRequest形式
    @RequestMapping("listtest")
    public JsonResult show(@RequestParam(value = "pageNum", required = true) int pageNum,
                           HttpServletRequest request) {
        JsonResult res =  createSuccessResult();
        System.out.println("goodService.show()");
        res.setData(goodService.getGoodListInHometest(pageNum));
        return res;
    }


    @ResponseBody
    @ApiOperation(value="获取首页商品列表",httpMethod = "POST", response = GetHomeListResponse.class, notes = "首页商品列表")
    @ApiImplicitParam(name = "request", required = true, dataType = "GetHomeListRequest")
    // Todo 没有request bean 的注释方式
    @PostMapping("/list")
    public ApiResponse show(@RequestBody @Valid ApiRequest<GetHomeListRequest> request) {
        GetHomeListRequest homeListRequestBean = request.getData();
        GetHomeListResponse response = goodService.getGoodListInHome(homeListRequestBean.getPageNum());
        ApiResponse res = ApiResponse.buildSuccess();
        res.put("goodList",response.getList());
        res.put(GoodService.KEY_HAS_NEXT, response.getHasNext());
        res.put(GoodService.KEY_CUEENT_PAGE_NUM, response.getPageNum());
        System.out.println("goodService.show()");
        return res;
    }

    @ResponseBody
    @ApiOperation(value="获取商品详情",httpMethod = "POST", response = GetGoodResponse.class, notes = "商品详情")
    @ApiImplicitParam(name = "request", required = true, dataType = "GetGoodRequest")
    // Todo 没有request bean 的注释方式
    //@ApiImplicitParam(paramType="query", name = "id", value = "商品编号", required = true, dataType = "String")
    @PostMapping("/get")
    ///public JsonResult getGood(@ApiParam("商品ID") @RequestParam String id){
    public ApiResponse getGood(@RequestBody @Valid ApiRequest<GetGoodRequest> request){
        GetGoodRequest goodRequestBean = request.getData();
        GetGoodResponse fruitGood = goodService.getGood(goodRequestBean.getId().toString());
        ApiResponse res = ApiResponse.buildSuccess();
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

package com.iot.sale.Service.service;

import com.iot.sale.Service.bean.response.good.GetGoodResponse;
import com.iot.sale.Service.entity.FruitGood;

import java.util.List;
import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public interface GoodService {

    public List<Map<String, Object>> getGoodListInHome();

    public GetGoodResponse getGood(String id);

    FruitGood getGoodJson(String id);
}

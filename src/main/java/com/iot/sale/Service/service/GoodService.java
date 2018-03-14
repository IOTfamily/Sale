package com.iot.sale.Service.service;

import com.iot.sale.Service.bean.response.good.GetGoodResponse;
import com.iot.sale.Service.bean.response.good.GetHomeListResponse;
import com.iot.sale.Service.entity.FruitGood;

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
public interface GoodService {

    List<Map<String, Object>> getGoodListInHome();

    public static final String KEY_HAS_NEXT = "hasNext";

    public static final String KEY_CUEENT_PAGE_NUM = "currentPageNum";

    public static final int PAGE_SIZE = 10;

    public HashMap<String, Object> getGoodListInHometest(int pageNum);

    public GetHomeListResponse getGoodListInHome(int pageNum);

    GetGoodResponse getGood(String id);

    FruitGood getGoodJson(String id);

    List<Object> queryCategoriesTree();
}

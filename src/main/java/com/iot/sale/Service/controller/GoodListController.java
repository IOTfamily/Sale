package com.iot.sale.Service.controller;

import com.iot.sale.Base.web.BaseController;
import com.iot.sale.Base.web.JsonResult;
import com.iot.sale.Service.entity.FruitGood;
import com.iot.sale.Service.service.impl.GoodListServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luxiaolin on 17/12/31.
 */
@RestController
@RequestMapping("/getgoodlist")
@Slf4j
public class GoodListController extends BaseController {

    @RequestMapping("")
    public JsonResult show(HttpServletRequest request) {
        System.out.println(request);
        System.out.println("============");
        GoodListServiceImpl goodListService = new GoodListServiceImpl();
        JsonResult res =  createSuccessResult();
        List<Map<String, Object>> list = goodListService.getGoodListInHome();
        for(Map<String, Object> item: list){
            for(String key :item.keySet()){
                System.out.println(key);
            }
            System.out.println("<><>>");
            res.setData(item);
        }
        return res;
    }
}

package com.iot.sale.Service.controller;

import com.iot.sale.Service.dao.FruitGoodDao;
import com.iot.sale.Service.entity.FruitGood;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/11/26
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description:
 ******************************************/
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

    @Autowired
    FruitGoodDao fruitGoodDao;

    @RequestMapping("")
    public HashMap<Object,Object> index(HttpServletRequest request) {
        System.out.println(request);
        System.out.println("============");
        HashMap<Object,Object> map = new HashMap<>();
        FruitGood good = new FruitGood();
        good = fruitGoodDao.findById("1818");
        map.put("good",good);
        return map;
    }

    @RequestMapping("/about")
    public HashMap<String,String> about(HttpServletRequest request) {
        System.out.println(request);
        System.out.println("============");
        HashMap<String,String> map = new HashMap<>();
        return map;
    }
}

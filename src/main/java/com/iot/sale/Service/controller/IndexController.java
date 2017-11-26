package com.iot.sale.Service.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
//@Slf4j
public class IndexController {

    @RequestMapping("")
    public HashMap<String,String> index(HttpServletRequest request) {
        System.out.println(request);
        System.out.println("============");
        HashMap<String,String> map = new HashMap<>();
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

package com.iot.sale.Service.controller;

import com.iot.sale.Base.web.BaseController;
import com.iot.sale.Base.web.JsonResult;
import com.iot.sale.Service.config.WebSecurityConfig;
import com.iot.sale.Service.entity.FruitUser;
import com.iot.sale.Service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/16
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping("")
    public JsonResult index(HttpServletRequest request) {
        JsonResult res = new JsonResult();

        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute(WebSecurityConfig.SESSION_KEY);

        if (uid == null) {
            res.setCode("Error");
            res.setDesc("请先登录");
            return res;
        }
        FruitUser fruitUser = userService.getUserInfo(uid);
        Map map = new HashMap();
        map.put("userInfo",fruitUser);

        res.setData(map);
        return res;
    }
}

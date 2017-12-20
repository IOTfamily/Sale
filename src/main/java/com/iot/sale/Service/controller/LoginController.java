package com.iot.sale.Service.controller;

import com.iot.sale.Base.web.BaseController;
import com.iot.sale.Base.web.JsonResult;
import com.iot.sale.Service.config.WebSecurityConfig;
import com.iot.sale.Service.entity.FruitGood;
import com.iot.sale.Service.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/******************************************
 * @author: lio
 * @createDate: 2017/12/16
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public JsonResult index(@RequestParam(value = "name", required = true) String name,
                            @RequestParam(value = "password", required = true) String password,
                            HttpServletRequest request) {
        JsonResult res = new JsonResult();

        Integer check_result = loginService.login(name,password);
        HttpSession session = request.getSession();
        if(session.getAttribute(WebSecurityConfig.SESSION_KEY) != null) return res;
        if(check_result != null){
            // 设置session
            session.setAttribute(WebSecurityConfig.SESSION_KEY,check_result);
        }else{
            res.setCode("Error");
            res.setDesc("登录失败");
        }
        System.out.println(session.getAttribute(WebSecurityConfig.SESSION_KEY));
        System.out.println("====== login ========");
        return this.createSuccessResult();
    }

    @RequestMapping("/logout")
    public JsonResult logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        System.out.println("====== logout ========");
        return this.createSuccessResult();
    }

    @RequestMapping("/register")
    public JsonResult register(@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "password", required = true) String password,
                               @RequestParam(value = "auth", required = true) String auth,
                               HttpServletRequest request) {
        // Todo 等接完短信auth换成短信验证，暂时就两次密码认证
        String uid = loginService.register(name,password,auth);
        if (uid != null) return this.createSuccessResult();

        JsonResult res = new JsonResult();
        res.setCode("Error");
        res.setMsg("注册失败");
        return res;
    }
}

package com.iot.sale.Service.controller;

import com.iot.sale.Base.util.DateUtil;
import com.iot.sale.Base.util.Sms;
import com.iot.sale.Base.web.BaseController;
import com.iot.sale.Base.web.JsonResult;
import com.iot.sale.Service.config.WebSecurityConfig;
import com.iot.sale.Service.entity.FruitGood;
import com.iot.sale.Service.service.LoginService;
import com.iot.sale.Service.service.SmsService;
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

    @Autowired
    private SmsService smsService;

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
            res.setCode("ERR_LOG_LOGIN_ERROR");
        }
        return res;
    }

    @RequestMapping("/logout")
    public JsonResult logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return this.createSuccessResult();
    }

    @RequestMapping("/register")
    public JsonResult register(@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "password", required = true) String password,
                               @RequestParam(value = "auth", required = true) String auth,
                               HttpServletRequest request) {
        JsonResult res = this.createSuccessResult();
        Boolean authRes = smsService.isValidCode(name, auth);
        Map<String,Object> registerRes = loginService.register(name, password, authRes);
        if (registerRes.get("code") == null){
            // 设置session
            HttpSession session = request.getSession();
            session.setAttribute(WebSecurityConfig.SESSION_KEY, registerRes.get("uid"));
            return res;
        };

        res.setCode(registerRes.get("code").toString());
        return res;
    }

    @RequestMapping("/getVcode")
    public JsonResult getVcode(@RequestParam(value = "phone", required = true) String phone,
                               HttpServletRequest request) {
        JsonResult res = this.createSuccessResult();

        HttpSession session = request.getSession();
        if(session.getAttribute(WebSecurityConfig.SESSION_KEY) != null){
            res.setCode("ERR_SYS_SID_INVALID");
            return res;
        }
        Map<String,Object> code = smsService.createVcode(phone);
        if(!code.get("code").equals("success")){
            res.setCode(code.get("code").toString());
            return res;
        }
        Map<String, String> map = new HashMap<>();
        DateUtil dateUtil = new DateUtil();
        map.put("name", code.get("vCode").toString());
        map.put("time", dateUtil.getFormatDate());
        if(Sms.sendSms(phone,"SMS_78760146", map)){
            res.setData(code);
            return res;
        }
        res.setCode("ERR_LOG_VERIFY_CODE_SEND_FALSE");
        return res;
    }

}

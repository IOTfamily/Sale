package com.iot.sale.util;

import com.iot.sale.Base.util.DateUtil;
import com.iot.sale.Base.util.Sms;
import com.iot.sale.Service.dao.FruitUserDao;
import com.iot.sale.Service.service.SmsService;
import com.iot.sale.Service.service.UserService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import com.iot.sale.Service.util.VcodeUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/17
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsTest {

    @Autowired
    UserService userService;

    @Autowired
    SmsService smsService;

    @Test
    public void sendSmsTest() {
        Sms.test();
    }

    @Test
    public void sendSms() {
//        Map<String, String> map = new HashMap<>();
//        DateUtil dateUtil = new DateUtil();
//        map.put("name", "黑社会大哥");
//        map.put("time", dateUtil.getFormatDate());
//        Boolean res = Sms.sendSms("13051813611","SMS_78760146", map);
//
//        System.out.println(res ? "success" : "fail");
    }

    @Test
    public void getVcode(){
        //Map<String,String> res = smsService.createVcode("13051813611");
        //System.out.println(res.toString());
    }

    @Test
    public void checkVcode(){
        Boolean res = smsService.isValidCode("13051813611","333333");
        System.out.println(res.toString());
    }

    @Test
    public void getUserInfo(){
        System.out.println(userService.getUserInfo(1));
    }


}

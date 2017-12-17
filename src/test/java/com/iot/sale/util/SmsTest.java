package com.iot.sale.util;

import com.iot.sale.Base.util.DateUtil;
import com.iot.sale.Base.util.Sms;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/17
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public class SmsTest {

    @Test
    public void sendSmsTest() {
        Sms sms = new Sms();

        sms.test();
    }

    @Test
    public void sendSms() {
        Sms sms = new Sms();
        Map<String, String> map = new HashMap<>();
        DateUtil dateUtil = new DateUtil();
        map.put("name", "黑社会大哥");
        map.put("time", dateUtil.getFormatDate());
        Boolean res = sms.sendSms("13051813611", map);

        System.out.println(res ? "success" : "fail");
    }
}

package com.iot.sale.Service.util;

import com.iot.sale.Service.dao.FruitUserDao;
import com.iot.sale.Service.dao.FruitVcodeDao;
import com.iot.sale.Service.entity.FruitUser;
import com.iot.sale.Service.entity.FruitVcode;
import com.iot.sale.Service.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/21
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public class VcodeUtil {

    @Autowired
    private FruitVcodeDao fruitVcodeDao;

    @Autowired
    private SmsService smsService;

    private static final Integer VALIDATE_CODE_EXPIRED = 600;
    private static final Integer VALIDATE_CODE_SEND_INTERVAL = 60;

    //发短信
    public Boolean sendSms(String mobile, String tmplNo, Map<String,Object> parameter){
        return smsService.sendSms(mobile, tmplNo, parameter);
    }


    /**
     * 生成指定长度的随机验证码
     *
     * @param length
     * @return
     */
    public static String createRandCode(Integer length) {
        if(length == null) length = 6;
        StringBuilder randCode = new StringBuilder();
        while (randCode.length() < length) {
            Random rand =new Random();
            randCode.append(rand.nextInt(10));
        }
        return randCode.toString();
    }

    /**
     * 验证码是否已超时
     *
     * @param sendTime
     * @return
     */
    public static Boolean isExpired(Integer sendTime) {
        Date date = new Date();
        return date.getTime() >= sendTime + VcodeUtil.VALIDATE_CODE_EXPIRED;
    }

    /**
     * 判断下发验证码的操作频率是否过快
     *
     * @param sendTime
     * @return
     */
    public static Boolean isFrequent(Integer sendTime) {
        Date date = new Date();
        return date.getTime() < sendTime + VcodeUtil.VALIDATE_CODE_SEND_INTERVAL;
    }
}

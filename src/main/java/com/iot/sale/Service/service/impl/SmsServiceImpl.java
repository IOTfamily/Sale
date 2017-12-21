package com.iot.sale.Service.service.impl;

import com.iot.sale.Base.util.Sms;
import com.iot.sale.Service.dao.FruitVcodeDao;
import com.iot.sale.Service.entity.FruitVcode;
import com.iot.sale.Service.service.SmsService;
import com.iot.sale.Service.util.CheckUtil;
import com.iot.sale.Service.util.VcodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/21
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private FruitVcodeDao fruitVcodeDao;

    @Autowired
    private SmsService smsService;

    private static final Integer VALIDATE_CODE_EXPIRED = 600;
    private static final Integer VALIDATE_CODE_SEND_INTERVAL = 60;


    @Override
    public Boolean sendSms(String mobile, String tmplNo, Map<String, Object> parameter) {
        Map<String, String> map = new HashMap<>();
        // Todo 配置过滤
        return Sms.sendSms(mobile,tmplNo,map);
    }

    /**
     * 生成短信验证码
     */
    public Map<String, Object> createVcode(String mobile) {
        String error_code = "";
        // 不是有效的手机号码
        if (!CheckUtil.isValidMobile(mobile)) {
            // 报错返回错误码
            Map<String, Object> res = new HashMap<>();
            // Todo 添加错误码配置文件
            System.out.println("不是有效手机号");
            res.put("code","error");
            return res;
        }
        // 生成验证码和校验码
        String vCode = VcodeUtil.createRandCode(6);
        String cCode = UUID.randomUUID().toString().replaceAll("-", "").substring(0,6);
        Map<String, Object> condition = new HashMap<>();
        condition.put("mobile", mobile);
        condition.put("status", 0);
        FruitVcode fruitVcode = fruitVcodeDao.findObjByFields(condition);
        if (fruitVcode != null) {
            // 验证码过期
            if (VcodeUtil.isExpired(fruitVcode.getSendTime())) {
                // 更新数据
                Map<String, Object> conditionAdd = new HashMap<>();
                conditionAdd.put("id", fruitVcode.getId());
                conditionAdd.put("status", 0);
                conditionAdd.put("vcode", vCode);
                conditionAdd.put("ccode", cCode);
                Date date = new Date();
                conditionAdd.put("send_time", Math.abs(date.getTime()/1000));
                conditionAdd.put("device_id", "");

                fruitVcodeDao.update(conditionAdd);
            } else {
                // 操作频率过快
                if (VcodeUtil.isFrequent(fruitVcode.getSendTime())) {
                    error_code = "ERR_LOG_MOBILE_FREQUENT_SEND";
                    System.out.println("操作频率过快");
                } else {
                    // 再次下发验证码
                    Map<String, Object> conditionAdd = new HashMap<>();
                    conditionAdd.put("id", fruitVcode.getId());
                    conditionAdd.put("status", 0);
                    Date date = new Date();
                    conditionAdd.put("send_time", Math.abs(date.getTime()/1000));
                    conditionAdd.put("device_id", "");

                    fruitVcodeDao.update(conditionAdd);
                }
            }
        } else {
            // 新增数据
            Map<String, Object> conditionAdd = new HashMap<>();
            conditionAdd.put("mobile", mobile);
            conditionAdd.put("status", 0);
            conditionAdd.put("vcode", vCode);
            conditionAdd.put("ccode", cCode);
            Date date = new Date();
            conditionAdd.put("send_time", Math.abs(date.getTime()/1000));
            conditionAdd.put("device_id", "");

            fruitVcodeDao.saveReturnPrimary(conditionAdd);
        }
        Map<String, Object> res = new HashMap<>();
        res.put("cCode",cCode);
        res.put("vCode",vCode);
        res.put("code",error_code.equals("") ? "success" : error_code);
        return res;
    }

    public Boolean isValidCode(String mobile,String vcode){
        if (mobile != null && vcode != null && vcode.length() > 0) {
            Map<String, Object> condition = new HashMap<>();
            condition.put("mobile", mobile);
            condition.put("vcode", vcode);
            condition.put("status", 0);
            FruitVcode fruitVcode = fruitVcodeDao.findObjByFields(condition);

            if (fruitVcode != null) {
                Integer send_time = fruitVcode.getSendTime();
                Date date = new Date();
                // 验证码在有效期内
                System.out.println(Math.abs(date.getTime()/1000));
                System.out.println((send_time + VALIDATE_CODE_EXPIRED));
                if (Math.abs(date.getTime()/1000) < (send_time + VALIDATE_CODE_EXPIRED)) {
                    //更新状态
                    Map<String,Object> saveCondition = new HashMap<>();
                    saveCondition.put("id", fruitVcode.getId());
                    saveCondition.put("status", 1);
                    saveCondition.put("send_time", Math.abs(date.getTime()/1000));
                    fruitVcodeDao.update(saveCondition);
                    return true;
                }
            }
        }
        return false;
    }
}

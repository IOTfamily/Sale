package com.iot.sale.Service.service.impl;

import com.iot.sale.Service.dao.FruitUserDao;
import com.iot.sale.Service.entity.FruitUser;
import com.iot.sale.Service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/16
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    FruitUserDao fruitUserDao;

    @Override
    public Integer login(String name, String password) {
        HashMap<String,Object> condition = new HashMap<>();
        condition.put("phone_number",name);
        FruitUser fruitUser = fruitUserDao.findObjByFields(condition);
        if(fruitUser != null && password.equals(fruitUser.getPassword())){
            return fruitUser.getUid();
        }else {
            return null;
        }
    }

    @Override
    public Map<String, Object> register(String phoneNumber, String password, Boolean auth) {
        // 验证手机号是否存在
        HashMap<String,Object> condition = new HashMap<>();
        HashMap<String,Object> resultMap = new HashMap<>();
        condition.put("phone_number",phoneNumber);
        FruitUser fruitUser = fruitUserDao.findObjByFields(condition);
        if(fruitUser != null) {
            resultMap.put("code","ERR_LOG_REG_USER_PHONE_NUM_EXISTED");
            return resultMap;
        }
        // "auth" 认证
        if(!auth){
            resultMap.put("code","ERR_LOG_REG_VALIDATE_FAILURE");
            return resultMap;
        }
        condition.put("password",password);
        String uid = fruitUserDao.saveReturnPrimary(condition);
        resultMap.put("uid",uid);
        resultMap.put("code",null);
        return resultMap;
    }

    @Override
    public Boolean updatePassword(String name, String password) {
        return null;
    }
}

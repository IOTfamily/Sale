package com.iot.sale.Service.service.impl;

import com.iot.sale.Service.dao.FruitUserDao;
import com.iot.sale.Service.entity.FruitUser;
import com.iot.sale.Service.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    FruitUserDao fruitUserDao;

    @Override
    public FruitUser getUserInfo(Integer uid) {
        Map<String,Object> condition = new HashMap<>();
        condition.put("uid",uid);
        FruitUser fruitUser = fruitUserDao.findObjByFields(condition);

        return fruitUser;
    }
}

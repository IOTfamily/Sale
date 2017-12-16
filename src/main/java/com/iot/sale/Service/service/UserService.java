package com.iot.sale.Service.service;

import com.iot.sale.Service.entity.FruitUser;

import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/16
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public interface UserService {

    /**
     * 获取用户基本信息
     * @param uid
     * @return
     */
    public FruitUser getUserInfo(Integer uid);
}

package com.iot.sale.Service.service;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/16
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public interface LoginService {
    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    public Integer login(String name, String password);

    /**
     * 注册
     * @param name
     * @param password
     * @param auth
     * @return
     */
    public String register(String name, String password, String auth);


    /**
     * 修改密码
     * @param name
     * @param password
     * @return
     */
    public Boolean updatePassword(String name,String password);
}

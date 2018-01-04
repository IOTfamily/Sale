package com.iot.sale.Base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/3
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Slf4j
public class LogUtil {
    private static InetAddress address = null;

    static{
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.error("UnknownHostException", e);
        }
    }

    public static String getJSONMessage(Throwable e){
        return getJSONMessage(e.getMessage(), e);
    }

    public static String getJSONMessage(String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hostName", address.getHostAddress());
        jsonObject.put("machineName", address.getHostName());
        jsonObject.put("message", message);
        return JSON.toJSONString(jsonObject);
    }

    public static String getJSONMessage(String message, String data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hostName", address.getHostAddress());
        jsonObject.put("machineName", address.getHostName());
        jsonObject.put("message", message);
        jsonObject.put("data", data);
        return JSON.toJSONString(jsonObject);
    }

    public static String getJSONMessage(String message, Throwable e){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hostName", IPUtil.getIp());
        jsonObject.put("machineName", address.getHostName());
        jsonObject.put("message",message);
        jsonObject.put("exception", ExceptionUtils.getStackTrace(e));
        return JSON.toJSONString(jsonObject);
    }

    public static String getJSONMessage(String message, String data, Throwable e){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hostName", IPUtil.getIp());
        jsonObject.put("machineName", address.getHostName());
        jsonObject.put("message",message);
        jsonObject.put("data",data);
        jsonObject.put("exception",ExceptionUtils.getStackTrace(e));
        return JSON.toJSONString(jsonObject);
    }
}

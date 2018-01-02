package com.iot.sale.Base.config;

import com.iot.sale.Base.exception.ErrorCode;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public class BaseErrorCode {
    public static final ErrorCode SUCCESS = ErrorCode.of("OK", "调用成功");
    public static final ErrorCode ERR_SYSTEM_ERROR = ErrorCode.of("ERR_SYSTEM_ERROR", "系统繁忙,请稍后再试");
    public static final ErrorCode ERR_SYSTEM_UNKNOW = ErrorCode.of("ERR_SYSTEM_UNKNOW", "未知错误");
    public static final ErrorCode ERR_SYSTEM_UNAUTHENTICATED = ErrorCode.of("ERR_SYSTEM_UNAUTHENTICATED", "未登陆");
    public static final ErrorCode ERR_SYSTEM_AUTH_REJECT = ErrorCode.of("ERR_SYSTEM_AUTH_REJECT", "非法请求");
    public static final ErrorCode ERR_SYSTEM_PARAM_MISSING = ErrorCode.of("ERR_SYSTEM_PARAM_MISSING", "缺少关键参数");
    public static final ErrorCode ERR_SYSTEM_PARAM_CHECK = ErrorCode.of("ERR_SYSTEM_PARAM_CHECK", "参数校验失败");
    public static final ErrorCode ERR_SYSTEM_API_ERROR = ErrorCode.of("ERR_SYSTEM_API_ERROR", "请求的接口异常");
    public static final ErrorCode ERR_SYSTEM_SERVICE_ERROR = ErrorCode.of("ERR_SYSTEM_SERVICE_ERROR", "请求的服务异常");
    public static final ErrorCode ERR_SYSTEM_DAO_ERROR = ErrorCode.of("ERR_SYSTEM_DAO_ERROR", "请求的数据异常");

    public BaseErrorCode() {
    }
}
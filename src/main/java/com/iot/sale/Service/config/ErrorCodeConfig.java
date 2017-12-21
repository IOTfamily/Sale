package com.iot.sale.Service.config;


import com.iot.sale.Base.exception.ErrorCode;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/21
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public class ErrorCodeConfig extends com.iot.sale.Base.config.ErrorCodeConfig{
    public static final ErrorCode ERR_BNO_NOT_FOUND = ErrorCode.of("ERR_BNO_NOT_FOUND", "保险编号不存在");
}

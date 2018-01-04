package com.iot.sale.Base.exception;

import lombok.Data;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/3
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@Data
public class UnauthorizedException extends AbstractErrorCodeException{
    private static final long serialVersionUID = 5140227518765869992L;

    /**
     * @param errorCode 异常的代码
     */
    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }

    /**
     * @param code    异常的代码
     * @param content 异常的文案，出现在JsonResult中。
     */
    public UnauthorizedException(String code, String content) {
        super(ErrorCode.of(code, content));
    }

    /**
     * @param errorCode  异常的代码
     * @param cause 原始错误信息，异常链的上层。
     */
    public UnauthorizedException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}

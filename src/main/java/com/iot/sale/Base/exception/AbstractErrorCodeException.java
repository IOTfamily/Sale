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
public abstract class AbstractErrorCodeException extends RuntimeException {
    private static final long serialVersionUID = -239271176553209759L;

    /**
     * 异常信息对象,包含
     */
    protected ErrorCode errorCode;

    /**
     * @param errorCode 异常的代码
     */
    public AbstractErrorCodeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @param errorCode  异常的代码
     * @param cause 原始错误信息，异常链的上层。
     */
    public AbstractErrorCodeException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }
}
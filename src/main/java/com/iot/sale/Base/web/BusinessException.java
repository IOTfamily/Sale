package com.iot.sale.Base.web;


import com.iot.sale.Base.config.ErrorCodeConfig;

/**
 * 业务异常类
 */
public class BusinessException extends RuntimeException {
    /**
     * 异常的类目信息里的具体代码
     */
    private String code;

    /**
     * 业务异常信息，用户在客户端上展示等。
     */
    private String content;

    /**
     * @param code 异常的代码
     */
    public BusinessException(String code) {
        super(ErrorCodeConfig.getErrorMsg(code));
        this.code = code;
    }

    /**
     * @param code    异常的代码
     * @param content 异常的文案，出现在JsonResult中。
     */
    public BusinessException(String code, String content) {
        super(content);
        this.code = code;
        this.content = content;
    }

    /**
     * @param code  异常的代码
     * @param cause 原始错误信息，异常链的上层。
     */
    public BusinessException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

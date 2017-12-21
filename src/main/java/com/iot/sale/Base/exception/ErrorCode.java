package com.iot.sale.Base.exception;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/21
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
import java.io.Serializable;

public class ErrorCode implements Serializable {
    private String errorCode;
    private String errorMsg;
    private String errorDesc;

    public ErrorCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ErrorCode(String errorCode, String errorMsg, String errorDesc) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorDesc = errorDesc;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public ErrorCode withErrorMsg(String errorMsg) {
        return new ErrorCode(this.errorCode, errorMsg);
    }

    public ErrorCode withErrorDesc(String errorDesc) {
        return new ErrorCode(this.errorCode, this.errorMsg, errorDesc);
    }

    public ErrorCode() {
    }

    public String toString() {
        return "ErrorCode{errorCode='" + this.errorCode + "', errorMsg='" + this.errorMsg + "', errorDesc='" + this.errorDesc + "'}";
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            ErrorCode error = (ErrorCode)o;
            return this.errorCode.equals(error.errorCode) && this.errorMsg.equals(error.errorMsg);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.errorCode.hashCode();
        result = 31 * result + this.errorMsg.hashCode();
        return result;
    }

    public static ErrorCode of(String errorCode, String errorMsg) {
        return new ErrorCode(errorCode, errorMsg);
    }
}

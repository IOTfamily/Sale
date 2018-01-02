package com.iot.sale.Base.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iot.sale.Base.config.BaseErrorCode;
import com.iot.sale.Base.exception.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.collections.map.HashedMap;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(
        value = "ApiResponse",
        description = "api响应体"
)
public class ApiResponse implements Serializable {
    @ApiModelProperty("返回数据对象")
    private Map<String, Object> data;
    @ApiModelProperty(
            value = "错误码",
            required = true
    )
    private String code;
    @ApiModelProperty(
            value = "错误原因",
            required = true
    )
    private String msg;
    @ApiModelProperty("误原因详细描述")
    private String desc;
    @ApiModelProperty(
            value = "处理时间",
            required = true
    )
    private Long time;

    public void setErrorCode(ErrorCode errorCode) {
        this.code = errorCode.getErrorCode();
        this.msg = errorCode.getErrorMsg();
    }

    public void put(String key, Object value) {
        this.data.put(key, value);
    }

    public ApiResponse() {
        this.data = new HashedMap();
        this.time = Long.valueOf((new Date()).getTime());
    }

    public ApiResponse(ErrorCode error) {
        this(error.getErrorCode(), error.getErrorMsg());
    }

    public ApiResponse(String code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    public ApiResponse(String code, String msg, String desc) {
        this();
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public static ApiResponse buildFail(String code, String msg, String desc) {
        return new ApiResponse(code, msg, desc);
    }

    public static ApiResponse buildFail(ErrorCode error) {
        return buildFail(error.getErrorCode(), error.getErrorMsg(), error.getErrorDesc());
    }

    public static ApiResponse buildFail() {
        return new ApiResponse(BaseErrorCode.ERR_SYSTEM_ERROR);
    }

    public static ApiResponse buildSuccess() {
        return new ApiResponse(BaseErrorCode.SUCCESS);
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getDesc() {
        return this.desc;
    }

    public Long getTime() {
        return this.time;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof ApiResponse)) {
            return false;
        } else {
            ApiResponse other = (ApiResponse)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$data = this.getData();
                    Object other$data = other.getData();
                    if(this$data == null) {
                        if(other$data == null) {
                            break label71;
                        }
                    } else if(this$data.equals(other$data)) {
                        break label71;
                    }

                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if(this$code == null) {
                    if(other$code != null) {
                        return false;
                    }
                } else if(!this$code.equals(other$code)) {
                    return false;
                }

                label57: {
                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if(this$msg == null) {
                        if(other$msg == null) {
                            break label57;
                        }
                    } else if(this$msg.equals(other$msg)) {
                        break label57;
                    }

                    return false;
                }

                Object this$desc = this.getDesc();
                Object other$desc = other.getDesc();
                if(this$desc == null) {
                    if(other$desc != null) {
                        return false;
                    }
                } else if(!this$desc.equals(other$desc)) {
                    return false;
                }

                Object this$time = this.getTime();
                Object other$time = other.getTime();
                if(this$time == null) {
                    if(other$time == null) {
                        return true;
                    }
                } else if(this$time.equals(other$time)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null?43:$code.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null?43:$msg.hashCode());
        Object $desc = this.getDesc();
        result = result * 59 + ($desc == null?43:$desc.hashCode());
        Object $time = this.getTime();
        result = result * 59 + ($time == null?43:$time.hashCode());
        return result;
    }

    public String toString() {
        return "ApiResponse(data=" + this.getData() + ", code=" + this.getCode() + ", msg=" + this.getMsg() + ", desc=" + this.getDesc() + ", time=" + this.getTime() + ")";
    }
}

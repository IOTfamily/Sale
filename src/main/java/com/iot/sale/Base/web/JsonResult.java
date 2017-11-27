package com.iot.sale.Base.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.iot.sale.Base.config.ErrorCodeConfig;
import org.apache.commons.collections.map.HashedMap;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class JsonResult implements Serializable {

    private Map<String, Object> data;

    private String code;

    private String msg;

    private String desc;

    private Long time;

    public JsonResult() {
        data = new HashedMap();
        time = new Date().getTime();
    }

    public Map<?, ?> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        if (ErrorCodeConfig.hasErrorCode(code)) {
            this.msg = ErrorCodeConfig.getErrorMsg(code);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDesc() { return desc; }

    public void setDesc(String desc) { this.desc = desc; }

    public void put(String key, Object value) {
        data.put(key, value);
    }
}
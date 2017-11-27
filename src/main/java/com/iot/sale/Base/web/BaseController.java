package com.iot.sale.Base.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.iot.sale.Base.config.ErrorCodeConfig;
import com.iot.sale.Base.exception.ParamValidException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/******************************************
 * @author: 颜回
 * @createDate: 16/6/21
 * @company: (C) Copyright 2016
 * @since: JDK 1.8
 * @Description:控制器基类
 ******************************************/
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * controller异常处理
     */
    public void handleException(Exception ex, JsonResult result) {
        if (ex instanceof BusinessException) {
            BusinessException e = (BusinessException) ex;
            if (ErrorCodeConfig.hasErrorCode(e.getCode())) {
                result.setCode(e.getCode());
                if (StringUtils.isNotBlank(e.getContent())) {
                    result.setMsg(e.getContent());
                }
            } else {
                result.setCode(e.getCode());
                result.setMsg(e.getContent());
            }
        } else if (ex instanceof ParamValidException) {
            result.setCode(ErrorCodeConfig.ERR_CHECK_PARAMS);
            result.setMsg(ex.getMessage());
        } else {
            if ((ex instanceof JsonParseException) || ex instanceof IOException) {
                result.setCode(ErrorCodeConfig.ERR_SYSTEM_JSON);
            } else if (ex instanceof NullPointerException) {
                result.setCode(ErrorCodeConfig.ERR_SYSTEM_NULLPOINT);
            } else {
                result.setCode(ErrorCodeConfig.ERR_SYSTEM);
            }
            result.setMsg(ex.getMessage());
        }

        logger.error(ex.getMessage(), ex);
    }


    /**
     * 创建默认成功返回json对象
     *
     * @return
     */
    public JsonResult createSuccessResult() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(ErrorCodeConfig.OK);
        return jsonResult;
    }

    private String errors;

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}

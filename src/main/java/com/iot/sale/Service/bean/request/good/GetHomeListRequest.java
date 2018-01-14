package com.iot.sale.Service.bean.request.good;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by luxiaolin on 18/1/14.
 */
@Data
@ApiModel(value = "GetHomeListRequest", description = "首页列表")
public class GetHomeListRequest implements Serializable {
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @ApiModelProperty(value = "分页查询的页码", example = "1", required = true)
    @JsonProperty("pageNum")
    public Integer pageNum;
}

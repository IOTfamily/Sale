package com.iot.sale.Service.bean.response.good;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.sale.Base.dao.annotation.Column;
import com.iot.sale.Service.bean.vo.Album;
import com.iot.sale.Service.bean.vo.GoodInfoSimple;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luxiaolin on 18/1/14.
 */
@Data
@ApiModel(value = "GetGoodList", description = "商品详情")
public class GetHomeListResponse implements Serializable{
    public List<GoodInfoSimple> getList() {
        return list;
    }

    public void setList(List<GoodInfoSimple> list) {
        this.list = list;
    }


    @ApiModelProperty(value = "列表")
    @Column(name = "list")

    @JsonProperty("list")
    private List<GoodInfoSimple> list;

    public Boolean getHasNext() {
        return isHasNext;
    }

    public void setHasNext(Boolean hasNext) {
        isHasNext = hasNext;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @ApiModelProperty(value = "是否下页数据")
    @Column(name = "isHasNext")
    @JsonProperty("isHasNext")
    private Boolean isHasNext;

    @ApiModelProperty(value = "当前查询的页码")
    @Column(name = "pageNum")
    @JsonProperty("pageNum")
    private int pageNum;


}

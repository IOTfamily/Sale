package com.iot.sale.Service.bean.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.sale.Base.dao.annotation.Column;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by luxiaolin on 18/1/14.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "GoodInfoSimple", description = "图片资源")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodInfoSimple implements Serializable{

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    @ApiModelProperty(value = "自增主键")
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;


    @ApiModelProperty(value = "价格")
    @Column(name = "price")
    @JsonProperty("price")
    private Integer price;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @ApiModelProperty(value = "首图")
    @Column(name = "show")
    @JsonProperty("show")
    private String show;

}

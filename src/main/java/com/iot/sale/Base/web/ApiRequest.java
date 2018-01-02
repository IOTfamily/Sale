package com.iot.sale.Base.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2018/1/2
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(
        value = "ApiRequest",
        description = "api请求体"
)
public class ApiRequest<T> implements Serializable {
    @ApiModelProperty("应用名称")
    private String app;
    @ApiModelProperty("接口名称")
    private String api;
    @ApiModelProperty("接口版本")
    private String v = "1";
    @ApiModelProperty("接口签名")
    private String sig;
    @ApiModelProperty("请求时间")
    private String t;
    @ApiModelProperty("发起请求的主机名")
    private String clientHost;
    @ApiModelProperty(
            value = "发起请求客户端类型",
            example = "java, node"
    )
    private String clientType;
    @ApiModelProperty("发起请求的客户端版本")
    private String clientVersion = "1";
    @Valid
    @NotNull
    @ApiModelProperty(
            value = "请求参数",
            required = true
    )
    protected T data;
    private static final String DEFAULT_VERSION = "1";

    public static <T> ApiRequest<T> build(T data) {
        ApiRequest<T> request = new ApiRequest();
        request.setData(data);
        return request;
    }

    public ApiRequest() {
    }

    public String getApp() {
        return this.app;
    }

    public String getApi() {
        return this.api;
    }

    public String getV() {
        return this.v;
    }

    public String getSig() {
        return this.sig;
    }

    public String getT() {
        return this.t;
    }

    public String getClientHost() {
        return this.clientHost;
    }

    public String getClientType() {
        return this.clientType;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public T getData() {
        return this.data;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setV(String v) {
        this.v = v;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public void setT(String t) {
        this.t = t;
    }

    public void setClientHost(String clientHost) {
        this.clientHost = clientHost;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof ApiRequest)) {
            return false;
        } else {
            ApiRequest<?> other = (ApiRequest)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label119: {
                    Object this$app = this.getApp();
                    Object other$app = other.getApp();
                    if(this$app == null) {
                        if(other$app == null) {
                            break label119;
                        }
                    } else if(this$app.equals(other$app)) {
                        break label119;
                    }

                    return false;
                }

                Object this$api = this.getApi();
                Object other$api = other.getApi();
                if(this$api == null) {
                    if(other$api != null) {
                        return false;
                    }
                } else if(!this$api.equals(other$api)) {
                    return false;
                }

                label105: {
                    Object this$v = this.getV();
                    Object other$v = other.getV();
                    if(this$v == null) {
                        if(other$v == null) {
                            break label105;
                        }
                    } else if(this$v.equals(other$v)) {
                        break label105;
                    }

                    return false;
                }

                Object this$sig = this.getSig();
                Object other$sig = other.getSig();
                if(this$sig == null) {
                    if(other$sig != null) {
                        return false;
                    }
                } else if(!this$sig.equals(other$sig)) {
                    return false;
                }

                label91: {
                    Object this$t = this.getT();
                    Object other$t = other.getT();
                    if(this$t == null) {
                        if(other$t == null) {
                            break label91;
                        }
                    } else if(this$t.equals(other$t)) {
                        break label91;
                    }

                    return false;
                }

                Object this$clientHost = this.getClientHost();
                Object other$clientHost = other.getClientHost();
                if(this$clientHost == null) {
                    if(other$clientHost != null) {
                        return false;
                    }
                } else if(!this$clientHost.equals(other$clientHost)) {
                    return false;
                }

                label77: {
                    Object this$clientType = this.getClientType();
                    Object other$clientType = other.getClientType();
                    if(this$clientType == null) {
                        if(other$clientType == null) {
                            break label77;
                        }
                    } else if(this$clientType.equals(other$clientType)) {
                        break label77;
                    }

                    return false;
                }

                label70: {
                    Object this$clientVersion = this.getClientVersion();
                    Object other$clientVersion = other.getClientVersion();
                    if(this$clientVersion == null) {
                        if(other$clientVersion == null) {
                            break label70;
                        }
                    } else if(this$clientVersion.equals(other$clientVersion)) {
                        break label70;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if(this$data == null) {
                    if(other$data != null) {
                        return false;
                    }
                } else if(!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiRequest;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $app = this.getApp();
        result = result * 59 + ($app == null ? 43 : $app.hashCode());
        Object $api = this.getApi();
        result = result * 59 + ($api == null?43:$api.hashCode());
        Object $v = this.getV();
        result = result * 59 + ($v == null?43:$v.hashCode());
        Object $sig = this.getSig();
        result = result * 59 + ($sig == null?43:$sig.hashCode());
        Object $t = this.getT();
        result = result * 59 + ($t == null?43:$t.hashCode());
        Object $clientHost = this.getClientHost();
        result = result * 59 + ($clientHost == null?43:$clientHost.hashCode());
        Object $clientType = this.getClientType();
        result = result * 59 + ($clientType == null?43:$clientType.hashCode());
        Object $clientVersion = this.getClientVersion();
        result = result * 59 + ($clientVersion == null?43:$clientVersion.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null?43:$data.hashCode());
        return result;
    }

    public String toString() {
        return "ApiRequest(app=" + this.getApp() + ", api=" + this.getApi() + ", v=" + this.getV() + ", sig=" + this.getSig() + ", t=" + this.getT() + ", clientHost=" + this.getClientHost() + ", clientType=" + this.getClientType() + ", clientVersion=" + this.getClientVersion() + ", data=" + this.getData() + ")";
    }
}
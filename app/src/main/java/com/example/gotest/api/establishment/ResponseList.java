package com.example.gotest.api.establishment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseList {

    @SerializedName("return")
    @Expose
    private Boolean _return;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private List<Establishment> data = null;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Boolean getReturn() {
        return _return;
    }

    public void setReturn(Boolean _return) {
        this._return = _return;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Establishment> getData() {
        return data;
    }

    public void setData(List<Establishment> data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

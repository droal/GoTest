package com.example.gotest.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUser {

    @SerializedName("return")
    @Expose
    private Boolean _return;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private UserData data;
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

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

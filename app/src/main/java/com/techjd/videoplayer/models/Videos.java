package com.techjd.videoplayer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Videos {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("msg")
    @Expose
    private List<Msg> msg = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Msg> getMsg() {
        return msg;
    }

    public void setMsg(List<Msg> msg) {
        this.msg = msg;
    }

}

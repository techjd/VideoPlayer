package com.techjd.videoplayer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BodyCredentials {
    @SerializedName("fb_id")
    @Expose
    private String fbId;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("device_id")
    @Expose
    private String deviceId;

    public BodyCredentials(String fbId, String token, String type, String page, String deviceId) {
        this.fbId = fbId;
        this.token = token;
        this.type = type;
        this.page = page;
        this.deviceId = deviceId;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}

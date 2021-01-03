package com.techjd.videoplayer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioPath {
    @SerializedName("mp3")
    @Expose
    private String mp3;
    @SerializedName("acc")
    @Expose
    private String acc;

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
}

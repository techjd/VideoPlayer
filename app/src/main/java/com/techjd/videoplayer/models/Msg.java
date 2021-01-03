package com.techjd.videoplayer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Msg {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fb_id")
    @Expose
    private String fbId;
    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;
    @SerializedName("count")
    @Expose
    private Count count;
    @SerializedName("liked")
    @Expose
    private String liked;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("thum")
    @Expose
    private String thum;
    @SerializedName("gif")
    @Expose
    private String gif;
    @SerializedName("is_block")
    @Expose
    private String isBlock;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("sound")
    @Expose
    private Sound sound;
    @SerializedName("created")
    @Expose
    private String created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getThum() {
        return thum;
    }

    public void setThum(String thum) {
        this.thum = thum;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public String getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(String isBlock) {
        this.isBlock = isBlock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}

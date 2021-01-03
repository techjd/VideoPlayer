package com.techjd.videoplayer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sound {
    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("audio_path")
    @Expose
    private AudioPath audioPath;
    @SerializedName("sound_name")
    @Expose
    private Object soundName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("thum")
    @Expose
    private Object thum;
    @SerializedName("section")
    @Expose
    private Object section;
    @SerializedName("created")
    @Expose
    private Object created;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public AudioPath getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(AudioPath audioPath) {
        this.audioPath = audioPath;
    }

    public Object getSoundName() {
        return soundName;
    }

    public void setSoundName(Object soundName) {
        this.soundName = soundName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getThum() {
        return thum;
    }

    public void setThum(Object thum) {
        this.thum = thum;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
        this.created = created;
    }
}

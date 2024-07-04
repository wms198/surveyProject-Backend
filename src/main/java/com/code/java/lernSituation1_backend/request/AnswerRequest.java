package com.code.java.lernSituation1_backend.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerRequest {
    @JsonProperty("option")
    private int option_id;
    @JsonProperty("user")
    private String subject_identifier;
    private int duration;

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }

    public String getSubject_identifier() {
        return subject_identifier;
    }

    public void setSubject_id(String subject_id) {
        this.subject_identifier = subject_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

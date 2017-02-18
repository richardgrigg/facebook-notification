package com.wrigglegriggle.domain;

import com.wrigglegriggle.infrastructure.web.UrlEncodedStringDeserializer;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class FacebookAppRequest {

    private Long id;
    private FacebookApplicationObject facebookApplicationObject;
    private String message;
    private String createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("application")
    public FacebookApplicationObject getFacebookApplicationObject() {
        return facebookApplicationObject;
    }

    @JsonProperty("application")
    public void setFacebookApplicationObject(FacebookApplicationObject facebookApplicationObject) {
        this.facebookApplicationObject = facebookApplicationObject;
    }

    public String getMessage() {
        return message;
    }

    @JsonDeserialize(using=UrlEncodedStringDeserializer.class)
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}

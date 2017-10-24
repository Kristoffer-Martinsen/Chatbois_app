package com.example.kristoffer.chatbois_app;

/**
 * Created by Kristoffer on 22.10.2017.
 */

public class Conversation {
    String id;
    String version;

    public void setId(String id) {
        this.id = id;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public String getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }
}

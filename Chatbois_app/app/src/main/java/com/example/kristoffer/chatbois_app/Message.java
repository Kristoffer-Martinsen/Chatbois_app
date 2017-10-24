package com.example.kristoffer.chatbois_app;

/**
 * Created by Kristoffer on 22.10.2017.
 */

public class Message {
    String name;
    String text;
    String timeStamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}

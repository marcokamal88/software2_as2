package com.example.demo.model;

import com.example.demo.service.NotificationChannel;
import com.example.demo.service.NotificationTemplate;


public class Notification {
    String to;
    String subject;
    String text;

    // constructor
    public Notification(String to, String subject){
        this.to = to;
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }
    NotificationChannel channel;

    public void send(){
        channel.sendNotification(to, subject, text);
    }


    public void setText(String text) {
        this.text = text;
    }
}

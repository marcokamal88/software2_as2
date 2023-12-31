package com.example.demo.model;

import com.example.demo.service.NotificationChannel;
import com.example.demo.service.NotificationTemplate;


public class Notification {
    String to;
    String subject;
    String text;

    NotificationChannel channel;

    public void send(){
        channel.sendNotification(to, subject, text);
    }
}

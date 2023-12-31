package com.example.demo.service;

public class SmsChannel implements NotificationChannel{

    @Override
    public String sendNotification(String to, NotificationTemplate template) {

        return "Sms sent";
    }
}

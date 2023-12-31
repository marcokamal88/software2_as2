package com.example.demo.service;

import javax.security.auth.Subject;

public interface NotificationChannel {
    String sendNotification(String to, String Subject , String text);
}

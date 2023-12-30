package com.example.demo.service;

import com.example.demo.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

@Service
public class NotificationsImpl implements Notifications {
    @Autowired
    private JavaMailSender mailsender;
    @Value("$(spring.mail.username)")
    private String fromMail;

    @Override
    public String sendNotification(String mail, Mail mailStructure) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(fromMail);
            mailMessage.setSubject("mailStructure.getSubject()");
            mailMessage.setText("mailStructure.getMessage()");
            mailMessage.setTo(mail);
            mailsender.send(mailMessage);
            return "Mail sent successfully";
        } catch (Exception e) {
            return "Failed to send mail. Error: " + e.getMessage();
        }

    }
}

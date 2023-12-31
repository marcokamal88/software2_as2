package com.example.demo.service;


import org.springframework.mail.SimpleMailMessage;

public class EmailChannel implements NotificationChannel {
    private JavaMailSender mailsender;

    public EmailChannel(JavaMailSender mailsender) {
        this.mailsender = mailsender;
    }

    @Override
    public String sendNotification(String to, String Subject, String text) {
        
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("From Samer");
            mailMessage.setSubject(Subject);
            mailMessage.setText(text);
            mailMessage.setTo(to);
            mailsender.send(mailMessage);
            return "Mail sent successfully";
        } catch (Exception e) {
            return "Failed to send mail. Error: " + e.getMessage();
        }
    }
}


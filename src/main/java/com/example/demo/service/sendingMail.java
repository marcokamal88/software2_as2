package com.example.demo.service;

import com.example.demo.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

@Service
public class sendingMail implements Notifications {
    private String mail;
    private Mail mailStructure;
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail=mail;
    }
    public void setmailStructure(Mail mailStructure) {
        this.mailStructure=mailStructure;
    }   
    public Mail getMailStructure() {
        return mailStructure;
    }
    @Autowired
    private JavaMailSender mailsender;
    @Value("$(spring.mail.username)")
    private String fromMail;

    @Override
    public String sendNotification( ) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(fromMail);
            mailMessage.setSubject("supject");
            mailMessage.setText("this is text of massage");
            mailMessage.setTo(getMail());
            mailsender.send(mailMessage);
            return "Mail sent successfully";
        } catch (Exception e) {
            return "Failed to send mail. Error: " + e.getMessage();
        }

    }
}

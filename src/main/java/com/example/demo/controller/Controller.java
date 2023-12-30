package com.example.demo.controller;

import com.example.demo.service.sendingMail;
import com.example.demo.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/mail", method = {RequestMethod.GET, RequestMethod.POST})
public class Controller {
    @Autowired
    private sendingMail mailService;

    @PostMapping("/sendmail/{mail}")
    public String sendMail(@PathVariable String mail, @RequestBody Mail mailstructure) {
        mailService.setMail(mail);
        mailService.setmailStructure(mailstructure);
        return mailService.sendNotification();
    }
    @GetMapping("path")
    public String getMethodName() {
        return "new SomeData()";
    }
    
} 
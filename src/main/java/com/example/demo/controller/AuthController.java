package com.example.demo.controller;

import com.example.demo.model.LoginForm;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService auth_service;

    @PostMapping(value="/login")
    public User login(@RequestBody LoginForm formData){
        return auth_service.get_user(formData);
    }

    @PostMapping(value="/register")
    public User register(@RequestBody User formData){
        return auth_service.add_user(formData);
    }
}

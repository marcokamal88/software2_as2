package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {


    @PostMapping(value = "/order/create")
    public String createOrder(){
        return "hhhh";
    }


}

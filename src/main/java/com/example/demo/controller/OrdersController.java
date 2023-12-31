package com.example.demo.controller;

import com.example.demo.model.CreateOrderInput;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    OrdersService orders_service;

    @PostMapping(value = "/order/create")
    public String createOrder(@RequestBody CreateOrderInput input_data){

        orders_service.addOrder(input_data);

        return "hhhh";
    }


}

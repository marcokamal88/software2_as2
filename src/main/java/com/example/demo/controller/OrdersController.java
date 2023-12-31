package com.example.demo.controller;

import com.example.demo.model.CreateOrderInput;
import com.example.demo.model.Order;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {

    @Autowired
    OrdersService orders_service;

    @PostMapping(value = "/orders/create")
    public String createOrder(@RequestBody CreateOrderInput input_data){

        orders_service.addOrder(input_data);

        return "hhhh";
    }


    @GetMapping (value = "/orders/{id}")
    public String getOrder(@PathVariable("id") Integer id){

        Order order = orders_service.getOrder(id);

        if(order != null){
            return order.print();

        }else{
            return "Order Not Found";
        }

    }

}

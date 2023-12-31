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

    // get the order
    @GetMapping (value = "/orders/{id}")
    public String getOrder(@PathVariable("id") Integer id){

        Order order = orders_service.getOrder(id);

        if(order != null){
            return order.print();
        }else{
            return "Order Not Found";
        }

    }
    @PostMapping(value = "/orders/create")
    public String createOrder(@RequestBody CreateOrderInput input){
        Order order = orders_service.addOrder(input);

        if(order != null){
            return order.print();

        }else{
            return "Order Not Created";
        }

    }

    // ship the order
    @PostMapping(value = "/orders/ship/{id}")
    public String shipOrder(@PathVariable("id") Integer id){
        Order order = orders_service.shipOrder(id);

        if(order != null){
            return order.print();

        }else{
            return "Order Not Found";
        }

    }




    // cancel the order
    @PostMapping(value = "/orders/cancel/{id}")
    public String cancelOrder(@PathVariable("id") Integer id){
        Order order = orders_service.cancelOrder(id);

        if(order != null){
            return order.print();

        }else{
            return "Order Not Found";
        }

    }
    // cancel the shipping

    @PostMapping(value = "/orders/cancelShipping/{id}")
    public String cancelShipping(@PathVariable("id") Integer id){
        Order order = orders_service.cancelShipping(id);

        if(order != null){
            return order.print();

        }else{
            return "Order Not Found";
        }

    }





}

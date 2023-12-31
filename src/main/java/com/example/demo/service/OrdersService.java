package com.example.demo.service;

import com.example.demo.model.CreateOrderInput;
import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrdersService {

    ArrayList<Order> orders_table = new ArrayList<Order>() {};


    public void addOrder(CreateOrderInput input_data){

    }

}

package com.example.demo.service;

import com.example.demo.model.CreateOrderInput;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrdersService {

    ArrayList<Order> orders_table = new ArrayList<Order>() {
    };

    public void addOrder(CreateOrderInput input_data) {

    }

    public Order getOrder(Integer id) {

        Order order = null;

        for (int i = 0; i < orders_table.size(); i++) {
            Order it_order = orders_table.get(i);

            if (it_order.getId() == id) {
                order = it_order;
            }
        }

        return order;

    }

}

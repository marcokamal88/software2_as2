package com.example.demo.model;

import com.example.demo.service.OrderItem;

import java.util.ArrayList;

public class Order {

    ArrayList<OrderItem> items;

    Order subOrder;

    User user;

    Order(ArrayList<OrderItem> items){
        this.items = items;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }

    public Order getSubOrder() {
        return subOrder;
    }

    public void setSubOrder(Order subOrder) {
        this.subOrder = subOrder;
    }
}

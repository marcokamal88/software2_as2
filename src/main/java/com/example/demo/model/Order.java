package com.example.demo.model;

import com.example.demo.service.OrderItem;

import java.util.ArrayList;

public class Order {

    ArrayList<OrderItem> items;

    Order subOrder;

    User user;

    String status;

    Integer id;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

package com.example.demo.model;

import com.example.demo.service.OrderItem;

import java.util.ArrayList;

public class Order {

    ArrayList<OrderItem> items;

    ArrayList<Order> subOrders;

    User user;

    String status;

    Integer id;

    String shippingAddress;

    Order(ArrayList<OrderItem> items){
        this.items = items;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }


    public ArrayList<Order> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(ArrayList<Order> subOrders) {
        this.subOrders = subOrders;
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

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


    public String print(){

        String result = "Order "+id + ":\n";

        if(items.size() > 0){
            for(int i = 0 ; i < items.size() ; i++){
                result += "Product: " + items.get(i).getProduct().getName() + ", ";
            }
        }

        if(subOrders.size() > 0){
            result += "SubOrders :\n";
            for(int i = 0 ; i < subOrders.size() ; i++){
                result += subOrders.get(i).print() + "\n";
            }
        }

        return result;
    }

}

package com.example.demo.model;

import com.example.demo.service.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    ArrayList<OrderItem> items;

    ArrayList<Order> subOrders;

    User user;

    String status;

    Integer id;

    String shippingAddress;
    private LocalDateTime placedAt;


    public Order(ArrayList<OrderItem> items){
        this.items = items;
        this.placedAt = LocalDateTime.now();
        this.status = "pending";

        // generate unique id
        this.id = (int) (Math.random() * 1000000);
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

        String result = "Order "+id + "\n" + "Status: "+status+"\n" + "Shipping Address: "+shippingAddress+"\n" + "Customer: "+user.getName()+"\n" + "Placed At: "+placedAt+"\n";

        if(items.size() > 0){
            for(int i = 0 ; i < items.size() ; i++){
                result += "Product: " + items.get(i).getProduct().getName() + ", ";
                result += "Quantity: " + items.get(i).getQuantity() + "\n";
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

    public void ship() {
        this.status = "shipped";
        // deduct price from user balance
        if (this.user == null) {
            throw new RuntimeException("User is not set");
        }
        this.user.setBalance(this.user.getBalance() - this.getTotalPrice());
        // if suborders exist, ship them too
        if (this.subOrders != null) {
            for (Order subOrder : this.subOrders) {
                subOrder.ship();
            }
        }
    }

    private double getTotalPrice() {
        double totalPrice = 0;
        for (OrderItem item : this.items) {
            totalPrice += item.getQuantity() * item.getProduct().getPrice();
        }
        return totalPrice;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }
}

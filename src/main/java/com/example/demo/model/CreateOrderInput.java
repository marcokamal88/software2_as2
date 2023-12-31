package com.example.demo.model;


import com.example.demo.service.AuthService;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateOrderInput {
    private ArrayList<OrderItemInput> orderItems;
    private String address;
    private ArrayList<CreateOrderInput> subOrders; // For handling suborders

    public String customerName;

    public ArrayList<OrderItemInput> getOrderItems() {
        return orderItems;
    }

    // get address
    public String getAddress(){
        return address;
    }

    // get suborders
    public ArrayList<CreateOrderInput> getSubOrders(){
        return subOrders;
    }

    // get customer name
    public String getCustomerName(){
        return customerName;
    }
    // print
    public String print(){
        String output = "Order Items: \n";
        for(OrderItemInput item : orderItems){
            output += item.print();
        }
        output += "Address: " + address + "\n";
        output += "Sub Orders: \n";
        if (subOrders != null) {
            for (CreateOrderInput subOrder : subOrders) {
                output += subOrder.print();
            }
        }
        output += "Customer Name: " + customerName + "\n";
        return output;
    }

}


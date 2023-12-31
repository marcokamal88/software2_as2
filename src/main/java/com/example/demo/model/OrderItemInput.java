package com.example.demo.model;

import com.example.demo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItemInput {
    private final ProductsService products_service;

    // constructor
    public OrderItemInput(){
        products_service = new ProductsService();
    }

    private Integer productId;
    private Integer quantity;
    // Other relevant fields

    // Constructors, getters, setters
    // get product id
    public Integer getProductId(){
        return productId;
    }

    // get product object
    public Product getProduct(){
        return products_service.getProduct(this.productId);
    }

    // get quantity
    public Integer getQuantity(){
        return quantity;
    }

    // print
    public String print(){
        String output = "Product Id: " + productId + "\n";
        output += "Quantity: " + quantity + "\n";
        return output;
    }
}

package com.example.demo.service;

import com.example.demo.model.Product;

public class OrderItem {

    Integer quantity;
    Product product;

    OrderItem(Integer q, Product p){
        quantity = q;
        product = p;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

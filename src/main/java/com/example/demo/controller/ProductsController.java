package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductsService products_service;

    @GetMapping(value = "/products")
    public List<Product> getProducts(){
        return products_service.getProducts();
    }

}

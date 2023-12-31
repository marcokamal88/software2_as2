package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductsService {

    ArrayList<Product> products_table = new ArrayList<Product>(){};

    public ProductsService(){

        Product p1 = new Product(1, "11", "p1", "v", "c", 15.0, 5);
        Product p2 = new Product(2, "22", "p2", "v", "c", 20.0, 5);

        products_table.add(p1);
        products_table.add(p2);

    }

    public ArrayList<Product> getProducts(){
        return products_table;
    }

    public Product getProduct(Integer id){
        Product product = null;
        for(int i = 0 ; i < products_table.size() ; i++){
            Product it_product = products_table.get(i);
            if(it_product.getId() == id){
                product = it_product;
            }
        }
        return  product;
    }

}

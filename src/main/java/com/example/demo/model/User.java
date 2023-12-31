package com.example.demo.model;

public class User {

    Integer id;
    Double balance;
    String name, email, password;


    public  User(String n, String e, String p){
        name = n;
        email = e;
        password = p;
    }

    public void setId(Integer i){
        id = i;
    }

    public void setName(String n){
        name = n;
    }
    public void getEmail(String e){
        email = e;
    }
    public void getPassword(String p){
        password = p;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

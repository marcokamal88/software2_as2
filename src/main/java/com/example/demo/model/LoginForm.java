package com.example.demo.model;

public class LoginForm {
    private String email;
    private String password;

    public void setEmail(String e){
        email = e;
    }
    public void setPassword(String p){
        password = p;
    }

    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}

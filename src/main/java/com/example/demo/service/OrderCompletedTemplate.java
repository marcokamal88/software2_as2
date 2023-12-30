package com.example.demo.service;

import java.util.ArrayList;

public class OrderCompletedTemplate implements NotificationTemplate {
    public String getSubject() {
        return " order comfirmed ";
    }

    @Override
    public String getText(ArrayList<String> params) {
        String str ="Dear {x} , your booking of the {y} is confirmed. thanks for using our store :) ";
        str.replaceAll("{x}", params.get(0));
        str.replaceAll("{y}", params.get(1));
        return str;
    }
}

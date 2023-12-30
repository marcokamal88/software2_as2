package com.example.demo.service;

import java.util.ArrayList;

public interface NotificationTemplate {

    public String getSubject();
    public String getText(ArrayList<String> params);
}

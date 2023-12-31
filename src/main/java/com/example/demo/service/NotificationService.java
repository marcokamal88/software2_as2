package com.example.demo.service;

import com.example.demo.model.Notification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationService {

    Queue<Notification> readyList = new LinkedList<>();

    public void start() {
        long delay = 2 * 1000; // delay in milliseconds
        LoopTask task = new LoopTask();
        Timer timer = new Timer("sendingNoti");
        timer.cancel();
        timer = new Timer("sendingNoti");
        Date executionDate = new Date(); // no params = now
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }

    private class LoopTask extends TimerTask {
        public void run() {
            if(readyList.size() > 0){
                Notification front = readyList.remove();
                front.send();
            }
        }
    }

    public NotificationService(){
        start();
    }

    public void addToQueue(Notification newNoti){
        readyList.add(newNoti);
    }

}

package com.example.demo.service;

import com.example.demo.model.Notification;

import io.micrometer.common.util.StringUtils;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import java.util.*;

@Service
public class NotificationService {

    Queue<Notification> readyList = new LinkedList<>();
    ArrayList<String> recievers = new ArrayList<>();
    ArrayList<String> Templates=new ArrayList<>();

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
            if (readyList.size() > 0) {
                Notification front = readyList.remove();
                // front.send();
            }
        }
    }

    public NotificationService() {
        start();
    }

    public void addToQueue(Notification newNoti,OrderCompletedTemplate template) {
        readyList.add(newNoti);
        recievers.add(newNoti.getTo());
        Templates.add(template.getTemplateName());
        
    }

    public String GetMostNotified() {

        int n = recievers.size();
        int max_count = 0;
        String maxfreq = "";

        // Logic implementation
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (recievers.get(i) == recievers.get(j)) {
                    count++;
                }
            }

            if (count > max_count) {
                max_count = count;
                maxfreq = recievers.get(i);
            }
        }
        return maxfreq;
    }

    public String GetMostTemplate() {
        int n = Templates.size();
        int max_count = 0;
        String maxfreq = "";

        // Logic implementation
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (Templates.get(i) == Templates.get(j)) {
                    count++;
                }
            }

            if (count > max_count) {
                max_count = count;
                maxfreq = Templates.get(i);
            }
        }
        return maxfreq;
    }
}

package com.example.demo.model;

public class Mail {
    private String subject;
    private String message;

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public void setSubject(String subj) {
        this.subject = subj;
    }
}

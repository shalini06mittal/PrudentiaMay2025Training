package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScannerMessageProvider implements IMessageProvider{

    @Value("some message")
    String message;

    public ScannerMessageProvider() {
        System.out.println("SMP default constructor");
    }

    public String getMessage() {
        return message;
    }
    @Value("this is from scanner")
    public void setMessage( String message) {
        this.message = message;
    }
}

package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StringMessageProvider implements IMessageProvider {

    @Value("some message")
    String message;

    public StringMessageProvider() {
        System.out.println("SMP default constructor");
    }

    public String getMessage() {
        return message;
    }
    @Value("this is from setter")
    public void setMessage( String message) {
        this.message = message;
    }
}

package com.boot.demo.springbootdemo.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DefaultEntity implements EnvProfile{

    @Value("${message}")
    private String message;

    public String getMessage(){
        return message;
    }

}

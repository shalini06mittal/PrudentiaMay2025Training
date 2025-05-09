package com.boot.demo.springbootdemo.profile;

import org.springframework.beans.factory.annotation.Value;

public class ProdEntity implements EnvProfile{

    @Value("${message}")
    private String message;

    public String getMessage(){
        return message;
    }

}

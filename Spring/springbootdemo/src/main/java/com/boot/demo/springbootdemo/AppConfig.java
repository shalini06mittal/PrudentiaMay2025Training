package com.boot.demo.springbootdemo;


import com.boot.demo.springbootdemo.profile.DefaultEntity;
import com.boot.demo.springbootdemo.profile.DevEntity;
import com.boot.demo.springbootdemo.profile.ProdEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public DevEntity devEntity(){
        System.out.println("development");
        return new DevEntity();
    }
    @Bean
    @Profile("production")
    public ProdEntity prodEntity(){
        System.out.println("production");
        return new ProdEntity();
    }
    @Bean
    @Profile("default")
    public DefaultEntity defaultEntity(){
        System.out.println("default");
        return new DefaultEntity();
    }
}

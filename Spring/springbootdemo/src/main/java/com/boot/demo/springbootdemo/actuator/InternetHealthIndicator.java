package com.boot.demo.springbootdemo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;

@Component
public class InternetHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        Health health = null;
        health = check()==true?Health.up().withDetail("success", "active internet").build():Health.down().withDetail("success", "internet down").build();
        return health;
    }
    private boolean check()
    {
        boolean flag = false;
        try {
            URL url = new URL("http://www.google.com");
            URLConnection con = url.openConnection();
            con.connect();
            flag = true;
        }catch(Exception e )
        {
            return flag;
        }
        return flag;
    }

}

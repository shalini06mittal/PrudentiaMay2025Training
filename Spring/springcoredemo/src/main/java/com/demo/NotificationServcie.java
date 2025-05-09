package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.management.ImmutableDescriptor;

@Component
public class NotificationServcie {

    @Autowired
    @Qualifier("stringMessageProvider")
    private IMessageProvider provider;

    @Autowired
    Payment payment;

    public NotificationServcie() {
    }

    public NotificationServcie(IMessageProvider messageProvider)
    {
        System.out.println("Notification service object created");
    }
    public IMessageProvider getStringMessageProvider() {
        return provider;
    }


    public void sendMessage()
    {
        System.out.println(provider.getMessage());
    }
}

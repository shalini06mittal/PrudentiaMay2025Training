package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        StringMessageProvider messageProvider = context.getBean(StringMessageProvider.class);
        NotificationServcie notificationServcie = context.getBean(NotificationServcie.class);
        System.out.println(notificationServcie.getStringMessageProvider());
        notificationServcie.sendMessage();
    }
    @Bean
    public Payment getPaymentBean(){
        return new Payment();
    }
}

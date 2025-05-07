package com.boot.demo.springbootdemo.xtra.telecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {

    @Id
    private String id;
    private String planName;
    private int validity;
    private double price;
    private double dataLimit;
    private int voiceLimit;
    private int smsLimit;

    // Getters and Setters
}

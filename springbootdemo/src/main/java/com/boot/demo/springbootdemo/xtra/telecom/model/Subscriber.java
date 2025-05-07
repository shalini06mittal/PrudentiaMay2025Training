package com.boot.demo.springbootdemo.xtra.telecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscribers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {

    @Id
    private String id;
    private String name;
    private String mobileNumber;
    private String email;
    private String status;
    private String planId;

    // Getters and Setters
}

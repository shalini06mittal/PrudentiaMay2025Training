package com.boot.demo.springbootdemo.xtra.telecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "usages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usage {


    @Id
    private String id;
    private String subscriberId;
    private double dataUsed;
    private int voiceMinutesUsed;
    private int smsUsed;
    private LocalDate date;

    // Getters and Setters
}

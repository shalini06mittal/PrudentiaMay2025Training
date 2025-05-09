package com.boot.demo.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "fictional_character")
public class FictionalCharacter {

    @Id
    private int id;
    private String name;
    private String house;
    private Wand wand;
    private String bio;
    private String imageurl;



}

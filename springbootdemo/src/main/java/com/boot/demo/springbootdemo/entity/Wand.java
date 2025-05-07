package com.boot.demo.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wand {
    @Id
    private int id;
    private String wood;
    private String core;
    private String length;


}


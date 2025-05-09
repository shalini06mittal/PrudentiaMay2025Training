package com.boot.demo.springbootdemo.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    /**
     * In Spring Boot applications using Spring Data MongoDB, the mapping of the id field in your Java entity
     * to the _id field in MongoDB documents is handled automatically by default.
     * Spring Data MongoDB recognizes fields named id (or annotated with @Id) and maps them to the _id field in MongoDB.
     *
     * If you prefer to explicitly define the mapping or use a different name for your identifier field in the Java entity,
     * you can use the @Field annotation from org.springframework.data.mongodb.core.mapping
     */
    @Id
    @Field("_id")
    @NotNull(message = "Id must not be empty")
    private int bookid;
    @NotNull(message = "Title must not be empty")
    private String title;
    private String author;
    private String desc;
    @Positive(message = "Price must be positive")
    private double price;


}

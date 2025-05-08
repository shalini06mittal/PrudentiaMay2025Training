package com.boot.demo.springbootdemo.repo;

import com.boot.demo.springbootdemo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepo extends MongoRepository<Book, Integer> {

    List<Book> findByAuthor(String author);

    @Query("{price : {$gt: ?0}}")                                 // SQL Equivalent : SELECT * FROM BOOK where price<?
        //@Query("{ price : { $gte: ?0 } }")                        // SQL Equivalent : SELECT * FROM BOOK where price>=?
        //@Query("{ price : ?0 }")                                      // SQL Equivalent : SELECT * FROM BOOK where price=?
    List<Book> getBooksByPrice(Integer price);


}

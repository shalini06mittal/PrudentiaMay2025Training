package com.boot.demo.springbootdemo.repo;

import com.boot.demo.springbootdemo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepo extends MongoRepository<Book, Integer> {

    List<Book> findByAuthor(String author);
    //public List<Book> findByPrice(double price);
}

package com.boot.demo.springbootdemo.repo;


import com.boot.demo.springbootdemo.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer,Integer> {
}

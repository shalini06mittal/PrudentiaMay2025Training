package com.security.demo.SpringSecurityDemoLatest.repository;

import com.security.demo.SpringSecurityDemoLatest.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}

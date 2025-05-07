package com.boot.demo.springbootdemo.repo;


import com.boot.demo.springbootdemo.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InvoiceRepo extends MongoRepository<Invoice,Integer> {
    public List<Invoice> findAllByCustomerId(int id);
}

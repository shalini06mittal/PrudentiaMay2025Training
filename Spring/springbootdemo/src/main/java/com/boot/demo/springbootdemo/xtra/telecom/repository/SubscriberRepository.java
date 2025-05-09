package com.boot.demo.springbootdemo.xtra.telecom.repository;

import com.boot.demo.springbootdemo.xtra.telecom.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
    List<Subscriber> findByStatus(String status);
    List<Subscriber> findByPlanId(String planId);
}

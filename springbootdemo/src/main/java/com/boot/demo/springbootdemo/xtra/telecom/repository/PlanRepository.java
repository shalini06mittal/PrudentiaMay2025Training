package com.boot.demo.springbootdemo.xtra.telecom.repository;

import com.boot.demo.springbootdemo.xtra.telecom.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends MongoRepository<Plan, String> {
    Plan findByPlanName(String planName);
}

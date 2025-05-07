package com.boot.demo.springbootdemo.xtra.telecom.service;

import com.boot.demo.springbootdemo.xtra.telecom.model.Plan;
import com.boot.demo.springbootdemo.xtra.telecom.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Optional<Plan> getPlanById(String id) {
        return planRepository.findById(id);
    }

    public void deletePlan(String id) {
        planRepository.deleteById(id);
    }
}

package com.boot.demo.springbootdemo.service;


import com.boot.demo.springbootdemo.entity.Customer;
import com.boot.demo.springbootdemo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer getCustomerById(int id){
        return customerRepo.findById(id)
                .orElseThrow(()->  new RuntimeException("customer with "+id+" does not exists"));
    }
    public Customer insertCustomer(Customer customer){
        if(customerRepo.existsById(customer.getId()))
            throw new RuntimeException("Cannot add "+customer.getId()+" already exists");

        return customerRepo.save(customer);
    }


}

package com.boot.demo.springbootdemo.rest;



import com.boot.demo.springbootdemo.entity.Customer;
import com.boot.demo.springbootdemo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*",methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;


    @PostMapping()
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
        try{
            Customer ob = customerService.insertCustomer(customer);
            return ResponseEntity.ok(ob);
        }catch (RuntimeException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }

}

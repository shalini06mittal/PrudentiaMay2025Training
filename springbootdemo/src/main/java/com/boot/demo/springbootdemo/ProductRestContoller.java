package com.boot.demo.springbootdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductRestContoller {

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductBYId(@PathVariable  int id)
    {
        // database code to search for product by id
        Product product = null;

        if(id==1){
            return  ResponseEntity.ok().body(new Product(1,"Laptop")) ;
        }
        return ResponseEntity.badRequest().body("Product not found");

    }
}

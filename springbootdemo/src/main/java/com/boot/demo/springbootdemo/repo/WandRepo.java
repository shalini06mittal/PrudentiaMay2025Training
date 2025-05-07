package com.boot.demo.springbootdemo.repo;


import com.boot.demo.springbootdemo.entity.Wand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WandRepo extends MongoRepository<Wand, Integer>
{
}

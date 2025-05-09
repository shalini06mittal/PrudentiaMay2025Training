package com.boot.demo.springbootdemo.repo;

import com.boot.demo.springbootdemo.entity.FictionalCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepo extends MongoRepository<FictionalCharacter,Integer >
 {

    public List<FictionalCharacter> findAllByHouse(String house);
    public FictionalCharacter findByName(String name);
    public boolean existsByName(String name);
}

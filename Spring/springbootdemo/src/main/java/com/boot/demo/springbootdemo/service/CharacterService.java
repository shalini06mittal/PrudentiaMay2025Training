package com.boot.demo.springbootdemo.service;



import com.boot.demo.springbootdemo.entity.FictionalCharacter;
import com.boot.demo.springbootdemo.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepo characterRepo;

    public long getCount(){
        return this.characterRepo.count();
    }

    public List<FictionalCharacter> getCharacterByHouse(String house){
        return characterRepo.findAllByHouse(house);
    }
    public List<FictionalCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }

    public FictionalCharacter addNewCharacter(FictionalCharacter character){
        if(characterRepo.existsById(character.getId()))
            throw new RuntimeException("cannot insert "+character.getId()+" already exists");
        return characterRepo.save(character);

    }
    public FictionalCharacter updateCharacter(FictionalCharacter character){
        if(!characterRepo.existsById(character.getId()))
            throw new RuntimeException("cannot update "+character.getName()+" does not exist");
        return characterRepo.save(character);

    }
    public void deleteCharacter(int id){
        if(!characterRepo.existsById(id))
            throw new RuntimeException("cannot delete "+id+" does not exist");
        FictionalCharacter character = characterRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Could not delete character"));
        characterRepo.delete(character);
    }
    public FictionalCharacter getCharacterByName(String name){
        if(!characterRepo.existsByName(name))
            throw new RuntimeException(name+" not found");
        return characterRepo.findByName(name);

    }
    public FictionalCharacter getCharacterById(int id){
        if(!characterRepo.existsById(id))
            throw new RuntimeException(id+" not found");
        return characterRepo.findById(id).get();
    }


}

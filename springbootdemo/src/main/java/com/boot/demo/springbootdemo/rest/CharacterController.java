package com.boot.demo.springbootdemo.rest;


import com.boot.demo.springbootdemo.entity.FictionalCharacter;
import com.boot.demo.springbootdemo.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "*",methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
public class CharacterController {

    Logger logger = LoggerFactory.getLogger(CharacterController.class);
    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<FictionalCharacter> getAllCharacters(@RequestParam(defaultValue = "all") String house){
        logger.info("GET All Characters for house {}", house);
        if(house.equals("all")) {
           List<FictionalCharacter> ob = characterService.getAllCharacters();
           return ob;
        }else{
           List<FictionalCharacter> ob = characterService.getCharacterByHouse(house);
           return ob;
        }
    }
    @PostMapping()
    public ResponseEntity<Object> addCharacter(@RequestBody FictionalCharacter character){
        try{
            FictionalCharacter ob = characterService.addNewCharacter(character);
            return ResponseEntity.ok(ob);
        }catch (RuntimeException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getCharacterById(@PathVariable int id){
        try {
            FictionalCharacter ob = characterService.getCharacterById(id);
            return ResponseEntity.ok(ob);
        }catch (RuntimeException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getCharacterByName(@PathVariable String name){
        try {
            FictionalCharacter ob = characterService.getCharacterByName(name);
            return ResponseEntity.ok(ob);
        }catch (RuntimeException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }
    @PutMapping
    public ResponseEntity<Object> updateCharacter(@RequestBody FictionalCharacter character){
        try {
            FictionalCharacter ob = characterService.updateCharacter(character);
            return ResponseEntity.ok(ob);
        }catch (RuntimeException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCharacter(@PathVariable int id){
        Map<String, String> map = new HashMap<>();
        try {
            characterService.deleteCharacter(id);
            map.put("message", "Delete successful");
            return ResponseEntity.ok(map);
        }catch (RuntimeException e){
            map.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

}

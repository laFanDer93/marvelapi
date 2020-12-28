package com.shamilusoyan.marvel.rest_api.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shamilusoyan.marvel.rest_api.entity.Character;
import com.shamilusoyan.marvel.rest_api.entity.Comic;
import com.shamilusoyan.marvel.rest_api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequestMapping("/v1/public/")
@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @GetMapping("/characters")
    public List<Character> showAllCharacters() {
        List<Character> allCharacter = characterService.getAllCharacter();
        return allCharacter;
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity getCharacter(@PathVariable int id) {
        Character character = characterService.getCharacter(id);
        if(character==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - персонаж с id " + id + " не найден");
        }
        return new ResponseEntity(character,HttpStatus.OK);
    }

    @GetMapping("/characters/{id}/comics")
    public ResponseEntity getComicsOfCharacter(@PathVariable int id) {
        Character character = characterService.getCharacter(id);
        if(character==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - персонаж с id " + id + " не найден");
        }
        List<Comic> comics = character.getComics();
        return new ResponseEntity(comics,HttpStatus.OK);
    }

    @PostMapping("/characters")
    public ResponseEntity addNewCharacter(@RequestBody Character character) {
        if(Character.hasNullField(character)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - неправильно составлен запрос к серверу с помощью метода POST.");
        }
        characterService.saveCharacter(character);
        return new ResponseEntity(character,HttpStatus.OK);
    }
    @PutMapping("/characters")
    public ResponseEntity updateCharacter(@RequestBody Character character) {
        if(Character.hasNullField(character)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - неправильно составлен запрос к серверу с помощью метода PUT.");
        }

        characterService.saveCharacter(character);
        return new ResponseEntity(character,HttpStatus.OK);
    }

}

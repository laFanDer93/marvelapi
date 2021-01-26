package com.shamilusoyan.marvel.api.controller;

import com.shamilusoyan.marvel.api.entity.Character;
import com.shamilusoyan.marvel.api.entity.Comic;
import com.shamilusoyan.marvel.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/public/characters")
@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/")
    public List<Character> showAllCharacters() {
        List<Character> allCharacter = characterService.getAllCharacter();
        return allCharacter;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCharacter(@PathVariable int id) {
        Character character = characterService.getCharacter(id);
        if(character==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - персонаж с id " + id + " не найден");
        }
        return new ResponseEntity(character,HttpStatus.OK);
    }

    @GetMapping("/{id}/comics")
    public ResponseEntity getComicsOfCharacter(@PathVariable int id) {
        Character character = characterService.getCharacter(id);
        if(character==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - персонаж с id " + id + " не найден");
        }
        List<Comic> comics = character.getComics();
        return new ResponseEntity(comics,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addNewCharacter(@RequestBody Character character) {
        if(Character.hasNullField(character)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - неправильно составлен запрос к серверу");
        }
        characterService.saveCharacter(character);
        return new ResponseEntity(character,HttpStatus.OK);
    }

}

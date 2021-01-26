package com.shamilusoyan.marvel.api.controller;

import com.shamilusoyan.marvel.api.entity.Character;
import com.shamilusoyan.marvel.api.entity.Comic;
import com.shamilusoyan.marvel.api.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/public/comics")
@RestController
public class ComicController {

    @Autowired
    private ComicService comicService;

    @GetMapping("/")
    public List<Comic> showAllComics() {
        List<Comic> allComic = comicService.getAllComic();
        return allComic;
    }

    @GetMapping("/{id}")
    public ResponseEntity getComic(@PathVariable int id) {
        Comic comic = comicService.getComic(id);
        if (comic == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - комикса с id " + id + "не существует.");
        }
        return new ResponseEntity(comic, HttpStatus.OK);
    }

    @GetMapping("/{id}/characters")
    public ResponseEntity getCharactersOfComics(@PathVariable int id) {
        Comic comic = comicService.getComic(id);
        if (comic == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - комикса с id " + id + "не существует.");
        }
        List<Character> characters = comic.getCharacters();
        return new ResponseEntity(characters, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addNewComic(@RequestBody Comic comic) {
        if (Comic.hasNullField(comic)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - Неправильно составлен запрос к серверу с помощи метода POST.");
        }
        comicService.saveComic(comic);
        return new ResponseEntity(comic, HttpStatus.OK);
    }


    @PutMapping("/")
    public ResponseEntity updateComic(@RequestBody Comic comic) {
        if (Comic.hasNullField(comic)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - Неправильно составлен запрос к серверу с помощи метода PUT.");
        }
        List<Character> newCharacters = comic.getCharacters();
        Comic newComic = comicService.getComic(comic.getId());

        int count=0;
        for(Character c: newComic.getCharacters()){
            if(newCharacters.contains(c)){
                newCharacters.remove(c);
            }
            count++;
        }

        comic.setCharacters(newCharacters);
        comicService.saveComic(comic);
        return new ResponseEntity(comic, HttpStatus.OK);
    }
}
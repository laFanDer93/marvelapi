package com.shamilusoyan.marvel.api.service;

import com.shamilusoyan.marvel.api.dao.CharacterRepository;
import com.shamilusoyan.marvel.api.entity.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<Character> getAllCharacter() {
        return characterRepository.findAll();
    }

    @Override
    public void saveCharacter(Character character) {
        characterRepository.save(character);
    }

    @Override
    public Character getCharacter(int id) {
        Character character = null;
        Optional<Character> optional = characterRepository.findById(id);
        if (optional.isPresent()) {
            character = optional.get();
        }

        return character;
    }
}


package com.shamilusoyan.marvel.api.service;

import com.shamilusoyan.marvel.api.entity.Character;

import java.util.List;

public interface CharacterService {


     List<Character> getAllCharacter();

     void saveCharacter(Character character);

     Character getCharacter(int id);
}

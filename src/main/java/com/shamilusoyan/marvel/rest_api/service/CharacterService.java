package com.shamilusoyan.marvel.rest_api.service;

import com.shamilusoyan.marvel.rest_api.entity.Character;
import com.shamilusoyan.marvel.rest_api.entity.Comic;

import java.util.List;

public interface CharacterService {


    public List<Character> getAllCharacter();

    public void saveCharacter(Character character);

    public Character getCharacter(int id);
}

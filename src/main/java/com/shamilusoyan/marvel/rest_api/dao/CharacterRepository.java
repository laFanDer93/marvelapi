package com.shamilusoyan.marvel.rest_api.dao;

import com.shamilusoyan.marvel.rest_api.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}

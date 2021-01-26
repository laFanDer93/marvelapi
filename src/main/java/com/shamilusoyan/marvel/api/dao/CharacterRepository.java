package com.shamilusoyan.marvel.api.dao;

import com.shamilusoyan.marvel.api.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}

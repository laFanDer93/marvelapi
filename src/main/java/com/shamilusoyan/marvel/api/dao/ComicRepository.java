package com.shamilusoyan.marvel.api.dao;

import com.shamilusoyan.marvel.api.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Integer> {
}

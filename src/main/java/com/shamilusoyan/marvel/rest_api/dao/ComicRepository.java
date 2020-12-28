package com.shamilusoyan.marvel.rest_api.dao;

import com.shamilusoyan.marvel.rest_api.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Integer> {
}

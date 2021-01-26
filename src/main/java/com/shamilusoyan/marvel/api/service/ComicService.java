package com.shamilusoyan.marvel.api.service;

import com.shamilusoyan.marvel.api.entity.Comic;

import java.util.List;

public interface ComicService {


     List<Comic> getAllComic();

     void saveComic(Comic comic);

     Comic getComic(int id);

}

package com.shamilusoyan.marvel.rest_api.service;

import com.shamilusoyan.marvel.rest_api.entity.Comic;

import java.util.List;

public interface ComicService {


    public List<Comic> getAllComic();

    public void saveComic(Comic comic);

    public Comic getComic(int id);

}

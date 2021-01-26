package com.shamilusoyan.marvel.api.service;

import com.shamilusoyan.marvel.api.dao.ComicRepository;
import com.shamilusoyan.marvel.api.entity.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComicServiceImpl implements ComicService {

    @Autowired
    ComicRepository comicRepository;

    @Override
    public List<Comic> getAllComic() {
        return comicRepository.findAll();
    }

    @Override
    public void saveComic(Comic comic) {
        comicRepository.save(comic);
    }

    @Override
    public Comic getComic(int id) {
        Comic comic = null;
        Optional<Comic> optional = comicRepository.findById(id);
        if (optional.isPresent()) {
            comic = optional.get();
        }
        return comic;

    }
}

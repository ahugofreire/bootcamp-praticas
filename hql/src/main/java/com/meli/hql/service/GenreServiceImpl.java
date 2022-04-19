package com.meli.hql.service;

import com.meli.hql.model.Genre;
import com.meli.hql.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GenreServiceImpl implements IGenreService{

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> find() {
        return this.genreRepository.findAll();
    }

    @Override
    public Genre create(Genre genre) {
        return this.genreRepository.save(genre);
    }
}

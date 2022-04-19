package com.meli.movie.service;

import com.meli.movie.entity.Genre;
import com.meli.movie.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GenreService implements IGenreService {
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

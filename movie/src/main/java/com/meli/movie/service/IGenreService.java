package com.meli.movie.service;

import com.meli.movie.entity.Genre;

import java.util.List;

public interface IGenreService {
    public List<Genre> find();
    public Genre create(Genre genre);
}

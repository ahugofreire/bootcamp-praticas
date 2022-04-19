package com.meli.hql.service;

import com.meli.hql.model.Genre;

import java.util.List;

public interface IGenreService {
    public List<Genre> find();
    public Genre create(Genre genre);
}

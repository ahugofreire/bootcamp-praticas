package com.meli.hql.service;

import com.meli.hql.model.Movie;

import java.util.List;

public interface IMovieService {
    public List<Movie> find();
    public Movie create(Movie movie);
    public Movie update(Integer id, Movie movie);
    public List<Movie> findMovieByGenreId(Integer id);

}

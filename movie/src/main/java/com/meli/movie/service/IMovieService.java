package com.meli.movie.service;

import com.meli.movie.entity.Movie;

import java.util.List;

public interface IMovieService {
    public List<Movie> find();
    public Movie create(Movie movie);
    public Movie update(Integer id, Movie movie);
}

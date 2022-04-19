package com.meli.hql.service;

import com.meli.hql.model.Movie;
import com.meli.hql.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MovieServiceImpl implements IMovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> find() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie create(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Movie update(Integer id, Movie movie) {
        return null;
    }

    @Override
    public List<Movie> findMovieByGenreId(Integer id) {
        return this.movieRepository.findMovieByGenreId(id);
    }
}

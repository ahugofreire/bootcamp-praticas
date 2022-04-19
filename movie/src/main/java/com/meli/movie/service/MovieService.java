package com.meli.movie.service;

import com.meli.movie.entity.Movie;
import com.meli.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class MovieService implements IMovieService {

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
}

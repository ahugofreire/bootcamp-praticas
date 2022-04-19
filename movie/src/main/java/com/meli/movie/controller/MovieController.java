package com.meli.movie.controller;

import com.meli.movie.dto.MovieDTO;
import com.meli.movie.entity.Movie;
import com.meli.movie.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.movieService.find());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> create(@RequestBody MovieDTO movieDTO) {
        System.out.println(movieDTO);
       Movie movieCreated = this.movieService.create(movieDTO);

       return ResponseEntity.created(URI.create("/api/movies/" + movieCreated.getId())).body(movieCreated);
    }
}

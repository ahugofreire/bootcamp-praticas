package com.meli.hql.controller;

import com.meli.hql.dto.MovieRequestDTO;
import com.meli.hql.model.Movie;
import com.meli.hql.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@AllArgsConstructor
@RestController
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.movieService.find());
    }

    @GetMapping("/movies/genre/{id}")
    public ResponseEntity<List<Movie>> getMovieByGenreId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(this.movieService.findMovieByGenreId(id));
    }

//    @PostMapping("/movies")
//    public ResponseEntity<Movie> create(@RequestBody MovieRequestDTO movieDTO) {
//        System.out.println(movieDTO);
////        Movie movieCreated = this.movieService.create(movieDTO);
//
//        return ResponseEntity.created(URI.create("/api/movies/" + movieCreated.getId())).body(movieCreated);
//    }
}

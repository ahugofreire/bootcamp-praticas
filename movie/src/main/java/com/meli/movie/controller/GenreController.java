package com.meli.movie.controller;

import com.meli.movie.entity.Genre;
import com.meli.movie.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    private IGenreService genreService;

    @PostMapping("/genres")
    public ResponseEntity<Genre> create(@RequestBody Genre genre) {
        Genre genreCreated = this.genreService.create(genre);
        return ResponseEntity.created(URI.create("/api/genres/" + genreCreated.getId())).body(genreCreated);
    }
}

package com.meli.hql.controller;

import com.meli.hql.model.Actor;
import com.meli.hql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {
    @Autowired
    private IActorService actorService;

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> getAll() {
        return ResponseEntity.ok().body(this.actorService.find());
    }

    @GetMapping("/actors/favorite")
    public ResponseEntity<List<Actor>> getActorFavoriteMovie(){
        return ResponseEntity.ok().body(this.actorService.findFavoriteMovie());
    }

    @GetMapping("/actors/{rating}")
    public ResponseEntity<List<Actor>> getActorFavoriteMovie(@PathVariable Float rating){
        return ResponseEntity.ok().body(this.actorService.findActorsByRatingIsGreater(rating));
    }

    @GetMapping("/actors/movie/{id}")
    public ResponseEntity<List<Actor>> getActorsByMovieName(@PathVariable Integer id) {
        return ResponseEntity.ok().body(this.actorService.findActorsByMove(id));
    }
}

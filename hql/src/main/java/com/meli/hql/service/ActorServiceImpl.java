package com.meli.hql.service;

import com.meli.hql.model.Actor;
import com.meli.hql.repository.ActorMovieRepository;
import com.meli.hql.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorMovieRepository actorMovieRepository;

    @Override
    public Actor create(Actor actor) {
        return this.actorRepository.save(actor);
    }

    @Override
    public Actor findOne(Integer id) {
        return null;
    }

    @Override
    public List<Actor> find() {

        return this.actorRepository.findAll();
    }

    @Override
    public List<Actor> findFavoriteMovie() {
        return this.actorRepository.findActorsFavorite();
    }

    @Override
    public List<Actor> findActorsByRatingIsGreater(Float rating) {
        return this.actorRepository.findActorsByRatingIsGreaterThan(rating);
    }

    @Override
    public List<Actor> findActorsByMove(Integer id) {

        return this.actorRepository.findActorsByMoviesIdIs(id);
    }
}

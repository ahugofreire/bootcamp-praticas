package com.meli.hql.service;

import com.meli.hql.model.Actor;

import javax.swing.*;
import java.util.List;

public interface IActorService {
    Actor create(Actor actor);
    Actor findOne(Integer id);
    List<Actor> find();
    List<Actor> findFavoriteMovie();
    List<Actor> findActorsByRatingIsGreater(Float rating);
    List<Actor> findActorsByMove(Integer id);
}

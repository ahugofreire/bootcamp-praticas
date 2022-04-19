package com.meli.hql.repository;

import com.meli.hql.model.Actor;
import com.meli.hql.model.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("from Actor a where a.favorite_movie <> 'NULL'")
    List<Actor> findActorsFavorite();

    @Query("from Actor a where  a.rating > :rating")
    List<Actor> findActorsByRatingIsGreaterThan(@Param("rating") Float rating);

    @Query("from Actor a left join fetch ActorMovie am on am.actors.id = a.id where am.movies.id = :id")
    List<Actor> findActorsByMoviesIdIs(@Param("id") Integer id);

}

package com.meli.hql.repository;

import com.meli.hql.model.Actor;
import com.meli.hql.model.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorMovieRepository extends JpaRepository<ActorMovie, Integer> {

}

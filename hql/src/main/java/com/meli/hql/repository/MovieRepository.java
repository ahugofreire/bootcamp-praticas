package com.meli.hql.repository;

import com.meli.hql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Integer> {
    @Query("from Movie m inner join Genre g on g.id = m.genre.id where g.id = :id")
    List<Movie> findMovieByGenreId(@Param("id")Integer id);
}

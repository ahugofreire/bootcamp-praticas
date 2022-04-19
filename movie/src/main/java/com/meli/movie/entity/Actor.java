package com.meli.movie.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime update_at;
    private String first_name;
    private String last_name;
    private Float rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie movie;
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}

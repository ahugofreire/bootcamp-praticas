package com.meli.hql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime update_at;
    private String title;
    private Float rating;
    private Integer awards;
    private LocalDate release_date;
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @OneToMany(mappedBy = "movies")
    private List<ActorMovie> actorMovies ;
}

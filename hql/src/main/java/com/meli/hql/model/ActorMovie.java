package com.meli.hql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actor_movie")
public class ActorMovie implements Serializable {

    @Id
    private Integer id;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime update_at;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actors;
    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movies;

}

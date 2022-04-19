package com.meli.movie.dto;

import com.meli.movie.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MovieDTO {
    private String title;
    private Float rating;
    private Integer awards;
    private LocalDate release_date;
    private Integer length;
    private Integer genres;
    private List<Actor> actors;
}

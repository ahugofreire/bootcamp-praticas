package com.meli.hql.dto;

import com.meli.hql.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDTO {
    private String title;
    private Float rating;
    private Integer awards;
    private LocalDate release_date;
    private Integer length;
    private Integer genres;
    private List<Actor> actors;
}

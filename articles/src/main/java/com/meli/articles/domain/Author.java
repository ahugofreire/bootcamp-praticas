package com.meli.articles.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
@Data
@AllArgsConstructor
public class Author {

    @Id
    private Integer id;
    private String name;
}

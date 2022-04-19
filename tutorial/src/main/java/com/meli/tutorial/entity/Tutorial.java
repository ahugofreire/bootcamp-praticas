package com.meli.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "the title must not be empty")
    @Size(max = 40, message = "the title must not be longer than 40 characters")
    private String title;
    @Size(max = 100, message = "the title must not be longer than 100 characters")
    private String description;
    private Boolean published;
    private LocalDateTime createdAt = LocalDateTime.now();
}

package com.meli.dealership.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ServicesDTO {
    private LocalDate date;
    private int kilometers;
    private String description;
}
